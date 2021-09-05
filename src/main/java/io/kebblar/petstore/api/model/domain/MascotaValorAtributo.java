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
 * Nombre:      MascotaValorAtributo
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:49:48
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;

/**
 * POJO asociado a la entidad 'mascota_valor_atributo'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MascotaValorAtributo implements Serializable {

    private static final long serialVersionUID = 8636526037194157358L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private Integer idAnuncio;
    private Integer idValorAtributo;

    /**
     * Constructor por default (sin parámetros).
     */
    public MascotaValorAtributo() {
    }

    /**
     * Constructor basado en el id del objeto.
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public MascotaValorAtributo(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idAnuncio a {@link java.lang.Integer} object.
     * @param idValorAtributo a {@link java.lang.Integer} object.
     */
    public MascotaValorAtributo(Integer id, Integer idAnuncio, Integer idValorAtributo) {
        this.id = id;
        this.idAnuncio = idAnuncio;
        this.idValorAtributo = idValorAtributo;
    }

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
     * <p>Getter for the field <code>idValorAtributo</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdValorAtributo() {
        return idValorAtributo;
    }

    /**
     * <p>Setter for the field <code>idValorAtributo</code>.</p>
     *
     * @param idValorAtributo a {@link java.lang.Integer} object.
     */
    public void setIdValorAtributo(Integer idValorAtributo) {
        this.idValorAtributo = idValorAtributo;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((idAnuncio == null) ? 0 : idAnuncio.hashCode());
        result = prime * result + ((idValorAtributo == null) ? 0 : idValorAtributo.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MascotaValorAtributo other = (MascotaValorAtributo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (idAnuncio == null) {
            if (other.idAnuncio != null)
                return false;
        } else if (!idAnuncio.equals(other.idAnuncio))
            return false;
        if (idValorAtributo == null) {
            if (other.idValorAtributo != null)
                return false;
        } else if (!idValorAtributo.equals(other.idValorAtributo))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "MascotaValorAtributo [id=" + id + ", idAnuncio=" + idAnuncio + ", idValorAtributo=" + idValorAtributo + "]";
    }

}
