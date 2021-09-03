/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   InternatServerException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 4 de Mayo de 2021 (22_27)
 *
 * Historia:    .
 *              20210503_1409 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

public class InternalServerException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;
    private static final String MSG = "Ha ocurrido un error interno. Favor de notificar al administrador el código de error: %s";

    /**
     * Indica que hay un error del lado del servidor.
     * @param shortMessage Breve descripción del problema
     * @param longMessage Descripción específica
     */
    public InternalServerException(String shortMessage, String longMessage) {
        super(
            ControllerException.buildMessage(MSG, shortMessage),
            ControllerException.buildMessage(MSG, longMessage),
            1010,
            "CVE_1010",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
