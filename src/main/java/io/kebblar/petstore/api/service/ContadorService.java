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
 * Tipo:        interface
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (11_00)
 *
 * Historia:    .
 *              20210504_1100 Creación
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TablasContador;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Definición de la interfaz de servicios para 'Contador'.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Contador
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface ContadorService {
    /**
     * Regresa el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     * @throws BusinessException
     */
    int getUsuarioDetalleCounter() throws BusinessException;
   
    int getUsuarioCounter() throws BusinessException;
    int getPaisCounter() throws BusinessException;
    int getEstadoCounter() throws BusinessException;
    int getMunicipioCounter() throws BusinessException;

    /**
     * <p>Recupera la cantidad de datos existentes en una tabla.
     * 
     * @param tabla Nombre de la tabla.
     * @return Objeto de tipo {@link Integer} indicando la cantidad de datos.
     * @throws BusinessException
     */
    Integer getTableCounter(String tabla) throws BusinessException;
    
    /**
     * <p>Recupera la cantidad de datos existentes en la tabla indicada en forma de JSON 
     * guardando los datos en un String de la siguiente forma:
     * {"tabla":"nombre_tabla", "contador": "cantidad_de_datos"}.
     * 
     * @param Objeto del tipo {@link TablasContador}.
     * @return Objeto de tipo {@link String} con datos en forma de JSON.
     * @throws BusinessException
     */
    String getTableCounter2(TablasContador contador) throws BusinessException;
}
