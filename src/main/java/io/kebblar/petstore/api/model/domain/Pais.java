/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Pais.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (23_21)
 *
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link Pais}.
 * 
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Pais implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    private Integer id;
    private String nombre;

    /**
     * Constructor por default.
     */
    public Pais() {
    }

    /**
     * Constructor basado en llaves.
     */
    public Pais(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en atributos.
     */
    public Pais(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    
    @Override
    public String toString() {
        return "[Pais] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) obj;
        return
               id == other.id && 
               nombre == other.nombre; 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            nombre
        );
    }

}
