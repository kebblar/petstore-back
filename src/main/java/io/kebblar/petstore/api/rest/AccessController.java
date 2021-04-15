package io.kebblar.petstore.api.rest;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.model.response.LoginResponse;
import io.kebblar.petstore.api.service.AccessService;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.UserAlreadyExistsException;

@RestController
@RequestMapping(value = "/api")
public class AccessController {
    private AccessService accessService;
    
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }
    
    @PostMapping(path = "/login.json", produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws BusinessException {
        if(cred.getClave().length()<3) throw new UserAlreadyExistsException();
        return new LoginResponse(1, "gus", new Date());
    }
    
    @PostMapping(path = "/usuarios.json", produces = "application/json; charset=utf-8")
    public Usuario createUser(@RequestBody CredencialesRequest credenciales) throws BusinessException {
        return this.accessService.createUser(credenciales);
    }
    
    @GetMapping(path = "/usuarios/{id}.json", produces = "application/json; charset=utf-8")
    public Usuario getUser(@RequestAttribute int id) throws BusinessException {
        return this.accessService.getUser(id);
    }
    
    @GetMapping(path = "/usuarios.json", produces = "application/json; charset=utf-8")
    public List<Usuario> getAllUsers() throws BusinessException {
        return this.accessService.getAllUsers();
    }

}
