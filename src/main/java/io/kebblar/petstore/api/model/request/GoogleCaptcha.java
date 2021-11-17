/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
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

/**
 * <p>GoogleCaptcha class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class GoogleCaptcha {
    // https://www.google.com/recaptcha/admin/site/315317938/settings
    // arellano.gustavo@gmail.com account
    /** Constant <code>GOOGLE_RECAPTCHA_VERIFY_URL="https://www.google.com/recaptcha/api/si"{trunked}</code> */
    /** Constant <code>GOOGLE_RECAPTCHA_SECRET_CODE="6LffEdkaAAAAAHjf_29VgTHm1RUIgvhnFOAGDN6"{trunked}</code> */
    //public static final String GOOGLE_RECAPTCHA_SECRET_CODE = "6LffEdkaAAAAAHjf_29VgTHm1RUIgvhnFOAGDN6q";
    private String response;
    private String ip = "127.0.0.1";

    /**
     * <p>Constructor for GoogleCaptcha.</p>
     */
    public GoogleCaptcha() {
    }
    /**
     * <p>Constructor for GoogleCaptcha.</p>
     *
     * @param response a {@link java.lang.String} object.
     */
    public GoogleCaptcha(String response) {
        this.response = response;
    }
    /**
     * <p>Constructor for GoogleCaptcha.</p>
     *
     * @param response a {@link java.lang.String} object.
     * @param ip a {@link java.lang.String} object.
     */
    public GoogleCaptcha(String response, String ip) {
        this.response = response;
        this.ip = ip;
    }
    /**
     * <p>Getter for the field <code>response</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getResponse() {
        return response;
    }
    /**
     * <p>Getter for the field <code>ip</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIp() {
        return ip;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((response == null) ? 0 : response.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GoogleCaptcha other = (GoogleCaptcha) obj;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (response == null) {
            if (other.response != null)
                return false;
        } else if (!response.equals(other.response))
            return false;
        return true;
    }

    public int getHash() {
        return this.hashCode();
    }
    
}
