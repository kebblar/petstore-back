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
 * Artefacto:   MediaTipoController .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (23_19)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2319 Implementación de clase
 *
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
import io.kebblar.petstore.api.model.domain.MediaTipo;
import io.kebblar.petstore.api.service.MediaTipoService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'media_tipo'.
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
 * @see io.kebblar.petstore.api.model.domain.MediaTipo
 * @see io.kebblar.petstore.api.service.MediaTipoService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class MediaTipoController {

    private MediaTipoService mediaTipoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param mediaTipoService Servicios de usuario
     */
    public MediaTipoController(MediaTipoService mediaTipoService) {
        this.mediaTipoService = mediaTipoService;
    }

    @ApiOperation(
        value = "MediaTipoController::getAll",
        notes = "Regresa una lista de todos los objetos MediaTipo "
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
        value = "/media-tipos.json",
        produces = "application/json; charset=utf-8")
    public List<MediaTipo> getAllMediaTipo() throws BusinessException {
        return mediaTipoService.getAll();
    }

    @ApiOperation(
        value = "MediaTipoController::get",
        notes = "Regresa un objeto MediaTipo cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/media-tipo/{id}.json",
        produces = "application/json; charset=utf-8")
    public MediaTipo getMediaTipo(
    @ApiParam(name="id", value="Representa el id del mediaTipo buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.mediaTipoService.getById(id);
    }

    @ApiOperation(
        value = "MediaTipoController::insert",
        notes = "Recibe un objeto MediaTipo el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/media-tipo.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="mediaTipo", value="MediaTipo que será insertado en el sistema.")
    @RequestBody MediaTipo mediaTipo
    ) throws BusinessException {
        return mediaTipoService.insert(mediaTipo);
    }

    @ApiOperation(
        value = "MediaTipoController::update",
        notes = "Recibe un objeto MediaTipo, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/media-tipo.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="mediaTipo", value="MediaTipo que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody MediaTipo mediaTipo
    ) throws BusinessException {
        return mediaTipoService.update(mediaTipo);
    }

    @ApiOperation(
        value = "MediaTipoController::delete",
        notes = "Recibe un objeto MediaTipo, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/media-tipo.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="mediaTipo", value="MediaTipo que será removido del sistema.")
    @RequestBody MediaTipo mediaTipo
    ) throws BusinessException {
        return mediaTipoService.delete(mediaTipo);
    }

    @GetMapping(path = "/mediatipos/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<MediaTipo> getMediaTipo(
            @ApiParam(name = "nombre", value = "Nombre del MediaTipo", defaultValue = "PESO")
            @PathVariable String nombre) throws BusinessException {
        return this.mediaTipoService.getByNombre(nombre);
    }
}
