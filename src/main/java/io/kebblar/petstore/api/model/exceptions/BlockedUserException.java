package io.kebblar.petstore.api.model.exceptions;

public class BlockedUserException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;
    private final static String mensaje = "El usuario ha sido bloqueado por exceder el número máximo de intentos %d de ingreso permitidos al sistema.";

    public BlockedUserException(int intentos) {
        super(
            "Usuario bloqueado",
            String.format(mensaje, intentos),
            1002,
            "CVE_1002",
            HttpStatus.BAD_REQUEST);
    }

}