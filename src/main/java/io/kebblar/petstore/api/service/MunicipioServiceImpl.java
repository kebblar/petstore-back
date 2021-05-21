/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   EstadoServiceImpl.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *              20210517_1635 Creación del método getByNombre
 *              20210517_1645 Creación del método getMunicipiosDescripcion
 *              20210517_1655 Creación del método getMunicipiosDescripcionByNombre
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
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'municipio'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Service("municipioService")
public class MunicipioServiceImpl implements MunicipioService {

    private static final Logger logger = LoggerFactory.getLogger(MunicipioServiceImpl.class);

    private MunicipioMapper municipioMapper;

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

	@Override
	public List<Municipio> getMunicipiosDescripcion() throws BusinessException {
		 try {
	            return municipioMapper.getMunicipiosDescripcion();
	        } catch (Exception e) {
	            throw new MapperCallException("Error de obtención de los Municipios asociados a un Estado", e.getMessage());
	        }
	}
	
	
	@Override
	public List<Municipio> getMunicipiosDescripcionByNombre(String nombre) throws BusinessException {
		 try {
	            return municipioMapper.getByNombre(nombre);
	        } catch (Exception e) {
	            throw new MapperCallException("Error de obtención de los Municipios asociados a un Estado", e.getMessage());
	        }
	}

}
