package io.kebblar.petstore.api.rest;

import java.util.List;

import io.kebblar.petstore.api.model.response.GoogleCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.domain.*;
import io.kebblar.petstore.api.service.*;

@RestController
@RequestMapping(value = "/api")
public class PruebaController {
    private static final String res = "{'result':'ok'}".replace('\'', '\"');

    @Autowired
    private DireccionService servicio;
    
    @GetMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba1() throws BusinessException {
        List<Direccion> data = servicio.getAll();
        System.out.println(data);
        return res;
    }

    @PostMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba1(@RequestBody Direccion dato) throws BusinessException {
        servicio.insert(dato);
        return res;
    }
    
    @PutMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba2(@RequestBody Direccion dato) throws BusinessException {
        servicio.update(dato);
        return res;
    }

    @PostMapping(path = "/pba1.json", produces = "application/json; charset=utf-8")
    public String prueba(@RequestBody UsuarioDetalle usuarioDetalle) throws  BusinessException{
        System.out.println(usuarioDetalle.toString());
        return "{ \"todo\" : \"ok\" }";
    }

    @PostMapping(path = "/captchaPba.json", produces = "application/json; charset=utf-8")
    public String captchaPba(@RequestBody GoogleCaptcha googleCaptcha) throws  BusinessException {
        return "{ \"todo\" : \"ok\" }";
    }
}
