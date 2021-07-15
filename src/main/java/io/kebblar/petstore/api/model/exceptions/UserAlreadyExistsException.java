package io.kebblar.petstore.api.model.exceptions;

public class UserAlreadyExistsException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;

    public UserAlreadyExistsException() {
        super(
            "Error de registro",
            "El correo proporcionado ya se encuentra registrado en la base de datos.",
            1021,
            "CVE_1021",
            HttpStatus.BAD_REQUEST);
    }

}
