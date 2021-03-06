package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.GraficaService;
import io.kebblar.petstore.api.service.GraficaTipoPagoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Implementacion del REST Controller asociado a los endpoints de gestión del
 * POJO 'Gráfica'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los distintos métodos de este controlador no llevan javadoc
 * debido a que la documentación Swagger API cumple con ese objetivo.
 *
 * @author Diego González Sánchez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Grafica
 * @see GraficaService
 */

@RestController
@Api(value = "graficaTipoPago")
@RequestMapping(value = "/api")
public class GraficaTipoPagoController {
    private GraficaTipoPagoService graficaTipoPagoService;

    /**
     * Constructor que realiza el setting de los servicios que serán utilizados en
     * este controlador.
     *
     * @param graficaTipoPagoService Servicios de grafica
     */
    public GraficaTipoPagoController(GraficaTipoPagoService graficaTipoPagoService) {
        super();
        this.graficaTipoPagoService = graficaTipoPagoService;
    }

    @ApiOperation(value = "GraficaController::getMontoTotalTipoPago", notes = "Regresa una cadena de todos los objetos Grafica "
            + "debidamente paginados con base en el payload de " + "request. " + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la cadena resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(value = "/grafica-tipo-pago.json", produces = "application/json; charset=utf-8")
    public String getMascotaMasVendida() throws ControllerException {
        return graficaTipoPagoService.getMontoTotalTipoPago();
    }

    @GetMapping(path = "/grafica-tipo-pago-rango.json", produces = "application/json; charset=utf-8")
    public String getMontoTipoPagoRango(
            @ApiParam(name = "fechaInicio", value = "La fechaInicio") @RequestParam String fechaInicio,
            @ApiParam(name = "fechaFin", value = "La fechaFin") @RequestParam String fechaFin)
            throws BusinessException {
        return graficaTipoPagoService.getMontoTipoPagoRango(fechaInicio, fechaFin);
    }


}
