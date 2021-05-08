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
 * Tipo:        clase
 * AUTOR:       Francisco Javier Moreno Romero
 * Fecha:       07/05/2021 08:45 pm
 *
 * Historia:    .
 *              20210503_1409 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

public class BlockedUserException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;
    private final static String mensaje = "El usuario ha sido bloqueado por exceder el número máximo de intentos %d de ingreso permitidos al sistema.";

    /**
     * <p>Excepción que modela la respuesta a una petición de autenticación 
     * cuyas credenciales proporcionadas fueron incorrectas.
     * 
     * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
     * constructorescon la definición necesaria, que incluye en algunos caos el
     * código HTTP que será devuelto.
     * 
     * 
     * @author javier
     * @param intentos
     * @version 1.0-SNAPSHOT
     */
    public BlockedUserException(int intentos) {
        super(
            "Usuario bloqueado",
            String.format(mensaje, intentos),
            1002,
            "CVE_1002",
            HttpStatus.BAD_REQUEST);
    }

}