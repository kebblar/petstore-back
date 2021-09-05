/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      DireccionController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:24:21
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.domain.*;
import io.kebblar.petstore.api.service.*;

@RestController
@RequestMapping(value = "/api")
public class DireccionController {

    private DireccionService servicio;

    public DireccionController(DireccionService direccionService){
        this.servicio=direccionService;
    }

    @ApiOperation(
            value= "DireccionController::getAll",
            notes = "Devuelve una lista de todas las direcciones"
    )
    @GetMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public List<Direccion> getAll() throws BusinessException {
        return servicio.getAll();
    }

    @ApiOperation(
            value = "DireccionController::getByUsuario",
            notes = "Devuelve las direcciones de determinado usuario"
    )
    @GetMapping(path = "/direcciones-con-nombre/{userId}.json", produces = "application/json; charset=utf-8")
    public List<DireccionConNombre> getByUsuario(
            @ApiParam(name="userId", value="Id del usuario")
            @PathVariable int userId
    ) throws BusinessException {
        return servicio.getDireccionesNombre(userId);
    }

    @ApiOperation(
            value = "DireccionController::nuevaDireccion",
            notes = "Inserta la dirección desde la pantalla de proceso de compra"
    )
    @PostMapping(path = "/nueva-direccion.json", produces = "application/json; charset=utf-8")
    public int nuevaDireccion(
            @ApiParam(name="nuevaDireccion", value="Direccion ingresada por el usuario")
            @RequestBody NuevaDireccion nuevaDireccion) throws BusinessException{
        return servicio.agregaDireccion(nuevaDireccion);
    }
}
