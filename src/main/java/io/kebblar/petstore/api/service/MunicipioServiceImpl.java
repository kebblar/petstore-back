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
 * Nombre:      MunicipioServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:48:32
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;

import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.mapper.MunicipioMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'municipio'.
 *
 * <p>Implementación de la interfaz {@link MunicipioService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  Municipio
 * @see  MunicipioService
 */
@Service("municipioService")
public class MunicipioServiceImpl implements MunicipioService {
    private static final Logger logger = LoggerFactory.getLogger(MunicipioServiceImpl.class);
    private MunicipioMapper municipioMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param municipioMapper mapper utilizado para llamar a metodos de persistencia
     */
    public MunicipioServiceImpl(MunicipioMapper municipioMapper) {
        logger.debug("Invoking MunicipioServiceImpl constructor");
        this.municipioMapper = municipioMapper;
    }

    @Override
    public Municipio getById(int id) throws BusinessException {
        try {
            return municipioMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Municipio> getAll() throws BusinessException {
        try {
            return municipioMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int insert(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.insert(municipio);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int update(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.update(municipio);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int delete(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.delete(municipio.getId());
        } catch (Exception e) {
            throw new MapperCallException("Error en la eliminación del Municipio seleccionado ", e.getMessage());
        }
    }

    @Override
    public List<Municipio> getByEstado(int id) throws BusinessException {
        try {
            return municipioMapper.getByEstado(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int save(Municipio municipio) throws BusinessException {
        try {
            if (getById(municipio.getId()) == null) {
                return municipioMapper.insert(municipio);
            } else {
                return municipioMapper.update(municipio);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Municipio> getPaginatedMunicipios(int idEstado, int pageNumber, int pageSize) throws BusinessException {
        try {
            return municipioMapper.getPaginatedMunicipios(idEstado, (pageNumber-1)*pageSize, pageSize);
        } catch (Exception e) {
            throw new MapperCallException("Error de obtención de los Municipios", e.getMessage());
        }
    }

    @Override
    public List<Municipio> getMunicipiosDescripcion() throws BusinessException {
        try {
            return municipioMapper.getMunicipiosDescripcion();
        } catch (Exception e) {
            throw new MapperCallException("Error de obtención de los Municipios asociados a un Estado", e.getMessage());
        }
    }


    @Override
    public List<Municipio> getMunicipiosDescripcionByNombre(String nombre) throws BusinessException {
        try {
            return municipioMapper.getByNombre(nombre);
        } catch (Exception e) {
            throw new MapperCallException("Error de obtención de los Municipios asociados a un Estado", e.getMessage());
        }
    }

    @Override
    public List<Municipio> getMunicipiosByPaisDescripcion(int pais, String nombre) throws BusinessException {
        try {
            if(pais > 0 && (nombre == null || nombre.trim().length()<1 )) {
                return municipioMapper.getMunicipiosByPaisDescripcion(pais);
            } else if (pais > 0 && nombre.length()>0 ) {
                return municipioMapper.getMunicipiosByPaisNombreDescripcion(pais, nombre);
            } else if(nombre != null) {
                return municipioMapper.getByNombre(nombre);
            }  else {
                return municipioMapper.getMunicipiosDescripcion();
            }
        } catch (Exception e) {
            throw new MapperCallException("Error de obtención de los Municipios asociados a un Estado", e.getMessage());
        }
    }

    @Override
    public List<Municipio> getMunicipiosByEstadoDescripcion(int estado, String nombre) throws BusinessException {
        try {
            if(estado > 0 ) {
                return municipioMapper.getMunicipiosByEstadoNombreDescripcion(estado, nombre);
            } else {
                return municipioMapper.getMunicipiosDescripcion();
            }
        } catch (Exception e) {
            throw new MapperCallException("Error de obtención de los Municipios asociados a un Estado", e.getMessage());
        }
    }

}
