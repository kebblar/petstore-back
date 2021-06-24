/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   GraficaVentasTotalesController.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Francisco Espinosa
 * Fecha:       Tuesday 23 de Junio de 2021 (09_00)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210623_0900 Implementación de clase
 *
 */

package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.service.GraficaVentasTotalesService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementacion del REST Controller asociado a los endpoints de gestión del
 * POJO 'GraficaVentasTotales'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc
 * debido a que la documentación Swagger API cumple con ese objetivo.
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaVentasTotales
 * @see GraficaVentasTotalesService
 */
@RestController
@Api(value = "GraficaVentasTotales")
@RequestMapping(value = "/api")
public class GraficaVentasTotalesController {
    private GraficaVentasTotalesService graficaVentasTotalesService;

    /**
     * Constructor que realiza el setting de los servicios que serán utilizados en
     * este controlador.
     *
     * @param GraficaVentasTotalesService Servicios de gráfica venta total por categoria
     */
    public GraficaVentasTotalesController (GraficaVentasTotalesService graficaVentasTotalesService) {
        this.graficaVentasTotalesService = graficaVentasTotalesService;
    }

    @ApiOperation(value = "GraficaVentasTotalesController::getTotalImporteVentas", 
        notes = "Regresa una cadena de los objetos graficaVentasTotales pertenecientes "
        + "a la grafica de importe total de ventas.")
    @GetMapping(value = "/grafica-total-importe-ventas.json", produces = "application/json; charset=utf-8")
    public String getTotalImporteVentas() throws ControllerException {
        return graficaVentasTotalesService.getTotalImporteVentas();
    }
    
    @ApiOperation(value = "GraficaVentasTotalesController::getTotalImporteVentasFiltroFechas",
        notes = "Regresa un listado de objetos graficaVentasTotales pertenecientes "
        + "a la grafica de importe total de ventas con filtro de fechas.")
    @GetMapping(path = "/grafica-total-importe-ventas-filtro.json", produces = "application/json; charset=utf-8")
    public String getTotalImporteVentasFiltroFechas(
        @ApiParam(name = "fechaInicio", value = "La fechaInicio de búsqueda") @RequestParam String fechaInicio,
        @ApiParam(name = "fechaFin", value = "La fechaFin de búsqueda") @RequestParam String fechaFin)
        throws BusinessException {
        return graficaVentasTotalesService.getTotalImporteVentasFiltroFechas(fechaInicio, fechaFin);
    }
    
    @ApiOperation(value = "GraficaVentasTotalesController::getNumeroOrdenesTotalVentas", 
        notes = "Regresa una cadena de los objetos graficaVentasTotales pertenecientes "
        + "a la grafica de total de número de órdenes de ventas.")
    @GetMapping(value = "/grafica-total-numero-ordenes-ventas.json", produces = "application/json; charset=utf-8")
    public String getNumeroOrdenesTotalVentas() throws ControllerException {
        return graficaVentasTotalesService.getNumeroOrdenesTotalVentas();
    }
    
    @ApiOperation(value = "GraficaVentasTotalesController::getNumeroOrdenesTotalVentasFiltroFechas",
        notes = "Regresa un listado de objetos graficaVentasTotales pertenecientes "
        + "a la grafica de total de número de órdenes de ventas con filtro de fechas.")
    @GetMapping(path = "/grafica-total-numero-ordenes-ventas-filtro.json", produces = "application/json; charset=utf-8")
    public String getNumeroOrdenesTotalVentasFiltroFechas(
        @ApiParam(name = "fechaInicio", value = "La fechaInicio de búsqueda") @RequestParam String fechaInicio,
        @ApiParam(name = "fechaFin", value = "La fechaFin de búsqueda") @RequestParam String fechaFin)
        throws BusinessException {
        return graficaVentasTotalesService.getNumeroOrdenesTotalVentasFiltroFechas(fechaInicio, fechaFin);
    }

}
