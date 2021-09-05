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
 * Nombre:      EstatusAnuncioServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:44:47
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
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
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
        logger.debug("Invoking EstatusAnuncioServiceImpl constructor");
        this.estatusAnuncioMapper = estatusAnuncioMapper;
    }

    @Override
    public EstatusAnuncio getById(int id) throws BusinessException {
        try {
            return estatusAnuncioMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<EstatusAnuncio> getAll() throws BusinessException {
        try {
            return estatusAnuncioMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int insert(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            return estatusAnuncioMapper.insert(estatusAnuncio);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int update(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            return estatusAnuncioMapper.update(estatusAnuncio);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int delete(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            return estatusAnuncioMapper.delete(estatusAnuncio.getId());
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int save(EstatusAnuncio estatusAnuncio) throws BusinessException {
        try {
            if (getById(estatusAnuncio.getId()) == null) {
                return estatusAnuncioMapper.insert(estatusAnuncio);
            } else {
                return estatusAnuncioMapper.update(estatusAnuncio);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<EstatusAnuncio> getByNombre(String nombre) throws BusinessException {
        try {
            return estatusAnuncioMapper.getByNombre(nombre);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

}
