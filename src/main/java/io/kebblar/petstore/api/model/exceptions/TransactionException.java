/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TransactionException.java
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
 * Excepción que modela la respuesta a una petición cuyo token fue incorrecto.
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
public class TransactionException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Por medio de la excepción original se genera la nueva excepción.
     * @param e excepción lanzada en un inicio
     */
    public TransactionException(Exception e) {
        super(e);
    }

    /**
     * Cuando ocurre un problema con una transacción o se proporciona un token incorrecto.
     * @param msg detalles del problema
     */
    public TransactionException(String msg) {
        super(
            "Transacción fallida. Haciendo rollback del proceso.",
            msg,
            1019,
            "CVE_1019",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
