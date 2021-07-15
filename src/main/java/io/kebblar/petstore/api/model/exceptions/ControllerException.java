/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ControllerException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (08_59)
 *
 * Historia:    .
 *              20210503_0859 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

import java.util.UUID;

/**
 * <p>Excepción que modela las propiedades que definen una excepción
 * y es utilizada por el {@link CustomControllerAdvice} para manipular la información
 * en la excepción.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerException extends Exception {
    private static final long serialVersionUID = -5047974256813565913L;
    private static final Logger LOGGER = LoggerFactory.getLogger(MapperCallException.class);

    private Exception rootException; 
    private String shortMessage;
    private String detailedMessage;
    private int localExceptionNumber;
    private String localExceptionKey;
    private HttpStatus httpStatus = HttpStatus.ACCEPTED;

    public ControllerException(Exception rootException) {
        this.rootException = rootException;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.localExceptionNumber = 1000;
        this.localExceptionKey = "cve_1000";
        this.shortMessage = rootException.getMessage();
        this.detailedMessage = rootException.getMessage();
    }
    
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
        LOGGER.error(this.toString());
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
    public Exception getRootException() {
        return rootException;
    }
    public String getRootExceptionMessage() {
        return rootException.getMessage();
    }
    public String toString() {
        return "ControllerException [rootException=" + rootException + ", shortMessage=" + shortMessage
                + ", detailedMessage=" + detailedMessage + ", localExceptionNumber=" + localExceptionNumber
                + ", localExceptionKey=" + localExceptionKey + ", httpStatus=" + httpStatus + "]";
    }
    /**
     * Construye un mensaje genérico basado en un ID de rastreo para ocultar
     * el verdadero mensaje al usuario final y dejar huella para que lo busque
     * y gestione un administrador con acceso al log de transacciones.
     * 
     * @param msg Cadena con un mensaje genérico.
     * @param desc Mensaje real a ocultar.
     * 
     * @return Cadena con el ID genérico
     */
    public static String buildMessage(String msg, String desc) {
        String uid = UUID.randomUUID().toString();
        LOGGER.error("UID: " + uid + ". Description: " + desc);
        return String.format(msg,  uid);
    }
}
