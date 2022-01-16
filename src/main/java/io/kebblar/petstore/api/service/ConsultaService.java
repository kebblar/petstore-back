package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.request.ConsultaRequest;
import io.kebblar.petstore.api.model.response.ConsultaResponse;

public interface ConsultaService {
    List<ConsultaResponse> consulta(String jwt) throws ServiceException;
    String guarda(String jwt, List<ConsultaRequest> datos) throws ServiceException;
}
