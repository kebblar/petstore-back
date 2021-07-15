package io.kebblar.petstore.api.model.exceptions;

import java.util.List;

public class StrengthPasswordValidatorException extends BusinessException {
    private static final long serialVersionUID = -1222301152057974505L;
    private List<String> messages = null;

    public StrengthPasswordValidatorException(List<String> messages) {
        super(
            "Clave inválida",
            "La clave proporcionada es inválida.",
            1016,
            "CVE_1016",
            HttpStatus.BAD_REQUEST);
        this.messages = messages;
    }

    public List<String> getMessages() {
        return this.messages;
    }
}
