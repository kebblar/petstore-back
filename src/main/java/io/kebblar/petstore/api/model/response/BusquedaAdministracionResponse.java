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
 * AUTOR:       Edgar Uribe Mendez (EUM)
 * Fecha:       Martes 28 de Mayo de 2021 (21_35)
 *
 * Historia:    .
 *              20210528_2135 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.Date;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'anuncio' para realizar la busqueda. 
 *
 * @author Edgar Uribe Mendez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class BusquedaAdministracionResponse {

	private int id;
	private long sku;
	private String titulo;
	private Date fechaInicioVigencia;
	private Date fechaFinVigencia;
	private String estatus;
	private Integer idCategoria;
	private String descripcion;
	private int idEstatus;
	private String descripcionEstatus;
	private String descripcionCategoria;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getSku() {
		return sku;
	}
	public void setSku(long sku) {
		this.sku = sku;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getDescripcionEstatus() {
		return descripcionEstatus;
	}
	public void setDescripcionEstatus(String descripcionEstatus) {
		this.descripcionEstatus = descripcionEstatus;
	}
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((descripcionCategoria == null) ? 0 : descripcionCategoria.hashCode());
		result = prime * result + ((descripcionEstatus == null) ? 0 : descripcionEstatus.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
		result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
		result = prime * result + id;
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		result = prime * result + idEstatus;
		result = prime * result + (int) (sku ^ (sku >>> 32));
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
		BusquedaAdministracionResponse other = (BusquedaAdministracionResponse) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (descripcionCategoria == null) {
			if (other.descripcionCategoria != null)
				return false;
		} else if (!descripcionCategoria.equals(other.descripcionCategoria))
			return false;
		if (descripcionEstatus == null) {
			if (other.descripcionEstatus != null)
				return false;
		} else if (!descripcionEstatus.equals(other.descripcionEstatus))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
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
		if (id != other.id)
			return false;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		if (idEstatus != other.idEstatus)
			return false;
		if (sku != other.sku)
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
		return "BusquedaAdministracionResponse [id=" + id + ", sku=" + sku + ", titulo=" + titulo
				+ ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
				+ ", estatus=" + estatus + ", idCategoria=" + idCategoria + ", descripcion=" + descripcion
				+ ", idEstatus=" + idEstatus + ", descripcionEstatus=" + descripcionEstatus + ", descripcionCategoria="
				+ descripcionCategoria + "]";
	}
	public BusquedaAdministracionResponse(int id, long sku, String titulo, Date fechaInicioVigencia,
			Date fechaFinVigencia, String estatus, Integer idCategoria, String descripcion, int idEstatus,
			String descripcionEstatus, String descripcionCategoria) {
		super();
		this.id = id;
		this.sku = sku;
		this.titulo = titulo;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.estatus = estatus;
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.idEstatus = idEstatus;
		this.descripcionEstatus = descripcionEstatus;
		this.descripcionCategoria = descripcionCategoria;
	}
	public BusquedaAdministracionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
