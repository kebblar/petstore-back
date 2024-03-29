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
 * Nombre:      PaisServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:49:08
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.mapper.PaisMapper;
import io.kebblar.petstore.api.model.exceptions.ServiceException;
import io.kebblar.petstore.api.model.exceptions.MapperException;

/**
 * Servicio asociado a la entidad 'pais'.
 *
 * <p>Implementación de la interfaz {@link PaisService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link ServiceException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  Pais
 * @see  PaisService
 */
@Service("paisService")
public class PaisServiceImpl implements PaisService {
    private static final Logger logger = LoggerFactory.getLogger(PaisServiceImpl.class);
    private final PaisMapper paisMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param paisMapper mapper utilizado para llamar a métodos de persistencia
     */
    public PaisServiceImpl(PaisMapper paisMapper) {
        logger.debug("Invoking PaisServiceImpl constructor");
        this.paisMapper = paisMapper;
    }

    @Override
    public Pais getById(int id) throws ServiceException {
        try {
            return paisMapper.getById(id);
        } catch (Exception e) {
            throw new MapperException("Error al obtener el país con el id "+id, e.getMessage());
        }
    }

    @Override
    public List<Pais> getAll() throws ServiceException {
        try {
            return paisMapper.getAll();
        } catch (Exception e) {
            throw new MapperException("Error al obtener la lista de países", e.getMessage());
        }
    }

    @Override
    public int insert(Pais pais) throws ServiceException {
        try {
            return paisMapper.insert(pais);
        } catch (Exception e) {
            throw new MapperException("Error al insertar el pais "+pais.getNombre(), e.getMessage());
        }
    }

    @Override
    public int update(Pais pais) throws ServiceException {
        try {
            return paisMapper.update(pais);
        } catch (Exception e) {
            throw new MapperException("Error al actualizar el país con el id "+pais.getId(), e.getMessage());
        }
    }

    @Override
    public int delete(Pais pais) throws ServiceException {
        try {
            return paisMapper.delete(pais.getId());
        } catch (Exception e) {
            throw new MapperException("Error en la eliminación del pais seleccionado ", e.getMessage());
        }
    }

    @Override
    public int save(Pais pais) throws ServiceException {
        try {
            if (getById(pais.getId()) == null) {
                return paisMapper.insert(pais);
            } else {
                return paisMapper.update(pais);
            }
        } catch (Exception e) {
            throw new MapperException("Error al actualizar el país con el id "+pais.getId(), e.getMessage());
        }
    }

    @Override
    public List<Pais> getByNombre(String nombre) throws ServiceException {
        try {
            return paisMapper.getByNombre(nombre);
        } catch (Exception e) {
            throw new MapperException("Error al recuperar el país "+nombre, e.getMessage());
        }
    }

}
