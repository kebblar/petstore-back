/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   DireccionServiceImpl.java
 * Tipo:        Clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_25)
 *
 * Historia:    .
 *              0210506_0925 Creación de éste servicio de implementación
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.UsuarioDireccion;
import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.mapper.DireccionMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Implementación de la interfaz {@link DireccionService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Direccion
 * @see     io.kebblar.petstore.api.service.DireccionService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service("direccionService")
public class DireccionServiceImpl implements DireccionService {
    private static final Logger logger = LoggerFactory.getLogger(DireccionServiceImpl.class);

    private DireccionMapper direccionMapper;

    /**
     * Constructor que realiza el setting de todos
     * los Mappers y todos los servicios adicionales
     * a ser empleados en esta clase.
     *
     * @param direccionMapper
     */
    public DireccionServiceImpl(DireccionMapper direccionMapper) {
        this.direccionMapper = direccionMapper;
    }

    @Override
    public Direccion getById(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.getById(direccion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de una Dirección", e.getMessage());
        }
    }

    @Override
    public List<Direccion> getAll() throws BusinessException {
        try {
            return direccionMapper.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de las Direcciones", e.getMessage());
        }
    }

    @Override
    public int insert(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.insert(direccion);
        } catch (Exception e) {
            throw new MapperCallException("Error de inserción de la Dirección", e.getMessage());
        }
    }

    @Override
    public int update(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.update(direccion);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de actualización de una Dirección", e.getMessage());
        }
    }

    @Override
    public int delete(Direccion direccion) throws BusinessException {
        try {
            return direccionMapper.delete(direccion.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de borrado de una Dirección", e.getMessage());
        }
    }

    @Override
    public int save(Direccion direccion) throws BusinessException {
        try {
            if (getById(direccion) == null) {
                return direccionMapper.insert(direccion);
            } else {
                return direccionMapper.update(direccion);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de salvado de una Dirección", e.getMessage());
        }
    }

    @Override
    public List<DireccionConNombre> getDireccionesNombre(int idUser) throws BusinessException {
        try {
            return direccionMapper.getDireccionesNombre(idUser);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("No pudieron recuperarse las direcciones", e.getMessage());
        }
    }

    @Override
    public List<DireccionConNombre> getDireccionEnvio(int idUser, int idDir) throws BusinessException {
        try {
            return direccionMapper.getDireccionEnvio(idUser, idDir);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("No pudieron recuperarse las direcciones", e.getMessage());
        }
    }

    @Override
    public int agregaDireccion(NuevaDireccion nuevaDireccion) throws BusinessException {
        int idDireccion;
        UsuarioDireccion ud;
        //Se crea primero una dirección
        Direccion d = new Direccion(nuevaDireccion.getId(),
                nuevaDireccion.getCalleNumero(),
                nuevaDireccion.getColonia(),
                nuevaDireccion.getIdPais(),
                nuevaDireccion.getIdEstado(),
                nuevaDireccion.getIdMunicipio(),
                nuevaDireccion.getTipo(),
                nuevaDireccion.getCp(),
                nuevaDireccion.getReferencias(),
                true);
        try {
            //Se inserta recuperando su id
            direccionMapper.insert(d);
            idDireccion = d.getId();
            //El id de esa dirección se asocia al id del usuario que la ingresó
            ud = new UsuarioDireccion(nuevaDireccion.getIdUsuario(), idDireccion);
            return direccionMapper.insertUsuarioDireccion(ud);
        } catch(Exception e) {
            throw new MapperCallException("Error al insertar la nueva dirección y asociarla con el usuario", e.getMessage());
        }
    }

}
