/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   StrengthPasswordValidatorException.java
 * Tipo:        clase
 * AUTOR:       Diego González Sánchez
 * Fecha:       Martes 4 de Mayo de 2021 (09_57)
 *
 * Historia:    .
 *              20210503_0957 Creación de esta Excepción
 *
 */

package io.kebblar.petstore.api.model.exceptions;

import java.util.List;

/**
 * <p>Excepción que modela la respuesta a una petición de autenticación 
 * cuyas credenciales proporcionadas fueron incorrectas.
 * 
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author  Diego G. Sánchez
 * @see     io.kebblar.petstore.api.model.exceptions.StrengthPasswordValidatorException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class StrengthPasswordValidatorException extends BusinessException {
    private static final long serialVersionUID = -1222301152057974505L;
    private List<String> messages = null;

    public StrengthPasswordValidatorException(String message,  List<String> messages) {
        super(
            "Clave inválida",
            "La clave proporcionada es inválida.",
            3002,
            "CVE_3002",
            HttpStatus.BAD_REQUEST);
        this.messages = messages;
    }

    public  List<String> getessages() {
        return this.messages;
    }
}
