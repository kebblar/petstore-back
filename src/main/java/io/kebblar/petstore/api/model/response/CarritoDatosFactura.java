package io.kebblar.petstore.api.model.response;

import java.util.Objects;

public class CarritoDatosFactura {

    private String titulo;
    private double precio;
    private String descripcion;

    public CarritoDatosFactura(){}

    public CarritoDatosFactura(String titulo, double precio, String descripcion) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        if (!(o instanceof CarritoDatosFactura)) return false;
        CarritoDatosFactura that = (CarritoDatosFactura) o;
        return Double.compare(that.precio, precio) == 0 && Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, precio, descripcion);
    }

    @Override
    public String toString() {
        return "CarritoDatosFactura{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
