package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;

public interface AnuncioService {

    DetalleAnuncioResponse detalleAnuncio(int id) throws BusinessException;
}
