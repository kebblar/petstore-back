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
 * Nombre:      CategoriaController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:24:06
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

import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.domain.CategoriaTO;
import io.kebblar.petstore.api.service.CategoriaService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'categoria'.
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
 * @see io.kebblar.petstore.api.model.domain.Categoria
 * @see io.kebblar.petstore.api.service.CategoriaService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class CategoriaController {

    private CategoriaService categoriaService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param categoriaService Servicios de usuario
     */
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @ApiOperation(
        value = "CategoriaController::getAll",
        notes = "Regresa una lista de todos los objetos Categoria "
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
        value = "/categorias.json",
        produces = "application/json; charset=utf-8")
    public List<Categoria> getAllCategoria() throws BusinessException {
        return categoriaService.getAll();
    }

    @ApiOperation(
        value = "CategoriaController::get",
        notes = "Regresa un objeto Categoria cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/categoria/{id}.json",
        produces = "application/json; charset=utf-8")
    public Categoria getCategoria(
    @ApiParam(name="id", value="Representa el id del categoria buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.categoriaService.getById(id);
    }

    @ApiOperation(
        value = "CategoriaController::insert",
        notes = "Recibe un objeto Categoria el cual debe de ser insertado "
            + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/categoria.json",
            produces = "application/json; charset=utf-8")
    public int insert(
    @ApiParam(name="categoria", value="Categoria que será insertado en el sistema.")
    @RequestBody Categoria categoria
    ) throws BusinessException {
        return categoriaService.insert(categoria);
    }

    @ApiOperation(
        value = "CategoriaController::update",
        notes = "Recibe un objeto Categoria, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/categoria.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="categoria", value="Categoria que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody Categoria categoria
    ) throws BusinessException {
        return categoriaService.update(categoria);
    }

    @ApiOperation(
        value = "CategoriaController::delete",
        notes = "Recibe un objeto Categoria, el cual es buscado dentro de "
        +"la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/categoria.json",
            produces = "application/json; charset=utf-8")
    public int delete(
    @ApiParam(name="categoria", value="Categoria que será removido del sistema.")
    @RequestBody Categoria categoria
    ) throws BusinessException {
        return categoriaService.delete(categoria);
    }

    @GetMapping(path = "/categorias/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<Categoria> getCategoria(
            @ApiParam(name = "nombre", value = "Nombre de Categoria", defaultValue = "CANINOS")
            @PathVariable String nombre) throws BusinessException {
        return this.categoriaService.getByNombre(nombre);
    }


    @ApiOperation(
            value = "CategoriaController::getAllCategoriaDetalles",
            notes = "Regresa una lista de todos los objetos Categoria "
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
            value = "/categorias-detalle.json",
            produces = "application/json; charset=utf-8")
        public List<CategoriaTO> getAllCategoriaDetalles() throws BusinessException {
            return categoriaService.getAllCategoriaDetalles();
        }

}
