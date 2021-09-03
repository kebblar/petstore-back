/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UploadException.java
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
 * Excepción que se lanza cuando hay un problema con la carga de un archivo.
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

public class UploadException extends BusinessException {

    private static final long serialVersionUID = -7083159020205284484L;
    private static final String CVE = "CVE_1020";

    /**
     * Toma la excepción que se lanzó originalmente y reutiliza su mensaje.
     * @param e excepción atrapada por el constructor
     */
    public UploadException(Exception e) {
        super(
            "Error en el servicio de envío de carga de archivos",
            e.getMessage(),
            1020,
            CVE,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Es lanzado cuando hay un problema con la talla del archivo.
     * @param max máximo peso permitido
     * @param peso peso del archivo que se quiso cargar
     */
    public UploadException(long max, long peso) {
        super(
            "Error en el servicio de envio de carga de archivos",
            String.format("Limite excedido. Max: %d. Upload: %d", max, peso),
            1020,
            CVE,
            HttpStatus.INTERNAL_SERVER_ERROR);        
    }

    /**
     * Constructor sin parámetros, lanza un mensaje default.
     */
    public UploadException() {
        super(
            "Error en el servicio de envío de carga de archivos",
            "Tipo mime desconocido",
            1020,
            CVE,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
