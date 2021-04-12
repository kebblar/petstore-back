package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

public interface EstadoService {
    List<Estado> getAll() throws BusinessException;
    Estado getEstado(int id) throws BusinessException;
}
