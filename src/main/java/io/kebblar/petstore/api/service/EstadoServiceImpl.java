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
 * Fecha:       Lunes 3 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *              20210517_1615 Creación del método getByNombre
 *              20210517_1625 Creación del método getEstadosByPais
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.domain.Pais;
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
    

	@Override
	public List<Estado> getByNombre(String nombre) throws BusinessException {
        try {
            return estadoMapper.getByNombre(nombre);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de un Estado", e.getMessage());
        }
	}

	@Override
	public List<Estado> getEstadosByPais(int idPais) throws BusinessException {
        try {
            return estadoMapper.getEstadosByPais(idPais);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de un Estado", e.getMessage());
        }
	}

}
