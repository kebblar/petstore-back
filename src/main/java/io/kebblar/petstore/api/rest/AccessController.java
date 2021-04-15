package io.kebblar.petstore.api.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.model.exceptions.BadCredentialsException;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.MailException;

@RestController
@RequestMapping(value = "/api")
public class AccessController {
    
    @PostMapping(path = "/login.json", produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws BusinessException {
        if(cred.getClave().length()<3) throw new MailException("Para la clase del diplomado");
        return new LoginResponse(1, "gus", new Date());
    }

}
