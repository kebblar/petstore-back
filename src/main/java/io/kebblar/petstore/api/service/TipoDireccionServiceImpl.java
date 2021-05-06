/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      TipoDireccion
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio asociado a la entidad 'tipo_direccion'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.TipoDireccion;
import io.kebblar.petstore.api.mapper.TipoDireccionMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'tipo_direccion'. 
 *
 * @author Gustavo A. Arellano
 * @see     io.kebblar.petstore.api.model.domain.TipoDireccion
 * @see     io.kebblar.petstore.api.service.TipoDireccion
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Service("tipoDireccionService")
public class TipoDireccionServiceImpl implements TipoDireccionService {

    private static final Logger logger = LoggerFactory.getLogger(TipoDireccionServiceImpl.class);

    private TipoDireccionMapper tipoDireccionMapper;

    /**
     * Constructor que realiza el setting de todos
     * los Mappers y todos los servicios adicionales 
     * a ser empleados en esta clase.
     * 
     * @param tipoDireccionMapper
     */
    public TipoDireccionServiceImpl(TipoDireccionMapper tipoDireccionMapper) {
        this.tipoDireccionMapper = tipoDireccionMapper;
    }

    @Override
    public TipoDireccion getById(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.getById(tipoDireccion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de un Tipo de dirección", e.getMessage());
        }
    }

    @Override
    public List<TipoDireccion> getAll() throws BusinessException {
        try {
            return tipoDireccionMapper.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de los Tipos de direcciónes", e.getMessage());
        }
    }

    @Override
    public int insert(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.insert(tipoDireccion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de inserción de un Tipo de dirección", e.getMessage());
        }
    }

    @Override
    public int update(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.update(tipoDireccion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de actualización de un Tipo de dirección", e.getMessage());
        }
    }

    @Override
    public int delete(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.delete(tipoDireccion.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de borrado de un Tipo de dirección", e.getMessage());
        }
    }

    @Override
    public int save(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            if (getById(tipoDireccion) == null) {
                return tipoDireccionMapper.insert(tipoDireccion);
            } else {
                return tipoDireccionMapper.update(tipoDireccion);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de salvado de un Tipo de dirección", e.getMessage());
        }
    }

}
