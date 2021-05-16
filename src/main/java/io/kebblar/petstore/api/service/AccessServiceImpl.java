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
import io.kebblar.petstore.api.model.exceptions.*;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.support.JwtManagerService;
import io.kebblar.petstore.api.utils.DigestEncoder;

@Service
public class AccessServiceImpl implements AccessService {
    private static final Logger logger = LoggerFactory.getLogger(AccessServiceImpl.class);
    
    @Value("${proyecto.message}")
    private String message;
    
    private UsuarioService usuarioService;
    private JwtManagerService jwtManagerService;
    
    public AccessServiceImpl(
            UsuarioService usuarioService, 
            JwtManagerService jwtManagerService) {
        this.usuarioService = usuarioService;
        this.jwtManagerService = jwtManagerService;
    }

    @Override
    public LoginResponse login(String usr, String clave) throws BusinessException {
        logger.info(" ***** Invocando al servicio llamado 'AccessService'. Message: {}", message);
        this.valida(usr, clave);
        int maximoNumeroIntentosConcedidos = 5; // 5 intentos
        long delta = 1000*60*5L; // 5 minutos
        long instanteActual = System.currentTimeMillis();
        Usuario usuario = usuarioService.obtenUsuarioPorCorreo(usr);
        return login(usuario, clave, delta, maximoNumeroIntentosConcedidos, instanteActual);
    }

    @Override
    public LoginResponse login(
            Usuario usuario, 
            String claveProporcionada, 
            long delta, 
            int maximoNumeroIntentosConcedidos, 
            long instanteActual) throws BusinessException {
        // Si el usuario NO es nulo, procederé a calcular sus roles y sus direcciones:
        if(usuario==null) throw new BadCredentialsException();

        // Si el usuario fue encontrado, pero está inactivo, Notifica
        if(!usuario.isActivo()) throw new DisabledUserException();
        
        // Calcula cuanto tiempo lleva bloqueado el usuario. Si lleva menos de lo establecido, Notifica
        long instanteDeBloqueo = usuario.getInstanteBloqueo();
        long diff = instanteActual - instanteDeBloqueo;
        long restante = delta - diff;
        if(instanteDeBloqueo>0 && restante>0) throw new WaitLoginException(restante/1000);
        
        // Clave dada que debe ser validado contra el que está en la base de datos
        String clavePorVerificar = DigestEncoder.digest(claveProporcionada, usuario.getCorreo());

        if(!usuario.getClave().equals(clavePorVerificar)) {// Credenciales INCORRECTAS
            // Incrementa el contador de intentos erroneos de ingreso y actualiza:
            int numeroDeIntentosFallidos = usuario.getAccesoNegadoContador()+1;
            usuario.setAccesoNegadoContador(numeroDeIntentosFallidos);
            this.update(usuario);
            
            // Si los intentos de ingreso inválidos superan un limite, actualiza y Notifica:
            if(numeroDeIntentosFallidos >= maximoNumeroIntentosConcedidos) {
                usuario.setInstanteBloqueo(instanteActual);
                this.update(usuario);
                throw new BlockedUserException(maximoNumeroIntentosConcedidos);
            }

            // Si no se disparó la Notificación anterior, de todas formas notifica un intento
            // fallido de ingreso al sistema:
            throw new BadCredentialsException(numeroDeIntentosFallidos, maximoNumeroIntentosConcedidos);
        } else { // Credenciales CORRECTAS
            long ultimoIngresoExitoso = usuario.getInstanteUltimoAcceso();
            logger.info("Ingreso exitoso al sistema del usuario: " + usuario.getCorreo());
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
    
    private void valida(String usr, String clave) throws BusinessException {
        if(usr.trim().length()<1 || clave.trim().length()<1) throw new BadCredentialsException();
    }

    private void update(Usuario usuario) throws BusinessException {
        usuarioService.actualizaUsuario(usuario);
    }

    private UserFoundWrapper getUserFoundWrapper(int idUsuario, String correo) throws BusinessException {
        List<Rol> roles               = usuarioService.obtenRolesDeUsuario(idUsuario);
        //List<Direccion> direcciones   = usuarioService.obtenDireccionesDeUsuario(idUsuario);
        UsuarioDetalle usuarioDetalle = usuarioService.obtenDetallesDeUsuario(idUsuario);
        String jwt                    = jwtManagerService.createToken(correo);
        return new UserFoundWrapper(roles, usuarioDetalle, jwt);
    }

}
