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
        logger.debug("Invoking CategoriaAtributoServiceImpl constructor");
        this.categoriaAtributoMapper = categoriaAtributoMapper;
    }

    @Override
    public CategoriaAtributo getById(int id) throws BusinessException {
        try {
            return categoriaAtributoMapper.getById(id);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<CategoriaAtributo> getAll() throws BusinessException {
        try {
            return categoriaAtributoMapper.getAll();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public int insert(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
            return categoriaAtributoMapper.insert(categoriaAtributo);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public int update(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
            return categoriaAtributoMapper.update(categoriaAtributo);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public int delete(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
            return categoriaAtributoMapper.delete(categoriaAtributo);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public int save(CategoriaAtributo categoriaAtributo) throws BusinessException {
        try {
                return categoriaAtributoMapper.insert(categoriaAtributo);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<CategoriaAtributo> getAllAtributoByCategoria(int categoria) throws BusinessException {
        try {
            return categoriaAtributoMapper.getNombreAtributosByIdCategoria(categoria);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Atributo> getAllAtributosFaltantesByCategoria(int categoria) throws BusinessException {
        try {
            return categoriaAtributoMapper.getAtributosFaltantesByIdCategoria(categoria);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

}
