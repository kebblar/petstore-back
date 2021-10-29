package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.ConsultaRequest;
import io.kebblar.petstore.api.model.response.ConsultaResponse;

public interface ConsultaService {
	List<ConsultaResponse> consulta(String jwt, String encryptKey) throws BusinessException;
	List<ConsultaRequest> guarda(String jwt, String encryptKey, List<ConsultaRequest> datos) throws BusinessException;
}
