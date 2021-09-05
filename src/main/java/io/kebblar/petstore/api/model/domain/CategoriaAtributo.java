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
 * Nombre:      CategoriaAtributo
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:14:04
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'categoria_atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CategoriaAtributo implements Serializable {

    private static final long serialVersionUID = 2560581152871158325L;

    /*
     * Atributos de la clase.
     */
    private Integer idCategoria;
    private Integer idAtributo;
    private String nombreAtributo;


    /**
     * Constructor por default (sin parámetros).
     */
    public CategoriaAtributo() {
    }

    /**
     * Constructor basado en la llave primaria.
     *
     * @param idCategoria a {@link java.lang.Integer} object.
     * @param idAtributo a {@link java.lang.Integer} object.
     */
    public CategoriaAtributo(Integer idCategoria, Integer idAtributo) {
        this.idCategoria = idCategoria;
        this.idAtributo = idAtributo;
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param idCategoria a {@link java.lang.Integer} object.
     * @param idAtributo a {@link java.lang.Integer} object.
     * @param nombreAtributo a {@link java.lang.String} object.
     */
    public CategoriaAtributo(Integer idCategoria, Integer idAtributo,String nombreAtributo) {
        this.idCategoria = idCategoria;
        this.idAtributo = idAtributo;
        this.nombreAtributo = nombreAtributo;
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>idCategoria</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * <p>Setter for the field <code>idCategoria</code>.</p>
     *
     * @param idCategoria a {@link java.lang.Integer} object.
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * <p>Getter for the field <code>idAtributo</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdAtributo() {
        return idAtributo;
    }

    /**
     * <p>Setter for the field <code>idAtributo</code>.</p>
     *
     * @param idAtributo a {@link java.lang.Integer} object.
     */
    public void setIdAtributo(Integer idAtributo) {
        this.idAtributo = idAtributo;
    }

    /**
     * <p>Getter for the field <code>nombreAtributo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombreAtributo() {
        return nombreAtributo;
    }

    /**
     * <p>Setter for the field <code>nombreAtributo</code>.</p>
     *
     * @param nombreAtributo a {@link java.lang.String} object.
     */
    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[CategoriaAtributo] : ["
                + " idCategoria =" + this.idCategoria
                + " idAtributo =" + this.idAtributo
                + " nombreAtributo =" + this.nombreAtributo
                + "]";
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoriaAtributo)) {
            return false;
        }
        CategoriaAtributo other = (CategoriaAtributo) obj;
        return
               idCategoria == other.idCategoria &&
               idAtributo == other.idAtributo;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(
            idCategoria,
            idAtributo
        );
    }

}
