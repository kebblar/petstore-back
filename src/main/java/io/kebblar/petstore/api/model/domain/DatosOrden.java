/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      DatosOrden
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:17:53
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'orden_compra'.
 *
 * @author Fhernanda Romo, Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class DatosOrden implements Serializable {

    private static final long serialVersionUID = -6032711964621903590L;

    /*
     * Atributos de la clase.
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

    /**
     * Constructor basado en los atributos de la clase.
     */
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

    /*
     * Setter y Getter.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(int idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }

    public boolean isEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(boolean estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getCveOrdenCompra() {
        return cveOrdenCompra;
    }

    public void setCveOrdenCompra(String cveOrdenCompra) {
        this.cveOrdenCompra = cveOrdenCompra;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosOrden)) return false;
        DatosOrden that = (DatosOrden) o;
        return idUsuario == that.idUsuario && idDireccion == that.idDireccion && idPaqueteria == that.idPaqueteria && idMetodoPago == that.idMetodoPago && idMoneda == that.idMoneda && estadoEnvio == that.estadoEnvio && total == that.total && cveOrdenCompra.equals(that.cveOrdenCompra) && fecha.equals(that.fecha) && descripcion.equals(that.descripcion) && recibo.equals(that.recibo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDireccion, idPaqueteria, idMetodoPago, idMoneda, cveOrdenCompra, fecha, estadoEnvio, total, descripcion, recibo);
    }

    /**
     * {@inheritDoc}
     */
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
