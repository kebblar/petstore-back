/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.exceptions
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      InternalServerException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:57:05
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
