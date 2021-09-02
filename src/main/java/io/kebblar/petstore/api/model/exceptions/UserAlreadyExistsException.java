/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   WrongTokenException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (17_57)
 *
 * Historia:    .
 *              20210504_1757 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Descripción</p>
 * Excepción que se lanza cuando el sistema detecta que los datos de un usuario que desea registrarse ya existen.
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

public class UserAlreadyExistsException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Se lanza cuando el sistema detecta que el usuario ya fue registrado.
     */
    public UserAlreadyExistsException() {
        super(
            "Error de registro",
            "El correo proporcionado ya se encuentra registrado en la base de datos.",
            1021,
            "CVE_1021",
            HttpStatus.BAD_REQUEST);
    }

}
