package io.kebblar.petstore.api.model.request;

public class AtributoRequest {
	
	private int id;
	private int valor;
	private String unidad;
	
	public AtributoRequest() {
	}

	public AtributoRequest(int id, int valor, String unidad) {
		this.id = id;
		this.valor = valor;
		this.unidad = unidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
		result = prime * result + valor;
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
		AtributoRequest other = (AtributoRequest) obj;
		if (id != other.id)
			return false;
		if (unidad == null) {
			if (other.unidad != null)
				return false;
		} else if (!unidad.equals(other.unidad))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtributoRequest [id=" + id + ", valor=" + valor + ", unidad=" + unidad + "]";
	}
}
