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
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_29)
 *
 * Historia:    .
 *              20210506_0929 Creación de esta Excepción
 *
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