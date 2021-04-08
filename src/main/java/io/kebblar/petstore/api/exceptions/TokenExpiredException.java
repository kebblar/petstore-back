package io.kebblar.petstore.api.exceptions;

import org.springframework.http.HttpStatus;

public class TokenExpiredException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public TokenExpiredException() {
        super(
            "Token expirado",
            "El token que ha proporcionado no es válido, ya que ha expirado.",
            2007,
            "CVE_2007",
            HttpStatus.UNAUTHORIZED);
    }

}
