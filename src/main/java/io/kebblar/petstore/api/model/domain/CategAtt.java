
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
 * Artefacto:   CategAtt .java
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
 * POJO asociado a la entidad 'categ_att'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CategAtt implements Serializable {

    private static final long serialVersionUID = -681611276442828426L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private int idCategoria;
    private String leyenda;
    private int activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public CategAtt() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public CategAtt(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public CategAtt(Integer id, int idCategoria, String leyenda, int activo) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.leyenda = leyenda;
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
     * Getter para idCategoria.
     */
    public int getIdCategoria() {
        return idCategoria;
    }
    
    /**
     * Setter para idCategoria.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    /**
     * Getter para valor.
     */
    public String getLeyenda() {
        return leyenda;
    }
    
    /**
     * Setter para leyenda.
     */
    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
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
        return "[CategAtt] : ["
                + " id =" + this.id
                + " idCategoria =" + this.idCategoria
                + " leyenda =" + this.leyenda
                + " activo =" + this.activo
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase CategAtt son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategAtt)) {
            return false;
        }
        CategAtt other = (CategAtt) obj;
        return
               id == other.id && 
               idCategoria == other.idCategoria && 
               leyenda.equals(other.leyenda) && 
               activo == other.activo; 
    }
    
    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            idCategoria, 
            leyenda, 
            activo
        );
    }

}
