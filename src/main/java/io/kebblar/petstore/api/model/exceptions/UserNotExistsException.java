package io.kebblar.petstore.api.model.exceptions;

public class UserNotExistsException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    
    private final static String detailedMensaje = "El usuario %s no se encuentra reistrado.";
    private final static String shortMensaje = "Usuario Inexistente";

    public UserNotExistsException(String user) {
        super(
            shortMensaje,
            mess(user),
            1022,
            "CVE_1022",
            HttpStatus.BAD_REQUEST);
    }

    private static String mess(String user) {
        return String.format(detailedMensaje, user);
    }
    
}
