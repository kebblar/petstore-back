
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
 * Artefacto:   UsuarioDetalleServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       viernes 05 de mayo de 2021 (21_01)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210521_2101 Implementación de clase 
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'usuario_detalle'. 
 *
 * <p>Implementación de la interfaz {@link UsuarioDetalleService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.UsuarioDetalle
 * @see  io.kebblar.petstore.api.service.UsuarioDetalleService
 */

@Service("usuarioDetalleService")
public class UsuarioDetalleServiceImpl implements UsuarioDetalleService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDetalleServiceImpl.class);

    private UsuarioDetalleMapper usuarioDetalleMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param usuarioDetalleMapper mapper utilizado para llamar a metodos de persistencia
     */
    public UsuarioDetalleServiceImpl(UsuarioDetalleMapper usuarioDetalleMapper) {
        this.usuarioDetalleMapper = usuarioDetalleMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public UsuarioDetalle getById(int id) throws BusinessException {
        try {
            return usuarioDetalleMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<UsuarioDetalle> getAll() throws BusinessException {
        try {
            return usuarioDetalleMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            return usuarioDetalleMapper.insert(usuarioDetalle);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            return usuarioDetalleMapper.update(usuarioDetalle);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            return usuarioDetalleMapper.delete(usuarioDetalle.getIdUsuario());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            if (getById(usuarioDetalle.getIdUsuario()) == null) {
                return usuarioDetalleMapper.insert(usuarioDetalle);
            } else {
                return usuarioDetalleMapper.update(usuarioDetalle);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

}
