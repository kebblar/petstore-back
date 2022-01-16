package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.UsuarioHabilidad;
import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.response.HabResponse;

public interface HabilidadService {
    List<HabResponse> getHabilidadResponseList(int id) throws ServiceException;
    List<HabResponse> getHabilidades() throws ServiceException;
    int insertUsuarioHabilidad(UsuarioHabilidad usuarioHabilidad) throws ServiceException;
    int deleteUsuarioHabilidades(int id) throws ServiceException;
    int insertUsuarioHabilidad(List<UsuarioHabilidad> usuarioHabilidadesList) throws ServiceException;
    List<HabResponse> getHabilidadResponseListGratis(int id) throws ServiceException;
    List<HabResponse> getHabilidadResponseListConCosto(int id) throws ServiceException;
}
