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
 * Nombre:      FileUploadException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:56:22
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
