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
 * <p>Descripción:</p>
 * Excepción que indica que un usuario bloqueado debe de esperar aún para poder acceder a su cuenta.
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
public class WaitLoginException extends BusinessException {

    private static final long serialVersionUID = 8948866486775990561L;
    private static final String DETAILED_MENSAJE = "El usuario ha sido bloqueado por los próximos %d minutos y %d segundos debido a que alcanzó el máximo numero de intentos fallidos de ingreso al sistema.";
    private static final String SHORT_MENSAJE = "Usuario bloqueado";

    /**
     * Indica cuánto tiempo debe de esperar antes de poder volver a intentar el ingreso al sistema.
     * @param seconds segundos restantes
     */
    public WaitLoginException(long seconds) {
        super(
                SHORT_MENSAJE,
            calc(seconds),
            1024,
            "CVE_1024",
            HttpStatus.BAD_REQUEST);
    }

    /**
     * Método auxiliar generar un mensaje explicativo del tiempo de espera restante.
     * @param seconds segundos restantes
     * @return Cadena que informa al usuario en cuánto tiempo se desbloquea su cuenta
     */
    private static String calc(long seconds) {
        long minutes = seconds/60;
        long seg = seconds%60;
        return String.format(DETAILED_MENSAJE, minutes, seg);
    }

}
