/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   BlockedUserException.java
 * Tipo:        Clase
 * AUTOR:       Isabel Contreras
 * Fecha:       Martes 11 de Mayo de 2021 (09_03)
 *
 * Historia:    .
 *              20210511_0903 Se agrega la documentacion de la excepcion
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a una petición de bloqueo de usuario 
 * 
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BlockedUserException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    private final static String mensaje = "El usuario ha sido bloqueado por exceder el número máximo de intentos %d de ingreso permitidos al sistema.";

    public BlockedUserException(int intentos) {
        super(
            "Usuario bloqueado",
            String.format(mensaje, intentos),
            1002,
            "CVE_1002",
            HttpStatus.BAD_REQUEST);
    }

}