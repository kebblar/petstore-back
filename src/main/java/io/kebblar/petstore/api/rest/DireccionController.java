package io.kebblar.petstore.api.rest;

import java.util.List;

import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import io.kebblar.petstore.api.model.response.GoogleCaptcha;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.domain.*;
import io.kebblar.petstore.api.service.*;

@RestController
@RequestMapping(value = "/api")
public class DireccionController {
    private static final String res = "{'result':'ok'}".replace('\'', '\"');

    private DireccionService servicio;
    private TipoDireccionService servicio2;

    public DireccionController(DireccionService direccionService, TipoDireccionService tipoDireccionService){
        this.servicio=direccionService;
        this.servicio2=tipoDireccionService;
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
