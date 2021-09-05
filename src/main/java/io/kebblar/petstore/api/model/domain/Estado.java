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
 * Nombre:      Estado
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:22:33
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
