/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   BitcoinTransactionException.java
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
 * <p>Excepción que es lanzada cuando ocurre un problema al procesar una orden de compra
 * pagada con bitcoin.
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
public class BitcoinTransactionException extends BusinessException {

    public BitcoinTransactionException(String msg) {
        super(msg,
              "Error al procesar bitcoin como metodo de pago",
              2009,
              "CVE-2009",
              HttpStatus.BAD_REQUEST);
    }
}
