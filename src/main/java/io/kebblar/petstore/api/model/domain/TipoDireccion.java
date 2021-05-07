/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.model
 * Modulo:      TipoDireccion
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'tipo_direccion'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *              20210506_2015 Documentacion
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

public class TipoDireccion implements Serializable {
	
	/**
	 * <p>Descripción:</p>
	 * POJO asociado a la entidad 'tipo_direccion'. 
	 *
	 * @author Gustavo A. Arellano
	 * @version 1.0-SNAPSHOT
	 */
	
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
