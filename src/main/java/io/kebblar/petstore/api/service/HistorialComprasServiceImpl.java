/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      HistorialComprasServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:46:33
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
