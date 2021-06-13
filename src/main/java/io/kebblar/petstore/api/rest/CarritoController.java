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

import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import io.kebblar.petstore.api.model.response.CarritoVista;
import io.kebblar.petstore.api.service.CarritoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'carrito' y otros metodos suplementarios.
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
 */

@RestController
@Api(value = "carrito")
@RequestMapping(value = "/api")
public class CarritoController {

    private CarritoService carritoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param carritoService Servicios de usuario
     */
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @ApiOperation(
            value = "CarritoController:getCarrito",
            notes = "Devuelve la lista de elementos necesarios para poder presentar al usuario" +
                    " su carrito de compras en el frontend, es necesario otorgar el id del usuario" +
                    "del que se desea obtener el carrito.")
    @GetMapping(
            value = "/carritoVista/{id}.json",
            produces = "application/json; charset=utf-8")
    public List<CarritoVista> getCarritoView(
            @ApiParam(name = "id", value = "id del usuario")
            @PathVariable int id) throws BusinessException {
                return carritoService.getCarritoView(id);
    }

    @ApiOperation(
            value = "CarritoController::getAll",
            notes = "Regresa una lista de todos los objetos Carrito "
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
            value = "/carritoUser/{id}.json",
            produces = "application/json; charset=utf-8")
    public List<Carrito> getAllCarrito(
            @ApiParam(name = "id", value = "Id del usuario.")
            @PathVariable int id
    ) throws BusinessException {
        return carritoService.getAll(id);
    }

    @ApiOperation(
            value = "CarritoController::get",
            notes = "Regresa un objeto Carrito cuyo id "
                    + "coincide con el entero recibido como parametro.")
    @GetMapping(
            value = "/carrito/{id}.json",
            produces = "application/json; charset=utf-8")
    public Carrito getCarrito(
            @ApiParam(name="id", value="Representa el id del carrito buscado.")
            @PathVariable int id
    ) throws BusinessException {
        return this.carritoService.getById(id);
    }

    @ApiOperation(
            value = "CarritoController::insert",
            notes = "Recibe un objeto Carrito el cual debe de ser insertado "
                    + " como dato dentro de la base de datos del sistema.")
    @PostMapping(
            value = "/carrito.json",
            produces = "application/json; charset=utf-8")
    public int insert(
            @ApiParam(name="carrito", value="Carrito que será insertado en el sistema.")
            @RequestBody Carrito carrito
    ) throws BusinessException {
        return carritoService.insert(carrito);
    }

    @ApiOperation(
            value = "CarritoController::update",
            notes = "Recibe un objeto Carrito, este objeto es buscado por "
                    + "id dentro de la base de datos y es actualizado con el resto de "
                    + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/carrito.json",
            produces = "application/json; charset=utf-8")
    public int update(
            @ApiParam(name="carrito", value="Carrito que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
            @RequestBody Carrito carrito
    ) throws BusinessException {
        return carritoService.update(carrito);
    }

    @ApiOperation(
            value = "CarritoController::delete",
            notes = "Recibe un objeto Carrito, el cual es buscado dentro de "
                    + "la base de datos y en caso de existir es eliminado.")
    @DeleteMapping(
            value = "/carrito/{id}.json",
            produces = "application/json; charset=utf-8")
    public int delete(
            @ApiParam(name="id", value="id del carrito que será removido del sistema.")
            @PathVariable int id
    ) throws BusinessException {
        return carritoService.delete(id);
    }
    
    @ApiOperation(
            value = "CarritoController::getByClave",
            notes = "Retorna una lista de objetos 'CarritoDatosFactura' asociados a una clave")
    @GetMapping(
        value = "/carritoCve/{cve}.json", 
        produces = "application/json; charset=utf-8")
    public List<CarritoDatosFactura> getByClave(@PathVariable String cve) throws BusinessException {
        return carritoService.getByCveOrden(cve);
    }

}
