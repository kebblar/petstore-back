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
 * Artefacto:   ValorAtributoController .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       martes 06 de junio de 2021 (00_43)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210608_0043 Implementación de clase
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

import io.kebblar.petstore.api.model.domain.ValorAtributo;
import io.kebblar.petstore.api.service.ValorAtributoService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'valor_atributo'.
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
 * @see io.kebblar.petstore.api.model.domain.ValorAtributo
 * @see io.kebblar.petstore.api.service.ValorAtributoService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class ValorAtributoController {

    private ValorAtributoService valorAtributoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param valorAtributoService Servicios de usuario
     */
    public ValorAtributoController(ValorAtributoService valorAtributoService) {
        this.valorAtributoService = valorAtributoService;
    }

    @ApiOperation(
        value = "ValorAtributoController::getAll",
        notes = "Regresa una lista de todos los objetos ValorAtributo "
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
        value = "/valor-atributos.json",
        produces = "application/json; charset=utf-8")
    public List<ValorAtributo> getAllValorAtributo() throws BusinessException {
        return valorAtributoService.getAll();
    }

    @ApiOperation(
        value = "ValorAtributoController::get",
        notes = "Regresa un objeto ValorAtributo cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/valor-atributo/{id}.json",
        produces = "application/json; charset=utf-8")
    public ValorAtributo getValorAtributo(
    @ApiParam(name="id", value="Representa el id del valorAtributo buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.valorAtributoService.getById(id);
    }

    @ApiOperation(
        value = "ValorAtributoController::insert",
        notes = "Recibe un objeto ValorAtributo el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/valor-atributo.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="valorAtributo", value="ValorAtributo que será insertado en el sistema.")
    @RequestBody ValorAtributo valorAtributo
    ) throws BusinessException {
        return valorAtributoService.insert(valorAtributo);
    }

    @ApiOperation(
        value = "ValorAtributoController::update",
        notes = "Recibe un objeto ValorAtributo, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/valor-atributo.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="valorAtributo", value="ValorAtributo que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody ValorAtributo valorAtributo
    ) throws BusinessException {
        return valorAtributoService.update(valorAtributo);
    }

    @ApiOperation(
        value = "ValorAtributoController::delete",
        notes = "Recibe un objeto ValorAtributo, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/valor-atributo.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="valorAtributo", value="ValorAtributo que será removido del sistema.")
    @RequestBody ValorAtributo valorAtributo
    ) throws BusinessException {
        return valorAtributoService.delete(valorAtributo);
    }


    @ApiOperation(
            value = "ValorAtributoController::get",
            notes = "Regresa un objeto ValorAtributo cuyo id "
                + "coincide con el entero recibido como parametro.")
        @GetMapping(
            value = "/valor-atributo/atributo/{id}.json",
            produces = "application/json; charset=utf-8")
        public List<ValorAtributo> getValorAtributoByIdAtributo(
        @ApiParam(name="id", value="Representa el id del atributo del valorAtributo buscado.")
        @PathVariable int id
        ) throws BusinessException {
            return this.valorAtributoService.getAllByIdAtributo(id);
     }

}
