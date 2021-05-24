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
 *              20210523_2025 Se  agrega  el  metodo  de  elimado 
 *              logico
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
     * @param {@link AnuncioRequest}  Clase que contiene la informacion del {@link Anuncio} que se dara de alta
     * @return Objeto {@link AnuncioResponse} retornara el id y sku del objeto 'anuncio' registrado o actualizado
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
	 * @param id Identificador del anuncio que confirma su registro
	 * @return Objeto {@link AnuncioResponse} retornara el id y sku del objeto 'anuncio' que confirma su registro
	 * @throws BusinessException
	 */
	AnuncioResponse confirmarAnuncio(int id) throws BusinessException;
	
	/**
	 * Metodo que permite eliminar logicamente un producto con base al identificador proporcionado
	 * <p>El servicio validara que el producto no haya sido eliminado previamente y que exista</p>
	 * @param id Identificador del anuncio que será removido del sistema.
	 * @return {@link AnuncioResponse} clase que contiene id y sku del producto eliminado
	 * @throws BusinessException
	 */
	AnuncioResponse eliminarAnuncio(int id) throws BusinessException;
	
}
