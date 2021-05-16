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
import io.kebblar.petstore.api.model.exceptions.StrengthPasswordValidatorException;
import io.kebblar.petstore.api.model.exceptions.TokenExpiredException;
import io.kebblar.petstore.api.model.exceptions.TokenNotExistException;
import io.kebblar.petstore.api.model.exceptions.TransactionException;
import io.kebblar.petstore.api.model.exceptions.UserAlreadyExistsException;
import io.kebblar.petstore.api.model.exceptions.WrongTokenException;
import io.kebblar.petstore.api.model.request.ConfirmaRegistroRequest;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.support.MailSenderService;
import io.kebblar.petstore.api.utils.DigestEncoder;
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
    //private DireccionMapper direccionMapper;
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
    public int preRegistro(Preregistro preRegistroRequest) throws BusinessException {
        try {
            return preReg(preRegistroRequest);
        } catch (SQLException e) {
            throw new DatabaseException(e.toString());
        }
    }

    private int preReg(Preregistro preRegistroRequest) throws 
            StrengthPasswordValidatorException, 
            InternalServerException, 
            UserAlreadyExistsException,
            SQLException {
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
        sendMail(preRegistroRequest.getNick(), preRegistroRequest.getCorreo(), randomString);
        logger.info("Se ha enviado un correo para confirmación a: " + preRegistroRequest.getCorreo());
        return preRegistroRequest.getId();
    }
    
    @Override
    @Transactional(
            propagation = Propagation.REQUIRED, 
            isolation = Isolation.DEFAULT,
            timeout = 36000, 
            rollbackFor = TransactionException.class)
    public int confirmaReg(ConfirmaRegistroRequest confirmaRegistro) throws BusinessException {
        int idUsuario = 0;
        
        // the sent token wil survive 10 minutes:
        long TEN_MINUTES = 1000*60*10;
        
        // Obtén el token que dice ser el bueno:
        String randomString = confirmaRegistro.getToken();
        
        // Obtén la túpla asociada al token de confirmación
        Preregistro preregistro = getRegistroByRandomString(randomString);

        // Si no hay un registro asociado a tal token, notifica el error:
        if(preregistro==null) throw new TokenNotExistException();
        
        // Si ya expiró el token, notifica el error:
        long last = System.currentTimeMillis()-preregistro.getInstanteRegistro();
        if(last>TEN_MINUTES) { // token expired
            throw new TokenExpiredException();
        }
        
        // Si la clave no es la misma, notifica el error:
        if(!randomString.equals(preregistro.getRandomString())) {
            throw new WrongTokenException("Error al comparar el token registrado con el token proporcionado");
        }
        
        // Si todito lo anterior salió bien, actualiza los datos, guarda los datos y elimina el registro:
        try {
            idUsuario = doTransaction(preregistro, randomString);
            logger.info("Nevo Usuario Creado con ID: " + idUsuario);
        } catch (SQLException e) {
            throw new TransactionException("Registro fallido. Haciendo rollback a la transaccion");
        }
        
        // Sólo llego a este punto si absolutamente todo salió bien !!!
        return idUsuario;
    }

    private int doTransaction(Preregistro preregistro, String randomString) throws SQLException {
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
        
        // retorna el id del usuario recién creado:
        return idUsuario;
    }
    
    private void sendMail(String nick, String correo, String randomString) throws InternalServerException {
        String body = getTemplate(nick, randomString);
        this.mailSenderService.sendHtmlMail(correo, "Confirmación de registro", body);
    }
    private Preregistro getRegistroByRandomString(String randomString) throws BusinessException {
        try {
            return this.registroMapper.getByRandomString(randomString);
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
}
