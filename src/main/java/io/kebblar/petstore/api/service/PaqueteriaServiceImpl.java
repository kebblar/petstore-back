/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      PaqueteriaServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:49:28
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Paqueteria;
import io.kebblar.petstore.api.mapper.PaqueteriaMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'paqueteria'.
 *
 * <p>Implementación de la interfaz {@link PaqueteriaService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  Paqueteria
 * @see  PaqueteriaService
 */
@Service("paqueteriaService")
public class PaqueteriaServiceImpl implements PaqueteriaService {

    private static final Logger logger = LoggerFactory.getLogger(PaqueteriaServiceImpl.class);

    private PaqueteriaMapper paqueteriaMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param paqueteriaMapper mapper utilizado para llamar a metodos de persistencia
     */
    public PaqueteriaServiceImpl(PaqueteriaMapper paqueteriaMapper) {
        logger.debug("Invoking PaqueteriaServiceImpl constructor");
        this.paqueteriaMapper = paqueteriaMapper;
    }

    @Override
    public Paqueteria getById(int id) throws BusinessException {
        try {
            return paqueteriaMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Paqueteria> getAll() throws BusinessException {
        try {
            return paqueteriaMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int insert(Paqueteria paqueteria) throws BusinessException {
        try {
            return paqueteriaMapper.insert(paqueteria);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int update(Paqueteria paqueteria) throws BusinessException {
        try {
            return paqueteriaMapper.update(paqueteria);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int delete(Paqueteria paqueteria) throws BusinessException {
        try {
            return paqueteriaMapper.delete(paqueteria.getId());
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int save(Paqueteria paqueteria) throws BusinessException {
        try {
            if (getById(paqueteria.getId()) == null) {
                return paqueteriaMapper.insert(paqueteria);
            } else {
                return paqueteriaMapper.update(paqueteria);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Paqueteria> getByNombre(String nombre) throws BusinessException {
        try {
            return paqueteriaMapper.getByNombre(nombre);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

}
