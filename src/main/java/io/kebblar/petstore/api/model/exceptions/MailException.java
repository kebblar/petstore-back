/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MailException.java
 * Tipo:        clase
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_29)
 *
 * Historia:    .
 *              20210506_0929 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que modela la respuesta a una petición de envío de correos
 * cuya salida no tuvo éxito.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class MailException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Se lanza al ocurrir un problema con el envío de correos.
     * @param e excepción atrapada
     */
    public MailException(Exception e) {
        super(
            "Error en el servicio de envío de correos",
            e.getMessage(),
            1011,
            "CVE_1011",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
