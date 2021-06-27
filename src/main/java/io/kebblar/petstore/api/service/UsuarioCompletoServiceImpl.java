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
 * Artefacto:   UsuarioCompletoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Sunday 06 de June de 2021 (09_35)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210627_0935 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.UsuarioCompleto;
import io.kebblar.petstore.api.mapper.UsuarioCompletoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'usuario_completo'. 
 *
 * <p>Implementación de la interfaz {@link UsuarioCompletoService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.UsuarioCompleto
 * @see  io.kebblar.petstore.api.service.UsuarioCompletoService
 */
@Service("usuarioCompletoService")
public class UsuarioCompletoServiceImpl implements UsuarioCompletoService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioCompletoServiceImpl.class);

    private UsuarioCompletoMapper usuarioCompletoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param usuarioCompletoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public UsuarioCompletoServiceImpl(UsuarioCompletoMapper usuarioCompletoMapper) {
        this.usuarioCompletoMapper = usuarioCompletoMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public UsuarioCompleto getById(int id) throws BusinessException {
        try {
            return usuarioCompletoMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<UsuarioCompleto> getAll() throws BusinessException {
        try {
            return usuarioCompletoMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(UsuarioCompleto usuarioCompleto) throws BusinessException {
        try {
            return usuarioCompletoMapper.update(usuarioCompleto);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

}
