
/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   Estado .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    .
 *              20210504_1735 Creación de éste POJO
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

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private int idPais;
    private String nombre;
    private String nombrePais;

    /**
     * Constructor por default (sin parámetros).
     */
    public Estado() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Estado(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Estado(Integer id, int idPais, String nombre) {
        this.id = id;
        this.idPais = idPais;
        this.nombre = nombre;
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

    /*
     * Getter y Setter.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[Estado] : ["
                + " id =" + this.id
                + " idPais =" + this.idPais
                + " nombre =" + this.nombre
                + "]";
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idPais,
            nombre
        );
    }

}
