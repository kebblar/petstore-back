package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.RegistroMapper;
import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import static io.kebblar.petstore.api.model.enumerations.EnumMessage.*;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.CustomException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.Preregistro;

import io.kebblar.petstore.api.support.JwtManagerService;
import io.kebblar.petstore.api.utils.JWTUtil;
import io.kebblar.petstore.api.utils.StringUtils;

@Service
public class AccessHelperServiceImpl implements AccessHelperService {    
    private UsuarioDetalleMapper usuarioDetalleMapper;
    private UsuarioMapper usuarioMapper;
    private RegistroMapper registroMapper;
    private RolMapper rolMapper;
    private JwtManagerService jwtManagerService;
    
    public AccessHelperServiceImpl(
            UsuarioDetalleMapper usuarioDetalleMapper,
            UsuarioMapper usuarioMapper, 
            RolMapper rolMapper,
            JwtManagerService jwtManagerService,
            RegistroMapper registroMapper) {
        this.usuarioDetalleMapper = usuarioDetalleMapper;
        this.usuarioMapper = usuarioMapper;
        this.rolMapper = rolMapper;
        this.jwtManagerService = jwtManagerService;
        this.registroMapper = registroMapper;
    }
    
    /** {@inheritDoc} */
    @Override
    public Usuario getByToken(String token) {
        return usuarioMapper.getByToken(token);
    }

    /** {@inheritDoc} */
    @Override
    public void confirmaRegeneraClave(String token, String claveHash) {
        usuarioMapper.confirmaRegeneraClave(token, claveHash);
    }

    /** {@inheritDoc} */
    @Override
    public void valida(String usr, String clave) throws CustomException {
        if(usr.trim().length()<1 || clave.trim().length()<1) throw new CustomException(BAD_CREDENTIALS);
    }
    
    @Override
    public String createToken(String mail) {
        return jwtManagerService.createToken(mail);
    }
    
    @Override
    public void actualizaUsuario(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.update(usuario);
        } catch (SQLException e) {
            throw new MapperCallException("Error al actualizar un usuario", e.getMessage());
        }
    }
    
    /** {@inheritDoc} */
    @Override
    public Usuario obtenUsuarioPorCorreo(String correo) throws BusinessException {
        try {
            return usuarioMapper.getByCorreo(correo);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "Error al obtener el usuario con base en su correo");
        }
    }
    
    @Override
    public List<Rol> getUserRoles(int userId) throws BusinessException {
        try {
            return rolMapper.getUserRoles(userId);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "login::update");
        }
    }
    
    @Override
    public UsuarioDetalle getUsuarioDetalle(int userId) throws BusinessException {
        try {
            return usuarioDetalleMapper.getById(userId);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "login::update");
        }
    }

    /** {@inheritDoc} */
    @Override
    public Preregistro getRegistroByMail(String correo) throws BusinessException {
        try {
            return registroMapper.getByMail(correo);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::getRegistroByMail");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void insertRegistro(Preregistro preRegistroRequest) throws BusinessException {
        try {
            registroMapper.insert(preRegistroRequest);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertRegistro");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void updateRegistro(Preregistro preRegistroRequest) throws BusinessException {
        try {
            registroMapper.update(preRegistroRequest);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::updateRegistro");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void insertUsuario(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.update(usuario);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertUsuario");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void insertUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            usuarioDetalleMapper.insert(usuarioDetalle);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertUsuarioDetalle");
        }
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
    public void deletePreregistroByRandomString(String randomString) throws BusinessException {
        try {
            registroMapper.deleteByRandomString(randomString);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::deletePreregistroByRandomString");
        }
    }
    
    @Override
    public String getProfilePic(int idUser) throws BusinessException {
        try {
            return usuarioDetalleMapper.getProfilePic(idUser);
        } catch (SQLException e) {
            throw new CustomException(NOT_FOUND);
        }
    }
    
    /** {@inheritDoc} */
    @Override
    public void insertUserRol(int idUsuario, int rolId) throws BusinessException {
        try {
            rolMapper.insertUserRol(idUsuario, rolId);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertUserRol");
        }
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
    public String getCorreoFromJwt(String jwt) {
        String decoded = JWTUtil.getInstance().decodeJwt(jwt);
        String correo = JWTUtil.getInstance().getCorreo(decoded);
        return correo;
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
            throw new CustomException(e, DATABASE, "Error actualizando los datos del usuario");
        }
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
    
    /** {@inheritDoc} */
    @Override
    public Preregistro getPreregistroByRandomString(String token) throws CustomException {
        try {
            return this.registroMapper.getByRandomString(token);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "getRegistroByRandomString: " + e.toString());
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

    @Override
    public void subeFotoPerfil(int idUser, String nuevoNombre) throws CustomException {
        try {
            usuarioDetalleMapper.subeFotoPerfil(idUser, nuevoNombre);
        } catch (SQLException e) {
            throw new CustomException(e, MAPPER_CALL, "Error al subir la foto de perfil");
        }
    }    
    
}