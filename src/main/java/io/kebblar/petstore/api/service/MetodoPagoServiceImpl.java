
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
 * Artefacto:   MetodoPagoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Monday 05 de May de 2021 (15_02)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210510_1502 Implementación de clase 
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.MetodoPago;
import io.kebblar.petstore.api.mapper.MetodoPagoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'metodo_pago'. 
 *
 * <p>Implementación de la interfaz {@link MetodoPagoService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  MetodoPago
 * @see  MetodoPagoService
 */

@Service("metodoPagoService")
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private static final Logger logger = LoggerFactory.getLogger(MetodoPagoServiceImpl.class);

    private MetodoPagoMapper metodoPagoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param metodoPagoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public MetodoPagoServiceImpl(MetodoPagoMapper metodoPagoMapper) {
        this.metodoPagoMapper = metodoPagoMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public MetodoPago getById(int id) throws BusinessException {
        try {
            return metodoPagoMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<MetodoPago> getAll() throws BusinessException {
        try {
            return metodoPagoMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(MetodoPago metodoPago) throws BusinessException {
        try {
            return metodoPagoMapper.insert(metodoPago);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(MetodoPago metodoPago) throws BusinessException {
        try {
            return metodoPagoMapper.update(metodoPago);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(MetodoPago metodoPago) throws BusinessException {
        try {
            return metodoPagoMapper.delete(metodoPago.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public List<MetodoPago> getByUser(int idUser) throws BusinessException{
        try {
            return metodoPagoMapper.getByUser(idUser);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(MetodoPago metodoPago) throws BusinessException {
        try {
            if (getById(metodoPago.getId()) == null) {
                return metodoPagoMapper.insert(metodoPago);
            } else {
                return metodoPagoMapper.update(metodoPago);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

}
