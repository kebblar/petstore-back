/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   PaisServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase
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
 * Servicio asociado a la entidad 'pais'.
 *
 * <p>Implementación de la interfaz {@link PaisService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  Pais
 * @see  PaisService
 */
@Service("paisService")
public class PaisServiceImpl implements PaisService {
    private static final Logger logger = LoggerFactory.getLogger(PaisServiceImpl.class);
    private PaisMapper paisMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param paisMapper mapper utilizado para llamar a metodos de persistencia
     */
    public PaisServiceImpl(PaisMapper paisMapper) {
        this.paisMapper = paisMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public Pais getById(int id) throws BusinessException {
        try {
            return paisMapper.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public List<Pais> getAll() throws BusinessException {
        try {
            return paisMapper.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public int insert(Pais pais) throws BusinessException {
        try {
            return paisMapper.insert(pais);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public int update(Pais pais) throws BusinessException {
        try {
            return paisMapper.update(pais);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public int delete(Pais pais) throws BusinessException {
        try {
            return paisMapper.delete(pais.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error en la eliminación del pais seleccionado ", e.getMessage());
        }
    }

    @Override
    public int save(Pais pais) throws BusinessException {
        try {
            if (getById(pais.getId()) == null) {
                return paisMapper.insert(pais);
            } else {
                return paisMapper.update(pais);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public List<Pais> getByNombre(String nombre) throws BusinessException {
        try {
            return paisMapper.getByNombre(nombre);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

}
