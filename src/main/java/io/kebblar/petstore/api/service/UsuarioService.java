package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;

public interface UsuarioService {
    Usuario creaUsuario(CredencialesRequest cred) throws BusinessException;
    Usuario actualizaUsuario(Usuario usuario) throws BusinessException;
    Usuario obtenUsuarioPorId(int id) throws BusinessException;
    List<Usuario> obtenTodosUsuarios() throws BusinessException;
    Usuario eliminaUsuario(int id) throws BusinessException;
    Usuario obtenUsuarioPorCorreo(String correo) throws BusinessException;
    List<Rol> obtenRolesDeUsuario(int id) throws BusinessException;
    List<Direccion> obtenDireccionesDeUsuario(int id) throws BusinessException;
    UsuarioDetalle obtenDetallesDeUsuario(int id) throws BusinessException;
}
