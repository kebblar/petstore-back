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
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (22_29)
 *
 * Historia:    .
 *              20210503_2229 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints 
 * de gestión del POJO {@link Pais}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 * 
 * <p>NOTA IMPORTANTE: Los  distintos métodos de este controlador no 
 * llevan  javadoc  debido a que la  documentación  Swagger  API 
 * cumple con ese objetivo.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Pais
 * @see     io.kebblar.petstore.api.service.PaisService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Mascota;
import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.PaisService;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api")
public class PaisController {
    private static final String res = "{'result':'ok'}".replace('\'', '\"');
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
    
    @PostMapping(path = "/paises.json", produces = "application/json; charset=utf-8")
    public String crearPais(
        @ApiParam(name = "pais", value = "Crea un Pais empleando todos sus atributos", defaultValue = "1")
    	@Valid @RequestBody Pais dato) throws ControllerException {
		paisService.insert(dato);
        return res;
    }
    
    @PutMapping(path = "/paises.json", produces = "application/json; charset=utf-8")
    public int updatePais(
            @ApiParam(name = "pais", value = "Actualiza un Pais empleando todos los atributos provistos")
            @RequestBody Pais pais
            ) throws ControllerException {
         return this.paisService.update(pais);
    }
    
    @GetMapping(path = "/paises/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<Pais> getPais(
            @ApiParam(name = "nombre", value = "Nombre del Pais", defaultValue = "Mexico")
            @PathVariable String nombre) throws ControllerException {
        return this.paisService.getByNombre(nombre);
    }

    @DeleteMapping(path = "/paises/delete/{id}.json", produces = "application/json; charset=utf-8")
    public int deletePais(
            @ApiParam(name = "id", value = "Id del Pais", defaultValue = "1")
            @PathVariable int id) throws ControllerException {
        return this.paisService.delete(new Pais(id));
    }
    
}