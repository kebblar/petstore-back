/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   GraficaVentasTotalesService.java
 * Tipo:        interface
 * AUTOR:       Francisco Espinosa
 * Fecha:       Jueves 23 de Junio de 2021 (10_00)
 *
 * Historia:    .
 *              20210623_1000 Creación de interfaz
 *
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