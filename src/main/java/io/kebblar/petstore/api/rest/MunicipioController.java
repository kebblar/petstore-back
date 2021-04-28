package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.MunicipioService;
import io.kebblar.petstore.api.service.PaisService;

@RestController
@RequestMapping(value = "/api")
public class MunicipioController {
    private MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping(path = "/municipios/{idEstado}.json", produces = "application/json; charset=utf-8")
    public List<Municipio> getMunicipios(@PathVariable int idEstado, @RequestParam int pageNumber, @RequestParam int pageSize) throws ControllerException {
        return municipioService.getPaginatedMunicipios(idEstado, pageNumber, pageSize);
    }
    @GetMapping(path = "/municipios.json", produces = "application/json; charset=utf-8")
    public List<Municipio> getMunicipios(@RequestParam int idEstado) throws ControllerException {
        return municipioService.getAllByEstado(idEstado);
    }

}
