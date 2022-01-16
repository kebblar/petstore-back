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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.mapper.EstadoMapper;
import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.exceptions.MapperException;

/**
 * Servicio asociado a la entidad 'estado'.
 *
 * <p>Implementación de la interfaz {@link io.kebblar.petstore.api.service.EstadoService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.ServiceException}
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
    private final EstadoMapper estadoMapper;

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
    public Estado getById(int id) throws ServiceException {
        try {
            return estadoMapper.getById(id);
        } catch (Exception e) {
            throw new MapperException("Error al recuperar el estado con el id "+id,e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getAll() throws ServiceException {
        try {
            return estadoMapper.getAll();
        } catch (Exception e) {
            throw new MapperException("Error al recuperar la lista de estados", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int insert(Estado estado) throws ServiceException {
        try {
            return estadoMapper.insert(estado);
        } catch (Exception e) {
            throw new MapperException("Error al insertar el estado "+estado.getNombre(), e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int update(Estado estado) throws ServiceException {
        try {
            return estadoMapper.update(estado);
        } catch (Exception e) {
            throw new MapperException("Error al actualizar el estado con el id "+estado.getId(),e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int delete(Estado estado) throws ServiceException {
        try {
            return estadoMapper.delete(estado.getId());
        } catch (Exception e) {
            throw new MapperException("Error en la eliminación del estado seleccionado ", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getByPais(int id) throws ServiceException {
        try{
            return estadoMapper.getByPais(id);
        }catch (Exception e){
            throw new ServiceException("Error en obtener los estados asociados al pais "+id, e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int save(Estado estado) throws ServiceException {
        try {
            if (getById(estado.getId()) == null) {
                return estadoMapper.insert(estado);
            } else {
                return estadoMapper.update(estado);
            }
        } catch (Exception e) {
            throw new MapperException("Error al actualizar el estado con el id "+estado.getId(),e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getByNombre(String nombre, int idPais) throws ServiceException {
        try {
            if(idPais > 0) {
                return estadoMapper.getByNombreAndIdPais(nombre, idPais);
            } else  {
                return estadoMapper.getByNombre(nombre);
            }
        } catch (Exception e) {
            throw new MapperException("Error al recuperar el estado "+nombre, e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getEstadosByPais(int idPais) throws ServiceException {
        try {
            return estadoMapper.getEstadosByPais(idPais);
        } catch (Exception e) {
            throw new MapperException("Error en el get del estado", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Estado> getAllNombrePais() throws ServiceException {
        try {
            return estadoMapper.getAllNombrePais();
        } catch (Exception e) {
            throw new MapperException("Error en el get del estado", e.getMessage());
        }
    }

}
