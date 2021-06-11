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
 * Artefacto:   EstatusAnuncio .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (00_13)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210606_0013 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'estatus_anuncio'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class EstatusAnuncio implements Serializable {

    private static final long serialVersionUID = -3861741201718250311L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private String descripcion;

    /**
     * Constructor por default (sin parámetros).
     */
    public EstatusAnuncio() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public EstatusAnuncio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public EstatusAnuncio(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
     * Getter para descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Setter para descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[EstatusAnuncio] : ["
                + " id =" + this.id
                + " descripcion =" + this.descripcion
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase EstatusAnuncio son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EstatusAnuncio)) {
            return false;
        }
        EstatusAnuncio other = (EstatusAnuncio) obj;
        return
               id == other.id && 
               descripcion == other.descripcion; 
    }
    
    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            descripcion
        );
    }

}
