package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.*;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.support.JwtManagerService;
import io.kebblar.petstore.api.utils.DigestEncoder;

@Service
public class AccessServiceImpl implements AccessService {
    @Value("${proyecto.message}")
    private String message;
    
    private UsuarioService usuarioService;
    private JwtManagerService jwtManagerService;
    private RolMapper rolMapper;
    
    public AccessServiceImpl(
            UsuarioService usuarioService, 
            JwtManagerService jwtManagerService, 
            RolMapper rolMapper) {
        this.usuarioService = usuarioService;
        this.jwtManagerService = jwtManagerService;
        this.rolMapper = rolMapper;
    }

    @Override
    public LoginResponse login(String usr, String clave) throws BusinessException {
        this.valida(usr, clave);
        int invalidLoginMax = 5; // 5 intentos
        long delta = 1000*60*5L; // 5 minutos
        long currentTime = System.currentTimeMillis()+0;
        Usuario usuario = usuarioService.getUsuarioByCorreo(usr);
        List<Direccion> direcciones = getDirecciones();
        return login(usuario, clave, delta, invalidLoginMax, currentTime, direcciones);
    }

    public LoginResponse login(Usuario usuario, String pass, long delta, int invalidLoginMax, long currentTime, List<Direccion> direcciones) throws BusinessException {
        // Notifica, si el usuario no pudo ser encontrado
        if(usuario==null) throw new BadCredentialsException();
        
        // Si el usuario fue encontrado, pero está inactivo, Notifica
        if(!usuario.isActivo()) throw new DisabledUserException();
        
        // Calcula cuanto tiempo lleva bloqueado el usuario. Si lleva menos de lo establecido, Notifica
        long instanteDeBloqueo = usuario.getInstanteBloqueo();
        long diff = currentTime - instanteDeBloqueo;
        long restante = delta - diff;
        if(instanteDeBloqueo>0 && restante>0) throw new WaitLoginException(restante/1000);
        
        // Password dado que debe ser validado contra el que está en la base de datos
        String passwordToBeChecked = DigestEncoder.digest(pass, usuario.getCorreo());

        if(!usuario.getClave().equals(passwordToBeChecked)) {// Credenciales INCORRECTAS
            // Incrementa el contador de intentos erroneos de ingreso y actualiza:
            int invalidLoginAttemps = usuario.getAccesoNegadoContador()+1;
            usuario.setAccesoNegadoContador(invalidLoginAttemps);
            this.update(usuario);
            
            // Si los intentos de ingreso inválidos superan un limite, actualiza y Notifica:
            if(invalidLoginAttemps>=invalidLoginMax) {
                usuario.setInstanteBloqueo(currentTime);
                this.update(usuario);
                throw new BlockedUserException(invalidLoginMax);
            }

            // Si no se disparó la Notificación anterior, de todas formas notifica un intento
            // fallido de ingreso al sistema:
            throw new BadCredentialsException(invalidLoginAttemps, invalidLoginMax);
        } else { // Credenciales CORRECTAS
            // Resetea todoas las banderas de advertencia y bloqueo. Luego, actualiza y retorna el usuario:
            usuario.setAccesoNegadoContador(0);
            usuario.setInstanteBloqueo(0);
            usuario.setInstanteUltimoAcceso(currentTime);
            this.update(usuario);

            // Crea un token y regrésalo junto con el usuario y los roles:
            String jwt = jwtManagerService.createToken(usuario.getCorreo());
            List<Rol> roles = getRolesFromUserId(usuario.getId());
            UsuarioDetalle usuarioDetalle = getUsuarioDetalles(usuario.getId());

            // Esto va al front y se almacena en 'localStorage' (setItem)
            // https://gitlab.ci.ultrasist.net/root/impi-chatbot-frontend/blob/develop/src/components/04-LogIn/login.vue
            return new LoginResponse(usuarioDetalle, new Date(currentTime), usuario.getCorreo(), jwt, roles, direcciones);
        }
    }
    
    private List<Direccion> getDirecciones() {
        List<Direccion> direcciones = new ArrayList<>();
        return direcciones;
    }

    private UsuarioDetalle getUsuarioDetalles(int id) {
        return new UsuarioDetalle(1, "gus", "arellano");
    }

    private void valida(String usr, String clave) throws BusinessException {
        if(usr.trim().length()<1 || clave.trim().length()<1) throw new BadCredentialsException();
    }
    private void update(Usuario usuario) throws BusinessException {
        usuarioService.updateUser(usuario);
    }

    private List<Rol> getRolesFromUserId(int id) throws BusinessException {
        try {
            return rolMapper.getUserRoles(id);
        } catch (Exception e) {
            throw new BusinessException("Error en el acceso a la base de datos",e.toString());
        }
    }
}
