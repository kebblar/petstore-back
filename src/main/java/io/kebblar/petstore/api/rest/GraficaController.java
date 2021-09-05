/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      GraficaController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:24:56
 */
package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.service.GraficaService;
import io.kebblar.petstore.api.model.domain.ChartWrapper;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementacion del REST Controller asociado a los endpoints de gestión del
 * POJO 'ChartWrapper'.
 *
 * <p>
 * Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>
 * NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc
 * debido a que la documentación Swagger API cumple con ese objetivo.
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see ChartWrapper
 * @see GraficaService
 */

@RestController
@Api(value = "grafica")
@RequestMapping(value = "/api")
public class GraficaController {
    private GraficaService graficaService;

    /**
     * Constructor que realiza el setting de los servicios que serán utilizados en
     * este controlador.
     *
     * @param graficaService Servicios de grafica
     */
    public GraficaController(GraficaService graficaService) {
        this.graficaService = graficaService;
    }

    @ApiOperation(value = "GraficaController::getMascotaMasVendida", notes = "Regresa una cadena de todos los objetos ChartWrapper "
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-mascota-mas-vendida.json", produces = "application/json; charset=utf-8")
    public ChartWrapper getMascotaMasVendida() throws ControllerException {
        return graficaService.getMascotaMasVendida();
    }

    @GetMapping(path = "/grafica-mascota-mas-vendida-rango/{fechaInicio}/{fechaFin}.json", produces = "application/json; charset=utf-8")
    public ChartWrapper getMascotaMasVendidaRango(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio de busqueda") @PathVariable String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin de busqueda") @PathVariable String fechaFin)
            throws BusinessException {
        return graficaService.getMascotaMasVendidaRango(fechaInicio, fechaFin);
    }

    @ApiOperation(value = "GraficaController::getPaqueteria", notes = "Regresa una cadena de todos los objetos ChartWrapper "
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-paqueteria.json", produces = "application/json; charset=utf-8")
    public ChartWrapper getPaqueteria() throws ControllerException {
        return graficaService.getPaqueteria();
    }

    @GetMapping(path = "/grafica-paqueteria-rango/{fechaInicio}/{fechaFin}.json", produces = "application/json; charset=utf-8")
    public ChartWrapper getPaqueteriaRango(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio de busqueda") @PathVariable String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin de busqueda") @PathVariable String fechaFin)
            throws BusinessException {
        return graficaService.getPaqueteriaRango(fechaInicio, fechaFin);
    }

    @ApiOperation(value = "GraficaController::getCompradorAsiduo", notes = "Regresa una cadena de todos los objetos ChartWrapper Comprador Asiduo"
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-comprador-asiduo.json", produces = "application/json; charset=utf-8")
    public ChartWrapper getCompradorAsiduo() throws ControllerException {
        return graficaService.getCompradorAsiduo();
    }

    @GetMapping(path = "/grafica-comprador-asiduo-rango/{fechaInicio}/{fechaFin}.json", produces = "application/json; charset=utf-8")
    public ChartWrapper getCompradorAsiduoRango(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio de busqueda") @PathVariable String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin de busqueda") @PathVariable String fechaFin)
            throws BusinessException {
        return graficaService.getCompradorAsiduoRango(fechaInicio, fechaFin);
    }

}
