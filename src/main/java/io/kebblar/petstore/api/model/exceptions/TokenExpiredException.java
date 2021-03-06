package io.kebblar.petstore.api.model.exceptions;

public class TokenExpiredException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public TokenExpiredException() {
        super(
            "Token expirado",
            "El token que se ha proporcionado no es válido, ya que ha expirado.",
            1017,
            "CVE_1017",
            HttpStatus.UNAUTHORIZED);
    }

}
