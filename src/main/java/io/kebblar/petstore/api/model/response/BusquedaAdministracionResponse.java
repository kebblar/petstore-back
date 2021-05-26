package io.kebblar.petstore.api.model.response;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BusquedaAdministracionResponse {

	private int id;
	private int sku;
	private String titulo;
	private LocalDate fechaInicioVigencia;
	private LocalDate fechaFinVigencia;
	private String estatus;
	private int idCategoria;
	private String descripcion;
	
	
	

	public BusquedaAdministracionResponse(int id, int sku,
			@NotBlank(message = "{notblank.anuncio.titulo}") @NotNull(message = "{notnull.anuncio.titulo}") String titulo,
			LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia, String estatus,
			@Min(value = 1, message = "{min.anuncio.idcategoria}") int idCategoria, String descripcion) {
		super();
		this.id = id;
		this.sku = sku;
		this.titulo = titulo;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.estatus = estatus;
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "BusquedaAdministracionResponse [id=" + id + ", sku=" + sku + ", titulo=" + titulo
				+ ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
				+ ", estatus=" + estatus + ", idCategoria=" + idCategoria + ", descripcion=" + descripcion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
		result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
		result = prime * result + id;
		result = prime * result + idCategoria;
		result = prime * result + sku;
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
		BusquedaAdministracionResponse other = (BusquedaAdministracionResponse) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
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
		if (id != other.id)
			return false;
		if (idCategoria != other.idCategoria)
			return false;
		if (sku != other.sku)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
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
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
