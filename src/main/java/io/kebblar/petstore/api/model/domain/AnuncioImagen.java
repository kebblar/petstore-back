/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioImagen.java
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
 * POJO asociado a la entidad 'anuncio_imagen'. 
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioImagen implements Serializable {
	private static final long serialVersionUID = -4759453261602831311L;
	
	private Integer id;
	private Integer idAnuncio;
	private String uuid;
	private String imagen;
	
	public AnuncioImagen() {
	}

	public AnuncioImagen(Integer id) {
		this.id = id;
	}

	public AnuncioImagen(Integer id, Integer idAnuncio, String uuid, String imagen) {
		this.id = id;
		this.idAnuncio = idAnuncio;
		this.uuid = uuid;
		this.imagen = imagen;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idAnuncio == null) ? 0 : idAnuncio.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		AnuncioImagen other = (AnuncioImagen) obj;
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
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnuncioImagen [id=" + id + ", idAnuncio=" + idAnuncio + ", uuid=" + uuid + ", imagen=" + imagen + "]";
	}
}
