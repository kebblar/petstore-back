package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.util.List;

public class BusquedaRequest {

	private BigDecimal precio;
	private Long idCategoria;
	private List<AtributoRequest> atributos;
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
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
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		BusquedaRequest other = (BusquedaRequest) obj;
		if (atributos == null) {
			if (other.atributos != null)
				return false;
		} else if (!atributos.equals(other.atributos))
			return false;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BusquedaRequest [precio=" + precio + ", idCategoria=" + idCategoria + ", atributos=" + atributos + "]";
	}
	public BusquedaRequest(BigDecimal precio, Long idCategoria, List<AtributoRequest> atributos) {
		super();
		this.precio = precio;
		this.idCategoria = idCategoria;
		this.atributos = atributos;
	}
	public BusquedaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
