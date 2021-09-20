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
 * Tipo:        Interface
 * Nombre:      GraficaService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:44:55
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.domain.ChartWrapper;

/**
 * Interface para el servicio asociado a la entidad 'grafica'.
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface GraficaService {

    /**
     * Método utilizado para obtener una cadena indicando las mascotas mas vendidas
     * 'ChartWrapper'.
     *
     * @return ChartWrapper.
     */
    ChartWrapper getMascotaMasVendida() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando las mascotas mas vendidas
     * por rango de fechas 'graficaTO'.
     *
     * @return ChartWrapper.
     */
    ChartWrapper getMascotaMasVendidaRango(String fechaIni, String fechaFin) throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando las paqueterias mas usadas
     * 'graficaTO'.
     *
     * @return ChartWrapper.
     */
    ChartWrapper getPaqueteria() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando las paqueterias mas usadas
     * por rango de fechas 'graficaTO'.
     *
     * @return ChartWrapper.
     */
    ChartWrapper getPaqueteriaRango(String fechaIni, String fechaFin) throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando los compradores mas
     * recurrentes 'graficaComprador'.
     *
     * @return ChartWrapper.
     */
    ChartWrapper getCompradorAsiduo() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando los compradores mas
     * recurrentes por rango de fechas 'graficaComprador'.
     *
     * @return ChartWrapper.
     */
    ChartWrapper getCompradorAsiduoRango(String fechaIni, String fechaFin) throws BusinessException;

}
