/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      SmsResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:21:50
 */
package io.kebblar.petstore.api.model.response;

/**
 * Implementacion del POJO de la entidad de 'SmsResponse'.
 *
 * @author  Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class SmsResponse {
    private String ipCaller;
    private String fechaInvocacon;
    private String mensajeDado;
    private String telefonoDado;
    private boolean exito;
    private String resultMsg;

    /**
     * <p>Constructor for SmsResponse.</p>
     */
    public SmsResponse() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param ipCaller a {@link java.lang.String} object.
     * @param fechaInvocacon a {@link java.lang.String} object.
     * @param mensajeDado a {@link java.lang.String} object.
     * @param telefonoDado a {@link java.lang.String} object.
     * @param exito a boolean.
     * @param resultMsg a {@link java.lang.String} object.
     */
    public SmsResponse(String ipCaller, String fechaInvocacon, String mensajeDado, String telefonoDado, boolean exito,
            String resultMsg) {
        this.ipCaller = ipCaller;
        this.fechaInvocacon = fechaInvocacon;
        this.mensajeDado = mensajeDado;
        this.telefonoDado = telefonoDado;
        this.exito = exito;
        this.resultMsg = resultMsg;
    }

    /**
     * <p>Getter for the field <code>ipCaller</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIpCaller() {
        return ipCaller;
    }

    /**
     * <p>Setter for the field <code>ipCaller</code>.</p>
     *
     * @param ipCaller a {@link java.lang.String} object.
     */
    public void setIpCaller(String ipCaller) {
        this.ipCaller = ipCaller;
    }

    /**
     * <p>Getter for the field <code>fechaInvocacon</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFechaInvocacon() {
        return fechaInvocacon;
    }

    /**
     * <p>Setter for the field <code>fechaInvocacon</code>.</p>
     *
     * @param fechaInvocacon a {@link java.lang.String} object.
     */
    public void setFechaInvocacon(String fechaInvocacon) {
        this.fechaInvocacon = fechaInvocacon;
    }

    /**
     * <p>Getter for the field <code>mensajeDado</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMensajeDado() {
        return mensajeDado;
    }

    /**
     * <p>Setter for the field <code>mensajeDado</code>.</p>
     *
     * @param mensajeDado a {@link java.lang.String} object.
     */
    public void setMensajeDado(String mensajeDado) {
        this.mensajeDado = mensajeDado;
    }

    /**
     * <p>Getter for the field <code>telefonoDado</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTelefonoDado() {
        return telefonoDado;
    }

    /**
     * <p>Setter for the field <code>telefonoDado</code>.</p>
     *
     * @param telefonoDado a {@link java.lang.String} object.
     */
    public void setTelefonoDado(String telefonoDado) {
        this.telefonoDado = telefonoDado;
    }

    /**
     * <p>isExito.</p>
     *
     * @return a boolean.
     */
    public boolean isExito() {
        return exito;
    }

    /**
     * <p>Setter for the field <code>exito</code>.</p>
     *
     * @param exito a boolean.
     */
    public void setExito(boolean exito) {
        this.exito = exito;
    }

    /**
     * <p>Getter for the field <code>resultMsg</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * <p>Setter for the field <code>resultMsg</code>.</p>
     *
     * @param resultMsg a {@link java.lang.String} object.
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "SmsResponse [ipCaller=" + ipCaller + ", fechaInvocacon=" + fechaInvocacon + ", mensajeDado="
                + mensajeDado + ", telefonoDado=" + telefonoDado + ", exito=" + exito + ", resultMsg=" + resultMsg
                + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (exito ? 1231 : 1237);
        result = prime * result + ((fechaInvocacon == null) ? 0 : fechaInvocacon.hashCode());
        result = prime * result + ((ipCaller == null) ? 0 : ipCaller.hashCode());
        result = prime * result + ((mensajeDado == null) ? 0 : mensajeDado.hashCode());
        result = prime * result + ((resultMsg == null) ? 0 : resultMsg.hashCode());
        result = prime * result + ((telefonoDado == null) ? 0 : telefonoDado.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SmsResponse other = (SmsResponse) obj;
        if (exito != other.exito)
            return false;
        if (fechaInvocacon == null) {
            if (other.fechaInvocacon != null)
                return false;
        } else if (!fechaInvocacon.equals(other.fechaInvocacon))
            return false;
        if (ipCaller == null) {
            if (other.ipCaller != null)
                return false;
        } else if (!ipCaller.equals(other.ipCaller))
            return false;
        if (mensajeDado == null) {
            if (other.mensajeDado != null)
                return false;
        } else if (!mensajeDado.equals(other.mensajeDado))
            return false;
        if (resultMsg == null) {
            if (other.resultMsg != null)
                return false;
        } else if (!resultMsg.equals(other.resultMsg))
            return false;
        if (telefonoDado == null) {
            if (other.telefonoDado != null)
                return false;
        } else if (!telefonoDado.equals(other.telefonoDado))
            return false;
        return true;
    }
}
