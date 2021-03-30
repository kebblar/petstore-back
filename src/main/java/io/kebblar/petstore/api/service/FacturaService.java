package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.Factura;

public interface FacturaService {

	//int insert(Factura factura) throws BusinessException;

	List<Factura> getAll() throws BusinessException;

}
