package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.PaisService;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api")
public class PaisController {
    private PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping(path = "/paises.json", produces = "application/json; charset=utf-8")
    public List<Pais> getPaises() throws ControllerException {
        return paisService.getAll();
    }
    @GetMapping(path = "/paises/{id}.json", produces = "application/json; charset=utf-8")
    public Pais getPais(
            @ApiParam(name = "id", value = "ID del Pais", defaultValue = "1")
            @PathVariable int id
            ) throws ControllerException {
        return this.paisService.getById(id);
    }
}
