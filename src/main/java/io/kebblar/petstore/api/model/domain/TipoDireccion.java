/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TipoDireccion.java
 * Tipo:        clase
 * AUTOR:       Ulises A. Lopez (UAL)
 * Fecha:       Martes 4 de Mayo de 2021 (09_01)
 *
 * Historia:    .
 *              20210504_0901 Actualización de éste POJO
 *              20210511_0839 Actualización de licencia
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'tipo_direccion'.
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
public class TipoDireccion implements Serializable {

    private static final long serialVersionUID = 6627523800922208745L;

    private Integer id;
    private String nombre;
    private boolean activo;

    /**
     * Constructor por default.
     */
    public TipoDireccion() {
    }

    /**
     * Constructor basado en llaves.
     */
    public TipoDireccion(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en atributos.
     */
    public TipoDireccion(Integer id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    /**
     * Getter para id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter para id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter para nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para activo.
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * Setter para activo.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "[TipoDireccion] : [" + " id =" + this.id + " nombre =" + this.nombre + " activo =" + this.activo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TipoDireccion)) {
            return false;
        }
        TipoDireccion other = (TipoDireccion) obj;
        return id == other.id && nombre == other.nombre && activo == other.activo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, activo);
    }

}
