
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
 * Artefacto:   RolServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       jueves 06 de junio de 2021 (17_26)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210624_1726 Implementación de clase
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.mapper.RolMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'rol'.
 *
 * <p>Implementación de la interfaz {@link RolService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.Rol
 * @see  io.kebblar.petstore.api.service.RolService
 */

@Service("rolService")
public class RolServiceImpl implements RolService {
    private static final Logger logger = LoggerFactory.getLogger(RolServiceImpl.class);

    private RolMapper rolMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param rolMapper mapper utilizado para llamar a metodos de persistencia
     */
    public RolServiceImpl(RolMapper rolMapper) {
        logger.debug("Invoking RolServiceImpl constructor");
        this.rolMapper = rolMapper;
    }

    @Override
    public Rol getById(int id) throws BusinessException {
        try {
            return rolMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Rol> getAll() throws BusinessException {
        try {
            return rolMapper.getAllSinFiltros();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int insert(Rol rol) throws BusinessException {
        try {
            return rolMapper.insert(rol);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int update(Rol rol) throws BusinessException {
        try {
            return rolMapper.update(rol);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int delete(Rol rol) throws BusinessException {
        try {
            return rolMapper.delete(rol.getId());
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public int save(Rol rol) throws BusinessException {
        try {
            if (getById(rol.getId()) == null) {
                return rolMapper.insert(rol);
            } else {
                return rolMapper.update(rol);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
