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
 * Artefacto:   GraficaController .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Ulises López
 * Fecha:       Tuesday 09 de Jun de 2021 (09_22)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210609_0922 Implementación de clase
 *
 */

package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.service.GraficaService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementacion del REST Controller asociado a los endpoints de gestión del
 * POJO 'grafica'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc
 * debido a que la documentación Swagger API cumple con ese objetivo.
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Grafica
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

    @ApiOperation(value = "GraficaController::getMascotaMasVendida", notes = "Regresa una cadena de todos los objetos Grafica "
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-mascota-mas-vendida.json", produces = "application/json; charset=utf-8")
    public String getMascotaMasVendida() throws ControllerException {
        return graficaService.getMascotaMasVendida();
    }

    @GetMapping(path = "/grafica-mascota-mas-vendida-rango.json", produces = "application/json; charset=utf-8")
    public String getMascotaMasVendidaRango(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio de busqueda") @RequestParam String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin de busqueda") @RequestParam String fechaFin)
            throws BusinessException {
        return graficaService.getMascotaMasVendidaRango(fechaInicio, fechaFin);
    }

    @ApiOperation(value = "GraficaController::getPaqueteria", notes = "Regresa una cadena de todos los objetos Grafica "
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-paqueteria.json", produces = "application/json; charset=utf-8")
    public String getPaqueteria() throws ControllerException {
        return graficaService.getPaqueteria();
    }

    @GetMapping(path = "/grafica-paqueteria-rango.json", produces = "application/json; charset=utf-8")
    public String getPaqueteriaRango(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio de busqueda") @RequestParam String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin de busqueda") @RequestParam String fechaFin)
            throws BusinessException {

        return graficaService.getPaqueteriaRango(fechaInicio, fechaFin);
    }

    @ApiOperation(value = "GraficaController::getCompradorAsiduo", notes = "Regresa una cadena de todos los objetos Grafica Comprador Asiduo"
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-comprador-asiduo.json", produces = "application/json; charset=utf-8")
    public String getCompradorAsiduo() throws ControllerException {
        return graficaService.getCompradorAsiduo();
    }

    @GetMapping(path = "/grafica-comprador-asiduo-rango.json", produces = "application/json; charset=utf-8")
    public String getCompradorAsiduoRango(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio de busqueda") @RequestParam String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin de busqueda") @RequestParam String fechaFin)
            throws BusinessException {

        return graficaService.getCompradorAsiduoRango(fechaInicio, fechaFin);
    }

}
