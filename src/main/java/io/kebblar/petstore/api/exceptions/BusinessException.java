package io.kebblar.petstore.api.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends ControllerException {
    private static final long serialVersionUID = -1218087669509474484L;

    public BusinessException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey,
            HttpStatus httpStatus) {
        super(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey, httpStatus);
    }

    public BusinessException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey) {
        super(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey);
    }

}
