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
 * Nombre:      UsuarioCompletoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:23:38
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;

import io.kebblar.petstore.api.model.exceptions.MapperCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioCompleto;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.mapper.UsuarioCompletoMapper;
import io.kebblar.petstore.api.mapper.UsuarioDetalleMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
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

    private final UsuarioCompletoMapper usuarioCompletoMapper;
    private final UsuarioDetalleMapper usuarioDetalleMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     *
     * @param usuarioCompletoMapper mapper utilizado para llamar a métodos de persistencia
     */
    public UsuarioCompletoServiceImpl(
            UsuarioDetalleMapper usuarioDetalleMapper,
            UsuarioCompletoMapper usuarioCompletoMapper
            ) {
        logger.debug("Invocando al constructor de la clase");
        this.usuarioCompletoMapper = usuarioCompletoMapper;
        this.usuarioDetalleMapper = usuarioDetalleMapper;
    }

    @Override
    public UsuarioCompleto getById(int id) throws BusinessException {
        try {
            return usuarioCompletoMapper.getById(id);
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener el usuario con el id "+id, e.getMessage());
        }
    }

    @Override
    public List<UsuarioCompleto> getAll() throws BusinessException {
        try {
            return usuarioCompletoMapper.getAll();
        } catch (SQLException e) {
            throw new MapperCallException("Error al obtener la lista de usuarios", e.getMessage());
        }
    }

    @Override
    public int update(UsuarioCompleto usuarioCompleto) throws BusinessException {
        Usuario u = new Usuario(
                usuarioCompleto.getId(),
                "", // el correo no se actualiza aqui
                "", // la clave no se actualiza aqui
                -1L, // la fecha de creación debe ser incambiable
                usuarioCompleto.isActivo(),
                usuarioCompleto.getAccesoNegadoContador(),
                usuarioCompleto.getInstanteBloqueo(),
                usuarioCompleto.getInstanteUltimoAcceso(),
                usuarioCompleto.getInstanteUltimoCambioClave(),
                usuarioCompleto.getRegeneraClaveToken(),
                usuarioCompleto.getRegeneraClaveInstante()
                );
        UsuarioDetalle ud = new UsuarioDetalle(
                usuarioCompleto.getId(),
                usuarioCompleto.getNombre(),
                usuarioCompleto.getApellidoPaterno(),
                usuarioCompleto.getApellidoMaterno(),
                usuarioCompleto.getNickName(),
                usuarioCompleto.getFechaNacimiento(),
                usuarioCompleto.getTelefonoCelular()
                );
        try {
            int a = usuarioCompletoMapper.updateUsuarioPlano(u);
            int b = usuarioDetalleMapper.update(ud);
            return a+b;
        } catch (SQLException e) {
            throw new MapperCallException("Error al actualizar el usuario con el id "+usuarioCompleto.getId(), e.getMessage());
        }
    }

    @Override
    public List<UsuarioCompleto> getAllPaginated(int pageNumber, int pageSize) throws BusinessException {
        try {
            return usuarioCompletoMapper.getAllPaginated((pageNumber-1)*pageSize, pageSize);
        } catch (SQLException e) {
            throw new MapperCallException("No ha sido posible recuperar la lista de usuarios", e.getMessage());
        }
    }

    @Override
    public int countUsuarios() throws BusinessException {
        try {
            return usuarioCompletoMapper.countUsuarios();
        } catch (SQLException e) {
            throw new MapperCallException("Error al retornar la cuenta de los usuarios", e.getMessage());
        }
    }

}
