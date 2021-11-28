/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      UsuarioServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 09:25:12
 */
package io.kebblar.petstore.api.service;

import static io.kebblar.petstore.api.model.enumerations.EnumMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.exceptions.*;
import io.kebblar.petstore.api.support.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.kebblar.petstore.api.mapper.RegistroMapper;
import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
import io.kebblar.petstore.api.utils.DigestEncoder;
import io.kebblar.petstore.api.utils.StringUtils;
import io.kebblar.petstore.api.utils.ValidadorClave;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.UsuarioService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
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

    private final UsuarioMapper usuarioMapper;
    private final RolMapper rolMapper;
    private final RegistroMapper registroMapper;
    private final UsuarioDetalleMapper usuarioDetalleMapper;
    private final MailSenderService mailSenderService;

    private static final int RANDOM_STRING_LEN = 6;
    private final UploadService uploadService;

    /**
     * Constructor que realiza el setting de
     * los Mappers y los servicios adicionales
     * a ser empleados en esta clase.
     *
     * @param usuarioMapper a {@link io.kebblar.petstore.api.mapper.UsuarioMapper} object.
     * @param rolMapper a {@link io.kebblar.petstore.api.mapper.RolMapper} object.
     * @param usuarioDetalleMapper a {@link io.kebblar.petstore.api.mapper.UsuarioDetalleMapper} object.
     * @param registroMapper a {@link io.kebblar.petstore.api.mapper.RegistroMapper} object.
     * @param mailSenderService a {@link io.kebblar.petstore.api.support.MailSenderService} object.
     */
    public UsuarioServiceImpl(
            UsuarioMapper usuarioMapper,
            RolMapper rolMapper,
            UsuarioDetalleMapper usuarioDetalleMapper,
            RegistroMapper registroMapper,
            MailSenderService mailSenderService) {
        this.usuarioMapper = usuarioMapper;
        this.rolMapper = rolMapper;
        this.registroMapper = registroMapper;
        this.usuarioDetalleMapper = usuarioDetalleMapper;
        this.mailSenderService = mailSenderService;
        uploadService = new UploadServiceImpl();
    }

    /** {@inheritDoc} */
    @Override
    public Usuario creaUsuario(CredencialesRequest cred) throws BusinessException {
        Usuario usuario = new Usuario(-1, cred.getUsuario(), cred.getClave());
        try {
            usuarioMapper.insert(usuario);
        } catch (SQLException e) {
            throw new MapperCallException("Error de inserción de un usuario", e.getMessage());
        }
        return usuario;
    }

    /** {@inheritDoc} */
    @Override
    public Usuario creaUsuario(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.insert(usuario);
        } catch (SQLException e) {
            throw new MapperCallException("Error de inserción de un usuario", e.getMessage());
        }
        return usuario;
    }

    /** {@inheritDoc} */
    @Override
    public Usuario actualizaUsuario(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.update(usuario);
        } catch (SQLException e) {
            throw new MapperCallException("Error al actualizar un usuario", e.getMessage());
        }
        return usuario;
    }

    /** {@inheritDoc} */
    @Override
    public Usuario obtenUsuarioPorId(int id) throws BusinessException {
        try {
            return usuarioMapper.getById(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener un usuario", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Usuario> obtenTodosUsuarios() throws BusinessException {
        try {
            return usuarioMapper.getAll();
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener la lista de usuarios", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public Usuario eliminaUsuario(int id) throws BusinessException {
        try {
            usuarioMapper.delete(id);
            return usuarioMapper.getById(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener la lista de usuarios", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public Usuario obtenUsuarioPorCorreo(String correo) throws CustomException {
        try {
            return usuarioMapper.getByCorreo(correo);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "Error al obtener el usuario con base en su correo");
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Rol> obtenRolesDeUsuario(int id) throws CustomException {
        try {
            return rolMapper.getUserRoles(id);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "Error al obtener los roles de un usuario");
        }
    }
    
    /** {@inheritDoc} */
    @Override
    public List<Rol> obtenRolesDeUsuario(String correo) throws CustomException {
        try {
            return rolMapper.getUserRolesByMail(correo);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "Error al obtener los roles de un usuario");
        }
    }

//    @Override
//    public List<Direccion> obtenDireccionesDeUsuario(int id) throws BusinessException {
//        try {
//            return direccionMapper.getUserDirecciones(id);
//        } catch (SQLException e) {
//            throw new MapperCallException("Error al obtener las direcciones de un usuario", e.toString());
//        }
//    }

    /** {@inheritDoc} */
    @Override
    public UsuarioDetalle obtenDetallesDeUsuario(int id) throws CustomException {
        try {
            return usuarioDetalleMapper.getById(id);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "Error al obtener los detalles de un usuario");
        }
    }

    /** {@inheritDoc} */
    @Override
    public Preregistro preRegistro(Preregistro preRegistroRequest) throws BusinessException {
        try {
            return preRegistroHelper(preRegistroRequest);
        } catch (Exception e) {
            throw new MapperCallException("Error en el registro del nuevo usuario", e.toString());
        }
    }
    
    /**
     * <p>daysBetweenDates.</p>
     *
     * @param startDate a {@link java.util.Date} object.
     * @param endDate a {@link java.util.Date} object.
     * @return a int.
     */
    public int daysBetweenDates(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));            
        return Math.abs(diffDays);
    }
    
    private Date validaFechaPropuesta(int anio, int mes, int dia) throws BusinessException {
        if(dia>31)
            throw new CustomException(INCORRECT_DATE, "Ningún mes posee mas de 31 dias");
        
        if(dia==31 && (mes==2 || mes==4 || mes==6 || mes==9 || mes==11))
            throw new CustomException(INCORRECT_DATE, "El mes " + mes + "NO posee "+dia+" dias");

        if(dia>=30 && mes==2)
            throw new CustomException(INCORRECT_DATE, "Febrero no posee "+dia+" dias");

        if(dia==29 && mes==2 && anio%4!=0) {
           throw new CustomException(INCORRECT_DATE, "Febrero no fué biciesto en el "+anio);
        }
        
        @SuppressWarnings("deprecation")
        Date fecha = new Date(anio-1900, mes-1, dia);
        return fecha;
    }
    
    /** {@inheritDoc} */
    @Override
    public Preregistro preRegistro(PreregistroRequest preRegistroRequest) throws BusinessException {
        int dia = preRegistroRequest.getDay();
        int mes = preRegistroRequest.getMonth();
        int anio = preRegistroRequest.getYear();
        Date fechaNacimiento = validaFechaPropuesta(anio, mes, dia);
        validaEdad(fechaNacimiento, 21); // 21 años es la edad mínima (OJO: Convertir en valor de properties)
        Preregistro preRegistro = new Preregistro(
                 preRegistroRequest.getId(), 
                 preRegistroRequest.getNick(), 
                 preRegistroRequest.getCorreo(), 
                 preRegistroRequest.getClaveHash(), 
                 preRegistroRequest.getTelefono(), 
                 fechaNacimiento, 
                 preRegistroRequest.getRandomString(), 
                 preRegistroRequest.getInstanteRegistro());
        return preRegistroHelper(preRegistro);
    }
    
    private Date validaEdad(Date fechaNacimiento, int edadMinima) throws BusinessException {
        Date now = new Date();
        int diff = daysBetweenDates(now, fechaNacimiento);
        int min = 1+ 365*edadMinima + edadMinima/4; // lo último es por los años biciestos que suman 1 a cada 4 (y el 1 es porque debe ser MAYOR que)
        if(diff<min) throw new CustomException(TOO_YOUNG, edadMinima);
        return fechaNacimiento;
    }
    
    private Preregistro preRegistroHelper(Preregistro preRegistroRequest) throws
            BusinessException {
        // Quitale los caracteres raros al teléfono.
        String nuevoCel = StringUtils.limpia(preRegistroRequest.getTelefono());
        preRegistroRequest.setTelefono(nuevoCel);

        // Valida si la clave proporcionada es compatible con el
        // patrón de seguridad de claves solicitado por el sistema:
        ValidadorClave.validate(preRegistroRequest.getClaveHash());
        Preregistro registro;

        // Busca al usuario por su correo en la tabla de 'usuario'
        try {
            //Usuario usuario = this.usuarioMapper.getByCorreo(preRegistroRequest.getCorreo());

            // Si el usuario ya está en la tabla 'usuario', avisa error:
            //if(usuario!=null) throw new CustomException(USER_ALREADY_EXISTS, usuario.getCorreo());
            // SE COMENTAN LAS LINEAS ANTERIORES PARA EVITAR UN ATEQUE DE ENUMERACIÓN.
            // si el correo ya está registrado, simplemente se vuelve a enviar una clave de re-registro

            // Busca el registro por mail en la tabla de 'registro':
            registro = this.registroMapper.getByMail(preRegistroRequest.getCorreo());
        } catch (SQLException s) {
            throw new MapperCallException("No se ha podido asociar el correo "+ preRegistroRequest.getCorreo() + "con ningún registro", s.getMessage());
        }

        // Genera una cadena aleatoria de caracteres y crea un objeto de tipo 'PreRegistro':
        String randomString = StringUtils.getRandomString(RANDOM_STRING_LEN);

        // Calcula el Hash de la clave con un salt del correo:
        String claveHasheada = DigestEncoder.digest(preRegistroRequest.getClaveHash(), preRegistroRequest.getCorreo());

        // Asigna valores:
        preRegistroRequest.setRandomString(randomString);
        preRegistroRequest.setInstanteRegistro(System.currentTimeMillis());
        preRegistroRequest.setClaveHash(claveHasheada);

        try {
            // Si el usuario NO está en la tabla de 'registro', insertar info:
            if (registro == null) {
                logger.info("Creando registro en la tabla 'Registro'");
                this.registroMapper.insert(preRegistroRequest);
            } else { // Si el usuario SI está: actualizar info:
                logger.info("Actualizando registro en la tabla 'Registro'");
                this.registroMapper.update(preRegistroRequest);
            }
        } catch (SQLException s) {
            throw new MapperCallException("La información del registro no ha podido almacenarse", s.getMessage());
        }

        // Envia correo de notificación:
        sendMail(
                preRegistroRequest.getNick(),
                preRegistroRequest.getCorreo(),
                randomString,
                "Clave de confirmación de registro");
        logger.info("Se ha enviado un correo para confirmación a: {} con la clave: {}", preRegistroRequest.getCorreo(), randomString);
        return preRegistroRequest;
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = TransactionException.class)
    public Usuario confirmaPreregistro(String token) throws BusinessException {
        // El token sirve sólo 10 minutes:
        long delta = 1000*60*10L;

        // Obtén la túpla asociada al token de confirmación
        Preregistro preregistro = getPreregistroByRandomString(token);

        // Si no hay un registro asociado a tal token, notifica el error:
        if(preregistro==null) throw new CustomException(TOKEN_NOT_EXIST);

        // Si ya expiró el token, notifica el error:
        long age = System.currentTimeMillis()-preregistro.getInstanteRegistro();
        if(age>delta) { // token expirado
            throw new CustomException(TOKEN_EXPIRED);
        }

        // Si la clave no es la misma, notifica el error:
        if(!token.equals(preregistro.getRandomString())) {
            throw new CustomException(WRONG_TOKEN);
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
        Usuario testUser = usuarioMapper.getByCorreo(preregistro.getCorreo());
        if(testUser != null) {
            // Si el usuario SI existe, sólo actualiza su password y el instante de ultimo cambio
            testUser.setClave(preregistro.getClaveHash());
            testUser.setInstanteUltimoCambioClave(System.currentTimeMillis());
            usuarioMapper.update(testUser);
            return testUser;
        }
        
        // Si el usuario NO existe, Créalo e insértalo en la base:
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
        logger.info("Nevo Usuario Creado con ID: {}", idUsuario);
        return usuario;
    }

    private void sendMail(String nick, String correo, String randomString, String titulo) {
        String body="<h1>Hola, "+nick+". Tu calve es: "+randomString+" y tiene una validez de 10 minutos</h1>";
        try {
            body = getTemplate(nick, randomString);
        } catch (CustomException e) {
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
     * @throws CustomException if any
     */
    private Preregistro getPreregistroByRandomString(String token) throws CustomException {
        try {
            return this.registroMapper.getByRandomString(token);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "getRegistroByRandomString: " + e.toString());
        }
    }
    private String getTemplate(String user, String randStr) throws CustomException {
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
            throw new CustomException(e, INTERNAL_SERVER, "No se ha podido leer el archivo " + archivo);
        }

    }

    /** {@inheritDoc} */
    @Override
    public Usuario solicitaRegeneracionClave(String correo) {
        Usuario dummyUser = new Usuario(0, "err","err");
        String token = StringUtils.getRandomString(6);
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

    /** {@inheritDoc} */
    @Override
    public Usuario confirmaRegeneraClave(String token, String clave) throws BusinessException {
        ValidadorClave.validate(clave);
        long unaHora = 1000*60*60L;
        Usuario usuario = usuarioMapper.getByToken(token);
        if(usuario==null) throw new CustomException(TOKEN_NOT_EXIST);
        long remaining = System.currentTimeMillis()-usuario.getRegeneraClaveInstante();
        if(remaining<unaHora) {
            String claveHash = DigestEncoder.digest(clave, usuario.getCorreo());
            usuarioMapper.confirmaRegeneraClave(token, claveHash);
            return usuarioMapper.getByToken(token);
        } else {
            throw new CustomException(TOKEN_EXPIRED);
        }
    }

    /** {@inheritDoc} */
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
                throw new CustomException(USER_NOT_EXIST, correo);
            }
            ValidadorClave.validate(clave);
            String claveHash = DigestEncoder.digest(clave, usuario.getCorreo());
            usuario.setClave(claveHash);
            usuarioMapper.update(usuario);
            return usuario;
        } catch (SQLException e) {
            throw new MapperCallException("Error al modificar la clave", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            String nuevoCel = StringUtils.limpia(usuarioDetalle.getTelefonoCelular());
            usuarioDetalle.setTelefonoCelular(nuevoCel);
            usuarioDetalleMapper.update(usuarioDetalle);
            return usuarioDetalle;
        } catch (Exception e) {
            throw new MapperCallException("Error actualizando los datos del usuario", e.getMessage());
        }
    }

    @Override
    public UploadModel storeProfilePicture(MultipartFile files, String destinationFolder, long max, int idUser) throws BusinessException {
        try {
            if (usuarioMapper.getById(idUser) == null) throw new CustomException(UPLOAD_SERVICE);
        } catch (SQLException e) {
            throw new MapperCallException("Error al subir el archivo, el usuario es incorrecto", e.getMessage());
        }
        UploadModel um;
        try {
            um = uploadService.storeOne(files, destinationFolder, max);
            usuarioDetalleMapper.subeFotoPerfil(idUser, um.getNuevoNombre());
        } catch (SQLException | BusinessException e) {
            throw new CustomException(UPLOAD_SERVICE, "El archivo es demasiado grande");
        }
        return um;
    }

    @Override
    public String getProfilePic(int idUser) throws BusinessException {
        try {
            return usuarioDetalleMapper.getProfilePic(idUser);
        } catch (SQLException e) {
            throw new CustomException(NOT_FOUND);
        }
    }

}
