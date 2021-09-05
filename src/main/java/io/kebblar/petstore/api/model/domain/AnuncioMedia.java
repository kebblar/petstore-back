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
 * Nombre:      AnuncioMedia
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:12:37
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'anuncio_imagen'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioMedia implements Serializable {
    private static final long serialVersionUID = -4759453261602831311L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private Integer idAnuncio;
    private String uuid;
    private Integer idTipo;
    private Boolean principal;

    /**
     * Constructor por default (sin parámetros).
     */
    public AnuncioMedia() {
    }

    /**
     * Constructor por id.
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public AnuncioMedia(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase sin id.
     *
     * @param idAnuncio a {@link java.lang.Integer} object.
     * @param uuid a {@link java.lang.String} object.
     * @param idTipo a {@link java.lang.Integer} object.
     * @param principal a {@link java.lang.Boolean} object.
     */
    public AnuncioMedia(Integer idAnuncio, String uuid, Integer idTipo, Boolean principal) {
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
        this.idTipo = idTipo;
        this.principal = principal;
    }

    /*
     * Constructor basado en todos los atributos de la clase con id.
     */
    /**
     * <p>Constructor for AnuncioMedia.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idAnuncio a {@link java.lang.Integer} object.
     * @param uuid a {@link java.lang.String} object.
     * @param idTipo a {@link java.lang.Integer} object.
     * @param principal a {@link java.lang.Boolean} object.
     */
    public AnuncioMedia(Integer id, Integer idAnuncio, String uuid, Integer idTipo, Boolean principal) {
        super();
        this.id = id;
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
        this.idTipo = idTipo;
        this.principal = principal;
    }

    /**
     * Getter y Setter.
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
     * <p>Getter for the field <code>idAnuncio</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * <p>Setter for the field <code>idAnuncio</code>.</p>
     *
     * @param idAnuncio a {@link java.lang.Integer} object.
     */
    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * <p>Getter for the field <code>uuid</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * <p>Setter for the field <code>uuid</code>.</p>
     *
     * @param uuid a {@link java.lang.String} object.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * <p>Getter for the field <code>idTipo</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdTipo() {
        return idTipo;
    }

    /**
     * <p>Setter for the field <code>idTipo</code>.</p>
     *
     * @param idTipo a {@link java.lang.Integer} object.
     */
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * <p>Getter for the field <code>principal</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getPrincipal() {
        return principal;
    }

    /**
     * <p>Setter for the field <code>principal</code>.</p>
     *
     * @param principal a {@link java.lang.Boolean} object.
     */
    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioMedia)) return false;
        AnuncioMedia that = (AnuncioMedia) o;
        return Objects.equals(id, that.id) && Objects.equals(idAnuncio, that.idAnuncio) && Objects.equals(uuid, that.uuid)
                && Objects.equals(idTipo, that.idTipo) && Objects.equals(principal, that.principal);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(id, idAnuncio, uuid, idTipo, principal);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "AnuncioMedia [id=" + id + ", idAnuncio=" + idAnuncio + ", uuid=" + uuid + ", idTipo=" + idTipo
                + ", principal=" + principal + "]";
    }

}
