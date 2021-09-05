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
 * Nombre:      MediaTipoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:47:55
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.MediaTipo;
import io.kebblar.petstore.api.mapper.MediaTipoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'media_tipo'.
 *
 * <p>Implementación de la interfaz {@link MediaTipoService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.MediaTipo
 * @see  io.kebblar.petstore.api.service.MediaTipoService
 */
@Service("mediaTipoService")
public class MediaTipoServiceImpl implements MediaTipoService {
    private static final Logger logger = LoggerFactory.getLogger(MediaTipoServiceImpl.class);
    private MediaTipoMapper mediaTipoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param mediaTipoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public MediaTipoServiceImpl(MediaTipoMapper mediaTipoMapper) {
        logger.debug("Invoking GraficaTotalFechasCategoriaServiceImpl constructor");
        this.mediaTipoMapper = mediaTipoMapper;
    }

    @Override
    public MediaTipo getById(int id) throws BusinessException {
        try {
            return mediaTipoMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<MediaTipo> getAll() throws BusinessException {
        try {
            return mediaTipoMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int insert(MediaTipo mediaTipo) throws BusinessException {
        try {
            return mediaTipoMapper.insert(mediaTipo);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int update(MediaTipo mediaTipo) throws BusinessException {
        try {
            return mediaTipoMapper.update(mediaTipo);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int delete(MediaTipo mediaTipo) throws BusinessException {
        try {
            return mediaTipoMapper.delete(mediaTipo.getId());
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int save(MediaTipo mediaTipo) throws BusinessException {
        try {
            if (getById(mediaTipo.getId()) == null) {
                return mediaTipoMapper.insert(mediaTipo);
            } else {
                return mediaTipoMapper.update(mediaTipo);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<MediaTipo> getByNombre(String nombre) throws BusinessException {
        try {
            return mediaTipoMapper.getByNombre(nombre);
        } catch (Exception e) {
            throw new BusinessException("Error de obtención de un MediaTipo", e.getMessage());
        }
    }

}
