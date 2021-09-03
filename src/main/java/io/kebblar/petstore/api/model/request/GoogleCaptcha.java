/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Anuncio.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_28)
 *
 * Historia:    .
 *              20210518_2028 Creación de éste POJO
 *              20210604_1314 Modificacion de 'sku' por 'folio'
 *
 */
package io.kebblar.petstore.api.model.request;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'GoogleCaptcha'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * Ver ---> https://www.google.com/recaptcha/admin/site/315317938/settings
 * arellano.gustavo@gmail.com account
 */
public class GoogleCaptcha {

    /*
     * Atributos de la clase.
     */
    public static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
    public static final String GOOGLE_RECAPTCHA_SECRET_CODE = "6LffEdkaAAAAAHjf_29VgTHm1RUIgvhnFOAGDN6q";
    private String response;
    private String ip = "127.0.0.1";

    /**
     * Constructor por defecto.
     */
    public GoogleCaptcha() {
    }

    /**
     * Constructor por mensaje.
     * @param response respuesta recibida.
     */
    public GoogleCaptcha(String response) {
        this.response = response;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public GoogleCaptcha(String response, String ip) {
        this.response = response;
        this.ip = ip;
    }

    /*
     * Setter y Getter.
     */
    public String getResponse() {
        return response;
    }
    public String getIp() {
        return ip;
    }
}
