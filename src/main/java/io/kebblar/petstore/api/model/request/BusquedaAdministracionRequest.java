/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      BusquedaAdministracionRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:00:09
 */
package io.kebblar.petstore.api.model.request;

import java.time.LocalDate;

/**
 * Implementacion del POJO de la entidad de 'BusquedaAdministracionRequest'.
 *
 * @author  Edgar Uribe
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BusquedaAdministracionRequest {
    private String folio;
    private String titulo;
    private LocalDate fechaInicioVigencia;
    private LocalDate fechaFinVigencia;
    private int estatus;
    private int idCategoria;
    private int numPaginas;
    private int tamPaginas;

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
     * @return a {@link java.time.LocalDate} object.
     */
    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    /**
     * <p>Setter for the field <code>fechaInicioVigencia</code>.</p>
     *
     * @param fechaInicioVigencia a {@link java.time.LocalDate} object.
     */
    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }
    /**
     * <p>Getter for the field <code>fechaFinVigencia</code>.</p>
     *
     * @return a {@link java.time.LocalDate} object.
     */
    public LocalDate getFechaFinVigencia() {
        return fechaFinVigencia;
    }
    /**
     * <p>Setter for the field <code>fechaFinVigencia</code>.</p>
     *
     * @param fechaFinVigencia a {@link java.time.LocalDate} object.
     */
    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }
    /**
     * <p>Getter for the field <code>estatus</code>.</p>
     *
     * @return a int.
     */
    public int getEstatus() {
        return estatus;
    }
    /**
     * <p>Setter for the field <code>estatus</code>.</p>
     *
     * @param estatus a int.
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    /**
     * <p>Getter for the field <code>idCategoria</code>.</p>
     *
     * @return a int.
     */
    public int getIdCategoria() {
        return idCategoria;
    }
    /**
     * <p>Setter for the field <code>idCategoria</code>.</p>
     *
     * @param idCategoria a int.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    /**
     * <p>Getter for the field <code>numPaginas</code>.</p>
     *
     * @return a int.
     */
    public int getNumPaginas() {
        return numPaginas;
    }
    /**
     * <p>Setter for the field <code>numPaginas</code>.</p>
     *
     * @param numPaginas a int.
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    /**
     * <p>Getter for the field <code>tamPaginas</code>.</p>
     *
     * @return a int.
     */
    public int getTamPaginas() {
        return tamPaginas;
    }
    /**
     * <p>Setter for the field <code>tamPaginas</code>.</p>
     *
     * @param tamPaginas a int.
     */
    public void setTamPaginas(int tamPaginas) {
        this.tamPaginas = tamPaginas;
    }
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + estatus;
        result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
        result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
        result = prime * result +  + ((folio == null) ? 0 : folio.hashCode());
        result = prime * result + idCategoria;
        result = prime * result + numPaginas;
        result = prime * result + tamPaginas;
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
        BusquedaAdministracionRequest other = (BusquedaAdministracionRequest) obj;
        if (estatus != other.estatus)
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
        if (folio != other.folio)
            return false;
        if (idCategoria != other.idCategoria)
            return false;
        if (numPaginas != other.numPaginas)
            return false;
        if (tamPaginas != other.tamPaginas)
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
        return "BusquedaAdministracionRequest [folio=" + folio + ", titulo=" + titulo + ", fechaInicioVigencia="
                + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia + ", estatus=" + estatus
                + ", idCategoria=" + idCategoria + ", numPaginas=" + numPaginas + ", tamPaginas=" + tamPaginas + "]";
    }
    /**
     * <p>Constructor for BusquedaAdministracionRequest.</p>
     *
     * @param folio a {@link java.lang.String} object.
     * @param titulo a {@link java.lang.String} object.
     * @param fechaInicioVigencia a {@link java.time.LocalDate} object.
     * @param fechaFinVigencia a {@link java.time.LocalDate} object.
     * @param estatus a int.
     * @param idCategoria a int.
     * @param numPaginas a int.
     * @param tamPaginas a int.
     */
    public BusquedaAdministracionRequest(String folio, String titulo, LocalDate fechaInicioVigencia,
            LocalDate fechaFinVigencia, int estatus, int idCategoria, int numPaginas, int tamPaginas) {
        this.folio = folio;
        this.titulo = titulo;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.estatus = estatus;
        this.idCategoria = idCategoria;
        this.numPaginas = numPaginas;
        this.tamPaginas = tamPaginas;
    }
    /**
     * <p>Constructor for BusquedaAdministracionRequest.</p>
     */
    public BusquedaAdministracionRequest() {
    }

}
