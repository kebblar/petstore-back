package io.kebblar.petstore.api.model;

import java.util.Date;

public class Factura {

	private int id;
	private Date fecha;
	private String clienteRfc;
	private int idProducto;
	private Double precio;
	private int iva;

	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura(int id, Date fecha, String clienteRfc, int idProducto, Double precio, int iva) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.clienteRfc = clienteRfc;
		this.idProducto = idProducto;
		this.precio = precio;
		this.iva = iva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getClienteRfc() {
		return clienteRfc;
	}

	public void setClienteRfc(String clienteRfc) {
		this.clienteRfc = clienteRfc;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteRfc == null) ? 0 : clienteRfc.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + idProducto;
		result = prime * result + iva;
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Factura other = (Factura) obj;
		if (clienteRfc == null) {
			if (other.clienteRfc != null)
				return false;
		} else if (!clienteRfc.equals(other.clienteRfc))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (idProducto != other.idProducto)
			return false;
		if (iva != other.iva)
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", clienteRfc=" + clienteRfc + ", idProducto=" + idProducto
				+ ", precio=" + precio + ", iva=" + iva + "]";
	}

}
