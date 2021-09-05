/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Municipio
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:50:21
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'municipio'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Municipio implements Serializable {
    private static final long serialVersionUID = 5007490559310553080L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private int idEstado;
    private String nombre;
    private String nombrePais;
    private String nombreEstado;

    /**
     * Constructor por default (sin parámetros).
     */
    public Municipio() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Municipio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Municipio(Integer id, int idEstado, String nombre) {
        this.id = id;
        this.idEstado = idEstado;
        this.nombre = nombre;
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

    /*
     * Getter y Setter.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idEstado,
            nombre
        );
    }

}
