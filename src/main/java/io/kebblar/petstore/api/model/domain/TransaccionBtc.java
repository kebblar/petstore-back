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
 * Nombre:      TransaccionBtc
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:52:52
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'transaccionBtc'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class TransaccionBtc {

    /*
     * Atributos de la clase.
     */
    private int id;
    private int idUsuario;
    private int idDireccion;
    private String wallet;
    private int idPaqueteria;
    private boolean status;
    private double monto;
    private Date fecha;
    private String descripcion;
    private double lastBalance;

    /**
     * Constructor por default (sin parámetros).
     */
    public TransaccionBtc() {
    }

    /**
     * Constructor basado en parámetros de la clase.
     *
     * @param id a int.
     * @param idUsuario a int.
     * @param idDireccion a int.
     * @param wallet a {@link java.lang.String} object.
     * @param idPaqueteria a int.
     * @param status a boolean.
     * @param monto a double.
     * @param fecha a {@link java.util.Date} object.
     * @param descripcion a {@link java.lang.String} object.
     * @param lastBalance a double.
     */
    public TransaccionBtc(int id, int idUsuario, int idDireccion, String wallet, int idPaqueteria, boolean status, double monto, Date fecha, String descripcion, double lastBalance) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
        this.wallet = wallet;
        this.idPaqueteria = idPaqueteria;
        this.status = status;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.lastBalance = lastBalance;
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

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
     * <p>Getter for the field <code>wallet</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getWallet() {
        return wallet;
    }

    /**
     * <p>Setter for the field <code>wallet</code>.</p>
     *
     * @param wallet a {@link java.lang.String} object.
     */
    public void setWallet(String wallet) {
        this.wallet = wallet;
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
     * <p>isStatus.</p>
     *
     * @return a boolean.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * <p>Setter for the field <code>status</code>.</p>
     *
     * @param status a boolean.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * <p>Getter for the field <code>monto</code>.</p>
     *
     * @return a double.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * <p>Setter for the field <code>monto</code>.</p>
     *
     * @param monto a double.
     */
    public void setMonto(double monto) {
        this.monto = monto;
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
     * <p>Getter for the field <code>lastBalance</code>.</p>
     *
     * @return a double.
     */
    public double getLastBalance() {
        return lastBalance;
    }

    /**
     * <p>Setter for the field <code>lastBalance</code>.</p>
     *
     * @param lastBalance a double.
     */
    public void setLastBalance(double lastBalance) {
        this.lastBalance = lastBalance;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransaccionBtc)) return false;
        TransaccionBtc that = (TransaccionBtc) o;
        return id == that.id && idUsuario == that.idUsuario && idDireccion == that.idDireccion && idPaqueteria == that.idPaqueteria && status == that.status && Double.compare(that.monto, monto) == 0 && Double.compare(that.lastBalance, lastBalance) == 0 && Objects.equals(wallet, that.wallet) && Objects.equals(fecha, that.fecha) && Objects.equals(descripcion, that.descripcion);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idDireccion, wallet, idPaqueteria, status, monto, fecha, descripcion, lastBalance);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "TransaccionBtc{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idDireccion=" + idDireccion +
                ", wallet='" + wallet + '\'' +
                ", idPaqueteria=" + idPaqueteria +
                ", status=" + status +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", lastBalance=" + lastBalance +
                '}';
    }
}
