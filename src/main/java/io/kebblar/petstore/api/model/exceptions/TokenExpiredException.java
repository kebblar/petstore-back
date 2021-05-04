/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TokenExpiredException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (09_30)
 *
 * Historia:    .
 *              20210504_0930 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a la validez de un Token 
 * proporcionado a través de una petición.
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
public class TokenExpiredException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public TokenExpiredException() {
        super(
            "Token expirado",
            "El token que ha proporcionado no es válido, ya que ha expirado.",
            2007,
            "CVE_2007",
            HttpStatus.UNAUTHORIZED);
    }

}
