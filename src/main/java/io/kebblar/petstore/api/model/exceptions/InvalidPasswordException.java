package io.kebblar.petstore.api.model.exceptions;

public class InvalidPasswordException extends BusinessException {
    private static final long serialVersionUID = -1222301152057974505L;

    public InvalidPasswordException(String message) {
        super(
            "Clave inválida",
            "La clave proporcionada es inválida.",
            3002,
            "CVE_3002",
            HttpStatus.BAD_REQUEST);
    }
}
