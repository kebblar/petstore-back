/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioAtributo.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_28)
 *
 * Historia:    .
 *              20210518_2028 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'anuncio_atributo'. 
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioAtributo implements Serializable {
	private static final long serialVersionUID = 8636526037194157358L;
	
	private Integer id;
	private Integer idAnuncio;
	private Integer idAtributo;
	private int valor;
	private String unidad;
	
	public AnuncioAtributo() {
	}

	public AnuncioAtributo(Integer id) {
		this.id = id;
	}

	public AnuncioAtributo(Integer id, Integer idAnuncio, Integer idAtributo, int valor, String unidad) {
		this.id = id;
		this.idAnuncio = idAnuncio;
		this.idAtributo = idAtributo;
		this.valor = valor;
		this.unidad = unidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Integer idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public Integer getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(Integer idAtributo) {
		this.idAtributo = idAtributo;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idAnuncio == null) ? 0 : idAnuncio.hashCode());
		result = prime * result + ((idAtributo == null) ? 0 : idAtributo.hashCode());
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
		AnuncioAtributo other = (AnuncioAtributo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idAnuncio == null) {
			if (other.idAnuncio != null)
				return false;
		} else if (!idAnuncio.equals(other.idAnuncio))
			return false;
		if (idAtributo == null) {
			if (other.idAtributo != null)
				return false;
		} else if (!idAtributo.equals(other.idAtributo))
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
		return "AnuncioAtributo [id=" + id + ", idAnuncio=" + idAnuncio + ", idAtributo=" + idAtributo + ", valor="
				+ valor + ", unidad=" + unidad + "]";
	}
}
