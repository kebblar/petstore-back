/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UserAlreadyExistsException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 4 de Mayo de 2021 (09_05)
 *
 * Historia:    .
 *              20210504_0905 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
* <p>Excepción que modela la respuesta a una petición de registro 
* cuyo usuario ya se encuentra registrado en el sistema.</p>
* 
* <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
* constructores con la definición necesaria, que incluye en algunos casos el
* código HTTP que será devuelto.</p>
* 
* @author  garellano
* @see     io.kebblar.petstore.api.model.exceptions;
* @version 1.0-SNAPSHOT
* @since   1.0-SNAPSHOT
*/
public class UserAlreadyExistsException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Constructor por defecto que da el mensaje de que ya existe el usuario
     */
    public UserAlreadyExistsException() {
        super(
            "Error de registro",
            "El usuario proporcionado ya se encuentra registrado en la base de datos.",
            2005,
            "CVE_2005",
            HttpStatus.BAD_REQUEST);
    }

}