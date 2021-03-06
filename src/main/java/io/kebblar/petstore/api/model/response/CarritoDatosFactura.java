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
 * Artefacto:   CarritoDatosFactura.java
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
