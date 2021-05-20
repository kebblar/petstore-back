
/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion 
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 * 
 * Artefacto:   DatosOrden .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo, Daniel Alvarez
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'orden_compra'. 
 *
 * @author Fhernanda Romo, Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class DatosOrden implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6032711964621903590L;
	/**
     * Atributos de la clase
     */
	private int id;
    private int idUsuario;
    private int idDireccion;
    private int idPaqueteria;
    private int idMetodoPago;
    private int idMoneda;
    private int idAnuncio;
    private String cveOrdenCompra;
    private long importeTotal;
    private Date fecha;
    private boolean estadoEnvio;
    private String recibo;
    
    
    private long precio;
    private int total;
    private String descripcion;
    private String idOrden;

    /**
     * Constructor por default (sin parámetros).
     */
    public DatosOrden() {
    }



	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the idDireccion
	 */
	public int getIdDireccion() {
		return idDireccion;
	}

	/**
	 * @param idDireccion the idDireccion to set
	 */
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	/**
	 * @return the idPaqueteria
	 */
	public int getIdPaqueteria() {
		return idPaqueteria;
	}

	/**
	 * @param idPaqueteria the idPaqueteria to set
	 */
	public void setIdPaqueteria(int idPaqueteria) {
		this.idPaqueteria = idPaqueteria;
	}



	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the idMoneda
	 */
	public int getIdMoneda() {
		return idMoneda;
	}

	/**
	 * @param idMoneda the idMoneda to set
	 */
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	/**
	 * @return the idAnuncio
	 */
	public int getIdAnuncio() {
		return idAnuncio;
	}

	/**
	 * @param idAnuncio the idAnuncio to set
	 */
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	/**
	 * @return the precio
	 */
	public long getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(long precio) {
		this.precio = precio;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	/**
	 * @return the idMetodoPago
	 */
	public int getIdMetodoPago() {
		return idMetodoPago;
	}



	/**
	 * @param idMetodoPago the idMetodoPago to set
	 */
	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}


	
	/**
	 * @return the recibo
	 */
	public String getRecibo() {
		return recibo;
	}



	/**
	 * @param recibo the recibo to set
	 */
	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}



	/**
	 * @return the cveOrdenCompra
	 */
	public String getCveOrdenCompra() {
		return cveOrdenCompra;
	}



	/**
	 * @param cveOrdenCompra the cveOrdenCompra to set
	 */
	public void setCveOrdenCompra(String cveOrdenCompra) {
		this.cveOrdenCompra = cveOrdenCompra;
	}


	/**
	 * @return the idOrden
	 */
	public String getIdOrden() {
		return idOrden;
	}



	/**
	 * @param idOrden the idOrden to set
	 */
	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the importeTotal
	 */
	public long getImporteTotal() {
		return importeTotal;
	}



	/**
	 * @param importeTotal the importeTotal to set
	 */
	public void setImporteTotal(long importeTotal) {
		this.importeTotal = importeTotal;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cveOrdenCompra == null) ? 0 : cveOrdenCompra.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (estadoEnvio ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + idAnuncio;
		result = prime * result + idDireccion;
		result = prime * result + idMetodoPago;
		result = prime * result + idMoneda;
		result = prime * result + ((idOrden == null) ? 0 : idOrden.hashCode());
		result = prime * result + idPaqueteria;
		result = prime * result + idUsuario;
		result = prime * result + (int) (importeTotal ^ (importeTotal >>> 32));
		result = prime * result + (int) (precio ^ (precio >>> 32));
		result = prime * result + ((recibo == null) ? 0 : recibo.hashCode());
		result = prime * result + total;
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
		DatosOrden other = (DatosOrden) obj;
		if (cveOrdenCompra == null) {
			if (other.cveOrdenCompra != null)
				return false;
		} else if (!cveOrdenCompra.equals(other.cveOrdenCompra))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estadoEnvio != other.estadoEnvio)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (idAnuncio != other.idAnuncio)
			return false;
		if (idDireccion != other.idDireccion)
			return false;
		if (idMetodoPago != other.idMetodoPago)
			return false;
		if (idMoneda != other.idMoneda)
			return false;
		if (idOrden == null) {
			if (other.idOrden != null)
				return false;
		} else if (!idOrden.equals(other.idOrden))
			return false;
		if (idPaqueteria != other.idPaqueteria)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (importeTotal != other.importeTotal)
			return false;
		if (precio != other.precio)
			return false;
		if (recibo == null) {
			if (other.recibo != null)
				return false;
		} else if (!recibo.equals(other.recibo))
			return false;
		if (total != other.total)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "DatosOrden [id=" + id + ", idUsuario=" + idUsuario + ", idDireccion=" + idDireccion + ", idPaqueteria="
				+ idPaqueteria + ", idMetodoPago=" + idMetodoPago + ", idMoneda=" + idMoneda + ", idAnuncio="
				+ idAnuncio + ", cveOrdenCompra=" + cveOrdenCompra + ", importeTotal=" + importeTotal + ", fecha="
				+ fecha + ", estadoEnvio=" + estadoEnvio + ", recibo=" + recibo + ", precio=" + precio + ", total="
				+ total + ", descripcion=" + descripcion + ", idOrden=" + idOrden + "]";
	}

	

    
}