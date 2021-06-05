package io.kebblar.petstore.api.model.response;

import io.kebblar.petstore.api.model.request.MascotaValorAtributoRequest;

public class MascotaValorAtributoResponse extends MascotaValorAtributoRequest{

	private String rango;

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rango == null) ? 0 : rango.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MascotaValorAtributoResponse other = (MascotaValorAtributoResponse) obj;
		if (rango == null) {
			if (other.rango != null)
				return false;
		} else if (!rango.equals(other.rango))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MascotaValorAtributoResponse [rango=" + rango + "]";
	}

	public MascotaValorAtributoResponse(int id, int idValorAtributo, String rango) {
		super(id, idValorAtributo);
		this.rango = rango;
	}

	public MascotaValorAtributoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MascotaValorAtributoResponse(int id, int idValorAtributo) {
		super(id, idValorAtributo);
		// TODO Auto-generated constructor stub
	}	
	
	
	
	
}
