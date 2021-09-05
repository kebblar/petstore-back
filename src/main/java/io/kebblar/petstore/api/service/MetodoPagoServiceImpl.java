/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      MetodoPagoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:48:16
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
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'metodo_pago'.
 *
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.MetodoPagoService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
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
        logger.debug("Invoking MetodoPagoServiceImpl constructor");
        this.metodoPagoMapper = metodoPagoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public MetodoPago getById(int id) throws BusinessException {
        try {
            return metodoPagoMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<MetodoPago> getAll() throws BusinessException {
        try {
            return metodoPagoMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int insert(MetodoPago metodoPago) throws BusinessException {
        try {
            return metodoPagoMapper.insert(metodoPago);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int update(MetodoPago metodoPago) throws BusinessException {
        try {
            return metodoPagoMapper.update(metodoPago);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int delete(MetodoPago metodoPago) throws BusinessException {
        try {
            return metodoPagoMapper.delete(metodoPago.getId());
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<MetodoPago> getByIdUser(int id) throws BusinessException {
        try {
            return metodoPagoMapper.getByIdUser(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int save(MetodoPago metodoPago) throws BusinessException {
        try {
            if (getById(metodoPago.getId()) == null) {
                return metodoPagoMapper.insert(metodoPago);
            } else {
                return metodoPagoMapper.update(metodoPago);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
