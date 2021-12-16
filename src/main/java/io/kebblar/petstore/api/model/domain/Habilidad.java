
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
 * Artefacto:   Habilidad .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Wednesday 12 de December de 2021 (16_27)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20211215_1627 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'habilidad'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Habilidad implements Serializable {

    private static final long serialVersionUID = -7994371003871238060L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private String nombre;
    private int activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public Habilidad() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Habilidad(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Habilidad(Integer id, String nombre, int activo) {
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
    public int getActivo() {
        return activo;
    }
    
    /**
     * Setter para activo.
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }
    

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[Habilidad] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " activo =" + this.activo
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase Habilidad son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Habilidad)) {
            return false;
        }
        Habilidad other = (Habilidad) obj;
        return
               id == other.id && 
               nombre == other.nombre && 
               activo == other.activo; 
    }
    
    /**
     * Genera un hash del objeto
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
