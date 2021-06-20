/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   GraficaTotalFechasCategoriaService.java
 * Tipo:        interface
 * AUTOR:       Francisco Espinosa
 * Fecha:       Jueves 16 de Junio de 2021 (10_00)
 *
 * Historia:    .
 *              20210616_1000 Creación de interfaz
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * Interface para el servicio asociado a la entidad 'GraficaTotalFechasCategoria'.
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface GraficaTotalFechasCategoriaService {

    /**
     * Método utilizado para obtener una cadena indicando las datos para la gráfica de total por categoría
     * asociados a la entidad 'GraficaTotalFechasCategoria'.
     *
     * @return String.
     */
    String getTotalPorCategoria() throws BusinessException;

    /**
     * Método utilizado para obtener una cadena indicando las datos para la gráfica de total por categoría
     * por rango de fechas asociados a la entidad 'GraficaTotalFechasCategoria'.
     *
     * @return String.
     */
    String getTotalPorCategoriaFiltroFechas(String fechaIni, String fechaFin) throws BusinessException;
    
}

