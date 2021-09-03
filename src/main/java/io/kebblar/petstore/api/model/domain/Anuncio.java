/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Anuncio.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_28)
 *
 * Historia:    .
 *              20210518_2028 Creación de éste POJO
 *              20210604_1314 Modificacion de 'sku' por 'folio'
 *
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
     * @param id
     */
    public Anuncio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase con id.
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    public short getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(short idEstatus) {
        this.idEstatus = idEstatus;
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
        return "Anuncio [id=" + id + ", idCategoria=" + idCategoria + ", folio=" + folio + ", titulo=" + titulo
                + ", descripcion=" + descripcion + ", precio=" + precio + ", fechaInicioVigencia=" + fechaInicioVigencia
                + ", fechaFinVigencia=" + fechaFinVigencia + ", fechaAlta=" + fechaAlta + ", fechaModificacion="
                + fechaModificacion + ", fechaEliminacion=" + fechaEliminacion + ", idEstatus=" + idEstatus
                + ", searchUrl=" + searchUrl + "]";
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, idCategoria, folio, titulo, descripcion, precio, fechaInicioVigencia, fechaFinVigencia,
                fechaAlta, fechaModificacion, fechaEliminacion, idEstatus, searchUrl);
    }
}
