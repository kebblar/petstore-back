/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioService.java
 * Tipo:        Interface
 * AUTOR:       Maria Isabel Contreras Garcia (MICG)
 * Fecha:       Jueves 20 de Mayo de 2021 (23_39)
 *
 * Historia:    .
 *              20210510_2339 Creación de ésta interfaz
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
import io.kebblar.petstore.api.utils.AnuncioEstatusEnum;

/**
 * <p>Definición de la interfaz de servicios para 'Anuncio'.
 * 
 * @author  micontreras
 * @see     io.kebblar.petstore.api.model.domain.Anuncio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface AnuncioService {

	/**
     * Metodo que permite realizar el registro de un producto.
     * <p>Se guardan los datos generales y atributos del producto,
     * en este punto el anuncio tendrá un estatus de 1= En edicion {@link AnuncioEstatusEnum}</p>
     * @param request Clase que contiene la informacion del {@link Anuncio} que se dara de alta
     * @return Objeto que puede ser del tipo {@link ActualizaAnuncioRequest} o {@link AnuncioRequest} 
     * @throws BusinessException
     */
	AnuncioResponse guardar(AnuncioRequest request) throws BusinessException;
	
	/**
	 * Metodo que permite confirmar el registro de un producto {@link AnuncioEstatusEnum}
	 * con base al identificador proporcionado, cumpliendo las siguientes reglas para su publicación:
	 * <p>1. El anuncio debe estar en estatus En edicion o activo</p>
	 * <p>2. Si no se proporcionan fechas, el anuncio pasa directamente a estatus PUBLICADO</p>
	 * <p>2. Si solo se proporciona la fecha final y es igual o posterior al día de hoy,
	 *  el anuncio pasa directamente a estatus PUBLICADO</p>
	 * <p>3. Si solo se proporciona la fecha inicial y es igual al día de hoy,
	 *  el anuncio pasa directamente a estatus PUBLICADO</p>
	 * <p>4. Si solo se proporciona la fecha inicial y es posterior al día de hoy,
	 *  el anuncio pasa a estatus ACTIVO</p>
	 * @param id
	 * @throws BusinessException
	 */
	AnuncioResponse confirmarAnuncio(int id) throws BusinessException;
	
}
