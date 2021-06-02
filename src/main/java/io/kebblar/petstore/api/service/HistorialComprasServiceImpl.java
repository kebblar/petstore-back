/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      HistorialComprasServiceImpl
 * Tipo:        interface
 * Autor:       Luis Martinez
 * Fecha:       Martes 19 de mayo del 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Sevicio asociado a la entidad 'HistorialCompras'.
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

import io.kebblar.petstore.api.mapper.HistorialComprasMapper;
import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.HttpStatus;
/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'HistorialComprasServicel'.
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
@Service
public class HistorialComprasServiceImpl implements HistorialComprasService{
    private static final Logger logger = LoggerFactory.getLogger(HistorialComprasServiceImpl.class);
    private HistorialComprasMapper historialMapper;

    public HistorialComprasServiceImpl(HistorialComprasMapper historialMapper) {
        this.historialMapper = historialMapper;
    }

    @Override
    public List<HistorialCompras> getAll(int idUsuario) throws BusinessException {
        try {
            return historialMapper.getAll(idUsuario);
        }catch(Exception sql) {
            logger.error(sql.getMessage());
            throw new BusinessException("id no encontrado",
                    "ocurrio un error al buscar el id en la base de datos",500,"500",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
