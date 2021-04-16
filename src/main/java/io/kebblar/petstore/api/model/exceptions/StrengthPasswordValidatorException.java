package io.kebblar.petstore.api.model.exceptions;

import java.util.List;

public class StrengthPasswordValidatorException extends BusinessException {
    private static final long serialVersionUID = -1222301152057974505L;
    private List<String> messages = null;

    public StrengthPasswordValidatorException(String message,  List<String> messages) {
        super(
            "Clave inválida",
            "La clave proporcionada es inválida.",
            3002,
            "CVE_3002",
            HttpStatus.BAD_REQUEST);
        this.messages = messages;
    }

    public  List<String> getessages() {
        return this.messages;
    }
}
