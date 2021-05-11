/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   PaisController.java
 * Tipo:        clase
 * AUTOR:       Marco Antonio Santiago Garcia
 * Fecha:       Martes 11 de Mayo de 2021 (09_00)
 *
 * Historia:    .
 *              20210503_2229 Creación de éste controlador REST
 *
 */
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

/**
 * Controldaor asociado a la entidad 'pais'. 
 *
 * @author  Marco Antonio Santiago Garcia
 * @see     io.kebblar.petstore.api.rest.PaisController
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
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
