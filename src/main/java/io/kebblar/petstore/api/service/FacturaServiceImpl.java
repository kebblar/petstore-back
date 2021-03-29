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

	@Override
	public int insert(Factura factura) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return this.facturaMapper.insert(factura);
		} catch (SQLException e) {
			throw new ProductoInexistenteException(
					"Lo lamentamos pero ha ocurrido un error en la base de datos. Consulte con su administrador y proporciones el siguiente codigo: "
							+ e.getErrorCode());
		}
	}

	@Override
	public List<Factura> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			/*
			Factura f1 = new Factura(1, new Date(), "MALU920418EZ2", 123, 234.5, 15);
			Factura f2 = new Factura(1, new Date(), "MALU920418EZ3", 321, 2434.5, 14);

			List<Factura> resultado = new ArrayList<>();
			resultado.add(f1);
			resultado.add(f2);
             */
			return this.facturaMapper.getAll();
			//return resultado;
		} catch (Exception e) {
			throw new BusinessException("Texto adecuado ...."+e.getMessage());
		}
	}

}
