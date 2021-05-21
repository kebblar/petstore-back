/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   EstadoController.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (22_29)
 *
 * Historia:    .
 *              20210518_0203 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints 
 * de gestión del POJO {@link Estado}.
 * 
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 * 
 * <p>NOTA IMPORTANTE: Los  distintos métodos de este controlador no 
 * llevan  javadoc  debido a que la  documentación  Swagger  API 
 * cumple con ese objetivo.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Estado
 * @see     io.kebblar.petstore.api.service.EstadoService
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

import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.EstadoService;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api")
public class EstadoController {
    private static final String res = "{'result':'ok'}".replace('\'', '\"');
    private EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping(path = "/estados.json", produces = "application/json; charset=utf-8")
    public List<Estado> getEstados() throws ControllerException {
        return estadoService.getAll();
    }
    

    @GetMapping(path = "/estados/{id}.json", produces = "application/json; charset=utf-8")
    public Estado getEstado(
            @ApiParam(name = "id", value = "ID del Estado", defaultValue = "1")
            @PathVariable int id
            ) throws ControllerException {
        return this.estadoService.getById(new Estado(id)); 
    }
    
    @PostMapping(path = "/estados.json", produces = "application/json; charset=utf-8")
    public String crearEstado(
        @ApiParam(name = "Estado", value = "Crea un Estado empleando todos sus atributos", defaultValue = "1")
    	@Valid @RequestBody Estado dato) throws ControllerException {
		estadoService.insert(dato);
        return res;
    }
    
    @PutMapping(path = "/estados.json", produces = "application/json; charset=utf-8")
    public int updateEstado(
            @ApiParam(name = "Estado", value = "Actualiza un Estado empleando todos los atributos provistos")
            @RequestBody Estado Estado
            ) throws ControllerException {
    	System.out.println(Estado.toString());
         return this.estadoService.update(Estado);
    }
    
    @GetMapping(path = "/estados/list/{nombre}.json", produces = "application/json; charset=utf-8")
    public List<Estado> getEstado(
            @ApiParam(name = "nombre", value = "Nombre del Estado", defaultValue = "Mexico")
            @PathVariable String nombre) throws ControllerException {
    	System.out.println(nombre);
        return this.estadoService.getByNombre(nombre);
    }

    @DeleteMapping(path = "/estados/delete/{id}.json", produces = "application/json; charset=utf-8")
    public int deleteEstado(
            @ApiParam(name = "id", value = "Id del Estado", defaultValue = "1")
            @PathVariable int id) throws ControllerException {
    	System.out.println(id);
        return this.estadoService.delete(new Estado(id));
    }

    @GetMapping(path = "/estados/pais/{id}.json", produces = "application/json; charset=utf-8")
    public List<Estado> getEstadosbyPais(
            @ApiParam(name = "id", value = "ID del Estado", defaultValue = "1")
            @PathVariable int id
            ) throws ControllerException {
        return this.estadoService.getEstadosByPais(id); 
    }
    

}
