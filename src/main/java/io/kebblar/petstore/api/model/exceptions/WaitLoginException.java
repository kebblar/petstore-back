/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   WaitLoginException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (08_59)
 *
 * Historia:    .
 *              20210504_0859 Creación de esta Excepción
 *              20210511_0855 Se modifica la fecha en la licencia
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a una petición de autenticación 
 * cuyo usuario esta bloqueado.</p>
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
public class WaitLoginException extends BusinessException {
    private static final long serialVersionUID = 8948866486775990561L;
    private final static String mensaje = "El usuario ha sido bloqueado por los próximos %d minutos y %d segundos debido a que alcanzó el máximo numero de intentos fallidos de ingreso al sistema.";

    /**
     * Método que recibe un long con los segundos que estará bloqueado
     * @param segundos
     */
    public WaitLoginException(long segundos) {
        super(
            "Usuario bloqueado",
            calc(segundos),
            1001,
            "CVE_1001",
            HttpStatus.BAD_REQUEST);
    }

    /**
     * Método que rebibe un long con la cantidad de segundos que estara bloqueado el usuario
     * @param segundos
     * @return String con el mensaje de minutos y segundos bloqueados
     */
    private static String calc(long segundos) {
        long minutos = segundos/60;
        long seg = segundos%60;
        return String.format(mensaje, minutos, seg);
    }

}
