/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
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

    public SmsResponse() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     * @param ipCaller
     * @param fechaInvocacon
     * @param mensajeDado
     * @param telefonoDado
     * @param exito
     * @param resultMsg
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

    public String getIpCaller() {
        return ipCaller;
    }

    public void setIpCaller(String ipCaller) {
        this.ipCaller = ipCaller;
    }

    public String getFechaInvocacon() {
        return fechaInvocacon;
    }

    public void setFechaInvocacon(String fechaInvocacon) {
        this.fechaInvocacon = fechaInvocacon;
    }

    public String getMensajeDado() {
        return mensajeDado;
    }

    public void setMensajeDado(String mensajeDado) {
        this.mensajeDado = mensajeDado;
    }

    public String getTelefonoDado() {
        return telefonoDado;
    }

    public void setTelefonoDado(String telefonoDado) {
        this.telefonoDado = telefonoDado;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return "SmsResponse [ipCaller=" + ipCaller + ", fechaInvocacon=" + fechaInvocacon + ", mensajeDado="
                + mensajeDado + ", telefonoDado=" + telefonoDado + ", exito=" + exito + ", resultMsg=" + resultMsg
                + "]";
    }

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
