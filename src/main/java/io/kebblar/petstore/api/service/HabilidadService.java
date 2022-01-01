package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.Habilidad;
import io.kebblar.petstore.api.model.domain.UsuarioHabilidad;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.HabilidadResponse;

public interface HabilidadService {
    List<HabilidadResponse> getHabilidadResponseList(int id) throws BusinessException;
    List<Habilidad> getHabilidades() throws BusinessException;
    int insertUsuarioHabilidad(UsuarioHabilidad usuarioHabilidad) throws BusinessException;
    int deleteUsuarioHabilidades(int id) throws BusinessException;
    int insertUsuarioHabilidad(List<UsuarioHabilidad> usuarioHabilidadesList) throws BusinessException;
}
