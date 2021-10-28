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
 * Nombre:      RolServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 09:22:53
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
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

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

    private final RolMapper rolMapper;

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
            throw new MapperCallException("Error al obtener el rol "+id, e.getMessage());
        }
    }

    @Override
    public List<Rol> getAll() throws BusinessException {
        try {
            return rolMapper.getAllSinFiltros();
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener la lista de roles", e.getMessage());
        }
    }

    @Override
    public int insert(Rol rol) throws BusinessException {
        try {
            return rolMapper.insert(rol);
        } catch (SQLException e) {
            throw new MapperCallException("Error al insertar un nuevo rol "+rol.getNombre(), e.getMessage());
        }
    }

    @Override
    public int update(Rol rol) throws BusinessException {
        try {
            return rolMapper.update(rol);
        } catch (SQLException e) {
            throw new MapperCallException("Error al actualizar el rol con el id "+rol.getId(), e.getMessage());
        }
    }

    @Override
    public int delete(Rol rol) throws BusinessException {
        try {
            return rolMapper.delete(rol.getId());
        } catch (SQLException e) {
            throw new MapperCallException("Error al borrar el rol "+rol.getNombre(), e.getMessage());
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
            throw new MapperCallException("Error al actualizar el rol con el id "+rol.getId(), e.getMessage());
        }
    }

}
