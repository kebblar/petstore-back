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
 * Tipo:        Clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_25)
 *
 * Historia:    .
 *              0210506_0925 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'TipoDireccion'.
 * 
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class TipoDireccion implements Serializable {
	private static final long serialVersionUID = 6627523800922208745L;

    private Integer id;
    private String nombre;
    private boolean activo;

    public TipoDireccion() {
    }

    public TipoDireccion(Integer id) {
        this.id = id;
    }

    public TipoDireccion(Integer id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

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
    
    @Override
    public String toString() {
        return "[TipoDireccion] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " activo =" + this.activo
                + "]";
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
        return
               id == other.id && 
               nombre == other.nombre && 
               activo == other.activo; 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            nombre, 
            activo
        );
    }
}
