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
 * Artefacto:   EstadoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase
 *
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
 * <p>Implementación de la interfaz {@link EstadoService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
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

    @Override
    public Estado getById(int id) throws BusinessException {
        try {
            return estadoMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Estado> getAll() throws BusinessException {
        try {
            return estadoMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int insert(Estado estado) throws BusinessException {
        try {
            return estadoMapper.insert(estado);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int update(Estado estado) throws BusinessException {
        try {
            return estadoMapper.update(estado);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int delete(Estado estado) throws BusinessException {
        try {
            return estadoMapper.delete(estado.getId());
        } catch (Exception e) {
            throw new MapperCallException("Error en la eliminación del estado seleccionado ", e.getMessage());
        }
    }

    @Override
    public List<Estado> getByPais(int id) throws BusinessException {
        try{
            return estadoMapper.getByPais(id);
        }catch (SQLException e){
            throw new BusinessException(e);
        }
    }

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

    @Override
    public List<Estado> getEstadosByPais(int idPais) throws BusinessException {
        try {
            return estadoMapper.getEstadosByPais(idPais);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Estado> getAllNombrePais() throws BusinessException {
        try {
            return estadoMapper.getAllNombrePais();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
