package io.kebblar.petstore.api.model.domain;

import java.util.Date;

/**
 * Implementacion del POJO de la entidad de {@link GraficaTipoPago.
 *
 * @author Diego González
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaTipoPago {
	private static final long serialVersionUID = 4897377279463910357L;

	private String tipo_pago;
	private Long total_venta;
	private int cantidad_ordenes;
	private int mes;
	private int anio;
	
	public GraficaTipoPago(String tipo_pago, Long total_venta, int cantidad_ordenes, int mes, int anio) {
		super();
		this.tipo_pago = tipo_pago;
		this.total_venta = total_venta;
		this.cantidad_ordenes = cantidad_ordenes;
		this.mes = mes;
		this.anio = anio;
	}

	public GraficaTipoPago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}

	public Long getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Long total_venta) {
		this.total_venta = total_venta;
	}

	public int getCantidad_ordenes() {
		return cantidad_ordenes;
	}

	public void setCantidad_ordenes(int cantidad_ordenes) {
		this.cantidad_ordenes = cantidad_ordenes;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "GraficaTipoPago [tipo_pago=" + tipo_pago + ", total_venta=" + total_venta + ", cantidad_ordenes="
				+ cantidad_ordenes + ", mes=" + mes + ", anio=" + anio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + cantidad_ordenes;
		result = prime * result + mes;
		result = prime * result + ((tipo_pago == null) ? 0 : tipo_pago.hashCode());
		result = prime * result + ((total_venta == null) ? 0 : total_venta.hashCode());
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
		GraficaTipoPago other = (GraficaTipoPago) obj;
		if (anio != other.anio)
			return false;
		if (cantidad_ordenes != other.cantidad_ordenes)
			return false;
		if (mes != other.mes)
			return false;
		if (tipo_pago == null) {
			if (other.tipo_pago != null)
				return false;
		} else if (!tipo_pago.equals(other.tipo_pago))
			return false;
		if (total_venta == null) {
			if (other.total_venta != null)
				return false;
		} else if (!total_venta.equals(other.total_venta))
			return false;
		return true;
	}
	
	
	

		
}
