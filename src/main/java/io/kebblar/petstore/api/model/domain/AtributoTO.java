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
 * Nombre:      AtributoTO
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:13:08
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Descripción:
 * </p>
 * POJO asociado a la entidad 'atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AtributoTO implements Serializable {

    private static final long serialVersionUID = 8063110643925882553L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private String nombre;
    private int activo;
    private List<ValorAtributo> rangos;

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param id a int.
     * @param nombre a {@link java.lang.String} object.
     * @param activo a int.
     */
    public AtributoTO(int id, String nombre, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>nombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Setter for the field <code>nombre</code>.</p>
     *
     * @param nombre a {@link java.lang.String} object.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <p>Getter for the field <code>activo</code>.</p>
     *
     * @return a int.
     */
    public int getActivo() {
        return activo;
    }

    /**
     * <p>Setter for the field <code>activo</code>.</p>
     *
     * @param activo a int.
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }

    /**
     * <p>Getter for the field <code>rangos</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<ValorAtributo> getRangos() {
        return rangos;
    }

    /**
     * <p>Setter for the field <code>rangos</code>.</p>
     *
     * @param rangos a {@link java.util.List} object.
     */
    public void setRangos(List<ValorAtributo> rangos) {
        this.rangos = rangos;
    }

    /**
     * <p>getSerialversionuid.</p>
     *
     * @return a long.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
