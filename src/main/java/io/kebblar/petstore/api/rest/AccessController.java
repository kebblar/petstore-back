/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AccessControllerjava
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (22_29)
 *
 * Historia:    .
 *              20210503_2229 Creación de éste controlador REST
 *
 */
package io.kebblar.petstore.api.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.service.AccessService;
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
    
    /**
     * Constructor que realiza el setting de los servicios que serán 
     * utilizados en este controlador.
     * 
     * @param accessService Servicios de AccessService
     */
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping(path = "/login.json", produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws ControllerException {
        return accessService.login(cred.getUsuario(), cred.getClave());
    }

    @PostMapping(path = "/usuario-detalles.json", produces = "application/json; charset=utf-8")
    public LoginResponse insertaUsuarioDetalles(
            @ApiParam(name = "dato", value = "Información con el detalle de un Usuario")
    		@RequestBody UsuarioDetalle dato) throws ControllerException {
        System.out.println(dato); // Esto va a evolucionar por código real. Por el momento es sólo una prueba.
        String datos = UUID.randomUUID().toString();
        List<Rol> roles = new ArrayList<>();
        roles.add(new Rol(1,"r1",true));
        roles.add(new Rol(2,"r2",true));
        roles.add(new Rol(3,"r3",true));
        return new LoginResponse(dato, new Date(), "abc@aol.com", "gus-jwt-"+datos, roles, null);
    }
}
