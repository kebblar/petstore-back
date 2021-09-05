/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      GoogleCaptcha
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:00:59
 */
package io.kebblar.petstore.api.model.request;

public class GoogleCaptcha {
    // https://www.google.com/recaptcha/admin/site/315317938/settings
    // arellano.gustavo@gmail.com account
    public static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
    public static final String GOOGLE_RECAPTCHA_SECRET_CODE = "6LffEdkaAAAAAHjf_29VgTHm1RUIgvhnFOAGDN6q";
    private String response;
    private String ip = "127.0.0.1";

    public GoogleCaptcha() {
    }
    public GoogleCaptcha(String response) {
        this.response = response;
    }
    public GoogleCaptcha(String response, String ip) {
        this.response = response;
        this.ip = ip;
    }
    public String getResponse() {
        return response;
    }
    public String getIp() {
        return ip;
    }
}
