/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   BusquedaAdministracionResponse.java
 * Tipo:        clase
 * AUTOR:       Edgar Uribe Mendez (EUM)
 * Fecha:       Martes 28 de Mayo de 2021 (21_35)
 *
 * Historia:    .
 *              20210528_2135 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.Date;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'anuncio' para realizar la busqueda.
 *
 * @author Edgar Uribe Mendez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class BusquedaAdministracionResponse {

    /*
     * Atributos de la clase.
     */
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
     * Constructos basado en todos los atributos de la clase.
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
     * Constructor por default.
     */
    public BusquedaAdministracionResponse() {
    }

     /*
      * Getter y setter.
      */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    public Integer getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getIdEstatus() {
        return idEstatus;
    }
    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }
    public String getDescripcionEstatus() {
        return descripcionEstatus;
    }
    public void setDescripcionEstatus(String descripcionEstatus) {
        this.descripcionEstatus = descripcionEstatus;
    }
    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }
    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusquedaAdministracionResponse)) return false;
        BusquedaAdministracionResponse that = (BusquedaAdministracionResponse) o;
        return id == that.id && idEstatus == that.idEstatus && Objects.equals(folio, that.folio) &&
                Objects.equals(titulo, that.titulo) && Objects.equals(fechaInicioVigencia, that.fechaInicioVigencia) &&
                Objects.equals(fechaFinVigencia, that.fechaFinVigencia) && Objects.equals(estatus, that.estatus) &&
                Objects.equals(idCategoria, that.idCategoria) && Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(descripcionEstatus, that.descripcionEstatus) && Objects.equals(descripcionCategoria, that.descripcionCategoria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "BusquedaAdministracionResponse [id=" + id + ", folio=" + folio + ", titulo=" + titulo
                + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
                + ", estatus=" + estatus + ", idCategoria=" + idCategoria + ", descripcion=" + descripcion
                + ", idEstatus=" + idEstatus + ", descripcionEstatus=" + descripcionEstatus + ", descripcionCategoria="
                + descripcionCategoria + "]";
    }

}
