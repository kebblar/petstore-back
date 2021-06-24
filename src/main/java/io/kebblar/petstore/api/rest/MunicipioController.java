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
 * Artefacto:   MunicipioController .java
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.service.MunicipioService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'municipio'.
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
 * @see Municipio
 * @see MunicipioService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class MunicipioController {
    private MunicipioService municipioService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param municipioService Servicios de usuario
     */
    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @ApiOperation(
        value = "MunicipioController::getAll",
        notes = "Regresa una lista de todos los objetos Municipio "
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
        value = "/municipios.json",
        produces = "application/json; charset=utf-8")
    public List<Municipio> getAllMunicipio() throws BusinessException {
        return municipioService.getAll();
    }

    @ApiOperation(
        value = "MunicipioController::get",
        notes = "Regresa un objeto Municipio cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/municipio/{id}.json",
        produces = "application/json; charset=utf-8")
    public Municipio getMunicipio(
    @ApiParam(name="id", value="Representa el id del municipio buscado.")
    @PathVariable int id) throws BusinessException {
        return this.municipioService.getById(id);
    }

    @ApiOperation(
        value = "MunicipioController::insert",
        notes = "Recibe un objeto Municipio el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
        value = "/municipio.json",
        produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="municipio", value="Municipio que será insertado en el sistema.")
    @RequestBody Municipio municipio) throws BusinessException {
        return municipioService.insert(municipio);
    }

    @ApiOperation(
        value = "MunicipioController::update",
        notes = "Recibe un objeto Municipio, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
        value = "/municipio.json",
        produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="municipio", value="Municipio que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody Municipio municipio) throws BusinessException {
        return municipioService.update(municipio);
    }

    @ApiOperation(
        value = "MunicipioController::delete",
        notes = "Recibe un objeto Municipio, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
        value = "/municipio.json",
        produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="municipio", value="Municipio que será removido del sistema.")
    @RequestBody Municipio municipio) throws BusinessException {
        return municipioService.delete(municipio);
    }

    @GetMapping(
        value= "/municipio-por-estado/{id}.json",
        produces = "application/json; charset=utf-8")
    public List<Municipio> getByEstado(@PathVariable int id) throws BusinessException{
        return municipioService.getByEstado(id);
    }

    @GetMapping(
        value= "/municipios-por-estado-paginados.json",
        produces = "application/json; charset=utf-8")
    public List<Municipio> getByEstadoPaginados(
            @RequestParam int idEstado,
            @RequestParam int pageNumber,
            @RequestParam int pageSize
            ) throws BusinessException {
        return municipioService.getPaginatedMunicipios(idEstado, pageNumber, pageSize);
    }
    
    @GetMapping(
        path = "/municipios/list/descripcion.json", 
        produces = "application/json; charset=utf-8")
    public List<Municipio> getMunicipiosDescripcion() throws BusinessException {
        return this.municipioService.getMunicipiosDescripcion(); 
    }
    
    @GetMapping(
        path = "/municipios/list/{nombre}.json", 
        produces = "application/json; charset=utf-8")
    public List<Municipio> getMunicipiosbyEstado(
            @ApiParam(name = "nombre", value = "nombre del Municipio", defaultValue = "Ixtapaluca")
            @PathVariable String nombre
            ) throws BusinessException {
        return this.municipioService.getMunicipiosDescripcionByNombre(nombre); 
    }
    
    @GetMapping(
            path = "/municipios/pais/{id}/{nombre}.json", 
            produces = "application/json; charset=utf-8")
        public List<Municipio> getMunicipiosbyPaisId(
                @ApiParam(name = "id", value = "id del pais", defaultValue = "1") @PathVariable int id,
                @ApiParam(name = "nombre", value = "nombre del municipio", defaultValue = "Ixtapaluca") @PathVariable String nombre
                ) throws BusinessException {
            return this.municipioService.getMunicipiosByPaisDescripcion(id,nombre); 
        }
    
    @GetMapping(
            path = "/municipios/estado/{id}/{nombre}.json", 
            produces = "application/json; charset=utf-8")
        public List<Municipio> getMunicipiosbyEstadoId(
                @ApiParam(name = "id", value = "id del estado", defaultValue = "1") @PathVariable int id,
                @ApiParam(name = "nombre", value = "id del estado", defaultValue = "Ixtapaluca") @PathVariable String nombre
               ) throws BusinessException {
            return this.municipioService.getMunicipiosByEstadoDescripcion(id, nombre);
        }
}
