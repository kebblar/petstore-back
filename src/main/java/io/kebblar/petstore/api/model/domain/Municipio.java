/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 * Artefacto:   Municipio.java
 * Tipo:        clase 
 * Autor:       Francisco Javier Moreno Romero (FJMR)
 * Fecha:       Viernes 7 de Mayo de 2021 08:34pm 
 *
 * Historia:    .
 *              20210421_0935 Creación de éste POJO
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'municipio'. 
 *
 * @author javier
 * @version 1.0-SNAPSHOT
 */
public class Municipio implements Serializable {

    private static final long serialVersionUID = 4029696770607420120L;

    private Integer id;
    private int idEstado;
    private String nombre;

    /**
     * Constructor por default.
     */
    public Municipio() {
    }

    /**
     * Constructor basado en llaves.
     */
    public Municipio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en atributos.
     */
    public Municipio(Integer id, int idEstado, String nombre) {
        this.id = id;
        this.idEstado = idEstado;
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
     * Getter para idEstado.
     */
    public int getIdEstado() {
        return idEstado;
    }
    
    /**
     * Setter para idEstado.
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
        return "[Municipio] : ["
                + " id =" + this.id
                + " idEstado =" + this.idEstado
                + " nombre =" + this.nombre
                + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) obj;
        return
               id == other.id && 
               idEstado == other.idEstado && 
               nombre == other.nombre; 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            idEstado, 
            nombre
        );
    }

}
