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

import java.util.List;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.DireccionMapper;
import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.mapper.UsuarioMapper;
import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;

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
    private UsuarioMapper usuarioMapper;
    private RolMapper rolMapper;
    private DireccionMapper direccionMapper;
    private UsuarioDetalleMapper usuarioDetalleMapper;

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
            UsuarioDetalleMapper usuarioDetalleMapper) {
        this.usuarioMapper = usuarioMapper;
        this.rolMapper = rolMapper;
        this.direccionMapper = direccionMapper;
        this.usuarioDetalleMapper = usuarioDetalleMapper;
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

    @Override
    public List<Direccion> obtenDireccionesDeUsuario(int id) throws BusinessException {
        try {
            return direccionMapper.getUserDirecciones(id);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener las direcciones de un usuario", e.toString());
        }
    }

    @Override
    public UsuarioDetalle obtenDetallesDeUsuario(int id) throws BusinessException {
        try {
            return usuarioDetalleMapper.getById(id);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener los detalles de un usuario", e.toString());
        }
    }

}
