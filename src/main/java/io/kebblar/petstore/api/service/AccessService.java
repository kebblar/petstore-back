package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;

public interface AccessService {
    Usuario createUser(CredencialesRequest cred) throws BusinessException;
    Usuario updateUser(Usuario usuario) throws BusinessException;
    Usuario getUser(int id) throws BusinessException;
    List<Usuario> getAllUsers() throws BusinessException;
    Usuario eliminaUsuario(int id) throws BusinessException;

}
