package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.EstadoService;

@RestController
@RequestMapping(value = "/api")
public class EstadoController {
    private EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping(path = "/estados.json", produces = "application/json; charset=utf-8")
    public List<Estado> getEstaos() throws ControllerException {
        return estadoService.getAll();
    }

}
