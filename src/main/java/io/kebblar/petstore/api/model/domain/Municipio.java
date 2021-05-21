/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Municipio.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (23_21)
 *
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
 *              20210516_0215 Inclusion de atributo nombrePais
 *              20210516_0215 Inclusion de atributo nombreEstado
 *              20210516_0235 Inclusion de un nuevo constructor que caepta el parameto nombrePais y nombreEstado
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'municipio'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
public class Municipio implements Serializable {

    private static final long serialVersionUID = 4029696770607420120L;

    private Integer id;
    private int idEstado;
    private String nombre;
    private String nombrePais;
    private String nombreEstado;

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
     * Constructor basado en atributos temporales para el nombre del Estado.
     */
    public Municipio(Integer id, int idEstado, String nombre, String nombrePais, String nombreEstado) {
        this.id = id;
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.nombrePais = nombrePais;
        this.nombreEstado = nombreEstado;
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

    /**
     * Getter para nombreEstado.
     */
	public String getNombreEstado() {
		return nombreEstado;
	}

    /**
     * Setter para nombreEstado.
     */
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	@Override
    public String toString() {
        return "[Municipio] : ["
                + " id =" + this.id
                + " idEstado =" + this.idEstado
                + " nombre =" + this.nombre
                + " nombrePais =" + this.nombrePais
                + " nombreEstado =" + this.nombreEstado
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
