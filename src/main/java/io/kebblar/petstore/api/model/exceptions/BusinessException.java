/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   BusinessException.java
 * Tipo:        Clase
 * AUTOR:       Isabel Contreras
 * Fecha:       Martes 11 de Mayo de 2021 (09_04)
 *
 * Historia:    .
 *              20210511_0904 Se agrega la documentacion de la excepcion
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta de un error de negocio
 * 
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author  Isabel Contreras
 * @see     io.kebblar.petstore.api.model.exceptions.ControllerException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public class BusinessException extends ControllerException {
    private static final long serialVersionUID = -1218087669509474484L;

    public BusinessException() {
        super("", "", 0, "CVE_0000");
    }

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

    public BusinessException(
            String shortMessage,
            String detailedMessage) {
        super(shortMessage, detailedMessage, 0, "CVE_0000");
    }

}
