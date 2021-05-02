package io.kebblar.petstore.api.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.ControllerException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.service.AccessService;

@RestController
@RequestMapping(value = "/api")
public class AccessController {

    private AccessService accessService;
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping(path = "/login.json", produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws ControllerException {
        return accessService.login(cred.getUsuario(), cred.getClave());
    }

    @PostMapping(path = "/usuario-detalles.json", produces = "application/json; charset=utf-8")
    public LoginResponse insertaUsuarioDetalles(@RequestBody UsuarioDetalle dato) throws ControllerException {
        System.out.println(dato); // Esto va a evolucionar por código real. Por el momento es sólo una prueba.
        return new LoginResponse(dato, new Date(), "abc@aol.com", "jwt-bcdhbcxhdsb", null, null);
    }
}
