package io.kebblar.petstore.api.model.exceptions;

import org.springframework.http.HttpStatus;

public class TokenNotExistException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public TokenNotExistException() {
        super(
            "Token inexistente",
            "El token que ha proporcionado no ha podido ser encontrado en la base de datos.",
            2006,
            "CVE_2006",
            HttpStatus.FORBIDDEN);
    }

}
