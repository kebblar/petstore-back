/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      Pais
 * Tipo:        clase 
 * AUTOR:       Diego González Sánchez
 * Fecha:       Martes 4 de Mayo de 2021 (09_40)
 * Version:     1.0-SNAPSHOT
 * .
 * Controlador asociado a la entidad 'pais'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
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
 * <p>Descripción:</p>
 * Controldaor asociado a la entidad 'pais'. 
 *
 * @author Diego G. Sánchez.
 * @version 1.0-SNAPSHOT
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
    /**
     * <p>getPaises():</p>
     * Lista de Paises. 
     *
     * @author Diego G. Sánchez.
     */
    
    @GetMapping(path = "/paises/{id}.json", produces = "application/json; charset=utf-8")
    public Pais getPais(
            @ApiParam(name = "id", value = "ID del Pais", defaultValue = "1")
            @PathVariable int id
            ) throws ControllerException {
        return this.paisService.getById(id);
    }
    /**
     * <p>Pais getPais:</p>
     * Metodo para obtene un pais. 
     *
     * @author Diego G. Sánchez.
     */
}
