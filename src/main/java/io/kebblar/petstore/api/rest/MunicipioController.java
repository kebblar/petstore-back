/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MunicipioController.java
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.service.ContadorService;
import io.kebblar.petstore.api.service.MunicipioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.kebblar.petstore.api.model.domain.TablasContador;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints 
 * de gestión del POJO Municipio.
 * 
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 * 
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no 
 * llevan  javadoc  debido a que la  documentación  Swagger  API 
 * cumple con ese objetivo.
 * 
 * @author  edgarum
 * @see     io.kebblar.petstore.api.model.domain.Municipio
 * @see     io.kebblar.petstore.api.service.MunicipioService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class MunicipioController {
    private MunicipioService municipioService;
    private ContadorService contadorService;
    
    /**
     * Constructor que realiza el setting de los servicios que serán 
     * utilizados en este controlador.
     * 
     * @param municipioService Servicios de municipio
     * @param contadoraService Servicios de contadora
     */
    public MunicipioController(MunicipioService municipioService, ContadorService contadorService) {
        this.municipioService = municipioService;
        this.contadorService = contadorService;
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
    public List<Municipio> getMunicipios(@ApiParam(name = "idEstado", value = "Entero que representa el id del estado", defaultValue = "estado")
    									@RequestParam int idEstado) throws ControllerException {
        return municipioService.getAllByEstado(idEstado);
    }
    
    @GetMapping(path = "/contador-municipios.json", produces = "application/json; charset=utf-8")
    public String getMunicipioCounter() throws ControllerException {
         int contador = contadorService.getMunicipioCounter();
         //int contador = contadorService.getTableCounter("municipio");
         String data = "{\"tabla\":\"municipio\", \"contadorx\": "+contador+"}";
         return data;
    }
    
    @GetMapping(path = "/contador/{tabla}.json", produces = "application/json; charset=utf-8")
    public String getMunicipioCounter2(
            @ApiParam(name = "tabla", value = "Cadena que representa el nombre de una tabla cualquiera", defaultValue = "pais")
            @PathVariable String tabla) throws ControllerException {
         //int contador = contadorService.getMunicipioCounter();
         int contador = contadorService.getTableCounter(tabla);
         String data = "{\"tabla\":\""+tabla+"\", \"contador\": "+contador+"}";
         return data;
    }
    
    @GetMapping(path = "/contador-enum.json", produces = "application/json; charset=utf-8")
    public String getMunicipioCounter3(
            @ApiParam(name = "contador", value = "Cadena que representa el nombre de una tabla cualquiera", defaultValue = "PAISES")
            @RequestParam TablasContador contador) throws ControllerException {
         return contadorService.getTableCounter2(contador);
    }
    
}
