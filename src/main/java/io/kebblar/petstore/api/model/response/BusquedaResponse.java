package io.kebblar.petstore.api.model.response;

import java.util.List;

public class BusquedaResponse {

	private int totalAnuncios;
	private List<DetalleAnuncioResponse> listaAnuncios;
	public int getTotalAnuncios() {
		return totalAnuncios;
	}
	public void setTotalAnuncios(int totalAnuncios) {
		this.totalAnuncios = totalAnuncios;
	}
	public List<DetalleAnuncioResponse> getListaAnuncios() {
		return listaAnuncios;
	}
	public void setListaAnuncios(List<DetalleAnuncioResponse> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaAnuncios == null) ? 0 : listaAnuncios.hashCode());
		result = prime * result + totalAnuncios;
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
		BusquedaResponse other = (BusquedaResponse) obj;
		if (listaAnuncios == null) {
			if (other.listaAnuncios != null)
				return false;
		} else if (!listaAnuncios.equals(other.listaAnuncios))
			return false;
		if (totalAnuncios != other.totalAnuncios)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BusquedaResponse [totalAnuncios=" + totalAnuncios + ", listaAnuncios=" + listaAnuncios + "]";
	}
	public BusquedaResponse(int totalAnuncios, List<DetalleAnuncioResponse> listaAnuncios) {
		super();
		this.totalAnuncios = totalAnuncios;
		this.listaAnuncios = listaAnuncios;
	}
	public BusquedaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
