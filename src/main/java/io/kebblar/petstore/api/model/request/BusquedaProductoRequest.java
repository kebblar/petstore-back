package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.util.List;

public class BusquedaProductoRequest {

	private BigDecimal precio;
	private int idCategoria;
	private List<AtributoRequest> atributos;
	
	public BusquedaProductoRequest() {
	}
	
	public BusquedaProductoRequest(BigDecimal precio, int idCategoria, List<AtributoRequest> atributos) {
		this.precio = precio;
		this.idCategoria = idCategoria;
		this.atributos = atributos;
	}

	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
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
		result = prime * result + idCategoria;
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
		BusquedaProductoRequest other = (BusquedaProductoRequest) obj;
		if (atributos == null) {
			if (other.atributos != null)
				return false;
		} else if (!atributos.equals(other.atributos))
			return false;
		if (idCategoria != other.idCategoria)
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
		return "BusquedaProductoRequest [precio=" + precio + ", idCategoria=" + idCategoria + ", atributos=" + atributos
				+ "]";
	}
	
	
}
