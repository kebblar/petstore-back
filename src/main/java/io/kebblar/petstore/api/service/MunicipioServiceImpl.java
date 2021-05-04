/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      Municipio
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio asociado a la entidad 'municipio'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.mapper.MunicipioMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Implementación de la interfaz {@link MunicipioService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.service.MunicipioService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Service("municipioService")
public class MunicipioServiceImpl implements MunicipioService {

    private static final Logger logger = LoggerFactory.getLogger(MunicipioServiceImpl.class);

    private MunicipioMapper municipioMapper;
    
    /**
     * Constructor que realiza el setting de todos
     * los Mappers y todos los servicios adicionales 
     * a ser empleados en esta clase.
     * 
     * @param municipioMapper
     */
    public MunicipioServiceImpl(MunicipioMapper municipioMapper) {
        this.municipioMapper = municipioMapper;
    }

    @Override
    public List<Municipio> getAll() throws BusinessException {
        try {
            return municipioMapper.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de obtención de los Municipios", e.getMessage());
        }
    }

    @Override
    public int insert(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.insert(municipio);
        } catch (Exception e) {
            throw new MapperCallException("Error de inserción de un Municipio", e.getMessage());
        }
    }

    @Override
    public int update(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.update(municipio);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de actualización de un Municipio", e.getMessage());
        }
    }

    @Override
    public int delete(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.delete(municipio.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de borrado de un Municipio", e.getMessage());
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
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MapperCallException("Error de salvado de un Municipio", e.getMessage());
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
    public Municipio getById(int id) throws BusinessException {
        try {
            return municipioMapper.getById(id);
        } catch (Exception e) {
            throw new MapperCallException("Error de obtención de un Municipio por su ID", e.getMessage());
        }
    }

    @Override
    public List<Municipio> getAllByEstado(int idEstado) throws BusinessException {
        try {
            return municipioMapper.getByEstado(idEstado);
        } catch (Exception e) {
            throw new MapperCallException("Error de obtención de los Municipios asociados a un Estado", e.getMessage());
        }
    }

}
