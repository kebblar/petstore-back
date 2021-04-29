package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.MunicipioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api")
public class MunicipioController {
    private MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }
    
    @ApiOperation(
            value = "MunicipioController::getMunicipios", 
            notes = "Entrega una lista paginada de los municipios de un estado")
    @GetMapping(
            path = "/municipios/{idEstado}.json", 
            produces = "application/json; charset=utf-8")
    public List<Municipio> getMunicipios(
            @ApiParam(name = "idEstado", value = "ID del estado", defaultValue = "1")
            @PathVariable int idEstado, 
            @ApiParam(name = "pageNumber", value = "Numero de página", defaultValue = "1")
            @RequestParam int pageNumber, 
            @ApiParam(name = "pageSize", value = "Tamaño de la página", defaultValue = "5")
            @RequestParam int pageSize
        ) throws ControllerException {
        return municipioService.getPaginatedMunicipios(idEstado, pageNumber, pageSize);
    }
    
    @GetMapping(path = "/municipios.json", produces = "application/json; charset=utf-8")
    public List<Municipio> getMunicipios(@RequestParam int idEstado) throws ControllerException {
        return municipioService.getAllByEstado(idEstado);
    }

}
