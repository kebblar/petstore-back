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
 * Artefacto:   Categoria.java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (00_02)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210605_0002 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'categoria'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Categoria implements Serializable {

    private static final long serialVersionUID = 7174821499103256578L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private String categoria;
    private int activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public Categoria() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Categoria(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Categoria(Integer id, String categoria, int activo) {
        this.id = id;
        this.categoria = categoria;
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
     * Getter para categoria.
     */
    public String getCategoria() {
        return categoria;
    }
    
    /**
     * Setter para categoria.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        return "[Categoria] : ["
                + " id =" + this.id
                + " categoria =" + this.categoria
                + " activo =" + this.activo
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase Categoria son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) obj;
        return
               id == other.id && 
               categoria == other.categoria && 
               activo == other.activo; 
    }
    
    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            categoria, 
            activo
        );
    }

}
