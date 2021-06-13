
/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   DatosOrden .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo, Daniel Alvarez
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'orden_compra'.
 *
 * @author Fhernanda Romo, Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class DatosOrden implements Serializable {
    private static final long serialVersionUID = -6032711964621903590L;
    /**
     * Atributos de la clase
     */

    private int idUsuario;
    private int idDireccion;
    private int idPaqueteria;
    private int idMetodoPago;
    private int idMoneda;
    private String cveOrdenCompra;
    private Date fecha;
    private boolean estadoEnvio;
    private long total;
    private String descripcion;
    private String recibo;

    /**
     * Constructor por default (sin parámetros).
     */
    public DatosOrden() {
    }

    public DatosOrden(int idUsuario, int idDireccion, int idPaqueteria, int idMetodoPago, int idMoneda, String cveOrdenCompra, Date fecha, boolean estadoEnvio, long total, String descripcion, String recibo) {
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
        this.idPaqueteria = idPaqueteria;
        this.idMetodoPago = idMetodoPago;
        this.idMoneda = idMoneda;
        this.cveOrdenCompra = cveOrdenCompra;
        this.fecha = fecha;
        this.estadoEnvio = estadoEnvio;
        this.total = total;
        this.descripcion = descripcion;
        this.recibo = recibo;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idDireccion
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * @param idDireccion the idDireccion to set
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * @return the idPaqueteria
     */
    public int getIdPaqueteria() {
        return idPaqueteria;
    }

    /**
     * @param idPaqueteria the idPaqueteria to set
     */
    public void setIdPaqueteria(int idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }

    public boolean isEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(boolean estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idMoneda
     */
    public int getIdMoneda() {
        return idMoneda;
    }

    /**
     * @param idMoneda the idMoneda to set
     */
    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idMetodoPago
     */
    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    /**
     * @param idMetodoPago the idMetodoPago to set
     */
    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    /**
     * @return the recibo
     */
    public String getRecibo() {
        return recibo;
    }

    /**
     * @param recibo the recibo to set
     */
    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    /**
     * @return the cveOrdenCompra
     */
    public String getCveOrdenCompra() {
        return cveOrdenCompra;
    }

    /**
     * @param cveOrdenCompra the cveOrdenCompra to set
     */
    public void setCveOrdenCompra(String cveOrdenCompra) {
        this.cveOrdenCompra = cveOrdenCompra;
    }



    public long getTotal() {
        return total;
    }



    public void setTotal(long total) {
        this.total = total;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosOrden)) return false;
        DatosOrden that = (DatosOrden) o;
        return idUsuario == that.idUsuario && idDireccion == that.idDireccion && idPaqueteria == that.idPaqueteria && idMetodoPago == that.idMetodoPago && idMoneda == that.idMoneda && estadoEnvio == that.estadoEnvio && total == that.total && cveOrdenCompra.equals(that.cveOrdenCompra) && fecha.equals(that.fecha) && descripcion.equals(that.descripcion) && recibo.equals(that.recibo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDireccion, idPaqueteria, idMetodoPago, idMoneda, cveOrdenCompra, fecha, estadoEnvio, total, descripcion, recibo);
    }

    @Override
    public String toString() {
        return "DatosOrden{" +
                ", idUsuario=" + idUsuario +
                ", idDireccion=" + idDireccion +
                ", idPaqueteria=" + idPaqueteria +
                ", idMetodoPago=" + idMetodoPago +
                ", idMoneda=" + idMoneda +
                ", cveOrdenCompra='" + cveOrdenCompra + '\'' +
                ", fecha=" + fecha +
                ", estadoEnvio=" + estadoEnvio +
                ", total=" + total +
                ", descripcion='" + descripcion + '\'' +
                ", recibo='" + recibo + '\'' +
                '}';
    }
}