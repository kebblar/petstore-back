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
 * Artefacto:   ValorAtributoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       martes 06 de junio de 2021 (00_43)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210608_0043 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.ValorAtributo;
import io.kebblar.petstore.api.mapper.ValorAtributoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'valor_atributo'. 
 *
 * <p>Implementación de la interfaz {@link ValorAtributoService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.ValorAtributo
 * @see  io.kebblar.petstore.api.service.ValorAtributoService
 */
@Service("valorAtributoService")
public class ValorAtributoServiceImpl implements ValorAtributoService {

    private static final Logger logger = LoggerFactory.getLogger(ValorAtributoServiceImpl.class);

    private ValorAtributoMapper valorAtributoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param valorAtributoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public ValorAtributoServiceImpl(ValorAtributoMapper valorAtributoMapper) {
        this.valorAtributoMapper = valorAtributoMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public ValorAtributo getById(int id) throws BusinessException {
        try {
            return valorAtributoMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<ValorAtributo> getAll() throws BusinessException {
        try {
            return valorAtributoMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(ValorAtributo valorAtributo) throws BusinessException {
        try {
            return valorAtributoMapper.insert(valorAtributo);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(ValorAtributo valorAtributo) throws BusinessException {
        try {
            return valorAtributoMapper.update(valorAtributo);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(ValorAtributo valorAtributo) throws BusinessException {
        try {
            return valorAtributoMapper.delete(valorAtributo.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(ValorAtributo valorAtributo) throws BusinessException {
        try {
            if (getById(valorAtributo.getId()) == null) {
                return valorAtributoMapper.insert(valorAtributo);
            } else {
                return valorAtributoMapper.update(valorAtributo);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

	@Override
	public List<ValorAtributo> getAllByIdAtributo(int id) throws BusinessException {
		  try {
	            return valorAtributoMapper.getValorAtributoByIdAtributo(id);
	        } catch (SQLException e) {
	            logger.error(e.getMessage());
	            throw new BusinessException();
	        }
	}

}
