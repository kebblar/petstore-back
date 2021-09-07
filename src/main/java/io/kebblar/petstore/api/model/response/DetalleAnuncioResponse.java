/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   DetalleAnuncioResponse.java
 * Tipo:        clase
 * AUTOR:       Edgar Uribe Mendez (EUM)
 * Fecha:       Martes 24 de Mayo de 2021 (21_30)
 *
 * Historia:    .
 *              20210524_2130 Creación de éste POJO
 *
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

    /*
     * Atributos de clase.
     */
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
     * Constructor por defecto.
     */
    public DetalleAnuncioResponse() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
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

    /*
     * Setters y getters.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public short getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(short idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getDescEstatus() {
        return descEstatus;
    }

    public void setDescEstatus(String descEstatus) {
        this.descEstatus = descEstatus;
    }

    public List<MascotaValorAtributoResponse> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<MascotaValorAtributoResponse> atributos) {
        this.atributos = atributos;
    }

    public List<AnuncioImagenResponse> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<AnuncioImagenResponse> imagenes) {
        this.imagenes = imagenes;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "DetalleAnuncioResponse [id=" + id + ", idCategoria=" + idCategoria + ", descCategoria=" + descCategoria
                + ", folio=" + folio + ", titulo=" + titulo + ", descripcion=" + descripcion + ", precio=" + precio
                + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
                + ", idEstatus=" + idEstatus + ", descEstatus=" + descEstatus + ", searchUrl=" + searchUrl
                + ", atributos=" + atributos + ", imagenes=" + imagenes + "]";
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleAnuncioResponse)) return false;
        DetalleAnuncioResponse that = (DetalleAnuncioResponse) o;
        return idEstatus == that.idEstatus && Objects.equals(id, that.id) && Objects.equals(idCategoria, that.idCategoria)
                && Objects.equals(descCategoria, that.descCategoria) && Objects.equals(folio, that.folio) &&
                Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(precio, that.precio) && Objects.equals(fechaInicioVigencia, that.fechaInicioVigencia) &&
                Objects.equals(fechaFinVigencia, that.fechaFinVigencia) && Objects.equals(descEstatus, that.descEstatus) &&
                Objects.equals(searchUrl, that.searchUrl) && Objects.equals(atributos, that.atributos) &&
                Objects.equals(imagenes, that.imagenes);
    }
}
