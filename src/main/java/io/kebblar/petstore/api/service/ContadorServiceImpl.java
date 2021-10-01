/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      ContadorServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:43:40
 */
package io.kebblar.petstore.api.service;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.ContadorMapper;
import io.kebblar.petstore.api.model.domain.TablasContadorEnum;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MapperCallException;

/**
 * <p>Implementación de la interfaz {@link ContadorService}.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Contador
 * @see     io.kebblar.petstore.api.service.ContadorService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service
public class ContadorServiceImpl implements ContadorService {
    private final ContadorMapper contadorMapper;

    /**
     * Constructor que realiza el setting de
     * los Mappers y todos los servicios adicionales
     * a ser empleados en esta clase.
     *
     * @param contadorMapper instancia de {@link ContadorMapper}
     */
    public ContadorServiceImpl(ContadorMapper contadorMapper) {
        this.contadorMapper = contadorMapper;
    }

    @Override
    public int getUsuarioDetalleCounter() throws BusinessException {
        return this.getTableCounter("usuario_detalle");
    }

    @Override
    public int getUsuarioCounter() throws BusinessException {
        return this.getTableCounter("usuario");
    }

    @Override
    public int getPaisCounter() throws BusinessException {
        return this.getTableCounter("pais");
    }

    @Override
    public int getEstadoCounter() throws BusinessException {
        return this.getTableCounter("estado");
    }

    @Override
    public int getMunicipioCounter() throws BusinessException {
        return this.getTableCounter("municipio");
    }

    @Override
    public Integer getTableCounter(String tabla) throws BusinessException {
        String esquema = "petstore";
        // ********************************** Change previous var 'ESQUEMAS' Accordingly !!!
        try {
            return this.contadorMapper.getTableCount(esquema, tabla);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener el número de tuplas de la tabla: "+ tabla + " (tabla posiblemente inexistente)", e.getMessage());
        }
    }

    @Override
    public String getTableCounter2(TablasContadorEnum contador) throws BusinessException {
        int response = getTableCounter(contador.getTabla());
        return "{\"tabla\":\""+contador.getTabla()+"\", \"contador\": "+response+"}";
    }

}
