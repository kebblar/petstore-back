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

    /**
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

    /**
     * Getter para idCarrito.
     */
    public int getIdCarrito() {
        return idCarrito;
    }

    /**
     * Setter para idCarrito.
     */
    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    /**
     * Getter para urlImagen.
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * Setter para urlImagen.
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    /**
     * Getter para titulo.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter para titulo.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter para idAnuncio.
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * Setter para idAnuncio.
     */
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * Getter para precio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter para precio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Compara si dos instancias de la clase Atributo son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarritoVista)) return false;
        CarritoVista that = (CarritoVista) o;
        return idCarrito == that.idCarrito && idAnuncio == that.idAnuncio && Double.compare(that.precio, precio) == 0 && Objects.equals(urlImagen, that.urlImagen) && Objects.equals(titulo, that.titulo);
    }

    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCarrito, urlImagen, titulo, idAnuncio, precio);
    }

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
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
