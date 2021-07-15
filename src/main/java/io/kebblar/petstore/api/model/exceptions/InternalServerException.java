package io.kebblar.petstore.api.model.exceptions;

public class InternalServerException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    private static final String msg = "Ha ocurrido un error interno. Favor de notificar al administrador el código de error: %s";

    public InternalServerException(String shortMessage, String longMessage) {
        super(
            ControllerException.buildMessage(msg, shortMessage),
            ControllerException.buildMessage(msg, longMessage),
            1010,
            "CVE_1010",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
