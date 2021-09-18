/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      DetalleAnuncioResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:03:15
 */
package io.kebblar.petstore.api.model.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'anuncio' para mostrar su detalle.
 *
 * @author Edgar Uribe Mendez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class DetalleAnuncioResponse {
    private Integer id;
    private Integer idCategoria;
    private String descCategoria;
    private String folio;
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    private short idEstatus;
    private String descEstatus;
    private String searchUrl;
    private List<MascotaValorAtributoResponse> atributos;
    private List<AnuncioImagenResponse> imagenes;

    /**
     * <p>Constructor for DetalleAnuncioResponse.</p>
     */
    public DetalleAnuncioResponse() {
    }

    /**
     * <p>Constructor for DetalleAnuncioResponse.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idCategoria a {@link java.lang.Integer} object.
     * @param descCategoria a {@link java.lang.String} object.
     * @param folio a {@link java.lang.String} object.
     * @param titulo a {@link java.lang.String} object.
     * @param descripcion a {@link java.lang.String} object.
     * @param precio a {@link java.math.BigDecimal} object.
     * @param fechaInicioVigencia a {@link java.util.Date} object.
     * @param fechaFinVigencia a {@link java.util.Date} object.
     * @param idEstatus a short.
     * @param descEstatus a {@link java.lang.String} object.
     * @param searchUrl a {@link java.lang.String} object.
     * @param atributos a {@link java.util.List} object.
     * @param imagenes a {@link java.util.List} object.
     */
    public DetalleAnuncioResponse(Integer id, Integer idCategoria, String descCategoria, String folio, String titulo,
            String descripcion, BigDecimal precio, Date fechaInicioVigencia, Date fechaFinVigencia, short idEstatus,
            String descEstatus, String searchUrl, List<MascotaValorAtributoResponse> atributos, List<AnuncioImagenResponse> imagenes) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.descCategoria = descCategoria;
        this.folio = folio;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.idEstatus = idEstatus;
        this.descEstatus = descEstatus;
        this.atributos = atributos;
        this.imagenes = imagenes;
        this.searchUrl = searchUrl;
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
     * <p>Getter for the field <code>descCategoria</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescCategoria() {
        return descCategoria;
    }

    /**
     * <p>Setter for the field <code>descCategoria</code>.</p>
     *
     * @param descCategoria a {@link java.lang.String} object.
     */
    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
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
     * <p>Getter for the field <code>descEstatus</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescEstatus() {
        return descEstatus;
    }

    /**
     * <p>Setter for the field <code>descEstatus</code>.</p>
     *
     * @param descEstatus a {@link java.lang.String} object.
     */
    public void setDescEstatus(String descEstatus) {
        this.descEstatus = descEstatus;
    }

    /**
     * <p>Getter for the field <code>atributos</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<MascotaValorAtributoResponse> getAtributos() {
        return atributos;
    }

    /**
     * <p>Setter for the field <code>atributos</code>.</p>
     *
     * @param atributos a {@link java.util.List} object.
     */
    public void setAtributos(List<MascotaValorAtributoResponse> atributos) {
        this.atributos = atributos;
    }

    /**
     * <p>Getter for the field <code>imagenes</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AnuncioImagenResponse> getImagenes() {
        return imagenes;
    }

    /**
     * <p>Setter for the field <code>imagenes</code>.</p>
     *
     * @param imagenes a {@link java.util.List} object.
     */
    public void setImagenes(List<AnuncioImagenResponse> imagenes) {
        this.imagenes = imagenes;
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
        return "DetalleAnuncioResponse [id=" + id + ", idCategoria=" + idCategoria + ", descCategoria=" + descCategoria
                + ", folio=" + folio + ", titulo=" + titulo + ", descripcion=" + descripcion + ", precio=" + precio
                + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
                + ", idEstatus=" + idEstatus + ", descEstatus=" + descEstatus + ", searchUrl=" + searchUrl
                + ", atributos=" + atributos + ", imagenes=" + imagenes + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((atributos == null) ? 0 : atributos.hashCode());
        result = prime * result + ((descCategoria == null) ? 0 : descCategoria.hashCode());
        result = prime * result + ((descEstatus == null) ? 0 : descEstatus.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
        result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
        result = prime * result + ((folio == null) ? 0 : folio.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
        result = prime * result + idEstatus;
        result = prime * result + ((imagenes == null) ? 0 : imagenes.hashCode());
        result = prime * result + ((precio == null) ? 0 : precio.hashCode());
        result = prime * result + ((searchUrl == null) ? 0 : searchUrl.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleAnuncioResponse)) return false;
        DetalleAnuncioResponse that = (DetalleAnuncioResponse) o;
        return idEstatus == that.idEstatus && Objects.equals(id, that.id) && Objects.equals(idCategoria, that.idCategoria)
                && Objects.equals(descCategoria, that.descCategoria) && Objects.equals(folio, that.folio) &&
                Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion) && Objects.equals(precio, that.precio)
                && Objects.equals(fechaInicioVigencia, that.fechaInicioVigencia) && Objects.equals(fechaFinVigencia, that.fechaFinVigencia) &&
                Objects.equals(descEstatus, that.descEstatus) && Objects.equals(searchUrl, that.searchUrl) && Objects.equals(atributos, that.atributos)
                && Objects.equals(imagenes, that.imagenes);
    }
}
