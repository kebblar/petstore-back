/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Estado.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 4 de Mayo de 2021 (17_35)
 *
 * Historia:    .
 *              20210504_1735 Creación de éste POJO.
 *              20210516_0215 Inclusion de atributo nombrePais.
 *              20210516_0235 Inclusion de un nuevo constructor
 *                            que capta el parameto nombrePais.
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link Estado}.
 * 
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Estado implements Serializable {
    private static final long serialVersionUID = -4082525936309639098L;

    private Integer id;
    private int idPais;
    private String nombre;
    private String nombrePais;

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
     * Constructor basado en atributos temporales para el nombre del Pais.
     */
    public Estado(Integer id, int idPais, String nombre, String nombrePais) {
        this.id = id;
        this.idPais = idPais;
        this.nombre = nombre;
        this.nombrePais = nombrePais;
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
    
    /**
     * Getter para nombrePais.
     */
    public String getNombrePais() {
		return nombrePais;
	}
    
    /**
     * Setter para nombrePais.
     */
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@Override
    public String toString() {
        return "[Estado] : ["
                + " id =" + this.id
                + " idPais =" + this.idPais
                + " nombre =" + this.nombre
                + " nombrePais =" + this.nombrePais
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
               nombrePais == other.nombrePais && 
               nombre == other.nombre; 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            idPais, 
            nombre,
            nombrePais
        );
    }

}
