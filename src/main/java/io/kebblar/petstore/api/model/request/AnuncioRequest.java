package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AnuncioRequest {

	@NotBlank(message = "{notblank.anuncio.titulo}")
	@NotNull(message = "{notnull.anuncio.titulo}")
	private String titulo;
	@NotBlank(message = "{notblank.anuncio.descripcion}")
	@NotNull(message = "{notnull.anuncio.descripcion}")
	@NotBlank(message = "La descripción no puede ser vacio")
	private String descripcion;
	private Date fechaInicioVigencia;
	private Date fechaFinVigencia;
	@Min(value = 1, message = "{min.anuncio.idcategoria}")
	private int idCategoria;
	@NotBlank(message = "{notblank.anuncio.precio}")
	@NotNull(message = "{notnull.anuncio.precio}")
	private BigDecimal precio;
	private List <AtributoRequest> atributos;
	
	public AnuncioRequest() {
	}

	public AnuncioRequest(String titulo, String descripcion, Date fechaInicioVigencia, Date fechaFinVigencia,
			int idCategoria, BigDecimal precio, List<AtributoRequest> atributos) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.idCategoria = idCategoria;
		this.precio = precio;
		this.atributos = atributos;
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

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<AtributoRequest> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<AtributoRequest> atributos) {
		this.atributos = atributos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atributos == null) ? 0 : atributos.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
		result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
		result = prime * result + idCategoria;
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		AnuncioRequest other = (AnuncioRequest) obj;
		if (atributos == null) {
			if (other.atributos != null)
				return false;
		} else if (!atributos.equals(other.atributos))
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
		if (idCategoria != other.idCategoria)
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
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
		return "AnuncioRequest [titulo=" + titulo + ", descripcion=" + descripcion + ", fechaInicioVigencia="
				+ fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia + ", idCategoria=" + idCategoria
				+ ", precio=" + precio + ", atributos=" + atributos + "]";
	}
}
