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
 * Nombre:      EstatusAnuncioController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:24:38
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

import io.kebblar.petstore.api.model.domain.EstatusAnuncio;
import io.kebblar.petstore.api.service.EstatusAnuncioService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementación  del REST Controller asociado a los endpoints de  gestión del POJO 'estatus_anuncio'.
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
 * @see io.kebblar.petstore.api.model.domain.EstatusAnuncio
 * @see io.kebblar.petstore.api.service.EstatusAnuncioService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class EstatusAnuncioController {

    private final EstatusAnuncioService estatusAnuncioService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param estatusAnuncioService Servicios de usuario
     */
    public EstatusAnuncioController(EstatusAnuncioService estatusAnuncioService) {
        this.estatusAnuncioService = estatusAnuncioService;
    }

    @ApiOperation(
        value = "EstatusAnuncioController::getAll",
        notes = "Regresa una lista de todos los objetos EstatusAnuncio "
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
        value = "/estatus-anuncios.json",
        produces = "application/json; charset=utf-8")
    public List<EstatusAnuncio> getAllEstatusAnuncio() throws BusinessException {
        return estatusAnuncioService.getAll();
    }

    @ApiOperation(
        value = "EstatusAnuncioController::get",
        notes = "Regresa un objeto EstatusAnuncio cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/estatus-anuncio/{id}.json",
        produces = "application/json; charset=utf-8")
    public EstatusAnuncio getEstatusAnuncio(
    @ApiParam(name="id", value="Representa el id del estatusAnuncio buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.estatusAnuncioService.getById(id);
    }

    @ApiOperation(
        value = "EstatusAnuncioController::insert",
        notes = "Recibe un objeto EstatusAnuncio el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/estatus-anuncio.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="estatusAnuncio", value="EstatusAnuncio que será insertado en el sistema.")
    @RequestBody EstatusAnuncio estatusAnuncio
    ) throws BusinessException {
        return estatusAnuncioService.insert(estatusAnuncio);
    }

    @ApiOperation(
        value = "EstatusAnuncioController::update",
        notes = "Recibe un objeto EstatusAnuncio, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/estatus-anuncio.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="estatusAnuncio", value="EstatusAnuncio que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody EstatusAnuncio estatusAnuncio
    ) throws BusinessException {
        return estatusAnuncioService.update(estatusAnuncio);
    }

    @ApiOperation(
        value = "EstatusAnuncioController::delete",
        notes = "Recibe un objeto EstatusAnuncio, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/estatus-anuncio.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="estatusAnuncio", value="EstatusAnuncio que será removido del sistema.")
    @RequestBody EstatusAnuncio estatusAnuncio
    ) throws BusinessException {
        return estatusAnuncioService.delete(estatusAnuncio);
    }

    @GetMapping(path = "/estatusanuncios/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<EstatusAnuncio> getEstatusAnuncio(
            @ApiParam(name = "nombre", value = "Nombre del EstatusAnuncio", defaultValue = "EN LINEA")
            @PathVariable String nombre) throws BusinessException {
        return this.estatusAnuncioService.getByNombre(nombre);
    }
}
