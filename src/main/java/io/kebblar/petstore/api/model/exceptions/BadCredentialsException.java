/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   BadCredentialsException.java
 * Tipo:        clase
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_29)
 *
 * Historia:    .
 *              20210506_0929 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a una petición de autenticación
 * cuyas credenciales proporcionadas fueron incorrectas.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions",  sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  luz
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BadCredentialsException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    private final static String mensaje = "Las credenciales proporcionadas son inválidas. Usted tiene %d intentos mas antes de que su usuario quede bloqueado.";

    public BadCredentialsException(int counter, int maxAllowed) {
        super(
            "Las credenciales proporcionadas son inválidas",
            String.format(mensaje, maxAllowed-counter),
            1001,
            "CVE_1001",
            HttpStatus.UNAUTHORIZED);
    }

    public BadCredentialsException() {
        super(
            "Las credenciales proporcionadas son inválidas",
            "Favor de capturar credenciales válidas",
            1003,
            "CVE_1003",
            HttpStatus.UNAUTHORIZED);
    }

}
