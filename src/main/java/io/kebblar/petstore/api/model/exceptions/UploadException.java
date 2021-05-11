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
 * AUTOR:       Edgar Uribe (EUM)
 * Fecha:       Martes 11 de Mayo del 2021 (06 40)
 *
 * Historia:    .
 *              20210511_0640 Creación de esta clase de manejo de excepciones.
 *
 */
package io.kebblar.petstore.api.model.exceptions;

/**
 * <p>Excepción que modela la respuesta a una carga de archivo fallida.
 * 
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructorescon la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 * 
 * @author  edgarum
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class UploadException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    public UploadException(String msg) {
        super(
            "Error en el servicio de envio de carga de archivos",
            msg,
            2022,
            "CVE_2022",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
