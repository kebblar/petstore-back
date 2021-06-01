package io.kebblar.petstore.api.model.exceptions;

public class UserNotExistsException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public UserNotExistsException(String user) {
        super(
            "Usuario Inexistente",
            "El usuario "+user+" no se encuentra registrado",
            2027,
            "CVE_2027",
            HttpStatus.BAD_REQUEST);
    }

}
