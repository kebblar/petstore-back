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
 * Nombre:      EstadoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:44:29
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * Servicio asociado a la entidad 'estado'.
 *
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.EstadoService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see  Estado
 * @see  EstadoService
 */
@Service("estadoService")
public class EstadoServiceImpl implements EstadoService {
    private static final Logger logger = LoggerFactory.getLogger(EstadoServiceImpl.class);
    private EstadoMapper estadoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param estadoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public EstadoServiceImpl(EstadoMapper estadoMapper) {
        logger.debug("Invoking EstadoServiceImpl constructor");
        this.estadoMapper = estadoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public Estado getById(int id) throws BusinessException {
        try {
            return estadoMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getAll() throws BusinessException {
        try {
            return estadoMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int insert(Estado estado) throws BusinessException {
        try {
            return estadoMapper.insert(estado);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int update(Estado estado) throws BusinessException {
        try {
            return estadoMapper.update(estado);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int delete(Estado estado) throws BusinessException {
        try {
            return estadoMapper.delete(estado.getId());
        } catch (Exception e) {
            throw new MapperCallException("Error en la eliminación del estado seleccionado ", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getByPais(int id) throws BusinessException {
        try{
            return estadoMapper.getByPais(id);
        }catch (SQLException e){
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int save(Estado estado) throws BusinessException {
        try {
            if (getById(estado.getId()) == null) {
                return estadoMapper.insert(estado);
            } else {
                return estadoMapper.update(estado);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getByNombre(String nombre, int idPais) throws BusinessException {
        try {
            if(idPais > 0) {
                return estadoMapper.getByNombreAndIdPais(nombre, idPais);
            } else  {
                return estadoMapper.getByNombre(nombre);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getEstadosByPais(int idPais) throws BusinessException {
        try {
            return estadoMapper.getEstadosByPais(idPais);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getAllNombrePais() throws BusinessException {
        try {
            return estadoMapper.getAllNombrePais();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
