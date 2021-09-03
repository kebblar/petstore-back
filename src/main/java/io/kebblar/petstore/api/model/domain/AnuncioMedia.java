/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioMedia.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_28)
 *
 * Historia:    .
 *              20210518_2028 Creación de éste POJO
 *              20210604_1325 Se agregan los campos de 'idTipo' y
 *              'principal'
 *
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
