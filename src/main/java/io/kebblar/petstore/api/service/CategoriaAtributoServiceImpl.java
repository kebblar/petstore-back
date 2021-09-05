/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CategoriaAtributoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:43:09
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
