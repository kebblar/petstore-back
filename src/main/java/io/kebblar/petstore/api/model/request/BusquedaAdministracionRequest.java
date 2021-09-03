/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   BusquedaAdministracionRequest.java
 * Tipo:        clase
 * AUTOR:       Edgar Uribe (EU)
 * Fecha:       Sabado 8 de Mayo de 2021 (09_38)
 *
 * Historia:    20210508_0938 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.request;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'BusquedaAdministracionRequest'.
 *
 * @author  Edgar Uribe
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BusquedaAdministracionRequest {

    /*
     * Atributos de clase.
     */
    private String folio;
    private String titulo;
    private LocalDate fechaInicioVigencia;
    private LocalDate fechaFinVigencia;
    private int estatus;
    private int idCategoria;
    private int numPaginas;
    private int tamPaginas;

    /**
     * Constructor por defecto.
     */
    public BusquedaAdministracionRequest() {}

    /*
     * Getter y Setter.
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusquedaAdministracionRequest)) return false;
        BusquedaAdministracionRequest that = (BusquedaAdministracionRequest) o;
        return estatus == that.estatus && idCategoria == that.idCategoria && numPaginas == that.numPaginas &&
                tamPaginas == that.tamPaginas && Objects.equals(folio, that.folio) && Objects.equals(titulo, that.titulo) &&
                Objects.equals(fechaInicioVigencia, that.fechaInicioVigencia) && Objects.equals(fechaFinVigencia, that.fechaFinVigencia);
    }

    /**
     * {@inheritDoc}
     */
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

}
