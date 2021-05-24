package io.kebblar.petstore.api.model.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DetalleAnuncioResponse {

	private Integer id;
	private Integer idCategoria;
	private String descCategoria;
	private String sku;
	private String titulo;
	private String descripcion;
	private BigDecimal precio;
	private Date fechaInicioVigencia;
	private Date fechaFinVigencia;
	private short estatus;
	private String descEstatus;
	private List<AtributoResponse> atributos;
	private List<ImagenResponse> imagenes;
	
	public DetalleAnuncioResponse() {

	}
	public DetalleAnuncioResponse(Integer id, Integer idCategoria, String descCategoria, String sku, String titulo,
			String descripcion, BigDecimal precio, Date fechaInicioVigencia, Date fechaFinVigencia, short estatus,
			String descEstatus, List<AtributoResponse> atributos, List<ImagenResponse> imagenes) {
		this.id = id;
		this.idCategoria = idCategoria;
		this.descCategoria = descCategoria;
		this.sku = sku;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.estatus = estatus;
		this.descEstatus = descEstatus;
		this.atributos = atributos;
		this.imagenes = imagenes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescCategoria() {
		return descCategoria;
	}
	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}
	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}
	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}
	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}
	public short getEstatus() {
		return estatus;
	}
	public void setEstatus(short estatus) {
		this.estatus = estatus;
	}
	public String getDescEstatus() {
		return descEstatus;
	}
	public void setDescEstatus(String descEstatus) {
		this.descEstatus = descEstatus;
	}
	public List<AtributoResponse> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<AtributoResponse> atributos) {
		this.atributos = atributos;
	}
	public List<ImagenResponse> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<ImagenResponse> imagenes) {
		this.imagenes = imagenes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atributos == null) ? 0 : atributos.hashCode());
		result = prime * result + ((descCategoria == null) ? 0 : descCategoria.hashCode());
		result = prime * result + ((descEstatus == null) ? 0 : descEstatus.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + estatus;
		result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
		result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		result = prime * result + ((imagenes == null) ? 0 : imagenes.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		DetalleAnuncioResponse other = (DetalleAnuncioResponse) obj;
		if (atributos == null) {
			if (other.atributos != null)
				return false;
		} else if (!atributos.equals(other.atributos))
			return false;
		if (descCategoria == null) {
			if (other.descCategoria != null)
				return false;
		} else if (!descCategoria.equals(other.descCategoria))
			return false;
		if (descEstatus == null) {
			if (other.descEstatus != null)
				return false;
		} else if (!descEstatus.equals(other.descEstatus))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estatus != other.estatus)
			return false;
		if (fechaFinVigencia == null) {
			if (other.fechaFinVigencia != null)
				return false;
		} else if (!fechaFinVigencia.equals(other.fechaFinVigencia))
			return false;
		if (fechaInicioVigencia == null) {
			if (other.fechaInicioVigencia != null)
				return false;
		} else if (!fechaInicioVigencia.equals(other.fechaInicioVigencia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		if (imagenes == null) {
			if (other.imagenes != null)
				return false;
		} else if (!imagenes.equals(other.imagenes))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetalleAnuncioResponse [id=" + id + ", idCategoria=" + idCategoria + ", descCategoria=" + descCategoria
				+ ", sku=" + sku + ", titulo=" + titulo + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
				+ ", estatus=" + estatus + ", descEstatus=" + descEstatus + ", atributos=" + atributos + ", imagenes="
				+ imagenes + "]";
	}
	
	
}