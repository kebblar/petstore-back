/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioController.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_08)
 *
 * Historia:    .
 *              20210518_2028 Creación de éste controlador REST
 *              20210520_2028 Se agrega el llamado a los servicios 
 *              para el registro
<<<<<<< HEAD
 *              20210524_1142 Creacion de endpoint para Busqueda 
 *              Producto
=======
 *              20210523_2020 Se  agrega  el  metodo  de  elimado 
 *              logico
>>>>>>> refs/remotes/origin/feature/eliminar-producto
 *
 */
package io.kebblar.petstore.api.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.BusquedaAdministracionRequest;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
import io.kebblar.petstore.api.model.response.BusquedaAdministracionResponse;
import io.kebblar.petstore.api.service.AnuncioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Descripción:</p>
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'anuncio'. 
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 * 
 * <p>NOTA IMPORTANTE: Los distintos métodos de este controlador no llevan javadoc debido 
 *                     a que la  documentación Swagger API cumple con ese objetivo.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Anuncio
 * @see AnuncioService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class AnuncioController {

	 private AnuncioService anuncioService;
	 
	 /**
     * Constructor que realiza el setting de los servicios que serán 
     * utilizados en este controlador.
     * 
     * @param anuncioService Servicios de AnuncioService
     */
    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }
	    
	@ApiOperation(value = "AnuncioController::Registro",
	        notes = "Recibe un objeto <strong>AnuncioRequest</strong> que contiene la información para el "
	        		+ "registro de un anuncio.")
	@PostMapping(value = "/anuncios.json",
            produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.CREATED)
    public AnuncioResponse registro(
    		@ApiParam(name="anuncio", value="Anuncio que será registrado en el sistema.")
    		@RequestBody @Valid AnuncioRequest anuncio) throws BusinessException {
		return anuncioService.guardar(anuncio);
    }
	
	@ApiOperation(value = "AnuncioController::Confirmar",
	        notes = "Recibe el identificador del anuncio que confirma el guardado del anuncio")
	@PutMapping(value = "/anuncios/confirmar/{id}.json",
            produces = "application/json; charset=utf-8")
    public AnuncioResponse confirmarAnuncio(
    		@ApiParam(name="id", value="Identificador del anuncio.")
    		@PathVariable int id) throws BusinessException {
		return anuncioService.confirmarAnuncio(id);
    }
	
	@ApiOperation(value = "AnuncioController::Actualiza",
	        notes = "Recibe un objeto <strong>ActualizaAnuncioRequest</strong> que contiene la información para "
	        		+ "actualizar un anuncio.")
	@PutMapping(value = "/anuncio.json",
            produces = "application/json; charset=utf-8")
    public AnuncioResponse actualizar(
    		@ApiParam(name="anuncio", value="Anuncio que será actualizado en el sistema.")
    		@RequestBody @Valid ActualizaAnuncioRequest anuncio) throws BusinessException {
		return anuncioService.guardar(anuncio);
    }

	@ApiOperation(
        value = "AnuncioController::eliminar",
        notes = "Recibe un identificador del anuncio a eliminar en el sistema.")
    @DeleteMapping(
            value = "/anuncios.json",
            produces = "application/json; charset=utf-8")
    public AnuncioResponse eliminar(
    		@ApiParam(name="id", value="Identificador del anuncio que será removido del sistema.")
    		@RequestParam int id ) throws BusinessException {
		return anuncioService.eliminarAnuncio(id);
    }

	@ApiOperation(value = "AnuncioController::BusquedaAdministracion",
	        notes = "Recibe un objeto <strong>BusquedaAdministracionRequest</strong> que contiene la información para "
	        		+ "realizar la busqueda de productos.")
	@PostMapping(value = "/busquedaAdministracion.json",
            produces = "application/json; charset=utf-8")
	public List<BusquedaAdministracionResponse> busquedaAdministracion( 
					@ApiParam(name="busqueda", value="Objeto que se usara para realizar la busqueda")
					@RequestBody BusquedaAdministracionRequest busqueda){
		
		List<BusquedaAdministracionResponse> response = new ArrayList<BusquedaAdministracionResponse>();
		BusquedaAdministracionResponse mock = new BusquedaAdministracionResponse(123, "French Poddle", LocalDate.now(), LocalDate.now(), "Activo", 1, "Pelo chino");
		BusquedaAdministracionResponse mockito = new BusquedaAdministracionResponse(123, "Cocker", LocalDate.now(), LocalDate.now(), "Activo", 1, "Oreja Grandes");
		response.add(mock);
		response.add(mockito);
		return response;
	}
}
