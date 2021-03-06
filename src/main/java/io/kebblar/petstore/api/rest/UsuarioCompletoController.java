/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion 
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 * 
 * Artefacto:   UsuarioCompletoController .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Sunday 06 de June de 2021 (09_35)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210627_0935 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.UsuarioCompleto;
import io.kebblar.petstore.api.service.UsuarioCompletoService;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'usuario_completo'. 
 *
 * <p>Todos los métodos de esta clase disparan {@link BusinessException}
 * 
 * <p>NOTA IMPORTANTE: Los distntos métodos de este controlador no llevan javadoc debido 
 *                     a que la  documentación Swagger API cumple con ese objetivo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.UsuarioCompleto
 * @see io.kebblar.petstore.api.service.UsuarioCompletoService
 */
@RestController
@Api(value = "administracion")
@RequestMapping(value = "/api")
public class UsuarioCompletoController {

    private UsuarioCompletoService usuarioCompletoService;

    /**
     * Constructor que realiza el setting de los servicios que serán 
     * utilizados en este controlador.
     * 
     * @param usuarioCompletoService Servicios de usuario
     */
    public UsuarioCompletoController(UsuarioCompletoService usuarioCompletoService) {
        this.usuarioCompletoService = usuarioCompletoService;
    }

    @ApiOperation(
        value = "UsuarioCompletoController::getAll",
        notes = "Regresa una lista de todos los objetos UsuarioCompleto "
            + "debidamente paginados con base en el payload de "
            + "request que determina el tamaño de la página, la "
            + "longitud de la página, el campo por el que se va a "
            + "ordenar y si el orden es ascendente o descendente."
            + "<br/><br/>"
            + "En el caso de que los parámetros proporcionados "
            + "<b><i><label style='color:blue;'>excedan</label><i></b> las "
            + "dimensiones de la lista real de datos, este método es "
            + "capaz de ajustar lo necesario para que la lista resultante "
            + "sea suceptible de ser manipulada adecuadamente.")
    @GetMapping(
        value = "/usuario-completos.json",
        produces = "application/json; charset=utf-8")
    public List<UsuarioCompleto> getAllUsuarioCompleto() throws BusinessException {
        return usuarioCompletoService.getAll();
    }

    @ApiOperation(
        value = "UsuarioCompletoController::get",
        notes = "Regresa un objeto UsuarioCompleto cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/usuario-completo/{id}.json",
        produces = "application/json; charset=utf-8")
    public UsuarioCompleto getUsuarioCompleto(
    @ApiParam(name="id", value="Representa el id del usuarioCompleto buscado.")
    @PathVariable int id
    ) throws BusinessException {
        return this.usuarioCompletoService.getById(id);
    }

    @ApiOperation(
        value = "UsuarioCompletoController::update",
        notes = "Recibe un objeto UsuarioCompleto, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/usuario-completo.json",
            produces = "application/json; charset=utf-8")
    public int update(
    @ApiParam(name="usuarioCompleto", value="UsuarioCompleto que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
    @RequestBody UsuarioCompleto usuarioCompleto
    ) throws BusinessException {
        return usuarioCompletoService.update(usuarioCompleto);
    }

    @GetMapping(
            value = "/usuario-completos-paginated.json",
            produces = "application/json; charset=utf-8")
        public List<UsuarioCompleto> getAllUsuarioCompletoPaginado(int pageNumber, int pageSize) throws BusinessException {
            return usuarioCompletoService.getAllPaginated(pageNumber, pageSize);
        }
}
