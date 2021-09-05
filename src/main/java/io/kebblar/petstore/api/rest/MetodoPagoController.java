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
 * Nombre:      MetodoPagoController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:25:56
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.MetodoPago;
import io.kebblar.petstore.api.service.MetodoPagoService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'metodo_pago'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see MetodoPago
 * @see MetodoPagoService
 */

@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class MetodoPagoController {

    private MetodoPagoService metodoPagoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param metodoPagoService Servicios de usuario
     */
    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @ApiOperation(
        value = "MetodoPagoController::getAll",
        notes = "Regresa una lista de todos los objetos MetodoPago "
            + "debidamente paginados con base en el payload de "
            + "request que determina el tamaño de la página, la "
            + "longitud de la página, el campo por el que se va a "
            + "ordenar y si el orden es ascendente o descendente."
            + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la lista resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(
        value = "/metodo-pagos.json",
        produces = "application/json; charset=utf-8")
    public List<MetodoPago> getAllMetodoPago() throws BusinessException {
        return metodoPagoService.getAll();
    }

    @ApiOperation(
        value = "MetodoPagoController::get",
        notes = "Regresa un objeto MetodoPago cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/metodo-pago/{id}.json",
        produces = "application/json; charset=utf-8")
    public MetodoPago getMetodoPago(
    @ApiParam(name="id", value="Representa el id del metodoPago buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.metodoPagoService.getById(id);
    }

    @ApiOperation(
        value = "MetodoPagoController::getByUser",
        notes = "Regresa un listado de objetos MetodoPago pertenecientes "
            + "al usuario con el entero recibido como parametro.")
    @GetMapping(
        value = "/user-metodo-pago/{id}.json",
        produces = "application/json; charset=utf-8")
    public List<MetodoPago> getMetodoByUser(
    @ApiParam(name="id", value="Representa el id del usuario buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.metodoPagoService.getByIdUser(id);
    }

    @ApiOperation(
        value = "MetodoPagoController::insert",
        notes = "Recibe un objeto MetodoPago el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/metodo-pago.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="metodoPago", value="MetodoPago que será insertado en el sistema.")
    @RequestBody MetodoPago metodoPago
    ) throws BusinessException {
        return metodoPagoService.insert(metodoPago);
    }

    @ApiOperation(
        value = "MetodoPagoController::update",
        notes = "Recibe un objeto MetodoPago, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/metodo-pago.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="metodoPago", value="MetodoPago que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody MetodoPago metodoPago
    ) throws BusinessException {
        return metodoPagoService.update(metodoPago);
    }

    @ApiOperation(
        value = "MetodoPagoController::delete",
        notes = "Recibe un objeto MetodoPago, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/metodo-pago.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="metodoPago", value="MetodoPago que será removido del sistema.")
    @RequestBody MetodoPago metodoPago
    ) throws BusinessException {
        return metodoPagoService.delete(metodoPago);
    }

}
