package io.kebblar.petstore.api.model.exceptions;

public class ControllerException extends Exception {
    private static final long serialVersionUID = -5047974256813565913L;

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
    }
    public ControllerException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey) {
        this.shortMessage = shortMessage;
        this.detailedMessage = detailedMessage;
        this.localExceptionNumber = localExceptionNumber;
        this.localExceptionKey = localExceptionKey;
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