package io.kebblar.petstore.api.model.request;

import java.util.Objects;

public class CarritoCompraRequest {

    private int idUsuario;
    private String cveOrdenCompra;

    public CarritoCompraRequest () { }

    public CarritoCompraRequest(int idUsuario, String cveOrdenCompra) {
        this.idUsuario = idUsuario;
        this.cveOrdenCompra = cveOrdenCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCveOrdenCompra() {
        return cveOrdenCompra;
    }

    public void setCveOrdenCompra(String cveOrdenCompra) {
        this.cveOrdenCompra = cveOrdenCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarritoCompraRequest)) return false;
        CarritoCompraRequest that = (CarritoCompraRequest) o;
        return idUsuario == that.idUsuario && Objects.equals(cveOrdenCompra, that.cveOrdenCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, cveOrdenCompra);
    }

    @Override
    public String toString() {
        return "CarritoCompraRequest{" +
                "idUsuario=" + idUsuario +
                ", cveOrdenCompra='" + cveOrdenCompra + '\'' +
                '}';
    }
}
