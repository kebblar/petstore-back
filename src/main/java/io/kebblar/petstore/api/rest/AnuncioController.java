/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AnuncioController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:    .
 *              20210518_2028 Creación de  éste  controlador  REST
 *              20210520_2028 Se agrega el llamado a los servicios
 *              para el registro
 *              20210523_2020 Se  agrega  el  metodo  de  eliminado
 *              20210524_1142 Creacion de endpoint para Busqueda
 *              Producto
 *              20210523_2020 Se  agrega  el  metodo  de  eliminado
 *              logico
 *              20210523_2232 Se agrega  el rest del detalle del
 *              producto
 *              20210525_1532 Se agrega el llamado a los servicios
 *              para  el  registro  y  eliminado  de  imagenes  de
 *              anuncios
 *              20210524_1142 Creacion de endpoint para Busqueda
 *              Producto
 *              20210528_1142 Creacion de endpoint para Busqueda
 *              de usuario final
 */
package io.kebblar.petstore.api.rest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.ActualizaAnuncioRequest;
import io.kebblar.petstore.api.model.request.AnuncioImagenRequest;
import io.kebblar.petstore.api.model.request.AnuncioRequest;
import io.kebblar.petstore.api.model.request.BusquedaAdministracionRequest;
import io.kebblar.petstore.api.model.request.BusquedaRequest;
import io.kebblar.petstore.api.model.response.AnuncioImagenResponse;
import io.kebblar.petstore.api.model.response.AnuncioResponse;
import io.kebblar.petstore.api.model.response.BusquedaResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import io.kebblar.petstore.api.model.response.PaginacionAnunciosResponse;
import io.kebblar.petstore.api.service.AnuncioService;
import io.kebblar.petstore.api.utils.Convert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'anuncio'.
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}</p>
 *
 * <p>NOTA IMPORTANTE: Los distintos métodos de este controlador no llevan javadoc debido
 *                     a que la  documentación Swagger API cumple con ese objetivo.</p>
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

    @Autowired
    private Convert convert;

    private final AnuncioService anuncioService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param anuncioService Servicios de AnuncioService
     */
    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    @ApiOperation(
        value = "AnuncioController::Registro",
        notes = "Recibe un objeto <strong>AnuncioRequest</strong> que contiene la información para el registro de un anuncio.")
    @PostMapping(
        value = "/anuncios.json",
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.CREATED)
    public AnuncioResponse registro(
        @ApiParam(name="anuncio", value="Anuncio que será registrado en el sistema.")
        @RequestBody @Valid AnuncioRequest anuncio) throws BusinessException {
        return anuncioService.guardar(anuncio, new Anuncio());
    }

    @ApiOperation(
        value = "AnuncioController::Actualiza",
        notes = "Recibe un objeto <strong>ActualizaAnuncioRequest</strong> que contiene la información para actualizar un anuncio.")
    @PutMapping(
        value = "/anuncios.json",
            produces = "application/json; charset=utf-8")
    public AnuncioResponse actualizar(
        @ApiParam(name="anuncio", value="Anuncio que será actualizado en el sistema.")
        @RequestBody @Valid ActualizaAnuncioRequest anuncio) throws BusinessException {
        return anuncioService.guardar(anuncio, new Anuncio());
    }

    @ApiOperation(
        value = "AnuncioController::Confirmar",
        notes = "Recibe el identificador del anuncio que confirma el guardado del anuncio")
    @PutMapping(
        value = "/anuncios/confirmar/{id}.json",
            produces = "application/json; charset=utf-8")
    public AnuncioResponse confirmarAnuncio(
        @ApiParam(name="id", value="Identificador del anuncio.")
        @PathVariable int id) throws BusinessException {
        return anuncioService.confirmarAnuncio(id, new AnuncioResponse());
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
        return anuncioService.eliminarAnuncio(id, new AnuncioResponse());
    }

    @ApiOperation(
        value = "AnuncioController::Detalle",
        notes = "Recibe un identificador del anuncio del cual se consultara el detalle.")
    @GetMapping(
        value = "/anuncios/{id}.json",
        produces = "application/json; charset=utf-8")
    public DetalleAnuncioResponse anuncios(
        @ApiParam(name="id", value="Identificador del anuncio del cual se consultara el detalle.")
        @PathVariable int id ) throws BusinessException {
        return anuncioService.detalleAnuncio(id);
    }

    @ApiOperation(
    value = "AnuncioController::Registro",
    notes = "Recibe una imagen que sera asociada a un anuncio")
    @PostMapping(
        path = "/anuncios/imagen.json",
        produces = "application/json; charset=utf-8")
    public AnuncioImagenResponse guardarImagen(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile file) throws BusinessException {
        return anuncioService.guardarImagen(idAnuncio, file);
    }

    @ApiOperation(
    value = "AnuncioController::Registro",
    notes = "Recibe una imagen que sera asociada a un anuncio")
    @PostMapping(
        path = "/anuncios/imagen2.json",
        produces = "application/json; charset=utf-8")
    public AnuncioImagenResponse guardarImagen2(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile[] files) throws BusinessException {
        return anuncioService.guardarImagen(idAnuncio, files);
    }

    @ApiOperation(
        value = "AnuncioController::Eliminar",
        notes = "Elimina la imagen asociada a un anuncio con base al identificador de la imagen")
    @DeleteMapping(path = "/anuncios/imagen.json", produces = "application/json; charset=utf-8")
    public void eliminarImagen(
    @ApiParam(name = "uuid", value = "Identificador de la imagen de un anuncio a eliminar.")
    @RequestHeader("uuid") String uuid) throws BusinessException {
        anuncioService.eliminarImagen(uuid);
    }

    @ApiOperation(
        value = "AnuncioController::BusquedaAdministracion",
        notes = "Recibe un objeto <strong>BusquedaAdministracionRequest</strong> que contiene la información para realizar la busqueda de productos.")
    @PostMapping(
        value = "/anuncio/search.json",
            produces = "application/json; charset=utf-8")
    public PaginacionAnunciosResponse busquedaAdministracion(
    @ApiParam(name="filtros", value="Objeto que se usara para realizar la busqueda con paginacion")
    @RequestBody BusquedaAdministracionRequest filtros) throws BusinessException, SQLException{
        return anuncioService.busquedaAdministracion(filtros);
    }

    @ApiOperation(
        value = "AnuncioController::BusquedaUsuarioFinal",
        notes = "Recibe un objeto <strong>BusquedaRequest</strong> que contiene la información para realizar la busqueda de productos.")
    @PostMapping(
        value = "/anuncio/filter.json",
            produces = "application/json; charset=utf-8")
    public BusquedaResponse busquedaUsuarioFinal(
    @ApiParam(name="filtros", value="Objeto que se usara para realizar la busqueda con paginacion")
    @RequestBody @Valid BusquedaRequest filtros) throws BusinessException, SQLException{
        return anuncioService.busqueda(filtros);
    }

    @ApiOperation(
        value = "AnuncioController::Principal",
        notes = "Asigna como 'principal' a la imagen proporcionada")
    @PutMapping(
        path = "/anuncios/imagen/principal.json",
        produces = "application/json; charset=utf-8")
    public void confirmaImagenPrincipal(
    @ApiParam(name = "imagenRequest", value = "Informacion de la imagen de un anuncio a convertir en principal.")
    @RequestBody AnuncioImagenRequest imagenRequest) throws BusinessException {
        anuncioService.imagenPrincipal(imagenRequest);
    }

    @ApiOperation(
            value = "AnuncioController::getBySearchUrl",
            notes = "Regesa la lista de anuncios activos de entre todos los que coinciden con la busqueda dada")
    @GetMapping(
        value = "/content/{description}",
        produces = "application/json; charset=utf-8")
    public List<DetalleAnuncioResponse> getBySearchUrl(@PathVariable(required = true) String description) throws BusinessException {
        return anuncioService.getBySearchUrl(description); // lista NO nula con al menos 1 elemento
    }

    @ApiOperation(
            value = "AnuncioController::getDetalleAllAnuncio",
            notes = "Regesa la lista de TODOS los anuncios activos")
    @GetMapping(
        value = "/anuncios.json",
        produces = "application/json; charset=utf-8")
    public List<DetalleAnuncioResponse> getDetalleAllAnuncio() throws BusinessException {
        return anuncioService.detalleAllAnuncio();
    }

    @GetMapping(
        value = "/counter",
        produces = "application/json; charset=utf-8")
    public Map<String, Integer> getCounter(){
        Map<String, Integer> result = new HashMap<>();
        result.put("ok", convert.getContador());
        return result;
    }

}
