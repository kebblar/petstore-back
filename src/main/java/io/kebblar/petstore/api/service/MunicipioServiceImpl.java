
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
 * Artefacto:   MunicipioServiceImpl .java
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
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.mapper.MunicipioMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'municipio'. 
 *
 * <p>Implementación de la interfaz {@link MunicipioService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  Municipio
 * @see  MunicipioService
 */

@Service("municipioService")
public class MunicipioServiceImpl implements MunicipioService {

    private static final Logger logger = LoggerFactory.getLogger(MunicipioServiceImpl.class);

    private MunicipioMapper municipioMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param municipioMapper mapper utilizado para llamar a metodos de persistencia
     */
    public MunicipioServiceImpl(MunicipioMapper municipioMapper) {
        this.municipioMapper = municipioMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public Municipio getById(int id) throws BusinessException {
        try {
            return municipioMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<Municipio> getAll() throws BusinessException {
        try {
            return municipioMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.insert(municipio);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.update(municipio);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(Municipio municipio) throws BusinessException {
        try {
            return municipioMapper.delete(municipio.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    @Override
    public List<Municipio> getByEstado(int id) throws BusinessException {
        try{
            return municipioMapper.getByPais(id);
        }catch (SQLException e){
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(Municipio municipio) throws BusinessException {
        try {
            if (getById(municipio.getId()) == null) {
                return municipioMapper.insert(municipio);
            } else {
                return municipioMapper.update(municipio);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

}
