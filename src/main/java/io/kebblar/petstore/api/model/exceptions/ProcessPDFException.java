/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ProcessPDFException.java
 * Tipo:        clase
 * AUTOR:       Daniel Alvarez Morales
 * Fecha:       15 de Mayo de 2021 (22_20)
 *
 * Historia:    .
 *              20210504_1409 Creación de esta Excepción
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>
 * Excepción que modela la respuesta a una petición de procesar archivo PDF
 * 
 * <p>
 * Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author dalvarez
 * @see io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ProcessPDFException extends BusinessException {
    private static final long serialVersionUID = 1L;

    public ProcessPDFException(Exception technicalDescription) {
        super(
            "Error al generar el documento PDF",
            technicalDescription.getMessage(),
            1014,
            "CVE_1014",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

/*

*/
