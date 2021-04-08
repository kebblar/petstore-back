package io.kebblar.petstore.api.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;

    public UserAlreadyExistsException() {
        super(
            "Error de registro",
            "El usuario proporcionado ya se encuentra registrado en la base de datos.",
            2005,
            "CVE_2005",
            HttpStatus.BAD_REQUEST);
    }

}
