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
 * Nombre:      PaqueteriaController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:26:28
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

import io.kebblar.petstore.api.model.domain.Paqueteria;
import io.kebblar.petstore.api.service.PaqueteriaService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementación  del REST Controller asociado a los endpoints de  gestión del POJO 'paqueteria'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}</p>
 *
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.</p>
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Paqueteria
 * @see PaqueteriaService
 */

@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class PaqueteriaController {

    private final PaqueteriaService paqueteriaService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param paqueteriaService Servicios de usuario
     */
    public PaqueteriaController(PaqueteriaService paqueteriaService) {
        this.paqueteriaService = paqueteriaService;
    }

    @ApiOperation(
        value = "PaqueteriaController::getAll",
        notes = "Regresa una lista de todos los objetos Paqueteria "
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
        value = "/paqueterias.json",
        produces = "application/json; charset=utf-8")
    public List<Paqueteria> getAllPaqueteria() throws BusinessException {
        return paqueteriaService.getAll();
    }

    @ApiOperation(
        value = "PaqueteriaController::get",
        notes = "Regresa un objeto Paqueteria cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/paqueteria/{id}.json",
        produces = "application/json; charset=utf-8")
    public Paqueteria getPaqueteria(
    @ApiParam(name="id", value="Representa el id del paqueteria buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.paqueteriaService.getById(id);
    }

    @ApiOperation(
        value = "PaqueteriaController::insert",
        notes = "Recibe un objeto Paqueteria el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/paqueteria.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="paqueteria", value="Paqueteria que será insertado en el sistema.")
    @RequestBody Paqueteria paqueteria
    ) throws BusinessException {
        return paqueteriaService.insert(paqueteria);
    }

    @ApiOperation(
        value = "PaqueteriaController::update",
        notes = "Recibe un objeto Paqueteria, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/paqueteria.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="paqueteria", value="Paqueteria que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody Paqueteria paqueteria
    ) throws BusinessException {
        return paqueteriaService.update(paqueteria);
    }

    @ApiOperation(
        value = "PaqueteriaController::delete",
        notes = "Recibe un objeto Paqueteria, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/paqueteria.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="paqueteria", value="Paqueteria que será removido del sistema.")
    @RequestBody Paqueteria paqueteria
    ) throws BusinessException {
        return paqueteriaService.delete(paqueteria);
    }

    @GetMapping(path = "/paqueteria/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<Paqueteria> getPAqueterias(
            @ApiParam(name = "nombre", value = "Nombre la paqueteria", defaultValue = "DHL")
            @PathVariable String nombre) throws BusinessException {
        return this.paqueteriaService.getByNombre(nombre);
    }

}
