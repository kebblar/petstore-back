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
 * Nombre:      EstadoController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:24:30
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

import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.EstadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementación  del REST Controller asociado a los endpoints de  gestión del POJO 'estado'.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}</p>
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.</p>
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Estado
 * @see EstadoService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class EstadoController {
    private final EstadoService estadoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param estadoService Servicios de usuario
     */
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @ApiOperation(
        value = "EstadoController::getAll",
        notes = "Regresa una lista de todos los objetos Estado "
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
        value = "/estados",
        produces = "application/json; charset=utf-8")
    public List<Estado> getAllEstados() throws ControllerException {
        return estadoService.getAll();
    }

    @ApiOperation(
        value = "EstadoController::get",
        notes = "Regresa un objeto Estado cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/estado/{id}",
        produces = "application/json; charset=utf-8")
    public Estado getEstado(
    @ApiParam(name="id", value="Representa el id del estado buscado.")
    @PathVariable int id
    ) throws ControllerException {
        return this.estadoService.getById(id);
    }

    @ApiOperation(
            value = "EstadoController::getByPais",
            notes = "Regresa los estados de determinado país")
    @GetMapping(
            value = "/get-by-pais",
            produces = "application/json; charset=utf-8")
    public List<Estado> getByPais(
            @ApiParam(name = "id", value = "Representa el id del pais")
            @PathVariable int id) throws ControllerException {
        return estadoService.getByPais(id);
    }

    @ApiOperation(
        value = "EstadoController::insert",
        notes = "Recibe un objeto Estado el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/estado",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="estado", value="Estado que será insertado en el sistema.")
    @RequestBody Estado estado) throws ControllerException {
        return estadoService.insert(estado);
    }

    @ApiOperation(
        value = "EstadoController::update",
        notes = "Recibe un objeto Estado, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/estado",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="estado", value="Estado que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody Estado estado) throws ControllerException {
        return estadoService.update(estado);
    }

    @ApiOperation(
        value = "EstadoController::delete",
        notes = "Recibe un objeto Estado, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/estado",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="estado", value="Estado que será removido del sistema.")
    @RequestBody Estado estado) throws ControllerException {
        return estadoService.delete(estado);
    }


    @GetMapping(
        path = "/estados/list/{nombre}/{idPais}.json",
        produces = "application/json; charset=utf-8")
    public List<Estado> getEstado(
            @ApiParam(name = "nombre", value = "Nombre del Estado", defaultValue = "Mexico") @PathVariable String nombre,
            @ApiParam(name = "idPais", value = "Pais seleccionado", defaultValue = "1") @PathVariable int idPais) throws ControllerException {
        return this.estadoService.getByNombre(nombre, idPais);
    }

    @ApiOperation(
            value = "EstadoController::getAllNombrePais",
            notes = "Regresa una lista de todos los objetos Estado ")
    @GetMapping(
            value = "/estados-nombre-pais.json",
            produces = "application/json; charset=utf-8")
    public List<Estado> getAllEstadosNombrePAis() throws ControllerException {
        return estadoService.getAllNombrePais();
    }

    @GetMapping(
            path = "/estados/pais/{id}.json",
            produces = "application/json; charset=utf-8")
    public List<Estado> getEstadosbyPais(
            @ApiParam(name = "id", value = "ID del Estado", defaultValue = "1")
            @PathVariable int id
    ) throws ControllerException {
        return this.estadoService.getEstadosByPais(id);
    }

}
