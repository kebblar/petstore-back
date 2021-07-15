/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UsuarioServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *
 */
package io.kebblar.petstore.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.kebblar.petstore.api.mapper.DireccionMapper;
import io.kebblar.petstore.api.mapper.RegistroMapper;
import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;
import io.kebblar.petstore.api.model.exceptions.InternalServerException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import io.kebblar.petstore.api.model.exceptions.RuleException;
import io.kebblar.petstore.api.model.exceptions.StrengthPasswordValidatorException;
import io.kebblar.petstore.api.model.exceptions.TokenExpiredException;
import io.kebblar.petstore.api.model.exceptions.TokenNotExistException;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.exceptions.UserAlreadyExistsException;
import io.kebblar.petstore.api.model.exceptions.UserNotExistsException;
import io.kebblar.petstore.api.model.exceptions.WrongTokenException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
import io.kebblar.petstore.api.support.MailSenderService;
import io.kebblar.petstore.api.utils.DigestEncoder;
import io.kebblar.petstore.api.utils.StringUtils;
import io.kebblar.petstore.api.utils.ValidadorClave;

/**
 * <p>Implementación de la interfaz {@link UsuarioService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @see     io.kebblar.petstore.api.service.UsuarioService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    private UsuarioMapper usuarioMapper;
    private RolMapper rolMapper;
    private RegistroMapper registroMapper;
    private UsuarioDetalleMapper usuarioDetalleMapper;
    private MailSenderService mailSenderService;

    private static final int RANDOM_STRING_LEN = 6;

    /**
     * Constructor que realiza el setting de todos
     * los Mappers y todos los servicios adicionales
     * a ser empleados en esta clase.
     *
     * @param usuarioMapper
     * @param rolMapper
     * @param direccionMapper
     * @param usuarioDetalleMapper
     */
    public UsuarioServiceImpl(
            UsuarioMapper usuarioMapper,
            RolMapper rolMapper,
            DireccionMapper direccionMapper,
            UsuarioDetalleMapper usuarioDetalleMapper,
            RegistroMapper registroMapper,
            MailSenderService mailSenderService) {
        this.usuarioMapper = usuarioMapper;
        this.rolMapper = rolMapper;
        this.registroMapper = registroMapper;
        this.usuarioDetalleMapper = usuarioDetalleMapper;
        this.mailSenderService = mailSenderService;
    }

    @Override
    public Usuario creaUsuario(CredencialesRequest cred) throws BusinessException {
        Usuario usuario = new Usuario(-1, cred.getUsuario(), cred.getClave());
        try {
            usuarioMapper.insert(usuario);
        } catch (Exception e) {
            throw new MapperCallException("Error de inserción de un usuario", e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario creaUsuario(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.insert(usuario);
        } catch (Exception e) {
            throw new MapperCallException("Error de inserción de un usuario", e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario actualizaUsuario(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.update(usuario);
        } catch (Exception e) {
            throw new MapperCallException("Error al actualizar un usuario", e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario obtenUsuarioPorId(int id) throws BusinessException {
        try {
            return usuarioMapper.getById(id);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener un usuario", e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenTodosUsuarios() throws BusinessException {
        try {
            return usuarioMapper.getAll();
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener la lista de usuarios", e.getMessage());
        }
    }

    @Override
    public Usuario eliminaUsuario(int id) throws BusinessException {
        try {
            usuarioMapper.delete(id);
            return usuarioMapper.getById(id);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener la lista de usuarios", e.getMessage());
        }
    }

    @Override
    public Usuario obtenUsuarioPorCorreo(String correo) throws BusinessException {
        try {
            return usuarioMapper.getByCorreo(correo);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener el usuario con base en su correo", e.getMessage());
        }
    }

    @Override
    public List<Rol> obtenRolesDeUsuario(int id) throws BusinessException {
        try {
            return rolMapper.getUserRoles(id);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener los roles de un usuario", e.toString());
        }
    }

//    @Override
//    public List<Direccion> obtenDireccionesDeUsuario(int id) throws BusinessException {
//        try {
//            return direccionMapper.getUserDirecciones(id);
//        } catch (Exception e) {
//            throw new MapperCallException("Error al obtener las direcciones de un usuario", e.toString());
//        }
//    }

    @Override
    public UsuarioDetalle obtenDetallesDeUsuario(int id) throws BusinessException {
        try {
            return usuarioDetalleMapper.getById(id);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener los detalles de un usuario", e.toString());
        }
    }

    @Override
    public Preregistro preRegistro(Preregistro preRegistroRequest) throws BusinessException {
        try {
            return preRegistroHelper(preRegistroRequest);
        } catch (SQLException e) {
            throw new DatabaseException(e.toString());
        }
    }
    
    public int daysBetweenDates(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));            
        return Math.abs(diffDays);
    }
    
    private void validaFechaPropuesta(int anio, int mes, int dia) throws BusinessException {
        // NOTA: Ya hay prevalidaciones en el POJO: PreregistroRequest
        if(dia==31) {
            if(mes==2 || mes==4 || mes==6 || mes==9 || mes==11) throw new RuleException("Este mes NO posee 31 dias");
        }
        if(dia==30 && mes==2) {
            throw new RuleException("Febrero no posee 30 dias");
        }
        if(dia==29 && mes==2) {
           for(int i=0; i<30; i++) {
               int comp = 1900+(4*i);
               if(anio==comp) return;
           }
           throw new RuleException("En "+anio+" febrero no fué biciesto"); 
        }
    }
    
    @Override
    public Preregistro preRegistro2(PreregistroRequest preRegistroRequest) throws BusinessException {
        int edadMinima=21;
        int dia = preRegistroRequest.getDay();
        int mes = preRegistroRequest.getMonth();
        int anio = preRegistroRequest.getYear();
        validaFechaPropuesta(anio, mes, dia);
        //Calendar cal = Calendar.getInstance();
        //cal.set(preRegistroRequest.getYear(), preRegistroRequest.getMonth()-1, preRegistroRequest.getDay());
        //Date fechaNacimiento = cal.getTime();
        @SuppressWarnings("deprecation")
        Date fechaNacimiento = new Date(anio-1900, mes-1, dia);
        Date now = new Date();
        int diff = daysBetweenDates(now, fechaNacimiento);
        int min = 1+ 365*edadMinima + 21/4; // lo último es por los años biciestos que suman 1 a cada 4 (y el 1 es porque debe ser MAYOR que)
        if(diff<min) throw new RuleException("La edad mínima para pertenecer a este sitio es de "+edadMinima+" años cumplidos.");
        Preregistro preRegistro = new Preregistro
                (preRegistroRequest.getId(), 
                 preRegistroRequest.getNick(), 
                 preRegistroRequest.getCorreo(), 
                 preRegistroRequest.getClaveHash(), 
                 preRegistroRequest.getTelefono(), 
                 fechaNacimiento, 
                 preRegistroRequest.getRandomString(), 
                 preRegistroRequest.getInstanteRegistro());
        try {
            return preRegistroHelper(preRegistro);
        } catch (SQLException e) {
            throw new DatabaseException(e.toString());
        }
    }
    
    private Preregistro preRegistroHelper(Preregistro preRegistroRequest) throws
            StrengthPasswordValidatorException,
            InternalServerException,
            UserAlreadyExistsException,
            SQLException {
        // Quitale los caracteres raros al teléfono.
        String nuevoCel = StringUtils.limpia(preRegistroRequest.getTelefono());
        preRegistroRequest.setTelefono(nuevoCel);

        // Valida si la clave proporcionada es compatible con el
        // patrón de seguridad de claves solicitado por el sistema:
        ValidadorClave.validate(preRegistroRequest.getClaveHash());

        // Busca al usuario por su correo en la tabla de 'usuario'
        Usuario usuario = this.usuarioMapper.getByCorreo(preRegistroRequest.getCorreo());

        // Si el usuario ya está en la tabla 'usuario', avisa error:
        if(usuario!=null) throw new UserAlreadyExistsException();

        // Busca el registro por mail en la tabla de 'registro':
        Preregistro registro = this.registroMapper.getByMail(preRegistroRequest.getCorreo());

        // Genera una cadena aleatoria de caracteres y crea un objeto de tipo 'PreRegistro':
        String randomString = DigestEncoder.getRandomString(RANDOM_STRING_LEN);

        // Calcula el Hash de la clave con un salt del correo:
        String claveHasheada = DigestEncoder.digest(preRegistroRequest.getClaveHash(), preRegistroRequest.getCorreo());

        // Asigna valores:
        preRegistroRequest.setRandomString(randomString);
        preRegistroRequest.setInstanteRegistro(System.currentTimeMillis());
        preRegistroRequest.setClaveHash(claveHasheada);

        // Si el usuario NO está en la tabla de 'registro', insertar info:
        if(registro==null) {
            logger.info("Creando registro en la tabla 'Registro'");
            this.registroMapper.insertRegistro(preRegistroRequest);
        } else { // Si el usuario SI está: actualizar info:
            logger.info("Actualizando registro en la tabla 'Registro'");
            this.registroMapper.update(preRegistroRequest);
        }

        // Envia correo de notificación:
        sendMail(
                preRegistroRequest.getNick(),
                preRegistroRequest.getCorreo(),
                randomString,
                "Clave de confirmación de registro");
        logger.info("Se ha enviado un correo para confirmación a: " + preRegistroRequest.getCorreo());
        return preRegistroRequest;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = TransactionException.class)
    public Usuario confirmaPreregistro(String token) throws BusinessException {
        // El token sirve sólo 10 minutes:
        long DELTA = 1000*60*10;

        // Obtén la túpla asociada al token de confirmación
        Preregistro preregistro = getPreregistroByRandomString(token);

        // Si no hay un registro asociado a tal token, notifica el error:
        if(preregistro==null) throw new TokenNotExistException();

        // Si ya expiró el token, notifica el error:
        long age = System.currentTimeMillis()-preregistro.getInstanteRegistro();
        if(age>DELTA) { // token expirado
            throw new TokenExpiredException();
        }

        // Si la clave no es la misma, notifica el error:
        if(!token.equals(preregistro.getRandomString())) {
            throw new WrongTokenException("Error al comparar el token registrado con el token proporcionado");
        }

        // Si todito lo anterior salió bien, actualiza los
        // datos, guárdalos y elimina el preregistro auxiliar:
        try {
            return doTransaction(preregistro, token);
        } catch (SQLException e) {
            throw new TransactionException("Registro fallido. Haciendo rollback a la transaccion");
        }
    }

    private Usuario doTransaction(Preregistro preregistro, String randomString) throws SQLException {
        // Crea un usuario e insertalo en la base:
        Usuario usuario = new Usuario(
            0, //id (que va a ser autogenerado)
            preregistro.getCorreo(),       // correo
            preregistro.getClaveHash(),    // clave
            System.currentTimeMillis(), // creado
            true,// activo
            0,  // accesoNegadoContador
            0,  // instanteBloqueo
            0,  // instanteUltimoAcceso
            System.currentTimeMillis(),  // instanteUltimoCambioClave
            "", // regeneraClaveToken
            0   // regeneraClaveTokenInstante
        );
        usuarioMapper.insert(usuario);


        // Obtén el id autogenerado del usuario recién creado:
        int idUsuario = usuario.getId();


        // Crea un objeto 'usuarioDetalles' (con el ID autogenerado) e insértalo en la DB:
        UsuarioDetalle usuarioDetalle = new UsuarioDetalle(
            idUsuario,
            "",     // nombre
            "",     // apellidoPaterno
            "",     // apellidoMaterno
            preregistro.getNick(),     // nickName
            preregistro.getFechaNacimiento(),   // fechaNacimiento
            preregistro.getTelefono()    // telefonoCelular
        );
        this.usuarioDetalleMapper.insert(usuarioDetalle);


        // asociar el usuario recién creado con el rol 2:
        this.rolMapper.insertUserRol(idUsuario, 2);

        // Borra lo que tengas en la tabla registro
        this.registroMapper.deleteByRandomString(randomString);

        // Notifica al log y retorna el id del usuario recién creado:
        logger.info("Nevo Usuario Creado con ID: " + idUsuario);
        return usuario;
    }

    private void sendMail(String nick, String correo, String randomString, String titulo) {
        String body="<h1>Hola, "+nick+". Tu calve es: "+randomString+" y tiene una validez de 10 minutos</h1>";
        try {
            body = getTemplate(nick, randomString);
        } catch (InternalServerException e) {
            logger.error(e.toString());
        }
        this.mailSenderService.sendHtmlMail(correo, titulo, body);
    }

    /**
     * Obtiene la tupla de la tabla preregistro que tiene asociado el token proporcionado
     * por correo al momento del registro.
     *
     * @param token proporcionado por correo al momento del registro.
     * @return Objeto de tipo Preregistro ta que su RamdomString coincide con el token dado
     * @throws BusinessException
     */
    private Preregistro getPreregistroByRandomString(String token) throws BusinessException {
        try {
            return this.registroMapper.getByRandomString(token);
        } catch (SQLException e) {
            throw new BusinessException("getRegistroByRandomString", e.toString());
        }
    }
    private String getTemplate(String user, String randStr) throws InternalServerException {
        String archivo = "public/mail/templateMail.html";
        try {
            // Accedemos al recurso
            InputStream resource = new ClassPathResource(archivo).getInputStream();
            // Leemos el recurso
            BufferedReader reader = new BufferedReader( new InputStreamReader(resource));
            String template = reader.lines().collect(Collectors.joining("\n"));
            // remplazamos el contenido:
            template = template.replace("%NAME%",user);
            template = template.replace("%TOKEN%",randStr);
            return template;
        } catch (IOException e) {
            throw new InternalServerException("IO Error", "No se ha podido leer el archivo " + archivo);
        }

    }

    @Override
    public Usuario solicitaRegeneracionClave(String correo) {
        Usuario dummyUser = new Usuario(0, "err","err");
        String token = DigestEncoder.getRandomString(6);
        try {
            Usuario usuario = usuarioMapper.getByCorreo(correo);
            if(usuario==null) return dummyUser;
            usuario.setRegeneraClaveInstante(System.currentTimeMillis());
            usuario.setRegeneraClaveToken(token);
            usuarioMapper.update(usuario);
            sendMail("Estimado Usuario", correo, token, "Clave de recuperación");
            return usuario;
        } catch (SQLException e) {
            logger.error(e.toString());
            return dummyUser;
        }
    }

    @Override
    public Usuario confirmaRegeneraClave(String token, String clave) throws BusinessException {
        ValidadorClave.validate(clave);
        long UNA_HORA = 1000*60*60;
        Usuario usuario = usuarioMapper.getByToken(token);
        if(usuario==null) throw new TokenNotExistException();
        long remaining = System.currentTimeMillis()-usuario.getRegeneraClaveInstante();
        if(remaining<UNA_HORA) {
            String claveHash = DigestEncoder.digest(clave, usuario.getCorreo());
            usuarioMapper.confirmaRegeneraClave(token, claveHash);
            return usuarioMapper.getByToken(token);
        } else {
            throw new TokenExpiredException();
        }
    }

    @Override
    public Usuario cambiaClave(String correo, String clave) throws BusinessException {
        // BUG: con un token cualquiera válido (hasta el de un usuario no 'admin') se puede 
        // invocar este servicio y cambiarle la clave a cualquiera !!!!!
        // Para corregir este bug de seguridad, este servicio DEBE recibir el JWT y
        // A) verificar que es un JWT de un usuario con rol 'admin' 
        // o bien que:
        // B) el JWT es del usuario para el cual se está dando el correo
        // Si no se cumple con alguna de estas dos condiciones, se deberá impedir el cambio
        // y se deberá disparar la excepción de NO autorizado (401: unauthorized)
        try {
            Usuario usuario = usuarioMapper.getByCorreo(correo);
            if(usuario==null) {
                throw new UserNotExistsException(correo);
            }
            ValidadorClave.validate(clave);
            String claveHash = DigestEncoder.digest(clave, usuario.getCorreo());
            usuario.setClave(claveHash);
            usuarioMapper.update(usuario);
            return usuario;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            String nuevoCel = StringUtils.limpia(usuarioDetalle.getTelefonoCelular());
            usuarioDetalle.setTelefonoCelular(nuevoCel);
            usuarioDetalleMapper.update(usuarioDetalle);
            return usuarioDetalle;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }


}
