package io.kebblar.petstore.api.model.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerException extends Exception {
    private static final long serialVersionUID = -5047974256813565913L;
    private static final Logger LOGGER = LoggerFactory.getLogger(MapperCallException.class);

    private String shortMessage;
    private String detailedMessage;
    private int localExceptionNumber;
    private String localExceptionKey;
    private HttpStatus httpStatus = HttpStatus.ACCEPTED;

    public ControllerException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey,
            HttpStatus httpStatus) {
        this.shortMessage = shortMessage;
        this.detailedMessage = detailedMessage;
        this.localExceptionNumber = localExceptionNumber;
        this.localExceptionKey = localExceptionKey;
        this.httpStatus = httpStatus;
        LOGGER.error(detailedMessage);
    }
    public ControllerException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey) {
        this(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey, HttpStatus.ACCEPTED);
    }
    public String getShortMessage() {
        return shortMessage;
    }
    public String getDetailedMessage() {
        return detailedMessage;
    }
    public int getLocalExceptionNumber() {
        return localExceptionNumber;
    }
    public String getLocalExceptionKey() {
        return localExceptionKey;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
