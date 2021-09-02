/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   GoogleCaptchaException.java
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
 * Excepción que modela la respuesta a una petición de Google Captcha.
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
public class GoogleCaptchaException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Modela la respuesta de error de una petición de Google Captcha.
     * @param e excepción recibida desde el servicio de captcha
     */
    public GoogleCaptchaException(Exception e) {
        super(
            "Captcha Error",
            e.getMessage(),
            1009,
            "CVE_1009",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
