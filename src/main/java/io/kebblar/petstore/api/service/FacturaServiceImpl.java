package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.exceptions.ProductoInexistenteException;
import io.kebblar.petstore.api.mapper.FacturaMapper;
import io.kebblar.petstore.api.model.Factura;

@Service
public class FacturaServiceImpl implements FacturaService {

	private FacturaMapper facturaMapper;

	public FacturaServiceImpl(FacturaMapper facturaMapper) {
		this.facturaMapper = facturaMapper;
	}

	/*
	 * @Override public int insert(Factura factura) throws BusinessException { try {
	 * return this.facturaMapper.insert(factura); } catch (SQLException e) { throw
	 * new ProductoInexistenteException("Error en BD : " + e.getErrorCode()); } }
	 */

	@Override
	public List<Factura> getAll() throws BusinessException {
		try {
			/*
			 * Factura f1 = new Factura(1, new Date(), "LOUU761023XYZ", 123, 23.5, 15);
			 * Factura f2 = new Factura(2, new Date(), "MEOR891205WQT", 131, 212.5, 13);
			 * List<Factura> resultado = new ArrayList<>(); resultado.add(f1);
			 * resultado.add(f2); return resultado;
			 */
			return this.facturaMapper.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Error al consultar de BD ..." + e.getMessage());
		}
	}

}
