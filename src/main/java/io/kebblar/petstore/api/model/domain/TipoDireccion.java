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
 * Nombre:      TipoDireccion
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:52:44
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementación del POJO de la entidad de 'TipoDireccion'.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class TipoDireccion implements Serializable {
    private static final long serialVersionUID = 6627523800922208745L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private String nombre;
    private boolean activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public TipoDireccion() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public TipoDireccion(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public TipoDireccion(Integer id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    /*
     * Getter y Setter.
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[TipoDireccion] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " activo =" + this.activo
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
        if (!(obj instanceof TipoDireccion)) {
            return false;
        }
        TipoDireccion other = (TipoDireccion) obj;
        return
               id == other.id &&
               nombre == other.nombre &&
               activo == other.activo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            nombre,
            activo
        );
    }
}
