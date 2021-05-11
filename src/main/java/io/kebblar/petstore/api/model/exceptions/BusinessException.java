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
 * Tipo:        clase
 * AUTOR:       Francisco Javier Moreno Romero (FJMR)
 * Fecha:       Viernes 7 de Mayo de 2021 08:55pm 
 *
 * Historia:    .
 *              20210507_0855 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

public class BusinessException extends ControllerException {
    private static final long serialVersionUID = -1218087669509474484L;
    
    /**
     * <p>Excepción que modela la respuesta de un error de negocio
     * 
     * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
     * constructorescon la definición necesaria, que incluye en algunos caos el
     * código HTTP que será devuelto
     * 
     * @author javier
     * @version 1.0-SNAPSHOT
     */
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
