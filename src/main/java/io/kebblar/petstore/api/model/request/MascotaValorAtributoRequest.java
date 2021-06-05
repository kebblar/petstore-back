/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ActualizaAnuncioRequest.java
 * Tipo:        clase
 * AUTOR:       Isabel Contreras (IS)
 * Fecha:       Jueves 6 de Mayo de 2021 (10_40)
 *
 * Historia:    20210506_1040 Creación de éste POJO
 * 				20210604_1540 Se renombran las propiedades.
 *
 */
package io.kebblar.petstore.api.model.request;

/**
 * Implementacion del POJO de la entidad de 'ActualizaAnuncioRequest'.
 * 
 * @author  Isabel Contreras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class MascotaValorAtributoRequest {
	
	private int id;
	private int idValorAtributo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdValorAtributo() {
		return idValorAtributo;
	}
	public void setIdValorAtributo(int idValorAtributo) {
		this.idValorAtributo = idValorAtributo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idValorAtributo;
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
		MascotaValorAtributoRequest other = (MascotaValorAtributoRequest) obj;
		if (id != other.id)
			return false;
		if (idValorAtributo != other.idValorAtributo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MascotaValorAtributoRequest [id=" + id + ", idValorAtributo=" + idValorAtributo + "]";
	}
	public MascotaValorAtributoRequest(int id, int idValorAtributo) {
		super();
		this.id = id;
		this.idValorAtributo = idValorAtributo;
	}
	public MascotaValorAtributoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
