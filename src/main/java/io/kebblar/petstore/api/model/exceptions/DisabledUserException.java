package io.kebblar.petstore.api.model.exceptions;

import org.springframework.http.HttpStatus;

public class DisabledUserException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;

    public DisabledUserException() {
        super(
            "Error de ingreso",
            "El usuario ha sido deshabilitado.",
            2004,
            "CVE_2004",
            HttpStatus.BAD_REQUEST);
    }
}
