package io.kebblar.petstore.api.rest;

public class AnuncioImagenResponse {
	
	private Integer idImagen;
	private Integer idAnuncio;
	private String uuid;
	private String imagen;
	
	public AnuncioImagenResponse() {

	}
	
	public AnuncioImagenResponse(Integer idImagen, Integer idAnuncio, String uuid, String imagen) {
		this.idImagen = idImagen;
		this.idAnuncio = idAnuncio;
		this.uuid = uuid;
		this.imagen = imagen;
	}

	public Integer getIdAnuncio() {
		return idAnuncio;
	}
	public void setIdAnuncio(Integer idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	public Integer getIdImagen() {
		return idImagen;
	}
	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
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
		result = prime * result + ((idImagen == null) ? 0 : idImagen.hashCode());
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
		AnuncioImagenResponse other = (AnuncioImagenResponse) obj;
		if (idAnuncio == null) {
			if (other.idAnuncio != null)
				return false;
		} else if (!idAnuncio.equals(other.idAnuncio))
			return false;
		if (idImagen == null) {
			if (other.idImagen != null)
				return false;
		} else if (!idImagen.equals(other.idImagen))
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
		return "AnuncioImagenResponse [idAnuncio=" + idAnuncio + ", idImagen=" + idImagen + ", uuid=" + uuid
				+ ", imagen=" + imagen + "]";
	}
	
	
}
