/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      GraficaTotalFechasCategoriaController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:25:14
 */
package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.service.GraficaTotalFechasCategoriaService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementacion del REST Controller asociado a los endpoints de gestión del
 * POJO 'GraficaTotalFechasCategoria'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}</p>
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc
 * debido a que la documentación Swagger API cumple con ese objetivo.</p>
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaTotalFechasCategoria
 * @see GraficaTotalFechasCategoriaService
 */

@RestController
@Api(value = "GraficaTotalFechasCategoria")
@RequestMapping(value = "/api")
public class GraficaTotalFechasCategoriaController {
    private final GraficaTotalFechasCategoriaService graficaTotalFechasCategoriaService;

    /**
     * Constructor que realiza el setting de los servicios que serán utilizados en
     * este controlador.
     *
     * @param graficaTotalFechasCategoriaService Servicios de gráfica venta total por categoria
     */
    public GraficaTotalFechasCategoriaController (GraficaTotalFechasCategoriaService graficaTotalFechasCategoriaService) {
        this.graficaTotalFechasCategoriaService = graficaTotalFechasCategoriaService;
    }

    @ApiOperation(value = "GraficaController::getMascotaMasVendida", notes = "Regresa una cadena de los objetos GraficaTotalFechasCategoriaService "
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-total-fechas-categoria.json", produces = "application/json; charset=utf-8")
    public String getTotalPorCategoria() throws ControllerException {
        return graficaTotalFechasCategoriaService.getTotalPorCategoria();
    }

    @GetMapping(path = "/grafica-total-fechas-categoria-filtro.json", produces = "application/json; charset=utf-8")
    public String getTotalPorCategoriaFiltroFechas(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio de búsqueda") @RequestParam String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin de búsqueda") @RequestParam String fechaFin)
            throws BusinessException {
        return graficaTotalFechasCategoriaService.getTotalPorCategoriaFiltroFechas(fechaInicio, fechaFin);
    }

}

