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
 * Nombre:      BusquedaAdministracionResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:02:33
 */
package io.kebblar.petstore.api.model.response;

import java.util.Date;

/**
 * POJO asociado a la entidad 'anuncio' para realizar la busqueda.
 *
 * @author Edgar Uribe Mendez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class BusquedaAdministracionResponse {
    private int id;
    private String folio;
    private String titulo;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    private String estatus;
    private Integer idCategoria;
    private String descripcion;
    private int idEstatus;
    private String descripcionEstatus;
    private String descripcionCategoria;

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }
    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
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
     * <p>Getter for the field <code>estatus</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEstatus() {
        return estatus;
    }
    /**
     * <p>Setter for the field <code>estatus</code>.</p>
     *
     * @param estatus a {@link java.lang.String} object.
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
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
     * <p>Getter for the field <code>idEstatus</code>.</p>
     *
     * @return a int.
     */
    public int getIdEstatus() {
        return idEstatus;
    }
    /**
     * <p>Setter for the field <code>idEstatus</code>.</p>
     *
     * @param idEstatus a int.
     */
    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }
    /**
     * <p>Getter for the field <code>descripcionEstatus</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcionEstatus() {
        return descripcionEstatus;
    }
    /**
     * <p>Setter for the field <code>descripcionEstatus</code>.</p>
     *
     * @param descripcionEstatus a {@link java.lang.String} object.
     */
    public void setDescripcionEstatus(String descripcionEstatus) {
        this.descripcionEstatus = descripcionEstatus;
    }
    /**
     * <p>Getter for the field <code>descripcionCategoria</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }
    /**
     * <p>Setter for the field <code>descripcionCategoria</code>.</p>
     *
     * @param descripcionCategoria a {@link java.lang.String} object.
     */
    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((descripcionCategoria == null) ? 0 : descripcionCategoria.hashCode());
        result = prime * result + ((descripcionEstatus == null) ? 0 : descripcionEstatus.hashCode());
        result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
        result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
        result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
        result = prime * result + ((folio == null) ? 0 : folio.hashCode());
        result = prime * result + id;
        result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
        result = prime * result + idEstatus;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
        BusquedaAdministracionResponse other = (BusquedaAdministracionResponse) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (descripcionCategoria == null) {
            if (other.descripcionCategoria != null)
                return false;
        } else if (!descripcionCategoria.equals(other.descripcionCategoria))
            return false;
        if (descripcionEstatus == null) {
            if (other.descripcionEstatus != null)
                return false;
        } else if (!descripcionEstatus.equals(other.descripcionEstatus))
            return false;
        if (estatus == null) {
            if (other.estatus != null)
                return false;
        } else if (!estatus.equals(other.estatus))
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
        if (id != other.id)
            return false;
        if (idCategoria == null) {
            if (other.idCategoria != null)
                return false;
        } else if (!idCategoria.equals(other.idCategoria))
            return false;
        if (idEstatus != other.idEstatus)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "BusquedaAdministracionResponse [id=" + id + ", folio=" + folio + ", titulo=" + titulo
                + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
                + ", estatus=" + estatus + ", idCategoria=" + idCategoria + ", descripcion=" + descripcion
                + ", idEstatus=" + idEstatus + ", descripcionEstatus=" + descripcionEstatus + ", descripcionCategoria="
                + descripcionCategoria + "]";
    }

    /**
     * <p>Constructor for BusquedaAdministracionResponse.</p>
     *
     * @param id a int.
     * @param folio a {@link java.lang.String} object.
     * @param titulo a {@link java.lang.String} object.
     * @param fechaInicioVigencia a {@link java.util.Date} object.
     * @param fechaFinVigencia a {@link java.util.Date} object.
     * @param estatus a {@link java.lang.String} object.
     * @param idCategoria a {@link java.lang.Integer} object.
     * @param descripcion a {@link java.lang.String} object.
     * @param idEstatus a int.
     * @param descripcionEstatus a {@link java.lang.String} object.
     * @param descripcionCategoria a {@link java.lang.String} object.
     */
    public BusquedaAdministracionResponse(int id, String folio, String titulo, Date fechaInicioVigencia,
            Date fechaFinVigencia, String estatus, Integer idCategoria, String descripcion, int idEstatus,
            String descripcionEstatus, String descripcionCategoria) {
        super();
        this.id = id;
        this.folio = folio;
        this.titulo = titulo;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.estatus = estatus;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.idEstatus = idEstatus;
        this.descripcionEstatus = descripcionEstatus;
        this.descripcionCategoria = descripcionCategoria;
    }

    /**
     * <p>Constructor for BusquedaAdministracionResponse.</p>
     */
    public BusquedaAdministracionResponse() {
    }

}
