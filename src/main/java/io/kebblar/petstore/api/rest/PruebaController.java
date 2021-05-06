/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UsuarioController.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (22_29)
 *
 * Historia:    .
 *              20210503_2229 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.domain.*;
import io.kebblar.petstore.api.service.*;
import io.swagger.annotations.ApiParam;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints 
 * de gestión del POJO Direccion.
 * 
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 * 
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no 
 * llevan  javadoc  debido a que la  documentación  Swagger  API 
 * cumple con ese objetivo.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Direccion
 * @see     io.kebblar.petstore.api.service.DireccionService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class PruebaController {
    private static final String res = "{'result':'ok'}".replace('\'', '\"');

    /**
     * Constructor que realiza el setting de los servicios que serán 
     * utilizados en este controlador.
     * 
     * @param servicio Servicios de Direccion
     */
    @Autowired
    private DireccionService servicio;
    
    @GetMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba1() throws ControllerException {
    	
        List<Direccion> data = servicio.getAll();
        System.out.println(data);
        return res;
    }

    @PostMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba1(
    		@ApiParam(name = "dato", value = "Crea una Direccion")
    		@Valid 
    		@RequestBody Direccion dato) throws ControllerException {
        servicio.insert(dato);
        return res;
    }
    
    @PutMapping(path = "/direcciones.json", produces = "application/json; charset=utf-8")
    public String pba2(
    		@ApiParam(name = "dato", value = "Actualiza una Direccion")
    		@Valid 
    		@RequestBody Direccion dato) throws ControllerException {
        servicio.update(dato);
        return res;
    }

}
