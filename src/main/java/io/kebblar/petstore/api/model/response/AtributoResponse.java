package io.kebblar.petstore.api.model.response;

public class AtributoResponse {
	
	private int id;
	private int valor;
	
	public AtributoResponse() {
	}

	public AtributoResponse(int id, int valor) {
		this.id = id;
		this.valor = valor;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		AtributoResponse other = (AtributoResponse) obj;
		if (id != other.id)
			return false;
		if (valor != other.valor)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "AtributoRequest [id=" + id + ", valor=" + valor + "]";
	}
}
