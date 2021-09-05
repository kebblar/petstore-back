/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
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
     */
    public CarritoDatosFactura(String titulo, double precio, String descripcion) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
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
     * Compara si dos instancias de la clase Atributo son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarritoDatosFactura)) return false;
        CarritoDatosFactura that = (CarritoDatosFactura) o;
        return Double.compare(that.precio, precio) == 0 && Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion);
    }

    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(titulo, precio, descripcion);
    }

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
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
