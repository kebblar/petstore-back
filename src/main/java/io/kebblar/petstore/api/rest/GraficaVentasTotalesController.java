/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      GraficaVentasTotalesController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:25:22
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
