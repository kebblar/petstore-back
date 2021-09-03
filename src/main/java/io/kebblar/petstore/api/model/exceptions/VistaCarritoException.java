/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   VistaCarritoException.java
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Martes 11 de Mayo de 2021 (17_57)
 *
 * Historia:    .
 *              20210504_1757 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que es lanzada cuando ocurre un problema al procesar la petición de la
 * vista hacia un carrito de compras del aplicativo.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  fhernanda
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class VistaCarritoException extends BusinessException{

    private static final long serialVersionUID = 129288280347509459L;

    /**
     * Ocurrió un problema al procesar la petición del carrito de un usuario.
     * @param clave cadena que representa la clave de orden del carrito
     */
    public VistaCarritoException(String clave) {
        super(
            "Error al recuperar la vista del carrito",
            String.format("La clave de orden ingresada no existe: %s", clave),
            1023,
            "CVE-1023",
            HttpStatus.BAD_REQUEST);
    }
}
