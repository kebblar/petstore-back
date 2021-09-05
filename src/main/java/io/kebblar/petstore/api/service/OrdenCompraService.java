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
 * Nombre:      OrdenCompraService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:48:40
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
     * <p>Método utilizado para procesar, crear y almacenar PDF con la factura de la compra
     *
     * @return DatosOrden que contiene la información de la factura.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException
     * @param datosOrden a {@link io.kebblar.petstore.api.model.domain.DatosOrden} object.
     */
    DatosOrden procesarOrdenCompra(DatosOrden datosOrden) throws BusinessException;

    /**
     * <p>Método utilizado para consultar todas las ordenes de compra
     *
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException
     * @return a {@link java.util.List} object.
     */
    List<DatosOrden> getAll() throws BusinessException;

    /**
     * <p>Método utilizado para agregar una orden de compra en BD
     *
     * @return id con el valor de número de la transacción insertada en bd.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException
     * @param datosOrden a {@link io.kebblar.petstore.api.model.domain.DatosOrden} object.
     */
    int insert(DatosOrden datosOrden) throws BusinessException;
}
