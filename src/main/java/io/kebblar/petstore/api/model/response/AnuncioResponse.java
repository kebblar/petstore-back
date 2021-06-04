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
 * Fecha:       Martes 18 de Mayo de 2021 (20_40)
 *
 * Historia:    .
 *              20210518_2040 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'anuncio' para mostrar la informacion base. 
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioResponse {

	private int id;
	private String folio;
	private String info;
	
	public AnuncioResponse() {
	}
	
	public AnuncioResponse(int id, String folio) {
		this.id = id;
		this.folio = folio;
	}
	public AnuncioResponse(int id, String folio, String info) {
		this.id = id;
		this.folio = folio;
		this.info = info;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((folio == null) ? 0 : folio.hashCode());
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
		AnuncioResponse other = (AnuncioResponse) obj;
		if (id != other.id)
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (folio == null) {
			if (other.folio != null)
				return false;
		} else if (!folio.equals(other.folio))
			return false;
		return true;
	}

	public long getHash() {
        return this.hashCode();
    }

	@Override
	public String toString() {
		return "AnuncioResponse [id=" + id + ", folio=" + folio + ", info=" + info + "]";
	}
	
	
	
}
