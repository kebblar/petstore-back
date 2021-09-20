/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
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
     *
     * @param idUsuario a int.
     * @param idDireccion a int.
     * @param idPaqueteria a int.
     * @param idMetodoPago a int.
     * @param idMoneda a int.
     * @param cveOrdenCompra a {@link java.lang.String} object.
     * @param fecha a {@link java.util.Date} object.
     * @param estadoEnvio a boolean.
     * @param total a long.
     * @param descripcion a {@link java.lang.String} object.
     * @param recibo a {@link java.lang.String} object.
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
    /**
     * <p>Getter for the field <code>idUsuario</code>.</p>
     *
     * @return a int.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * <p>Setter for the field <code>idUsuario</code>.</p>
     *
     * @param idUsuario a int.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * <p>Getter for the field <code>idDireccion</code>.</p>
     *
     * @return a int.
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * <p>Setter for the field <code>idDireccion</code>.</p>
     *
     * @param idDireccion a int.
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * <p>Getter for the field <code>idPaqueteria</code>.</p>
     *
     * @return a int.
     */
    public int getIdPaqueteria() {
        return idPaqueteria;
    }

    /**
     * <p>Setter for the field <code>idPaqueteria</code>.</p>
     *
     * @param idPaqueteria a int.
     */
    public void setIdPaqueteria(int idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }

    /**
     * <p>isEstadoEnvio.</p>
     *
     * @return a boolean.
     */
    public boolean isEstadoEnvio() {
        return estadoEnvio;
    }

    /**
     * <p>Setter for the field <code>estadoEnvio</code>.</p>
     *
     * @param estadoEnvio a boolean.
     */
    public void setEstadoEnvio(boolean estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    /**
     * <p>Getter for the field <code>descripcion</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * <p>Setter for the field <code>descripcion</code>.</p>
     *
     * @param descripcion a {@link java.lang.String} object.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * <p>Getter for the field <code>idMoneda</code>.</p>
     *
     * @return a int.
     */
    public int getIdMoneda() {
        return idMoneda;
    }

    /**
     * <p>Setter for the field <code>idMoneda</code>.</p>
     *
     * @param idMoneda a int.
     */
    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    /**
     * <p>Getter for the field <code>fecha</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * <p>Setter for the field <code>fecha</code>.</p>
     *
     * @param fecha a {@link java.util.Date} object.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * <p>Getter for the field <code>idMetodoPago</code>.</p>
     *
     * @return a int.
     */
    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    /**
     * <p>Setter for the field <code>idMetodoPago</code>.</p>
     *
     * @param idMetodoPago a int.
     */
    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    /**
     * <p>Getter for the field <code>recibo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRecibo() {
        return recibo;
    }

    /**
     * <p>Setter for the field <code>recibo</code>.</p>
     *
     * @param recibo a {@link java.lang.String} object.
     */
    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    /**
     * <p>Getter for the field <code>cveOrdenCompra</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCveOrdenCompra() {
        return cveOrdenCompra;
    }

    /**
     * <p>Setter for the field <code>cveOrdenCompra</code>.</p>
     *
     * @param cveOrdenCompra a {@link java.lang.String} object.
     */
    public void setCveOrdenCompra(String cveOrdenCompra) {
        this.cveOrdenCompra = cveOrdenCompra;
    }

    /**
     * <p>Getter for the field <code>total</code>.</p>
     *
     * @return a long.
     */
    public long getTotal() {
        return total;
    }

    /**
     * <p>Setter for the field <code>total</code>.</p>
     *
     * @param total a long.
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosOrden)) return false;
        DatosOrden that = (DatosOrden) o;
        return idUsuario == that.idUsuario && idDireccion == that.idDireccion && idPaqueteria == that.idPaqueteria && idMetodoPago == that.idMetodoPago && idMoneda == that.idMoneda && estadoEnvio == that.estadoEnvio && total == that.total && cveOrdenCompra.equals(that.cveOrdenCompra) && fecha.equals(that.fecha) && descripcion.equals(that.descripcion) && recibo.equals(that.recibo);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDireccion, idPaqueteria, idMetodoPago, idMoneda, cveOrdenCompra, fecha, estadoEnvio, total, descripcion, recibo);
    }

    /** {@inheritDoc} */
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
