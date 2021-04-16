package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.service.AccessService;

@RestController
@RequestMapping(value = "/api")
public class AccessController {

    private AccessService as;
    public AccessController(AccessService as) {
        this.as = as;
    }
    @PostMapping(path = "/login.json", produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws BusinessException {
        return as.login(cred.getUsuario(), cred.getClave());
    }

}
