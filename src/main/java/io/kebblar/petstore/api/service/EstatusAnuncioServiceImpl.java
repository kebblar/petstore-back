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
 * Artefacto:   EstatusAnuncioServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (00_13)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210606_0013 Implementación de clase
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.EstatusAnuncio;
import io.kebblar.petstore.api.mapper.EstatusAnuncioMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'estatus_anuncio'.
 *
 * <p>Implementación de la interfaz {@link EstatusAnuncioService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.EstatusAnuncio
 * @see  io.kebblar.petstore.api.service.EstatusAnuncioService
 */

@Service("estatusAnuncioService")
public class EstatusAnuncioServiceImpl implements EstatusAnuncioService {

    private static final Logger logger = LoggerFactory.getLogger(EstatusAnuncioServiceImpl.class);

    private EstatusAnuncioMapper estatusAnuncioMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param estatusAnuncioMapper mapper utilizado para llamar a metodos de persistencia
     */
    public EstatusAnuncioServiceImpl(EstatusAnuncioMapper estatusAnuncioMapper) {
        this.estatusAnuncioMapper = estatusAnuncioMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public EstatusAnuncio getById(int id) throws BusinessException {
        try {
            return estatusAnuncioMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<EstatusAnuncio> getAll() throws BusinessException {
        try {
            return estatusAnuncioMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            return estatusAnuncioMapper.insert(estatusAnuncio);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            return estatusAnuncioMapper.update(estatusAnuncio);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            return estatusAnuncioMapper.delete(estatusAnuncio.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error en la eliminación del estatus seleccionado ", e.getMessage());
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            if (getById(estatusAnuncio.getId()) == null) {
                return estatusAnuncioMapper.insert(estatusAnuncio);
            } else {
                return estatusAnuncioMapper.update(estatusAnuncio);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public List<EstatusAnuncio> getByNombre(String nombre) throws BusinessException {
        try {
            return estatusAnuncioMapper.getByNombre(nombre);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException("Error de obtención de un EstatusAnuncio", e.getMessage());
        }
    }
}
