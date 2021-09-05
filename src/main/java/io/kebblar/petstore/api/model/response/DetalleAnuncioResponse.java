/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
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

    public DetalleAnuncioResponse() {
    }

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

    @Override
    public String toString() {
        return "DetalleAnuncioResponse [id=" + id + ", idCategoria=" + idCategoria + ", descCategoria=" + descCategoria
                + ", folio=" + folio + ", titulo=" + titulo + ", descripcion=" + descripcion + ", precio=" + precio
                + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
                + ", idEstatus=" + idEstatus + ", descEstatus=" + descEstatus + ", searchUrl=" + searchUrl
                + ", atributos=" + atributos + ", imagenes=" + imagenes + "]";
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DetalleAnuncioResponse other = (DetalleAnuncioResponse) obj;
        if (atributos == null) {
            if (other.atributos != null)
                return false;
        } else if (!atributos.equals(other.atributos))
            return false;
        if (descCategoria == null) {
            if (other.descCategoria != null)
                return false;
        } else if (!descCategoria.equals(other.descCategoria))
            return false;
        if (descEstatus == null) {
            if (other.descEstatus != null)
                return false;
        } else if (!descEstatus.equals(other.descEstatus))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (fechaFinVigencia == null) {
            if (other.fechaFinVigencia != null)
                return false;
        } else if (!fechaFinVigencia.equals(other.fechaFinVigencia))
            return false;
        if (fechaInicioVigencia == null) {
            if (other.fechaInicioVigencia != null)
                return false;
        } else if (!fechaInicioVigencia.equals(other.fechaInicioVigencia))
            return false;
        if (folio == null) {
            if (other.folio != null)
                return false;
        } else if (!folio.equals(other.folio))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (idCategoria == null) {
            if (other.idCategoria != null)
                return false;
        } else if (!idCategoria.equals(other.idCategoria))
            return false;
        if (idEstatus != other.idEstatus)
            return false;
        if (imagenes == null) {
            if (other.imagenes != null)
                return false;
        } else if (!imagenes.equals(other.imagenes))
            return false;
        if (precio == null) {
            if (other.precio != null)
                return false;
        } else if (!precio.equals(other.precio))
            return false;
        if (searchUrl == null) {
            if (other.searchUrl != null)
                return false;
        } else if (!searchUrl.equals(other.searchUrl))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

}
