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
 * Tipo:        Interface
 * Nombre:      ContadorService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:43:33
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TablasContadorEnum;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

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

    Integer getTableCounter(String tabla) throws BusinessException;
    String getTableCounter2(TablasContadorEnum contador) throws BusinessException;
}
