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
    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }
    public LocalDate getFechaFinVigencia() {
        return fechaFinVigencia;
    }
    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }
    public int getEstatus() {
        return estatus;
    }
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public int getTamPaginas() {
        return tamPaginas;
    }
    public void setTamPaginas(int tamPaginas) {
        this.tamPaginas = tamPaginas;
    }
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
    @Override
    public String toString() {
        return "BusquedaAdministracionRequest [folio=" + folio + ", titulo=" + titulo + ", fechaInicioVigencia="
                + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia + ", estatus=" + estatus
                + ", idCategoria=" + idCategoria + ", numPaginas=" + numPaginas + ", tamPaginas=" + tamPaginas + "]";
    }
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
    public BusquedaAdministracionRequest() {
    }

}
