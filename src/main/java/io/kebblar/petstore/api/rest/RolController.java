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
 * Nombre:      RolController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:26:51
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

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.service.RolService;
import io.kebblar.petstore.api.model.exceptions.ControllerException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'rol'.
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
 * @see io.kebblar.petstore.api.model.domain.Rol
 * @see io.kebblar.petstore.api.service.RolService
 */

@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class RolController {

    private final RolService rolService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param rolService Servicios de usuario
     */
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @ApiOperation(
        value = "RolController::getAll",
        notes = "Regresa una lista de todos los objetos Rol "
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
        value = "/roles.json",
        produces = "application/json; charset=utf-8")
    public List<Rol> getAllRol() throws ControllerException {
        return rolService.getAll();
    }

    @ApiOperation(
        value = "RolController::get",
        notes = "Regresa un objeto Rol cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/rol/{id}.json",
        produces = "application/json; charset=utf-8")
    public Rol getRol(
    @ApiParam(name="id", value="Representa el id del rol buscado.")
    @PathVariable int id
    ) throws ControllerException {
        return this.rolService.getById(id);
    }

    @ApiOperation(
        value = "RolController::insert",
        notes = "Recibe un objeto Rol el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/rol.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="rol", value="Rol que será insertado en el sistema.")
    @RequestBody Rol rol
    ) throws ControllerException {
        return rolService.insert(rol);
    }

    @ApiOperation(
        value = "RolController::update",
        notes = "Recibe un objeto Rol, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/rol.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="rol", value="Rol que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody Rol rol
    ) throws ControllerException {
        return rolService.update(rol);
    }

    @ApiOperation(
        value = "RolController::delete",
        notes = "Recibe un objeto Rol, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/rol.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="rol", value="Rol que será removido del sistema.")
    @RequestBody Rol rol
    ) throws ControllerException {
        return rolService.delete(rol);
    }

}
