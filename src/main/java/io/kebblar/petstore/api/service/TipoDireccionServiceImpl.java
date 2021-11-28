/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      TipoDireccionServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:25:39
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.TipoDireccion;
import io.kebblar.petstore.api.mapper.TipoDireccionMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.TipoDireccionService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author luz
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see  TipoDireccion
 * @see  TipoDireccionService
 */
@Service("tipoDireccionService")
public class TipoDireccionServiceImpl implements TipoDireccionService {
    private static final Logger logger = LoggerFactory.getLogger(TipoDireccionServiceImpl.class);

    private final TipoDireccionMapper tipoDireccionMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param tipoDireccionMapper mapper utilizado para llamar a metodos de persistencia
     */
    public TipoDireccionServiceImpl(TipoDireccionMapper tipoDireccionMapper) {
        logger.debug("Invoking TipoDireccionServiceImpl constructor");
        this.tipoDireccionMapper = tipoDireccionMapper;
    }

    /** {@inheritDoc} */
    @Override
    public TipoDireccion getById(int id) throws BusinessException {
        try {
            return tipoDireccionMapper.getById(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener el tipo de dirección: "+id, e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<TipoDireccion> getAll() throws BusinessException {
        try {
            return tipoDireccionMapper.getAll();
        } catch (SQLException e) {
            throw new MapperCallException("Error al recuperar la lista de tipo dirección", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int insert(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.insert(tipoDireccion);
        } catch (SQLException e) {
            throw new MapperCallException("Error al insertar un nuevo tipo de dirección "+tipoDireccion.getNombre(), e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int update(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.update(tipoDireccion);
        } catch (SQLException e) {
            throw new MapperCallException("Error al actualizar el tipo de dirección "+tipoDireccion.getId(), e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int delete(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.delete(tipoDireccion.getId());
        } catch (SQLException e) {
            throw new MapperCallException("Error al borrar el tipo de dirección "+tipoDireccion.getId(), e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int save(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            if (getById(tipoDireccion.getId()) == null) {
                return tipoDireccionMapper.insert(tipoDireccion);
            } else {
                return tipoDireccionMapper.update(tipoDireccion);
            }
        } catch (SQLException e) {
            throw new MapperCallException("Error al actualizar el tipo de dirección "+tipoDireccion.getId(), e.getMessage());
        }
    }

}
