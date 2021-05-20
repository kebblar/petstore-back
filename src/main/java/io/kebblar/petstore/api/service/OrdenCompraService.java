/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   FacturaService.java
 * Tipo:        interface
 * AUTOR:       Daniel Alvarez Morales
 * Fecha:       15 de Mayo de 2021 (16_00)
 *
 * Historia:    .
 *              20210503_1600 Creación
 *
 */
package io.kebblar.petstore.api.service;


import java.util.List;

import io.kebblar.petstore.api.model.domain.DatosOrden;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Definición de la interfaz de servicios para 'ordenCompra'.
 * 
 * @author  dalvarez
 * @see     io.kebblar.petstore.api.model.domain.DatosOrden
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface OrdenCompraService {

	/**
     * <p>Mètodo utilizado para procesar, crear y almacenar PDF con la factura de la compra
     * 
     * @param Objeto de tipo {@link DatosOrden} con la información de la factura.
     * @throws BusinessException
     */
	DatosOrden procesarOrdenCompra(DatosOrden ordenCompra) throws BusinessException;

	/**
     * <p>Mètodo utilizado para consultar todas las ordenes de compra
     * 
     * @param Objeto de tipo {@link DatosOrden} con la información de la factura.
     * @throws BusinessException
     */
	List<DatosOrden> getAll() throws BusinessException;

	/**
     * <p>Mètodo utilizado para agregar una orden de compra en BD
     * 
     * @param Objeto de tipo {@link DatosOrden} con la información de la factura.
     * @throws BusinessException
     */
	int insert(DatosOrden datosOrden) throws BusinessException;
}
