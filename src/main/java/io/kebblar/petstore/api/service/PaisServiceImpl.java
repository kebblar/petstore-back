/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      Pais
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio asociado a la entidad 'pais'. 
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
import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.mapper.PaisMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'pais'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Service("paisService")
public class PaisServiceImpl implements PaisService {

    private static final Logger logger = LoggerFactory.getLogger(PaisServiceImpl.class);

    private PaisMapper paisMapper;

    public PaisServiceImpl(PaisMapper paisMapper) {
        this.paisMapper = paisMapper;
    }

    @Override
    public Pais getById(Pais pais) throws BusinessException {
        try {
            return paisMapper.getById(pais);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de un Pais", e.getMessage());
        }
    }

    @Override
    public List<Pais> getAll() throws BusinessException {
        try {
            return paisMapper.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de los Paises", e.getMessage());
        }
    }

    @Override
    public int insert(Pais pais) throws BusinessException {
        try {
            return paisMapper.insert(pais);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de inserción de un Pais", e.getMessage());
        }
    }

    @Override
    public int update(Pais pais) throws BusinessException {
        try {
            return paisMapper.update(pais);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de actualización de un Pais", e.getMessage());
        }
    }

    @Override
    public int delete(Pais pais) throws BusinessException {
        try {
            return paisMapper.delete(pais.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de borrado de un Pais", e.getMessage());
        }
    }

    @Override
    public int save(Pais pais) throws BusinessException {
        try {
            if (getById(pais) == null) {
                return paisMapper.insert(pais);
            } else {
                return paisMapper.update(pais);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de salvado de un Pais", e.getMessage());
        }
    }

}
