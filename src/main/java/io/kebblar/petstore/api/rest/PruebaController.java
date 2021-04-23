package io.kebblar.petstore.api.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.domain.*;
import io.kebblar.petstore.api.service.*;

@RestController
@RequestMapping(value = "/api")
public class PruebaController {
    private static final String res = "{'result':'ok'}".replace('\'', '\"');

    @Autowired
    private DireccionService servicio;
    
    @GetMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba1() throws ControllerException {
        List<Direccion> data = servicio.getAll();
        System.out.println(data);
        return res;
    }

    @PostMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba1(@Valid @RequestBody Direccion dato) throws ControllerException {
        servicio.insert(dato);
        return res;
    }
    
    @PutMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba2(@Valid @RequestBody Direccion dato) throws ControllerException {
        servicio.update(dato);
        return res;
    }

}
