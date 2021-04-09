package io.kebblar.petstore.api.model.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPassword extends BusinessException {
    private static final long serialVersionUID = -1222301152057974505L;

    public InvalidPassword(String message) {
        super(
            "Clave inválida",
            "La clave proporcionada es inválida.",
            3002,
            "CVE_3002",
            HttpStatus.BAD_REQUEST);
    }
}
