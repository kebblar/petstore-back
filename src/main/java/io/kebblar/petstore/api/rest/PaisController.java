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
 * Artefacto:   PaisController .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase
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

import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.service.PaisService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'pais'.
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
 * @see Pais
 * @see PaisService
 */

@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class PaisController {

    private PaisService paisService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param paisService Servicios de usuario
     */
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @ApiOperation(
        value = "PaisController::getAll",
        notes = "Regresa una lista de todos los objetos Pais "
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
        value = "/paises.json",
        produces = "application/json; charset=utf-8")
    public List<Pais> getAllPais() throws ControllerException {
        return paisService.getAll();
    }

    @ApiOperation(
        value = "PaisController::get",
        notes = "Regresa un objeto Pais cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/pais/{id}.json",
        produces = "application/json; charset=utf-8")
    public Pais getPais(
            @ApiParam(name="id", value="Representa el id del pais buscado.")
            @PathVariable int id
    ) throws ControllerException {
        return this.paisService.getById(id);
    }

    @ApiOperation(
        value = "PaisController::insert",
        notes = "Recibe un objeto Pais el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/pais.json",
            produces = "application/json; charset=utf-8")
    public int insert(
            @ApiParam(name="pais", value="Pais que será insertado en el sistema.")
            @RequestBody Pais pais
    ) throws ControllerException {
        return paisService.insert(pais);
    }

    @ApiOperation(
        value = "PaisController::update",
        notes = "Recibe un objeto Pais, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/pais.json",
            produces = "application/json; charset=utf-8")
    public int update(
            @ApiParam(name="pais", value="Pais que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
            @RequestBody Pais pais
    ) throws ControllerException {
        return paisService.update(pais);
    }

    @ApiOperation(
        value = "PaisController::delete",
        notes = "Recibe un objeto Pais, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/pais.json",
            produces = "application/json; charset=utf-8")
    public int delete(
            @ApiParam(name="pais", value="Pais que será removido del sistema.")
            @RequestBody Pais pais
    ) throws ControllerException {
        return paisService.delete(pais);
    }
    
    @GetMapping(path = "/paises/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<Pais> getPais(
            @ApiParam(name = "nombre", value = "Nombre del Pais", defaultValue = "Mexico")
            @PathVariable String nombre) throws ControllerException {
        return this.paisService.getByNombre(nombre);
    }

}
