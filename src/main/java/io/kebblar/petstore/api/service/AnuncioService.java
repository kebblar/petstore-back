/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      AnuncioService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              20210510_2339 Creación de ésta interfaz
 *              20210523_2025 Se  agrega  el  metodo  de  elimado
 *              logico
 *              20210525_1806 Se  agrega  el  metodo  de consulta
 *              detalle de un anuncio
 *              20210528_1157 Se agrega el metodo BusquedaAdministracion
 * */
package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.AnuncioImagenRequest;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.BusquedaAdministracionRequest;
import io.kebblar.petstore.api.model.request.BusquedaRequest;
import io.kebblar.petstore.api.model.response.AnuncioImagenResponse;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
import io.kebblar.petstore.api.model.response.BusquedaResponse;
import io.kebblar.petstore.api.model.response.PaginacionAnunciosResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import io.kebblar.petstore.api.utils.AnuncioEstatusEnum;

/**
 * Definición de la interfaz de servicios para 'Anuncio'.
 *
 * @author  micontreras
 * @see     io.kebblar.petstore.api.model.domain.Anuncio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface AnuncioService {

    /**
     * Método que permite realizar el registro de un producto.
     *
     * <p>Se guardan los datos generales y atributos del producto, valida que la información sea correcta
     * y dado el caso, actualiza o crean un nuevo anuncio.
     * en este punto el anuncio tendrá un estatus de 1= En edición {@link AnuncioEstatusEnum}</p>
     *
     * @param request {@link AnuncioRequest} Clase que contiene la información del {@link Anuncio} que se dara de alta
     * @param anuncio //TODO
     * @return {@link AnuncioResponse} retornará el id y sku del objeto 'anuncio' registrado o actualizado
     * @throws BusinessException cuando ocurre un problema en el guardado.
     */
    AnuncioResponse guardar(AnuncioRequest request, Anuncio anuncio) throws BusinessException;

    /**
     * Método que permite confirmar el registro de un producto {@link AnuncioEstatusEnum}
     * con base al identificador proporcionado, cumpliendo las siguientes reglas para su publicación:
     *
     * <p>1. El anuncio debe estar en estatus En edición o activo</p>
     * <p>2. Si no se proporcionan fechas, el anuncio pasa directamente a estatus PUBLICADO</p>
     * <p>2. Si solo se proporciona la fecha final y es igual o posterior al día de hoy,
     *  el anuncio pasa directamente a estatus PUBLICADO</p>
     * <p>3. Si solo se proporciona la fecha inicial y es igual al día de hoy,
     *  el anuncio pasa directamente a estatus PUBLICADO</p>
     * <p>4. Si solo se proporciona la fecha inicial y es posterior al día de hoy,
     *  el anuncio pasa a estatus ACTIVO</p>
     *
     * @param id Identificador del anuncio que confirma su registro
     * @param response TODO
     * @return Objeto {@link AnuncioResponse} retornará el id y sku del objeto 'anuncio' que confirma su registro
     * @throws BusinessException Excepcion lanzada en caso de error
     */
    AnuncioResponse confirmarAnuncio(int id, AnuncioResponse response) throws BusinessException;

    /**
     * Método que permite eliminar logicamente un producto con base al identificador proporcionado
     * <p>El servicio validará que el producto no haya sido eliminado previamente y que exista</p>
     *
     * @param id Identificador del anuncio que será removido del sistema.
     * @return {@link AnuncioResponse} clase que contiene id y sku del producto eliminado
     * @throws BusinessException Excepcion lanzada en caso de error
     */
    AnuncioResponse eliminarAnuncio(int id) throws BusinessException;

    /**
     * Método que permite obtener el detalle de un anuncio con base al identificador.
     *
     * @param id Identificador del anuncio del cual se regresará el detalle
     * @return {@link DetalleAnuncioResponse} Clase que contiene el detalle de un anuncio
     * @throws BusinessException Excepcion lanzada en caso de error
     */
    DetalleAnuncioResponse detalleAnuncio(int id) throws BusinessException;


    /**
     * Método que permite el guardado de las imagenes de un anuncio.
     *
     * @param idAnuncio Identificador del anuncio con el cual se va a asociar la imagen
     * @param file Imagen a guardar
     * @return {@link AnuncioImagenResponse} Clase que contiene la información de la imagen guardada
     * @throws BusinessException Excepcion lanzada en caso de error
     */
    AnuncioImagenResponse guardarImagen(int idAnuncio, MultipartFile file) throws BusinessException;

    AnuncioImagenResponse guardarImagen(int idAnuncio, MultipartFile[] files) throws BusinessException;

    /**
     * Método que permite el eliminado de las imagenes de un anuncio.
     *
     * @param uuid Identificador de la imagen que sera eliminada
     * @throws BusinessException Excepcion lanzada en caso de error
     */
    void eliminarImagen(String uuid) throws BusinessException;

    /**
     * Método que permite la búsqueda de productos para búsqueda de administracion (ABC).
     *
     * @param filtros {@link BusquedaAdministracionRequest} Clase que contiene los filtros necesarios para poder realizar las consultas
     * @return {@link PaginacionAnunciosResponse}
     * @throws BusinessException, SQLException
     */
    PaginacionAnunciosResponse busquedaAdministracion(BusquedaAdministracionRequest filtros) throws BusinessException, SQLException;

    /**
     * Método que permite la búsqueda de productos para búsqueda de usuario final.
     *
     * @param filtros {@link BusquedaRequest} Clase que contiene los filtros necesarios para poder realizar las consultas
     * @return {@link BusquedaResponse}
     * @throws BusinessException, SQLException
     */
    BusquedaResponse busqueda(BusquedaRequest filtros) throws BusinessException, SQLException;

    /**
     * Método que permite asignar como principal la imagen del anuncio proporcionado.
     *
     * <p>El servicio validará que la imagen no haya sido eliminado previamente y que exista.</p>
     * @param imagenRequest {@link AnuncioImagenRequest} Clase que conetiene la informacion de la imagen que será principal
     * @throws BusinessException Excepcion lanzada en caso de error
     */
    void imagenPrincipal(AnuncioImagenRequest imagenRequest) throws BusinessException;

    /**
     * Método que permite publicar o finalizar un anuncio y
     * que permite pasar a vencido los anuncios cuya fecha de vencimiento ha sido alcanzada
     * @throws BusinessException Excepcion lanzada en caso de error
     */
    void schedulerPublicarAnuncio() throws BusinessException;

    /**
     * Dada la url única de un anuncio activo, este es buscado en el sistema y retornado dentro de una lista,
     * en caso que se ingrese la palabra "all" como parámetro, todos los anuncios activos o publicados son
     * retornados como una lista de objetos anuncio.
     *
     * @param searchUrl cadena que representa el fragmento de la url a buscar.
     * @return lista de objetos anuncio que concuerdan con la url.
     * @throws BusinessException En caso que la url no retorne resultados.
     */
    List<DetalleAnuncioResponse> getBySearchUrl(String searchUrl) throws BusinessException;

    /**
     * Auxiliar que actualiza los url's de búsqueda de los anuncios
     */
    void updateSearchUrl();

    /**
     * Regresa un anuncio con todos sus detalles
     *
     * @return lista de objetos de tipo 'DetalleAnuncioResponse'
     * @throws BusinessException
     */
    List<DetalleAnuncioResponse> detalleAllAnuncio() throws BusinessException;
}
