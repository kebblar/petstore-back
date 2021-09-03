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
 * Artefacto:   CarritoVista.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (21_41)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'carrito'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CarritoVista {

    /*
     * Atributos de la clase
     */
    private int idCarrito;
    private String urlImagen;
    private String titulo;
    private int idAnuncio;
    private double precio;

    /**
     * Constructor por default (sin parámetros).
     */
    public CarritoVista() { }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public CarritoVista(int idCarrito, String urlImagen, String titulo, int idAnuncio, double precio) {
        this.idCarrito = idCarrito;
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.idAnuncio = idAnuncio;
        this.precio = precio;
    }

    /*
     * Getter y setter.
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarritoVista)) return false;
        CarritoVista that = (CarritoVista) o;
        return idCarrito == that.idCarrito && idAnuncio == that.idAnuncio && Double.compare(that.precio, precio) == 0 && Objects.equals(urlImagen, that.urlImagen) && Objects.equals(titulo, that.titulo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCarrito, urlImagen, titulo, idAnuncio, precio);
    }

    /**
     * {@inheritDoc}
     */
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
