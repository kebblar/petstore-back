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
 * Nombre:      ValorAtributoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 09:25:30
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
import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Servicio asociado a la entidad 'valor_atributo'.
 *
 * <p>
 * Implementación de la interfaz {@link io.kebblar.petstore.api.service.ValorAtributoService}.
 *
 * <p>
 * Todos los métodos de esta clase disparan {@link io.kebblar.petstore.api.model.exceptions.BusinessException}
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see io.kebblar.petstore.api.model.domain.ValorAtributo
 * @see io.kebblar.petstore.api.service.ValorAtributoService
 */
@Service("valorAtributoService")
public class ValorAtributoServiceImpl implements ValorAtributoService {

    private static final Logger logger = LoggerFactory.getLogger(ValorAtributoServiceImpl.class);

    private ValorAtributoMapper valorAtributoMapper;

    /**
     * Constructor que realiza el setting de todos los Mappers y todos los servicios
     * adicionales a ser empleados en esta clase.
     *
     * @param valorAtributoMapper mapper utilizado para llamar a metodos de
     *                            persistencia
     */
    public ValorAtributoServiceImpl(ValorAtributoMapper valorAtributoMapper) {
        logger.debug("Invoking ValorAtributoServiceImpl constructor");
        this.valorAtributoMapper = valorAtributoMapper;
    }

    /*
     * Implementación del método getById
     */
    /** {@inheritDoc} */
    @Override
    public ValorAtributo getById(int id) throws BusinessException {
        try {
            return valorAtributoMapper.getById(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<ValorAtributo> getAll() throws BusinessException {
        try {
            return valorAtributoMapper.getAll();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int insert(ValorAtributo valorAtributo) throws BusinessException {
        try {
            return valorAtributoMapper.insert(valorAtributo);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int update(ValorAtributo valorAtributo) throws BusinessException {
        try {
            return valorAtributoMapper.update(valorAtributo);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int delete(ValorAtributo valorAtributo) throws BusinessException {
        try {
            return valorAtributoMapper.delete(valorAtributo.getId());
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public int save(ValorAtributo valorAtributo) throws BusinessException {
        try {
            if (getById(valorAtributo.getId()) == null) {
                return valorAtributoMapper.insert(valorAtributo);
            } else {
                return valorAtributoMapper.update(valorAtributo);
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<ValorAtributo> getAllByIdAtributo(int id) throws BusinessException {
        try {
            return valorAtributoMapper.getValorAtributoByIdAtributo(id);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
