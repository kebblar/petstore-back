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
 *              20210503_2229 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.EstadoService;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints 
 * de gestión del POJO Estado.
 * 
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 * 
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no 
 * llevan  javadoc  debido a que la  documentación  Swagger  API 
 * cumple con ese objetivo.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Estado
 * @see     io.kebblar.petstore.api.service.EstadoService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class EstadoController {
    private EstadoService estadoService;

    /**
     * Constructor que realiza el setting de los servicios que serán 
     * utilizados en este controlador.
     * 
     * @param estadoService Servicios de estado
     */
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    /**
     * Método que regresa todos los estados 
     * @return lista de todos los estados {@link Estado}
     * @throws ControllerException
     */
    @GetMapping(path = "/estados.json", produces = "application/json; charset=utf-8")
    public List<Estado> getEstados() throws ControllerException {
        return estadoService.getAll();
    }

}