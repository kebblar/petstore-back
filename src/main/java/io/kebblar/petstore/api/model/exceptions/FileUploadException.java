/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   FileUploadException.java
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
 * <p>Descripción:</p>
 * Excepción lanzada cuando existen problemas al querer cargar archivos al sistema.
 *
 * Tal y como ocurre en la mayoría de "custom exceptions", solo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class FileUploadException extends BusinessException {

    private static final long serialVersionUID = -7083159020205284484L;
    private static final String DETAILED_MENSAJE = "Limite excedido. Max: %d. Peso: %d";

    /**
     * Se lanza en caso de que se quiera subir un archivo de un tamaño mayor al permitido.
     *
     * @param max Indica la máxima capacidad que puede tener un archivo
     * @param size Tamaño que tiene el archivo que se intentó subir
     */
    public FileUploadException(long max, long size) {
        super(
            "Error al subir un archivo",
            String.format(DETAILED_MENSAJE, max, size),
            1007,
            "CVE_1007",
            HttpStatus.BAD_REQUEST);
    }

    /**
     * Se lanza en caso de que se quiera subir un archivo de un tamaño mayor al permitido.
     * @param msg Mensaje explicativo del problema
     */
    public FileUploadException(String msg) {
        super(
            "Error al subir un archivo",
            msg,
            1008,
            "CVE_1008",
            HttpStatus.BAD_REQUEST);
    }
}
