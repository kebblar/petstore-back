/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Anuncio
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:12:20
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'anuncio'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Anuncio implements Serializable {
    private static final long serialVersionUID = -143592035892511227L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private Integer idCategoria;
    private String folio;
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Date fechaEliminacion;
    private short idEstatus;
    private String searchUrl;

    /**
     * Constructor por default (sin parámetros).
     */
    public Anuncio() {
    }

    /**
     * Constructor por id.
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public Anuncio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase con id.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idCategoria a {@link java.lang.Integer} object.
     * @param folio a {@link java.lang.String} object.
     * @param titulo a {@link java.lang.String} object.
     * @param descripcion a {@link java.lang.String} object.
     * @param precio a {@link java.math.BigDecimal} object.
     * @param fechaInicioVigencia a {@link java.util.Date} object.
     * @param fechaFinVigencia a {@link java.util.Date} object.
     * @param fechaAlta a {@link java.util.Date} object.
     * @param fechaModificacion a {@link java.util.Date} object.
     * @param fechaEliminacion a {@link java.util.Date} object.
     * @param idEstatus a short.
     * @param searchUrl a {@link java.lang.String} object.
     */
    public Anuncio(Integer id, Integer idCategoria, String folio, String titulo, String descripcion, BigDecimal precio,
            Date fechaInicioVigencia, Date fechaFinVigencia, Date fechaAlta, Date fechaModificacion,
            Date fechaEliminacion, short idEstatus, String searchUrl) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.folio = folio;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
        this.fechaEliminacion = fechaEliminacion;
        this.idEstatus = idEstatus;
        this.searchUrl= searchUrl;
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
     * <p>Getter for the field <code>folio</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * <p>Setter for the field <code>folio</code>.</p>
     *
     * @param folio a {@link java.lang.String} object.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * <p>Getter for the field <code>titulo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * <p>Setter for the field <code>titulo</code>.</p>
     *
     * @param titulo a {@link java.lang.String} object.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * <p>Getter for the field <code>descripcion</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * <p>Setter for the field <code>descripcion</code>.</p>
     *
     * @param descripcion a {@link java.lang.String} object.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * <p>Getter for the field <code>precio</code>.</p>
     *
     * @return a {@link java.math.BigDecimal} object.
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * <p>Setter for the field <code>precio</code>.</p>
     *
     * @param precio a {@link java.math.BigDecimal} object.
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * <p>Getter for the field <code>fechaInicioVigencia</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    /**
     * <p>Setter for the field <code>fechaInicioVigencia</code>.</p>
     *
     * @param fechaInicioVigencia a {@link java.util.Date} object.
     */
    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    /**
     * <p>Getter for the field <code>fechaFinVigencia</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    /**
     * <p>Setter for the field <code>fechaFinVigencia</code>.</p>
     *
     * @param fechaFinVigencia a {@link java.util.Date} object.
     */
    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    /**
     * <p>Getter for the field <code>fechaAlta</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * <p>Setter for the field <code>fechaAlta</code>.</p>
     *
     * @param fechaAlta a {@link java.util.Date} object.
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * <p>Getter for the field <code>fechaModificacion</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * <p>Setter for the field <code>fechaModificacion</code>.</p>
     *
     * @param fechaModificacion a {@link java.util.Date} object.
     */
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * <p>Getter for the field <code>fechaEliminacion</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    /**
     * <p>Setter for the field <code>fechaEliminacion</code>.</p>
     *
     * @param fechaEliminacion a {@link java.util.Date} object.
     */
    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    /**
     * <p>Getter for the field <code>idEstatus</code>.</p>
     *
     * @return a short.
     */
    public short getIdEstatus() {
        return idEstatus;
    }

    /**
     * <p>Setter for the field <code>idEstatus</code>.</p>
     *
     * @param idEstatus a short.
     */
    public void setIdEstatus(short idEstatus) {
        this.idEstatus = idEstatus;
    }

    /**
     * <p>Getter for the field <code>searchUrl</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSearchUrl() {
        return searchUrl;
    }

    /**
     * <p>Setter for the field <code>searchUrl</code>.</p>
     *
     * @param searchUrl a {@link java.lang.String} object.
     */
    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Anuncio [id=" + id + ", idCategoria=" + idCategoria + ", folio=" + folio + ", titulo=" + titulo
                + ", descripcion=" + descripcion + ", precio=" + precio + ", fechaInicioVigencia=" + fechaInicioVigencia
                + ", fechaFinVigencia=" + fechaFinVigencia + ", fechaAlta=" + fechaAlta + ", fechaModificacion="
                + fechaModificacion + ", fechaEliminacion=" + fechaEliminacion + ", idEstatus=" + idEstatus
                + ", searchUrl=" + searchUrl + "]";
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anuncio)) return false;
        Anuncio anuncio = (Anuncio) o;
        return idEstatus == anuncio.idEstatus && Objects.equals(id, anuncio.id) &&
                Objects.equals(idCategoria, anuncio.idCategoria) && Objects.equals(folio, anuncio.folio) &&
                Objects.equals(titulo, anuncio.titulo) && Objects.equals(descripcion, anuncio.descripcion) &&
                Objects.equals(precio, anuncio.precio) && Objects.equals(fechaInicioVigencia, anuncio.fechaInicioVigencia) &&
                Objects.equals(fechaFinVigencia, anuncio.fechaFinVigencia) && Objects.equals(fechaAlta, anuncio.fechaAlta) &&
                Objects.equals(fechaModificacion, anuncio.fechaModificacion) && Objects.equals(fechaEliminacion, anuncio.fechaEliminacion) &&
                Objects.equals(searchUrl, anuncio.searchUrl);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(id, idCategoria, folio, titulo, descripcion, precio, fechaInicioVigencia, fechaFinVigencia,
                fechaAlta, fechaModificacion, fechaEliminacion, idEstatus, searchUrl);
    }
}
