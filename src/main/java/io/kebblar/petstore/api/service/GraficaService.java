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

import io.kebblar.petstore.api.model.domain.GraficaTO;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

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
     * 'graficaTO'.
     *
     * @return GraficaTO.
     */
    String getMascotaMasVendida() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando las mascotas mas vendidas
     * por rango de fechas 'graficaTO'.
     *
     * @return GraficaTO.
     */
    String getMascotaMasVendidaRango(String fechaIni, String fechaFin) throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando las paqueterias mas usadas
     * 'graficaTO'.
     *
     * @return String.
     */
    String getPaqueteria() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando las paqueterias mas usadas
     * por rango de fechas 'graficaTO'.
     *
     * @return String.
     */
    String getPaqueteriaRango(String fechaIni, String fechaFin) throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando los compradores mas
     * recurrentes 'graficaComprador'.
     *
     * @return String.
     */
    String getCompradorAsiduo() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando los compradores mas
     * recurrentes por rango de fechas 'graficaComprador'.
     *
     * @return String.
     */
    String getCompradorAsiduoRango(String fechaIni, String fechaFin) throws BusinessException;

}
