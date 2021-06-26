/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   GraficaService.java
 * Tipo:        interface
 * AUTOR:       Ulises López (UL)
 * Fecha:       Jueves 9 de JUn de 2021 (09_38)
 *
 * Historia:    .
 *              20210609_0938 Creación
 *
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
