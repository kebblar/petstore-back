package io.kebblar.petstore.api.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.CambioClaveRequest;

@RestController
@RequestMapping(value = "/api")
public class CambioClaveController {

	@PostMapping(path = "/recuperar-clave.json", produces = "application/json; charset=utf-8")
	public String recuperarClave(@RequestBody String correo) throws BusinessException {
		return "Se envío un correo electrónico";
	}

	@PostMapping(path = "/confirma-recuperar-clave.json", produces = "application/json; charset=utf-8")
	public String confirmaRecuperarClave(@RequestBody CambioClaveRequest claves) throws BusinessException {
		return "OK";
	}

}
