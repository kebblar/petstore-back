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
 * Nombre:      BlockedUserException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:54:30
 */
package io.kebblar.petstore.api.model.exceptions;

public class BlockedUserException extends BusinessException{

    /**
     * <p>Descripción:</p>
     * Excepción que informa cuando se intenta ingresar con un usuario bloqueado.
     *
     * @author  fhernanda
     * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
     * @version 1.0-SNAPSHOT
     * @since   1.0-SNAPSHOT
     */
    private static final long serialVersionUID = -7083159020205284484L;
    private static final String MENSAJE = "El usuario ha sido bloqueado por exceder el número máximo de intentos %d de ingreso permitidos al sistema.";

    /**
     * Excepción lazada para informar a un usuario que está bloqueado.
     * @param intentos Cantidad de intentos de inicio de sesión
     */
    public BlockedUserException(int intentos) {
        super(
            "Usuario bloqueado",
            String.format(MENSAJE, intentos),
            1003,
            "CVE_1003",
            HttpStatus.BAD_REQUEST);
    }

}