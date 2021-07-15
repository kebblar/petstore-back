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
 * Artefacto:   MediaTipoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (23_19)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2319 Implementación de clase
 *
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
