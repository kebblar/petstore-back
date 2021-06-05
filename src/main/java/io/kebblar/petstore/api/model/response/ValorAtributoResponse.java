/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioImagenResponse.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_45)
 *
 * Historia:    .
 *              20210518_2045 Creación de éste POJO
 *              20210604_1645 Se renombran las propiedades.
 *
 */
package io.kebblar.petstore.api.model.response;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'atributo' para mostrar el detalle. 
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ValorAtributoResponse {
	
	private int id;
	private int idAtributo;
	private String nombreAtributo;
	private int idValorAtributo;
	private String descRango;
	
	public ValorAtributoResponse() {
		
	}

	public ValorAtributoResponse(int id, int idAtributo, String nombreAtributo, int idValorAtributo, String descRango) {
		super();
		this.id = id;
		this.idAtributo = idAtributo;
		this.nombreAtributo = nombreAtributo;
		this.idValorAtributo = idValorAtributo;
		this.descRango = descRango;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(int idAtributo) {
		this.idAtributo = idAtributo;
	}

	public String getNombreAtributo() {
		return nombreAtributo;
	}

	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo;
	}

	public int getIdValorAtributo() {
		return idValorAtributo;
	}

	public void setIdValorAtributo(int idValorAtributo) {
		this.idValorAtributo = idValorAtributo;
	}

	public String getDescRango() {
		return descRango;
	}

	public void setDescRango(String descRango) {
		this.descRango = descRango;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descRango == null) ? 0 : descRango.hashCode());
		result = prime * result + id;
		result = prime * result + idAtributo;
		result = prime * result + idValorAtributo;
		result = prime * result + ((nombreAtributo == null) ? 0 : nombreAtributo.hashCode());
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
		ValorAtributoResponse other = (ValorAtributoResponse) obj;
		if (descRango == null) {
			if (other.descRango != null)
				return false;
		} else if (!descRango.equals(other.descRango))
			return false;
		if (id != other.id)
			return false;
		if (idAtributo != other.idAtributo)
			return false;
		if (idValorAtributo != other.idValorAtributo)
			return false;
		if (nombreAtributo == null) {
			if (other.nombreAtributo != null)
				return false;
		} else if (!nombreAtributo.equals(other.nombreAtributo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ValorAtributoResponse [id=" + id + ", idAtributo=" + idAtributo + ", nombreAtributo=" + nombreAtributo
				+ ", idValorAtributo=" + idValorAtributo + ", descRango=" + descRango + "]";
	}
	
}
