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
 * AUTOR:       Edgar Uribe (EUM)
 * Fecha:       Martes 11 de Mayo del 2021 (06 40)
 *
 * Historia:    .
 *              20210511_0640 Creación de esta clase de manejo de excepciones.
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a un token expirado cuando la sesion termina.
 * 
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author  edgarum
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
