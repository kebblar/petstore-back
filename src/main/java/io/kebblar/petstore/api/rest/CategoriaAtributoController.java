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
 * Artefacto:   CategoriaAtributoController .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (19_06)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210606_1906 Implementación de clase
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
import io.kebblar.petstore.api.model.domain.CategoriaAtributo;
import io.kebblar.petstore.api.service.CategoriaAtributoService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'categoria_atributo'.
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
 * @see io.kebblar.petstore.api.model.domain.CategoriaAtributo
 * @see io.kebblar.petstore.api.service.CategoriaAtributoService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class CategoriaAtributoController {

    private CategoriaAtributoService categoriaAtributoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param categoriaAtributoService Servicios de usuario
     */
    public CategoriaAtributoController(CategoriaAtributoService categoriaAtributoService) {
        this.categoriaAtributoService = categoriaAtributoService;
    }

    @ApiOperation(
        value = "CategoriaAtributoController::getAll",
        notes = "Regresa una lista de todos los objetos CategoriaAtributo "
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
        value = "/categoria-atributos.json",
        produces = "application/json; charset=utf-8")
    public List<CategoriaAtributo> getAllCategoriaAtributo() throws BusinessException {
        return categoriaAtributoService.getAll();
    }

    @ApiOperation(
        value = "CategoriaAtributoController::get",
        notes = "Regresa un objeto CategoriaAtributo cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/categoria-atributo/{id}.json",
        produces = "application/json; charset=utf-8")
    public CategoriaAtributo getCategoriaAtributo(
    @ApiParam(name="id", value="Representa el id del categoriaAtributo buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.categoriaAtributoService.getById(id);
    }

    @ApiOperation(
        value = "CategoriaAtributoController::insert",
        notes = "Recibe un objeto CategoriaAtributo el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/categoria-atributo.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="categoriaAtributo", value="CategoriaAtributo que será insertado en el sistema.")
    @RequestBody CategoriaAtributo categoriaAtributo
    ) throws BusinessException {
        return categoriaAtributoService.insert(categoriaAtributo);
    }

    @ApiOperation(
        value = "CategoriaAtributoController::update",
        notes = "Recibe un objeto CategoriaAtributo, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/categoria-atributo.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="categoriaAtributo", value="CategoriaAtributo que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody CategoriaAtributo categoriaAtributo
    ) throws BusinessException {
        return categoriaAtributoService.update(categoriaAtributo);
    }

    @ApiOperation(
        value = "CategoriaAtributoController::delete",
        notes = "Recibe un objeto CategoriaAtributo, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/categoria-atributo.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="categoriaAtributo", value="CategoriaAtributo que será removido del sistema.")
    @RequestBody CategoriaAtributo categoriaAtributo
    ) throws BusinessException {
        return categoriaAtributoService.delete(categoriaAtributo);
    }

    @ApiOperation(
            value = "CategoriaAtributoController::get",
            notes = "Regresa una lista de objetos CategoriaAtributo cuyo id de categoria"
                + "coincide con el entero recibido como parametro.")
    @GetMapping(
            value = "/categoria-atributo/categoria/{id}.json",
            produces = "application/json; charset=utf-8")
   public List<CategoriaAtributo> getCategoriaAtributoNombre(
        @ApiParam(name="id", value="Representa el id de la categoria buscada.")
        @PathVariable int id) throws BusinessException {
            return this.categoriaAtributoService.getAllAtributoByCategoria(id);
   }

   @ApiOperation(
            value = "CategoriaAtributoController::get",
            notes = "Regresa una lista de objetos CategoriaAtributo cuyo id de categoria"
                + "coincide con el entero recibido como parametro.")
   @GetMapping(
            value = "/categoria-atributos-faltantes/categoria/{id}.json",
            produces = "application/json; charset=utf-8")
   public List<Atributo> getAtributosFaltantesByCategoria(
        @ApiParam(name="id", value="Representa el id de la categoria buscada.")
        @PathVariable int id) throws ControllerException {
            return this.categoriaAtributoService.getAllAtributosFaltantesByCategoria(id);
   }



}
