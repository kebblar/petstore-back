/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   DireccionServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *              0210511_0839 Actualización de licencia
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.mapper.DireccionMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * Servicio asociado a la entidad 'direccion'.
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Service("direccionService")
public class DireccionServiceImpl implements DireccionService {

    private static final Logger logger = LoggerFactory.getLogger(DireccionServiceImpl.class);

    private DireccionMapper direccionMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los servicios
     * adicionales a ser empleados en esta clase.
     * 
     * @param direccionMapper
     */
    public DireccionServiceImpl(DireccionMapper direccionMapper) {
        this.direccionMapper = direccionMapper;
    }

    @Override
    public Direccion getById(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.getById(direccion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de una Dirección", e.getMessage());
        }
    }

    @Override
    public List<Direccion> getAll() throws BusinessException {
        try {
            return direccionMapper.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de las Direcciones", e.getMessage());
        }
    }

    @Override
    public int insert(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.insert(direccion);
        } catch (Exception e) {
            throw new MapperCallException("Error de inserción de la Dirección", e.getMessage());
        }
    }

    @Override
    public int update(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.update(direccion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de actualización de una Dirección", e.getMessage());
        }
    }

    @Override
    public int delete(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.delete(direccion.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de borrado de una Dirección", e.getMessage());
        }
    }

    @Override
    public int save(Direccion direccion) throws BusinessException {
        try {
            if (getById(direccion) == null) {
                return direccionMapper.insert(direccion);
            } else {
                return direccionMapper.update(direccion);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de salvado de una Dirección", e.getMessage());
        }
    }

}
