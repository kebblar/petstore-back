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
 * Nombre:      TipoDireccionController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:27:12
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

import io.kebblar.petstore.api.model.domain.TipoDireccion;
import io.kebblar.petstore.api.service.TipoDireccionService;
import io.kebblar.petstore.api.model.exceptions.ControllerException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'tipo_direccion'.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see TipoDireccion
 * @see TipoDireccionService
 */

@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class TipoDireccionController {

    private final TipoDireccionService tipoDireccionService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param tipoDireccionService Servicios de usuario
     */
    public TipoDireccionController(TipoDireccionService tipoDireccionService) {
        this.tipoDireccionService = tipoDireccionService;
    }

    @ApiOperation(
        value = "TipoDireccionController::getAll",
        notes = "Regresa una lista de todos los objetos TipoDireccion "
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
        value = "/tipo-direcciones",
        produces = "application/json; charset=utf-8")
    public List<TipoDireccion> getAllTipoDireccion() throws ControllerException {
        return tipoDireccionService.getAll();
    }

    @ApiOperation(
        value = "TipoDireccionController::get",
        notes = "Regresa un objeto TipoDireccion cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/tipo-direccion/{id}",
        produces = "application/json; charset=utf-8")
    public TipoDireccion getTipoDireccion(
    @ApiParam(name="id", value="Representa el id del tipoDireccion buscado.")
    @PathVariable int id
    ) throws ControllerException {
        return this.tipoDireccionService.getById(id);
    }

    @ApiOperation(
        value = "TipoDireccionController::insert",
        notes = "Recibe un objeto TipoDireccion el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/tipo-direccion",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="tipoDireccion", value="TipoDireccion que será insertado en el sistema.")
    @RequestBody TipoDireccion tipoDireccion
    ) throws ControllerException {
        return tipoDireccionService.insert(tipoDireccion);
    }

    @ApiOperation(
        value = "TipoDireccionController::update",
        notes = "Recibe un objeto TipoDireccion, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/tipo-direccion",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="tipoDireccion", value="TipoDireccion que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody TipoDireccion tipoDireccion
    ) throws ControllerException {
        return tipoDireccionService.update(tipoDireccion);
    }

    @ApiOperation(
        value = "TipoDireccionController::delete",
        notes = "Recibe un objeto TipoDireccion, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/tipo-direccion",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="tipoDireccion", value="TipoDireccion que será removido del sistema.")
    @RequestBody TipoDireccion tipoDireccion
    ) throws ControllerException {
        return tipoDireccionService.delete(tipoDireccion);
    }

}
