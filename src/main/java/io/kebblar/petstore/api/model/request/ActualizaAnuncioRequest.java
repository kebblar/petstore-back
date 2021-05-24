package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;

public class ActualizaAnuncioRequest extends AnuncioRequest{

	@Min(value = 1, message = "{min.anuncio.id}")
	private int id;

	public ActualizaAnuncioRequest() {
	}

	public ActualizaAnuncioRequest(int id) {
		this.id = id;
	}
	public ActualizaAnuncioRequest(int id,String titulo, String descripcion, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia,
			int idCategoria, BigDecimal precio, List<AtributoRequest> atributos) {
		super(titulo, descripcion, fechaInicioVigencia, fechaFinVigencia, idCategoria, precio, atributos);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
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
		ActualizaAnuncioRequest other = (ActualizaAnuncioRequest) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ActualizaAnuncioRequest [id=" + id + "]";
	}
}
