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
 * Artefacto:   AtributoServiceImpl.java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (21_41)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.AtributoDetalleTO;
import io.kebblar.petstore.api.model.domain.AtributoTO;
import io.kebblar.petstore.api.model.domain.ValorAtributo;
import io.kebblar.petstore.api.mapper.AtributoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'atributo'. 
 *
 * <p>Implementación de la interfaz {@link AtributoService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.Atributo
 * @see  io.kebblar.petstore.api.service.AtributoService
 */
@Service("atributoService")
public class AtributoServiceImpl implements AtributoService {

    private static final Logger logger = LoggerFactory.getLogger(AtributoServiceImpl.class);

    private AtributoMapper atributoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param atributoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public AtributoServiceImpl(AtributoMapper atributoMapper) {
        this.atributoMapper = atributoMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public Atributo getById(int id) throws BusinessException {
        try {
            return atributoMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<Atributo> getAll() throws BusinessException {
        try {
            return atributoMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(Atributo atributo) throws BusinessException {
        try {
            return atributoMapper.insert(atributo);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(Atributo atributo) throws BusinessException {
        try {
            return atributoMapper.update(atributo);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(Atributo atributo) throws BusinessException {
        try {
            return atributoMapper.delete(atributo.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(Atributo atributo) throws BusinessException {
        try {
            if (getById(atributo.getId()) == null) {
                return atributoMapper.insert(atributo);
            } else {
                return atributoMapper.update(atributo);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    
    @Override
	public List<Atributo> getByNombre(String nombre) throws BusinessException {
        try {
            return atributoMapper.getByNombre(nombre);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException("Error de obtención de un Atributo", e.getMessage());
        }
	}

	@Override
	public List<AtributoTO> getAllAtributoDetalles() throws BusinessException {
		try {
            List<AtributoTO> ct = new ArrayList<>();
            Map<Integer, AtributoTO> map = new HashMap<Integer, AtributoTO>();
           
        	for (AtributoDetalleTO c: atributoMapper.getAllAtributoDetalle()) {
            	if(map.containsKey(c.getIdAtributo())) {
            			try {
		            			 ValorAtributo auxVa = new ValorAtributo(c.getIdRango(),c.getRangoIdAtributo(),c.getRango(),c.getEstatusRango());
		            			 map.get(c.getIdAtributo()).getRangos().add(auxVa); 
            			}  catch (Exception e) {
                            
            			}           		
            		
            	} else {
                    AtributoTO a = new AtributoTO(c.getIdAtributo(),c.getNombreAtributo(),c.getEstatusAtributo());
                	List<ValorAtributo> lva = new ArrayList<>();
	                    	 if(c.getIdRango() > 0) {
	 	                    
	 	                    	ValorAtributo va = new ValorAtributo(c.getIdRango(),c.getRangoIdAtributo(),c.getRango(),c.getEstatusRango());
	 	                    	lva.add(va);
	 	                    }
	 	                     a.setRangos(lva);
	                    	 map.put(a.getId(), a);
	            }

        	  }
        	for (Integer key : map.keySet()) {
        	    AtributoTO value = map.get(key);
        	   ct.add(value);
        	}

   
        	return ct;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
	}
}
