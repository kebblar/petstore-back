/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ContadorService.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (16_02)
 *
 * Historia:    .
 *              20210503_1602 Creación
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TablasContador;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Definición de la interfaz de servicios para 'Contador'.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface ContadorService {
    
	/**
     * <p>Regresa el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     * 
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     * @throws BusinessException
     */
    int getUsuarioDetalleCounter() throws BusinessException;
    
    /**
     * <p>Regresa el número de tuplas que actualmente tiene la tabla 'usuario'
     * 
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'usuario'
     * @throws BusinessException
     */
    int getUsuarioCounter() throws BusinessException;
    
    /**
     * <p>Regresa el número de tuplas que actualmente tiene la tabla 'pais'
     * 
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'pais'
     * @throws BusinessException
     */
    int getPaisCounter() throws BusinessException;
    
    /**
     * <p>Regresa el número de tuplas que actualmente tiene la tabla 'Estado'
     * 
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'Estado'
     * @throws BusinessException
     */
    int getEstadoCounter() throws BusinessException;
    
    /**
     * <p>Regresa el número de tuplas que actualmente tiene la tabla 'Municipio'
     * 
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'Municipio'
     * @throws BusinessException
     */
    int getMunicipioCounter() throws BusinessException;

    /**
     * <p>Regresa el número de tuplas que actualmente tiene la tabla que se pasa como 'parametro'
     * 
     * @param String que tiene el nombre de la tabla a buscar
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'parametro'
     * @throws BusinessException
     */
    Integer getTableCounter(String tabla) throws BusinessException;
    
    /**
     * <p>Regresa el número de tuplas que actualmente tiene el objetdo 'TablasContador'
     * 
     * @param Objeto de tipo {@link TablasContador} con la información de paises, estado y municipio.
     * @return String con el número de tuplas y el nombre que tiene el objeto 'TablasContador'
     * @throws BusinessException
     */
    String getTableCounter2(TablasContador contador) throws BusinessException;
}
