/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   CarritoException.java
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Martes 19 de Jun de 2021 (17_57)
 *
 * Historia:    .
 *              20210504_1757 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que es lanzada cuando ocurre un problema al procesar la actualización
 * de un carrito de compras del aplicativo.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  fhernanda
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class CarritoException extends BusinessException {
    private static final long serialVersionUID = -2374644132039662770L;
    private static final String detailedMessage = "No pudo actualizarse la orden compra del carrito del usuario %d";

    public CarritoException(int idUser) {
        super(
            "Error al asociar el carrito a una compra",
            String.format(detailedMessage, idUser),
            1004,
            "CVE-1004",
            HttpStatus.BAD_REQUEST);
    }
}
