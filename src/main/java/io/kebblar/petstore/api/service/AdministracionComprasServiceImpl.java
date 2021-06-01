/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      AdministracionComprasService
 * Tipo:        interface 
 * Autor:       Luis Martinez
 * Fecha:       Martes 19 de mayo del 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio asociado a la entidad 'AdministracionCompras'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por LMtz
 *
 */
package io.kebblar.petstore.api.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.mapper.AdministracionComprasMapper;
import io.kebblar.petstore.api.model.domain.AdministracionCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'AdministracionCompras'. 
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
@Service
public class AdministracionComprasServiceImpl implements AdministracionComprasService{
	private static final Logger logger = LoggerFactory.getLogger(AdministracionComprasServiceImpl.class);
	private AdministracionComprasMapper mapper;
	
	public AdministracionComprasServiceImpl(AdministracionComprasMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<AdministracionCompras> getAll() throws BusinessException {
		try {
			return mapper.getAll();
		}catch(Exception sql) {
			logger.error(sql.getMessage());
			throw new BusinessException("error de base de datos",
		            "ocurrio un error al acceder a la base de datos",500,"500",
		            HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public String sent(int estadoEnvio, int idCompra) throws BusinessException {
		try {
			mapper.sent(estadoEnvio, idCompra);
			return "{\"succed\": \"true\"}";
		}catch(Exception sql) {
			logger.error(sql.getMessage());
			throw new BusinessException("id no encontrado o estado del envio invalido",
		            "ocurrio un error al actualizar el estado del envio porque el id no existe o porque el estado envio no es valido",500,"500",
		            HttpStatus.NOT_FOUND);
		}
		
	}

}
