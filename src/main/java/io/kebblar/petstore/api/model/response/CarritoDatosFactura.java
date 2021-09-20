/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CarritoDatosFactura
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:02:51
 */
package io.kebblar.petstore.api.model.response;

import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'CarritoDatosFactura'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CarritoDatosFactura {

    /**
     * Atributos de la clase
     */
    private String titulo;
    private double precio;
    private String descripcion;

    /**
     * Constructor por default (sin parámetros).
     */
    public CarritoDatosFactura(){}

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param titulo a {@link java.lang.String} object.
     * @param precio a double.
     * @param descripcion a {@link java.lang.String} object.
     */
    public CarritoDatosFactura(String titulo, double precio, String descripcion) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    /**
     * Getter para titulo.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter para titulo.
     *
     * @param titulo a {@link java.lang.String} object.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter para precio.
     *
     * @return a double.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter para precio.
     *
     * @param precio a double.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Getter para descripción.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter para descripción.
     *
     * @param descripcion a {@link java.lang.String} object.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * {@inheritDoc}
     *
     * <p>Compara si dos instancias de la clase Atributo son iguales.</p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarritoDatosFactura)) return false;
        CarritoDatosFactura that = (CarritoDatosFactura) o;
        return Double.compare(that.precio, precio) == 0 && Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion);
    }

    /**
     * {@inheritDoc}
     *
     * <p>Genera un hash del objeto.</p>
     */
    @Override
    public int hashCode() {
        return Objects.hash(titulo, precio, descripcion);
    }

    /**
     * {@inheritDoc}
     *
     * <p>Método toString para el pojo, representa al objeto en forma de cadena.</p>
     */
    @Override
    public String toString() {
        return "CarritoDatosFactura{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
