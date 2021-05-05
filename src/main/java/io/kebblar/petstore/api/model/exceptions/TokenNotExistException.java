/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TokenNoExistException.java
 * Tipo:        clase
 * AUTOR:       Diego González Sánchez
 * Fecha:       Martes 4 de Mayo de 2021 (09_20)
 *
 * Historia:    .
 *              20210503_2229 Creación de esta Excepción
 *
 */

package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a la petición de Token.
 * cuyo Token no existe en la Base de Datos.
 * 
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author  Diego
 * @see     io.kebblar.petstore.api.model.exceptions.TokenNoExistException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class TokenNotExistException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public TokenNotExistException() {
        super(
            "Token inexistente",
            "El token que ha proporcionado no ha podido ser encontrado en la base de datos.",
            2006,
            "CVE_2006",
            HttpStatus.FORBIDDEN);
    }

}
