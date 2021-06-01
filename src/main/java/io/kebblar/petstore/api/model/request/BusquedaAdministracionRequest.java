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
 */package io.kebblar.petstore.api.model.request;

import java.time.LocalDate;

/**
 * Implementacion del POJO de la entidad de 'BusquedaAdministracionRequest'.
 * 
 * @author  Edgar Uribe
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BusquedaAdministracionRequest {

	private long sku;
	private String titulo;
	private LocalDate fechaInicioVigencia;
	private LocalDate fechaFinVigencia;
	private int estatus;
	private int idCategoria;
	private int numPaginas;
	private int tamPaginas;
	public long getSku() {
		return sku;
	}
	public void setSku(long sku) {
		this.sku = sku;
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
		result = prime * result + idCategoria;
		result = prime * result + numPaginas;
		result = prime * result + (int) (sku ^ (sku >>> 32));
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
		if (idCategoria != other.idCategoria)
			return false;
		if (numPaginas != other.numPaginas)
			return false;
		if (sku != other.sku)
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
		return "BusquedaAdministracionRequest [sku=" + sku + ", titulo=" + titulo + ", fechaInicioVigencia="
				+ fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia + ", estatus=" + estatus
				+ ", idCategoria=" + idCategoria + ", numPaginas=" + numPaginas + ", tamPaginas=" + tamPaginas + "]";
	}
	public BusquedaAdministracionRequest(long sku, String titulo, LocalDate fechaInicioVigencia,
			LocalDate fechaFinVigencia, int estatus, int idCategoria, int numPaginas, int tamPaginas) {
		super();
		this.sku = sku;
		this.titulo = titulo;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.estatus = estatus;
		this.idCategoria = idCategoria;
		this.numPaginas = numPaginas;
		this.tamPaginas = tamPaginas;
	}
	
	
	
	
	
}
