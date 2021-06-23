/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   GraficaVentasTotales.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Francisco Espinosa
 * Fecha:       Tuesday 23 de Jun de 2021 (09_00)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210623_0900 Creación de este POJO
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;

/**
 * Implementacion del POJO de la entidad de {@link GraficaVentasTotales}.
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaVentasTotales implements Serializable {
    
	public GraficaVentasTotales() {
	}
	
	private static final long serialVersionUID = 4897377279463910357L;
    private Long total_venta;
    private int cantidad_ordenes;
    private int mes;
    private int anio;
    
	public GraficaVentasTotales(Long total_venta, int cantidad_ordenes, int mes, int anio) {
		super();
		this.total_venta = total_venta;
		this.cantidad_ordenes = cantidad_ordenes;
		this.mes = mes;
		this.anio = anio;
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
		return "GraficaVentasTotales [total_venta=" + total_venta + ", cantidad_ordenes=" + cantidad_ordenes + ", mes="
				+ mes + ", anio=" + anio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + cantidad_ordenes;
		result = prime * result + mes;
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
		GraficaVentasTotales other = (GraficaVentasTotales) obj;
		if (anio != other.anio)
			return false;
		if (cantidad_ordenes != other.cantidad_ordenes)
			return false;
		if (mes != other.mes)
			return false;
		if (total_venta == null) {
			if (other.total_venta != null)
				return false;
		} else if (!total_venta.equals(other.total_venta))
			return false;
		return true;
	}
    
}
