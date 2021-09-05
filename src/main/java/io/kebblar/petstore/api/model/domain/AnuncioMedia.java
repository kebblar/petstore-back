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
     * @param id
     */
    public AnuncioMedia(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase sin id.
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
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioMedia)) return false;
        AnuncioMedia that = (AnuncioMedia) o;
        return Objects.equals(id, that.id) && Objects.equals(idAnuncio, that.idAnuncio) && Objects.equals(uuid, that.uuid)
                && Objects.equals(idTipo, that.idTipo) && Objects.equals(principal, that.principal);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, idAnuncio, uuid, idTipo, principal);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AnuncioMedia [id=" + id + ", idAnuncio=" + idAnuncio + ", uuid=" + uuid + ", idTipo=" + idTipo
                + ", principal=" + principal + "]";
    }

}
