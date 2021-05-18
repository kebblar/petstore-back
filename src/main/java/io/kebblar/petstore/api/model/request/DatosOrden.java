package io.kebblar.petstore.api.model.request;

import java.util.Date;
import java.util.Objects;

public class DatosOrden {

    private int idUsuario;
    private int idDireccion;
    private int idPaqueteria;
    private String descripcion;
    private int idMoneda;
    private int idAnuncio;
    private long precio;
    private int total;
    private Date fecha;

    public DatosOrden() {
    }

    public DatosOrden(int idUsuario, int idDireccion, int idPaqueteria, String descripcion, int idMoneda, int idAnuncio, long precio, int total, Date fecha) {
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
        this.idPaqueteria = idPaqueteria;
        this.descripcion = descripcion;
        this.idMoneda = idMoneda;
        this.idAnuncio = idAnuncio;
        this.precio = precio;
        this.total = total;
        this.fecha = fecha;
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

    public int getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(int idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
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

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosOrden)) return false;
        DatosOrden that = (DatosOrden) o;
        return idUsuario == that.idUsuario && idDireccion == that.idDireccion && idPaqueteria == that.idPaqueteria && idMoneda == that.idMoneda && idAnuncio == that.idAnuncio && precio == that.precio && total == that.total && Objects.equals(descripcion, that.descripcion) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDireccion, idPaqueteria, descripcion, idMoneda, idAnuncio, precio, total, fecha);
    }

    @Override
    public String toString() {
        return "DatosOrden{" +
                "idUsuario=" + idUsuario +
                ", idDireccion=" + idDireccion +
                ", idPaqueteria=" + idPaqueteria +
                ", descripcion='" + descripcion + '\'' +
                ", idMoneda=" + idMoneda +
                ", idAnuncio=" + idAnuncio +
                ", precio=" + precio +
                ", total=" + total +
                ", fecha=" + fecha +
                '}';
    }
}