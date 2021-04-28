package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.PaisService;

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

}
