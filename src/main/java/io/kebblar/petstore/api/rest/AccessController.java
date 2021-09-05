/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AccessController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:22:06
 */
package io.kebblar.petstore.api.rest;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.request.GoogleCaptcha;
import io.kebblar.petstore.api.model.request.Preregistro;
import io.kebblar.petstore.api.model.request.PreregistroRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.service.AccessService;
import io.kebblar.petstore.api.service.UsuarioService;
import io.kebblar.petstore.api.support.InvokeRestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Implementacion  del controlador REST asociado a los endpoints
 * de gestión del AccessController.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}
 *
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.UsuarioDetalle
 * @see     io.kebblar.petstore.api.model.request.CredencialesRequest
 * @see     io.kebblar.petstore.api.service.AccessService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class AccessController {
    private AccessService accessService;
    private UsuarioService usuarioService;
    private InvokeRestService invokeRestService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param accessService Servicios de AccessService
     */
    public AccessController(
            AccessService accessService,
            UsuarioService usuarioService,
            InvokeRestService invokeRestService) {
        this.accessService = accessService;
        this.usuarioService = usuarioService;
        this.invokeRestService = invokeRestService;
    }

    @PostMapping(
            path = "/login.json",
            produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws ControllerException {
        return accessService.login(cred.getUsuario(), cred.getClave());
    }

    @PostMapping(
            path = "/usuario-preregistro.json",
            produces = "application/json; charset=utf-8")
    public Preregistro preRegistro(
            @ApiParam(name = "dato", value = "Información con el detalle de un Usuario")
            @RequestBody Preregistro preRegistroRequest) throws ControllerException {
        return this.usuarioService.preRegistro(preRegistroRequest);
    }

    @PostMapping(
            path = "/usuario-preregistro2.json",
            produces = "application/json; charset=utf-8")
    public Preregistro preRegistro2(
            @ApiParam(name = "preRegistroRequest", value = "Información con el detalle de un Usuario")
            @RequestBody @Valid PreregistroRequest preRegistroRequest) throws ControllerException {
        return this.usuarioService.preRegistro2(preRegistroRequest);
    }

    @ApiOperation(
            value = "RegistroController::verificarCaptcha",
            notes = "Verifica que el Google captcha V 2.0 sea correcto")
    @PostMapping(
            value = "/check-captcha.json",
            produces = "application/json; charset=utf-8")
    public String checkCaptcha(
            @ApiParam(name = "googleCaptcha", value = "Google Captcha V2.0")
            @RequestBody GoogleCaptcha googleCaptcha) throws ControllerException {
        return invokeRestService.checkCaptcha(googleCaptcha);
    }

    @GetMapping(
            path = "/confirma-preregistro.json",
            produces = "application/json; charset=utf-8")
    public Usuario confirmaPreregistro(
            @ApiParam(name = "token", value = "Token de confirmación del registro enviado por correo")
            @RequestParam String token) throws ControllerException {
        return usuarioService.confirmaPreregistro(token);
    }

    @GetMapping(
            path = "/regenera-clave.json",
            produces = "application/json; charset=utf-8")
    public Usuario regeneraClave(
            @ApiParam(name = "correo", value = "Correo al que pertenece la clave a regenerar")
            @RequestParam String correo) throws ControllerException {
        // pase lo que pase esté endpoint siempre regresa algo "bueno", para no alentar el "enumeration atack"
        return usuarioService.solicitaRegeneracionClave(correo);
    }

    @GetMapping(
            path = "/confirma-regenera-clave.json",
            produces = "application/json; charset=utf-8")
    public Usuario confirmaRegeneraClave(
            @ApiParam(name = "token", value = "Token de confirmación del registro enviado por correo")
            @RequestParam String token,
            @ApiParam(name = "clave", value = "Nueva clave a actualizar")
            @RequestParam String clave) throws ControllerException {
        return usuarioService.confirmaRegeneraClave(token, clave);
    }
    @GetMapping(
            path = "/bitso.json",
            produces = "application/json; charset=utf-8")
    public String bitso() {
        return invokeRestService.getBitsoInfo2();
    }

}
