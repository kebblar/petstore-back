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
 * Nombre:      GraficaTipoPagoService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:45:10
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * Interface para el servicio asociado a la entidad 'grafica'.
 *
 * @author Diego González
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface GraficaTipoPagoService {

    /**
     * Método utilizado para obtener una cadena indicando monto total por tipo de pago
     * 'graficaMontoTipoPago'.
     *
     * @return String.
     */
    String getMontoTotalTipoPago() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando monto total por tipo de pago
     * por rango de fechas 'graficaMontoTipoPago'.
     *
     * @return String.
     */
    String getMontoTipoPagoRango(String fechaIni, String fechaFin) throws BusinessException;

}
