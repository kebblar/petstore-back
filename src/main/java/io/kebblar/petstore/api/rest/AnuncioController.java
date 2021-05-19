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
 *
 */
package io.kebblar.petstore.api.rest;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
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

	@ApiOperation(value = "AnuncioController::registro",
	        notes = "Recibe un objeto <strong>AnuncioRequest</strong> que contiene la información para el "
	        		+ "registro de un anuncio.")
	@PostMapping(value = "/registro.json",
            produces = "application/json; charset=utf-8")
    public AnuncioResponse registro(
    		@ApiParam(name="anuncio", value="Anuncio que será insertado en el sistema.")
    		@RequestBody @Valid AnuncioRequest anuncio) throws BusinessException {
		System.out.println(anuncio);
		return new AnuncioResponse(1,"18052122090001");
    }
	
	@ApiOperation(value = "AnuncioController::publicar",
	        notes = "Recibe el identificador del anuncio que sera publicado.")
	@PutMapping(value = "/publicar/{id}.json",
            produces = "application/json; charset=utf-8")
    public void publicar(
    		@ApiParam(name="id", value="Identificador del anuncio.")
    		@PathVariable int id) throws BusinessException {
		System.out.println(id);
    }

	
	
}
