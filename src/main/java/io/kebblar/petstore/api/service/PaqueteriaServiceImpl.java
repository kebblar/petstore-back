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
 * Artefacto:   PaqueteriaServiceImpl .java
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
