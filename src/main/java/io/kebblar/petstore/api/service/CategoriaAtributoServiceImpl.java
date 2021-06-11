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
 * Artefacto:   CategoriaAtributoServiceImpl .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (19_06)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210606_1906 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.CategoriaAtributo;
import io.kebblar.petstore.api.mapper.CategoriaAtributoMapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'categoria_atributo'. 
 *
 * <p>Implementación de la interfaz {@link CategoriaAtributoService}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see  io.kebblar.petstore.api.model.domain.CategoriaAtributo
 * @see  io.kebblar.petstore.api.service.CategoriaAtributoService
 */
@Service("categoriaAtributoService")
public class CategoriaAtributoServiceImpl implements CategoriaAtributoService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaAtributoServiceImpl.class);

    private CategoriaAtributoMapper categoriaAtributoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los
     * servicios adicionales a ser empleados en esta clase.
     * 
     * @param categoriaAtributoMapper mapper utilizado para llamar a metodos de persistencia
     */
    public CategoriaAtributoServiceImpl(CategoriaAtributoMapper categoriaAtributoMapper) {
        this.categoriaAtributoMapper = categoriaAtributoMapper;
    }

    /*
    * Implementación del método getById
    */
    @Override
    public CategoriaAtributo getById(int id) throws BusinessException {
        try {
            return categoriaAtributoMapper.getById(id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método getAll
    */
    @Override
    public List<CategoriaAtributo> getAll() throws BusinessException {
        try {
            return categoriaAtributoMapper.getAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método insert
    */
    @Override
    public int insert(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
            return categoriaAtributoMapper.insert(categoriaAtributo);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método update
    */
    @Override
    public int update(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
            return categoriaAtributoMapper.update(categoriaAtributo);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método delete
    */
    @Override
    public int delete(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
            return categoriaAtributoMapper.delete(categoriaAtributo);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

    /*
    * Implementación del método save
    */
    @Override
    public int save(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
                return categoriaAtributoMapper.insert(categoriaAtributo); 
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
    }

	@Override
	public List<CategoriaAtributo> getAllAtributoByCategoria(int categoria) throws BusinessException {
		try {
            return categoriaAtributoMapper.getNombreAtributosByIdCategoria(categoria);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
	}

	@Override
	public List<Atributo> getAllAtributosFaltantesByCategoria(int categoria) throws BusinessException {
		try {
            return categoriaAtributoMapper.getAtributosFaltantesByIdCategoria(categoria);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BusinessException();
        }
	}

}
