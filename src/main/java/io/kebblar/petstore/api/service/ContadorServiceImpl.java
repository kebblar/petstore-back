/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ContadorServiceImpl
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *
 */
package io.kebblar.petstore.api.service;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.mapper.ContadorMapper;
import io.kebblar.petstore.api.model.domain.TablasContador;
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
    private ContadorMapper contadorMapper;
    
    /**
     * Constructor que realiza el setting de todos
     * los Mappers y todos los servicios adicionales 
     * a ser empleados en esta clase.
     * 
     * @param contadorMapper
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
        String ESQUEMA = "petstore";
        // ********************************** Change previous var 'ESQUEMAS' Accordingly !!!
        try {
            return this.contadorMapper.getTableCount(ESQUEMA, tabla);
        } catch (Exception e) {
            throw new MapperCallException("Error al obtener el número de tuplas de la tabla: "+ tabla + " (tabla posiblemente inexistente)", e.getMessage());
        }
    }

    @Override
    public String getTableCounter2(TablasContador contador) throws BusinessException {
        int response = getTableCounter(contador.getTabla());
        return "{\"tabla\":\""+contador.getTabla()+"\", \"contador\": "+response+"}";
    }

}
