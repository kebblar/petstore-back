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
 * Artefacto:   TransaccionBtc.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 13 de junio de 2021 (21_41)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de clase
 *
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

    /**
     * Atributos de la clase
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

    /**
     * Getter para id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para idUsuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Setter para idUsuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Getter para idDireccion.
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Setter para idDireccion.
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Getter para wallet.
     */
    public String getWallet() {
        return wallet;
    }

    /**
     * Setter para wallet.
     */
    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    /**
     * Getter para idPaqueteria.
     */
    public int getIdPaqueteria() {
        return idPaqueteria;
    }

    /**
     * Setter para idPaqueteria.
     */
    public void setIdPaqueteria(int idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }

    /**
     * Getter para status.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Setter para status.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Getter para monto.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Setter para status.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Getter para fecha.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Setter para fecha.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Getter para descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter para descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter para lastBalance.
     */
    public double getLastBalance() {
        return lastBalance;
    }

    /**
     * Setter para lastBalance.
     */
    public void setLastBalance(double lastBalance) {
        this.lastBalance = lastBalance;
    }

    /**
     * Compara si dos instancias de la clase Atributo son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransaccionBtc)) return false;
        TransaccionBtc that = (TransaccionBtc) o;
        return id == that.id && idUsuario == that.idUsuario && idDireccion == that.idDireccion && idPaqueteria == that.idPaqueteria && status == that.status && Double.compare(that.monto, monto) == 0 && Double.compare(that.lastBalance, lastBalance) == 0 && Objects.equals(wallet, that.wallet) && Objects.equals(fecha, that.fecha) && Objects.equals(descripcion, that.descripcion);
    }

    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idDireccion, wallet, idPaqueteria, status, monto, fecha, descripcion, lastBalance);
    }

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
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
