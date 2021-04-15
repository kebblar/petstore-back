package io.kebblar.petstore.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.request.CredencialesRequest;
import io.kebblar.petstore.api.service.UsuarioService;
import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
    private UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
        
    @GetMapping(path = "/usuarios/{id}.json", produces = "application/json; charset=utf-8")
    public Usuario getUser(@RequestAttribute int id) throws BusinessException {
        return this.usuarioService.getUser(id);
    }
    
    @GetMapping(path = "/usuarios.json", produces = "application/json; charset=utf-8")
    public List<Usuario> getAllUsers() throws BusinessException {
        return this.usuarioService.getAllUsers();
    }
    
    @PostMapping(path = "/usuarios.json", produces = "application/json; charset=utf-8")
    public Usuario createUser(@RequestBody CredencialesRequest credenciales) throws BusinessException {
        return this.usuarioService.createUser(credenciales);
    }
        
    @PutMapping(path = "/usuarios.json", produces = "application/json; charset=utf-8")
    public Usuario updateUsuario(@RequestBody Usuario usuario) throws BusinessException {
         return this.usuarioService.updateUser(usuario);
    }
    
    @DeleteMapping(path = "/usuarios.json", produces = "application/json; charset=utf-8")
    public Usuario borraUsuario(@RequestParam int id) throws BusinessException {
         return this.usuarioService.eliminaUsuario(id);
    }

}
