
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
 * Artefacto:   CarritoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 06 de June de 2021 (13_15)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210608_1315 Implementación de clase 
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.mapper.CarritoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'carrito'. 
 *
 * <p>Implementación de la interfaz {@link CarritoService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  Carrito
 * @see  CarritoService
 */

@Service("carritoService")
public class CarritoServiceImpl implements CarritoService {

    private static final Logger logger = LoggerFactory.getLogger(CarritoServiceImpl.class);

    private CarritoMapper carritoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param carritoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public CarritoServiceImpl(CarritoMapper carritoMapper) {
        this.carritoMapper = carritoMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public Carrito getById(int id) throws BusinessException {
        try {
            return carritoMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<Carrito> getAll(int id) throws BusinessException {
        try {
            return carritoMapper.getAll(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(Carrito carrito) throws BusinessException {
        try {
            return carritoMapper.insert(carrito);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(Carrito carrito) throws BusinessException {
        try {
            return carritoMapper.update(carrito);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(Carrito carrito) throws BusinessException {
        try {
            return carritoMapper.delete(carrito.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(Carrito carrito) throws BusinessException {
        try {
            if (getById(carrito.getId()) == null) {
                return carritoMapper.insert(carrito);
            } else {
                return carritoMapper.update(carrito);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

}
