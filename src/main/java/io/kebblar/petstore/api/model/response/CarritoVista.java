package io.kebblar.petstore.api.model.response;

import java.util.Objects;

public class CarritoVista {

    private int idCarrito;
    private String urlImagen;
    private String titulo;
    private int idAnuncio;
    private double precio;

    public CarritoVista() { }

    public CarritoVista(int idCarrito, String urlImagen, String titulo, int idAnuncio, double precio) {
        this.idCarrito = idCarrito;
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.idAnuncio = idAnuncio;
        this.precio = precio;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarritoVista)) return false;
        CarritoVista that = (CarritoVista) o;
        return idCarrito == that.idCarrito && idAnuncio == that.idAnuncio && Double.compare(that.precio, precio) == 0 && Objects.equals(urlImagen, that.urlImagen) && Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarrito, urlImagen, titulo, idAnuncio, precio);
    }

    @Override
    public String toString() {
        return "CarritoVista{" +
                "idCarrito=" + idCarrito +
                ", urlImagen='" + urlImagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", idAnuncio=" + idAnuncio +
                ", precio=" + precio +
                '}';
    }
}
