package io.kebblar.petstore.api.model.exceptions;

public class MailException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public MailException(String msg) {
        super(
            "Error en el servicio de envio de correos",
            msg,
            2011,
            "CVE_2011",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
