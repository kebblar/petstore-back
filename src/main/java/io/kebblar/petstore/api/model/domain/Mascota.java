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
 * Nombre:      Mascota
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:49:37
 */
package io.kebblar.petstore.api.model.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * <p>Mascota class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class Mascota {

    /*
     * Atributos de la clase.
     */
    @Range(min = 1, max = 13, message = "El ID de la mascota debe ser mínimo {min} y máximo {max}")
    private int id;

    @Size(min = 4, max = 8, message = "El nombre de la mascota debe tener una longitud mínima de {min} y máxima de {max}")
    private String nombre;

    @NotBlank(message="La descripción de la mascota debe ser no vacia")
    private String descripcion;

    /**
     * Constructor por default (sin parámetros).
     */
    public Mascota() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param id a int.
     * @param nombre a {@link java.lang.String} object.
     * @param descripcion a {@link java.lang.String} object.
     */
    public Mascota(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>nombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Setter for the field <code>nombre</code>.</p>
     *
     * @param nombre a {@link java.lang.String} object.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <p>Getter for the field <code>descripcion</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * <p>Setter for the field <code>descripcion</code>.</p>
     *
     * @param descripcion a {@link java.lang.String} object.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Mascota [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mascota other = (Mascota) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    /**
     * Delvuelve el hash del objeto.
     *
     * @return entero hash del objeto
     */
    public int getHash() {
        return this.hashCode();
    }
}
