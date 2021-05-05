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
        String datos = UUID.randomUUID().toString();
        List<Rol> roles = new ArrayList<>();
        roles.add(new Rol(1,"r1",true));
        roles.add(new Rol(2,"r2",true));
        roles.add(new Rol(3,"r3",true));
        
        return new LoginResponse(dato, new Date(), "abc@aol.com", "gus-jwt-"+datos, roles, null);
    }

}
