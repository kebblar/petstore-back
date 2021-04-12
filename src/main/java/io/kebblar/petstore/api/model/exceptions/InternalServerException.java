package io.kebblar.petstore.api.model.exceptions;

public class InternalServerException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public InternalServerException(String shortMessage, String longMessage) {
        super(
            shortMessage,
            longMessage,
            9999,
            "CVE_9999",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
