package io.kebblar.petstore.api.exceptions;

import org.springframework.http.HttpStatus;

public class WrongTokenException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public WrongTokenException(String msg) {
        super(
            "Token incorrecto",
            "El token que ha proporcionado es incorrecto.",
            2008,
            "CVE_2008",
            HttpStatus.FORBIDDEN);
    }

}
