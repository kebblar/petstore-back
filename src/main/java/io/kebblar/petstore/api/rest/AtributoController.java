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
 * Artefacto:   AtributoController .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (21_41)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de clase 
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

import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.AtributoTO;
import io.kebblar.petstore.api.service.AtributoService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'atributo'. 
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
 * @see io.kebblar.petstore.api.model.domain.Atributo
 * @see io.kebblar.petstore.api.service.AtributoService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class AtributoController {

    private AtributoService atributoService;

    /**
     * Constructor que realiza el setting de los servicios que serán 
     * utilizados en este controlador.
     * 
     * @param atributoService Servicios de usuario
     */
    public AtributoController(AtributoService atributoService) {
        this.atributoService = atributoService;
    }

    @ApiOperation(
        value = "AtributoController::getAll",
        notes = "Regresa una lista de todos los objetos Atributo "
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
        value = "/atributos.json",
        produces = "application/json; charset=utf-8")
    public List<Atributo> getAllAtributo() throws BusinessException {
        return atributoService.getAll();
    }
    
    @ApiOperation(
        value = "AtributoController::get",
        notes = "Regresa un objeto Atributo cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/atributo/{id}.json",
        produces = "application/json; charset=utf-8")
    public Atributo getAtributo(
    @ApiParam(name="id", value="Representa el id del atributo buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.atributoService.getById(id);
    }
    
    @ApiOperation(
        value = "AtributoController::insert",
        notes = "Recibe un objeto Atributo el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/atributo.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="atributo", value="Atributo que será insertado en el sistema.")
    @RequestBody Atributo atributo
    ) throws BusinessException {
        return atributoService.insert(atributo);
    }

    @ApiOperation(
        value = "AtributoController::update",
        notes = "Recibe un objeto Atributo, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/atributo.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="atributo", value="Atributo que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody Atributo atributo
    ) throws BusinessException {
        return atributoService.update(atributo);
    }
    
    @ApiOperation(
        value = "AtributoController::delete",
        notes = "Recibe un objeto Atributo, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/atributo.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="atributo", value="Atributo que será removido del sistema.")
    @RequestBody Atributo atributo
    ) throws BusinessException {
        return atributoService.delete(atributo);
    }
    
    @GetMapping(path = "/atributos/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<Atributo> getAtributo(
            @ApiParam(name = "nombre", value = "Nombre del Atributo", defaultValue = "PESO")
            @PathVariable String nombre) throws BusinessException {
        return this.atributoService.getByNombre(nombre);
    }
    
    @ApiOperation(
            value = "AtributoController::getAll",
            notes = "Regresa una lista de todos los objetos Atributo "
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
            value = "/atributos-detalles.json",
            produces = "application/json; charset=utf-8")
        public List<AtributoTO> getAllAtributoDeralles() throws BusinessException {
            return atributoService.getAllAtributoDetalles();
        }
        
}
