/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   StrengthException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (17_57)
 *
 * Historia:    .
 *              20210504_1757 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

import java.util.List;

/**
 * <p>Descripción</p>
 * Excepción que determina cuando existe un problema con la fortaleza de una clave.
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

public class StrengthPasswordValidatorException extends BusinessException {

    private static final long serialVersionUID = -1222301152057974505L;
    private List<String> messages = null;

    /**
     * Se lanza cuando existe una clave que no cumple con los lineamientos de seguridad
     * @param messages lista de requisitos no cubiertos por la clave
     */
    public StrengthPasswordValidatorException(List<String> messages) {
        super(
            "Clave inválida",
            "La clave proporcionada es inválida.",
            1016,
            "CVE_1016",
            HttpStatus.BAD_REQUEST);
        this.messages = messages;
    }

    /**
     * Devuelve el atributo de la clase.
     * @return atributo lista de mensajes
     */
    public List<String> getMessages() {
        return this.messages;
    }
}
