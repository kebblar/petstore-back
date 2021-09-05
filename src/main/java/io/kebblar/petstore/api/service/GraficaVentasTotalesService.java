/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      GraficaVentasTotalesService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:45:47
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.DatabaseException;

/**
 * Interface para el servicio asociado a la entidad 'GraficaVentasTotales'.
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface GraficaVentasTotalesService {

    /**
     * Método utilizado para obtener una cadena indicando las datos para la gráfica de importe total de ventas
     * asociados a la entidad 'GraficaVentasTotales'.
     *
     * @return String.
     */
    String getTotalImporteVentas() throws DatabaseException;

    /**
     * Método utilizado para obtener una cadena indicando las datos para la gráfica de importe total de ventas
     * por rango de fechas asociados a la entidad 'GraficaVentasTotales'.
     *
     * @return String.
     */
    String getTotalImporteVentasFiltroFechas(String fechaIni, String fechaFin) throws DatabaseException;

    /**
     * Método utilizado para obtener una cadena indicando las datos para la gráfica de total de órdenes de compra de ventas
     * asociados a la entidad 'GraficaVentasTotales'.
     *
     * @return String.
     */
    String getNumeroOrdenesTotalVentas() throws DatabaseException;

    /**
     * Método utilizado para obtener una cadena indicando las datos para la gráfica de total de órdenes de compra de ventas
     * por rango de fechas asociados a la entidad 'GraficaVentasTotales'.
     *
     * @return String.
     */
    String getNumeroOrdenesTotalVentasFiltroFechas(String fechaIni, String fechaFin) throws DatabaseException;

}