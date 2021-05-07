/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Usuario.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (09_20)
 *
 * Historia:    .
 *              20210504_0920 Creación
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a una petición en la que hubo
 * un error en el servidor interno.
 * 
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos casos el
 * código HTTP que será devuelto.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
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
