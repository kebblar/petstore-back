/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TipoDireccionServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_44)
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
import io.kebblar.petstore.api.model.domain.TipoDireccion;
import io.kebblar.petstore.api.mapper.TipoDireccionMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * <p>Implementación de la interfaz {@link TipoDireccionService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author luz
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  TipoDireccion
 * @see  TipoDireccionService
 */
@Service("tipoDireccionService")
public class TipoDireccionServiceImpl implements TipoDireccionService {
    private static final Logger logger = LoggerFactory.getLogger(TipoDireccionServiceImpl.class);

    private TipoDireccionMapper tipoDireccionMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param tipoDireccionMapper mapper utilizado para llamar a metodos de persistencia
     */
    public TipoDireccionServiceImpl(TipoDireccionMapper tipoDireccionMapper) {
        logger.debug("Invoking TipoDireccionServiceImpl constructor");
        this.tipoDireccionMapper = tipoDireccionMapper;
    }

    @Override
    public TipoDireccion getById(int id) throws BusinessException {
        try {
            return tipoDireccionMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<TipoDireccion> getAll() throws BusinessException {
        try {
            return tipoDireccionMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int insert(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.insert(tipoDireccion);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int update(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.update(tipoDireccion);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int delete(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            return tipoDireccionMapper.delete(tipoDireccion.getId());
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int save(TipoDireccion tipoDireccion) throws BusinessException {
        try {
            if (getById(tipoDireccion.getId()) == null) {
                return tipoDireccionMapper.insert(tipoDireccion);
            } else {
                return tipoDireccionMapper.update(tipoDireccion);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
