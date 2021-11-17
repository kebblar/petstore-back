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
 * Nombre:      UsuarioCompletoController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:27:25
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
import io.kebblar.petstore.api.model.exceptions.ControllerException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * Implementacion  del REST Controller asociado a los endpoints de  gestión del POJO 'usuario_completo'.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
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

    private final UsuarioCompletoService usuarioCompletoService;

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
        value = "/usuario-completos",
        produces = "application/json; charset=utf-8")
    public List<UsuarioCompleto> getAllUsuarioCompleto() throws ControllerException {
        return usuarioCompletoService.getAll();
    }

    @ApiOperation(
        value = "UsuarioCompletoController::get",
        notes = "Regresa un objeto UsuarioCompleto cuyo id "
            + "coincide con el entero recibido como parametro.")
    @GetMapping(
        value = "/usuario-completo/{id}",
        produces = "application/json; charset=utf-8")
    public UsuarioCompleto getUsuarioCompleto(
        @ApiParam(name="id", value="Representa el id del usuarioCompleto buscado.")
        @PathVariable int id
    ) throws ControllerException {
        return this.usuarioCompletoService.getById(id);
    }

    @ApiOperation(
        value = "UsuarioCompletoController::update",
        notes = "Recibe un objeto UsuarioCompleto, este objeto es buscado por "
            + "id dentro de la base de datos y es actualizado con el resto de "
            + "datos proporcionados si es que el id en efecto existe. ")
    @PutMapping(
            value = "/usuario-completo",
            produces = "application/json; charset=utf-8")
    public int update(
        @ApiParam(name="usuarioCompleto", value="UsuarioCompleto que será actualizado en el sistema, el id debe coincidir con el id del objeto que se desea actualizar.")
        @RequestBody UsuarioCompleto usuarioCompleto
    ) throws ControllerException {
        return usuarioCompletoService.update(usuarioCompleto);
    }

    @GetMapping(
            value = "/usuario-completos-paginated",
            produces = "application/json; charset=utf-8")
    public List<UsuarioCompleto> getAllUsuarioCompletoPaginado(int pageNumber, int pageSize) throws ControllerException {
        return usuarioCompletoService.getAllPaginated(pageNumber, pageSize);
    }
}
