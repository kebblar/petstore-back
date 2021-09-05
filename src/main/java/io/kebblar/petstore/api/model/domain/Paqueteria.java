/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Paqueteria
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:50:49
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'paqueteria'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class Paqueteria implements Serializable {

    private static final long serialVersionUID = 4781082860740788585L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private String nombre;
    private String breveDescripcion;
    private String htmlDescripcion;
    private int precio;

    /**
     * Constructor por default (sin parámetros).
     */
    public Paqueteria() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Paqueteria(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Paqueteria(Integer id, String nombre, String breveDescripcion, String htmlDescripcion, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.breveDescripcion = breveDescripcion;
        this.htmlDescripcion = htmlDescripcion;
        this.precio = precio;
    }

    /*
     * Setter y Getter.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getHtmlDescripcion() {
        return htmlDescripcion;
    }

    public void setHtmlDescripcion(String htmlDescripcion) {
        this.htmlDescripcion = htmlDescripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[Paqueteria] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " breveDescripcion =" + this.breveDescripcion
                + " htmlDescripcion =" + this.htmlDescripcion
                + " precio =" + this.precio
                + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paqueteria)) {
            return false;
        }
        Paqueteria other = (Paqueteria) obj;
        return
               id == other.id &&
               nombre == other.nombre &&
               breveDescripcion == other.breveDescripcion &&
               htmlDescripcion == other.htmlDescripcion &&
               precio == other.precio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            nombre,
            breveDescripcion,
            htmlDescripcion,
            precio
        );
    }

}
