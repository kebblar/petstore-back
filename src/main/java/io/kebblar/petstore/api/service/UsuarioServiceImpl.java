package io.kebblar.petstore.api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario createUser(CredencialesRequest cred) throws BusinessException {
        Usuario u = new Usuario(-1, cred.getUsuario(), cred.getClave());
        try {
            usuarioMapper.insert(u);
        } catch (Exception e) {
            throw new MapperCallException("Error de inserción de un usuario", e.getMessage());
        }
        return u;
    }

    @Override
    public Usuario updateUser(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.update(usuario);
        } catch (Exception e) {
            throw new MapperCallException("Error al actualizar un usuario", e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario getUser(int id) throws BusinessException {
        try {
            return usuarioMapper.getById(id);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener un usuario", e.getMessage());
        }
    }

    @Override
    public List<Usuario> getAllUsers() throws BusinessException {
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
    public Usuario getUsuarioByCorreo(String correo) throws BusinessException {
        try {
            return usuarioMapper.getByCorreo(correo);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener el usuario con base en su correo", e.getMessage());
        }
    }
}
