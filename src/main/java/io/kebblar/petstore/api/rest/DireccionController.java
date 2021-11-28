/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.service.DireccionService;

@RestController
@RequestMapping(value = "/api")
public class DireccionController {

    private final DireccionService servicio;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param direccionService Servicios de usuario
     */
    public DireccionController(DireccionService direccionService){
        this.servicio=direccionService;
    }

    @ApiOperation(
            value= "DireccionController::getAll",
            notes = "Devuelve una lista de todas las direcciones"
    )
    @GetMapping(path = "/direcciones", produces = "application/json; charset=utf-8")
    public List<Direccion> getAll() throws ControllerException {
        return servicio.getAll();
    }

    @ApiOperation(
            value = "DireccionController::getByUsuario",
            notes = "Devuelve las direcciones de determinado usuario"
    )
    @GetMapping(path = "/direcciones-con-nombre/{userId}", produces = "application/json; charset=utf-8")
    public List<DireccionConNombre> getByUsuario(
            @ApiParam(name="userId", value="Id del usuario")
            @PathVariable int userId
    ) throws ControllerException {
        return servicio.getDireccionesNombre(userId);
    }

    @ApiOperation(
            value = "DireccionController::nuevaDireccion",
            notes = "Inserta la dirección desde la pantalla de proceso de compra"
    )
    @PostMapping(path = "/nueva-direccion", produces = "application/json; charset=utf-8")
    public int nuevaDireccion(
            @ApiParam(name="nuevaDireccion", value="Direccion ingresada por el usuario")
            @RequestBody NuevaDireccion nuevaDireccion) throws ControllerException{
        return servicio.agregaDireccion(nuevaDireccion);
    }
}
