/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.model
 * Modulo:      Estado
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'estado'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'estado'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
public class Estado implements Serializable {

    private static final long serialVersionUID = -4082525936309639098L;

    private Integer id;
    private int idPais;
    private String nombre;

    /**
     * Constructor por default.
     */
    public Estado() {
    }

    /**
     * Constructor basado en llaves.
     */
    public Estado(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en atributos.
     */
    public Estado(Integer id, int idPais, String nombre) {
        this.id = id;
        this.idPais = idPais;
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
     * Getter para idPais.
     */
    public int getIdPais() {
        return idPais;
    }
    
    /**
     * Setter para idPais.
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
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
        return "[Estado] : ["
                + " id =" + this.id
                + " idPais =" + this.idPais
                + " nombre =" + this.nombre
                + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) obj;
        return
               id == other.id && 
               idPais == other.idPais && 
               nombre == other.nombre; 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            idPais, 
            nombre
        );
    }

}
