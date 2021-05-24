package io.kebblar.petstore.api.model.request;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BusquedaAdministracionRequest {

	private int sku;
//	@NotBlank(message = "{notblank.anuncio.titulo}")
//	@NotNull(message = "{notnull.anuncio.titulo}")
	private String titulo;
	private LocalDate fechaInicioVigencia;
	private LocalDate fechaFinVigencia;
	private int estatus;
//	@Min(value = 1, message = "{min.anuncio.idcategoria}")
	private int idCategoria;
	private int numPaginas;
	private int tamPaginas;
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
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
		result = prime * result + sku;
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
	public BusquedaAdministracionRequest(int sku,
			@NotBlank(message = "{notblank.anuncio.titulo}") @NotNull(message = "{notnull.anuncio.titulo}") String titulo,
			LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia, int estatus,
			@Min(value = 1, message = "{min.anuncio.idcategoria}") int idCategoria, int numPaginas, int tamPaginas) {
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
