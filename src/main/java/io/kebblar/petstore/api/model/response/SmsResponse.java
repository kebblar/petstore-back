/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   SmsResponse.java
 * Tipo:        clase
 * AUTOR:       Daniel Alvarez (DA)
 * Fecha:       20 de Junio de 2021
 *
 * Historia:    20210620_0938 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'SmsResponse'.
 *
 * @author  Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class SmsResponse {

    /*
     * Atributos de la clase.
     */
    private String ipCaller;
    private String fechaInvocacon;
    private String mensajeDado;
    private String telefonoDado;
    private boolean exito;
    private String resultMsg;

    /**
     * Constructor por defecto.
     */
    public SmsResponse() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
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

    /*
     * Getter y setter.
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SmsResponse [ipCaller=" + ipCaller + ", fechaInvocacon=" + fechaInvocacon + ", mensajeDado="
                + mensajeDado + ", telefonoDado=" + telefonoDado + ", exito=" + exito + ", resultMsg=" + resultMsg
                + "]";
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsResponse)) return false;
        SmsResponse that = (SmsResponse) o;
        return exito == that.exito && Objects.equals(ipCaller, that.ipCaller) && Objects.equals(fechaInvocacon, that.fechaInvocacon)
                && Objects.equals(mensajeDado, that.mensajeDado) && Objects.equals(telefonoDado, that.telefonoDado)
                && Objects.equals(resultMsg, that.resultMsg);
    }
}
