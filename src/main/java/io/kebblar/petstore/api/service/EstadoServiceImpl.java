/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   EstadoServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (08_59)
 * 
 * Clase para la logica del servicio asociado a la entidad 'estado'. 
 * 
 * Historia:    .
 *              20210504_0859 Creación de está implementacion del servicio
 *              20210511_09:01 Se modifica la fecha en la licencia
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'estado'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Service("estadoService")
public class EstadoServiceImpl implements EstadoService {

    private static final Logger logger = LoggerFactory.getLogger(EstadoServiceImpl.class);

    private EstadoMapper estadoMapper;

    /**
     * Constructor que realiza el setting del mapper que serán 
     * utilizados en esta implementacion.
     * 
     * @param usuarioService Servicios de usuario
     */
    public EstadoServiceImpl(EstadoMapper estadoMapper) {
        this.estadoMapper = estadoMapper;
    }

    @Override
    public Estado getById(Estado estado) throws BusinessException {
        try {
            return estadoMapper.getById(estado);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de un Estado", e.getMessage());
        }
    }

    @Override
    public List<Estado> getAll() throws BusinessException {
        try {
            return estadoMapper.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de los Estados", e.getMessage());
        }
    }

    @Override
    public int insert(Estado estado) throws BusinessException {
        try {
            return estadoMapper.insert(estado);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de inserción de un Estado", e.getMessage());
        }
    }

    @Override
    public int update(Estado estado) throws BusinessException {
        try {
            return estadoMapper.update(estado);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de actualización de un Estado", e.getMessage());
        }
    }

    @Override
    public int delete(Estado estado) throws BusinessException {
        try {
            return estadoMapper.delete(estado.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de borrado de un Estado", e.getMessage());
        }
    }

    @Override
    public int save(Estado estado) throws BusinessException {
        try {
            if (getById(estado) == null) {
                return estadoMapper.insert(estado);
            } else {
                return estadoMapper.update(estado);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de salvado de un Estado", e.getMessage());
        }
    }

}