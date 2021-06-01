package io.kebblar.petstore.api.model.domain;

import java.util.Date;
import java.util.Objects;

public class TransaccionBtc {

    private int id;
    private int idUsuario;
    private int idDireccion;
    private String wallet;
    private int idAnuncio;
    private boolean status;
    private double monto;
    private Date fecha;
    private String descripcion;

    public TransaccionBtc() {
    }

    public TransaccionBtc(int id, int idUsuario, int idDireccion, String wallet, int idAnuncio, boolean status, double monto, Date fecha, String descripcion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
        this.wallet = wallet;
        this.idAnuncio = idAnuncio;
        this.status = status;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
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

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransaccionBtc)) return false;
        TransaccionBtc that = (TransaccionBtc) o;
        return id == that.id && idUsuario == that.idUsuario && idDireccion == that.idDireccion && idAnuncio == that.idAnuncio && status == that.status && Double.compare(that.monto, monto) == 0 && Objects.equals(wallet, that.wallet) && Objects.equals(fecha, that.fecha) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idDireccion, wallet, idAnuncio, status, monto, fecha, descripcion);
    }

    @Override
    public String toString() {
        return "TransaccionBtc{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idDireccion=" + idDireccion +
                ", wallet='" + wallet + '\'' +
                ", idAnuncio=" + idAnuncio +
                ", status=" + status +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
