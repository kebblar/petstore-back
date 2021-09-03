/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   RuleException.java
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
public class RuleException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /*
     * TODO: esta es una fuente de conflictos en el proceso de internacionalización.
     * Quizá convenga tener subclases de esta con la especialización en los
     * mensajes; algo similar a lo que se hace con UserAlreadyExistsException.
     */

    /**
     * Generalización de una violación a las reglas de negocio.
     * @param msg mensaje descriptivo
     */
    public RuleException(String msg) {
        super(
            "Se ha detectado una violación a alguna regla de negocio.",
            msg,
            1015,
            "CVE_1015",
            HttpStatus.PRECONDITION_FAILED);
    }
}
