package io.kebblar.petstore.api.model.domain;

import java.util.Date;
import java.util.Objects;

public class TransaccionBtc {

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

    public TransaccionBtc() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public int getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(int idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(double lastBalance) {
        this.lastBalance = lastBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransaccionBtc)) return false;
        TransaccionBtc that = (TransaccionBtc) o;
        return id == that.id && idUsuario == that.idUsuario && idDireccion == that.idDireccion && idPaqueteria == that.idPaqueteria && status == that.status && Double.compare(that.monto, monto) == 0 && Double.compare(that.lastBalance, lastBalance) == 0 && Objects.equals(wallet, that.wallet) && Objects.equals(fecha, that.fecha) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idDireccion, wallet, idPaqueteria, status, monto, fecha, descripcion, lastBalance);
    }

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
