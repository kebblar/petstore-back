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
 * Nombre:      UsuarioController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:27:35
 */
package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.request.ConsultaRequest;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.response.ConsultaResponse;
import io.kebblar.petstore.api.service.ConsultaService;
import io.kebblar.petstore.api.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.ControllerException;

/**
 * Implementación  del controlador REST asociado a los endpoints
 * de gestión del POJO Usuario.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 *
 * <p>NOTA IMPORTANTE: Los  distintos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @see     io.kebblar.petstore.api.model.request.CredencialesRequest
 * @see     io.kebblar.petstore.api.service.UsuarioService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
    @Value("${jwt.encryptor.password}")
    private String encryptKey;

    private final UsuarioService usuarioService;
    private ConsultaService consultaService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param usuarioService Servicios de usuario
     */
    public UsuarioController(UsuarioService usuarioService,
            ConsultaService consultaService) {
        this.usuarioService = usuarioService;
        this.consultaService = consultaService;
    }

    @GetMapping(
            path = "/usuarios/{id}.json",
            produces = "application/json; charset=utf-8")
    public Usuario getUser(
            @ApiParam(
                    name = "id",
                    value = "ID del Usuario",
                    defaultValue = "1")
            @PathVariable int id
            ) throws ControllerException {
        return this.usuarioService.obtenUsuarioPorId(id);
    }

    @GetMapping(
            path = "/usuarios.json",
            produces = "application/json; charset=utf-8")
    public List<Usuario> getAllUsers() throws ControllerException {
        return this.usuarioService.obtenTodosUsuarios();
    }

    @PostMapping(
            path = "/usuarios-thin.json",
            produces = "application/json; charset=utf-8")
    public Usuario createUserThin(
            @ApiParam(
                    name = "credenciales",
                    value = "Crea un Usuario empleando sólo sus credenciales")
            @RequestBody CredencialesRequest credenciales
            ) throws ControllerException {
        return this.usuarioService.creaUsuario(credenciales);
    }

    @PostMapping(
            path = "/usuarios.json",
            produces = "application/json; charset=utf-8")
    public Usuario createUser(
            @ApiParam(
                    name = "usuario",
                    value = "Crea un Usuario empleando todos sus atributos")
            @RequestBody Usuario usuario
            ) throws ControllerException {
        return this.usuarioService.creaUsuario(usuario);
    }

    @PutMapping(
            path = "/usuarios.json",
            produces = "application/json; charset=utf-8")
    public Usuario updateUsuario(
            @ApiParam(
                    name = "usuario",
                    value = "Actualiza un Usuario empleando todos los atributos provistos")
            @RequestBody Usuario usuario
            ) throws ControllerException {
         return this.usuarioService.actualizaUsuario(usuario);
    }

    @DeleteMapping(
            path = "/usuarios.json",
            produces = "application/json; charset=utf-8")
    public Usuario borraUsuario(
            @ApiParam(
                    name = "id",
                    value = "Borra un Usuario cuyo ID es dado")
            @RequestParam int id) throws ControllerException {
         return this.usuarioService.eliminaUsuario(id);
    }

    @PutMapping(
            path = "/cambia-clave.json",
            produces = "application/json; charset=utf-8")
    public Usuario cambiaClave(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "credenciales",
                    value = "Correo y clave nueva del usuario al que se piensa cambiar la clave")
            @RequestBody CredencialesRequest credenciales
            ) throws ControllerException {
         return this.usuarioService.cambiaClave(
                 credenciales.getUsuario(),
                 credenciales.getClave());
    }

    @PutMapping(
            path = "/usuario-detalles.json",
            produces = "application/json; charset=utf-8")
    public UsuarioDetalle updateUsuarioDetalles(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "usuarioDetalle",
                    value = "Actualiza un UsuarioDetalle empleando todos los atributos provistos")
            @RequestBody UsuarioDetalle usuarioDetalle
            ) throws ControllerException {
         return this.usuarioService.actualizaUsuarioDetalle(usuarioDetalle);
    }

    @ApiOperation(
            value = "AccessController::consulta",
            notes = "Se utiliza para recuperar el precio actual de BTC en dólares.")
    @GetMapping(
            path = "/consulta.json",
            produces = "application/json; charset=utf-8")
    public List<ConsultaResponse> consulta(@RequestHeader("jwt") String jwt) {
        return consultaService.consulta(jwt, encryptKey);
    }

    @ApiOperation(
            value = "AccessController::guarda",
            notes = "Se utiliza para recuperar el precio actual de BTC en dólares.")
    @PostMapping(
            path = "/guarda.json",
            produces = "application/json; charset=utf-8")
    public List<ConsultaRequest> guarda(@RequestHeader("jwt") String jwt, @RequestBody List<ConsultaRequest> datos) {
        return consultaService.guarda(jwt, encryptKey, datos);
    }
}
