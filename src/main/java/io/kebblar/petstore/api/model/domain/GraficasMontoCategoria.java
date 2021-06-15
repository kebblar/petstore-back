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
 * Artefacto:   GraficasMontoCategoria.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Cloudstore
 * Fecha:       Tuesday 15 de Jun de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210615_1444 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;

public class GraficasMontoCategoria implements Serializable {
	public GraficasMontoCategoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GraficasMontoCategoria(int id_categoria, String cveOrdenCompra, Date fecha_hora_comprar,
			long importe_total) {
		super();
		this.id_categoria = id_categoria;
		this.cveOrdenCompra = cveOrdenCompra;
		this.fecha_hora_comprar = fecha_hora_comprar;
		this.importe_total = importe_total;
	}
	private static final long serialVersionUID = -6032711964621903590L;
	
	private int id_categoria;
    private String cveOrdenCompra;
    private Date fecha_hora_comprar;
    private long importe_total;
    
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getCveOrdenCompra() {
		return cveOrdenCompra;
	}
	public void setCveOrdenCompra(String cveOrdenCompra) {
		this.cveOrdenCompra = cveOrdenCompra;
	}
	public Date getFecha_hora_comprar() {
		return fecha_hora_comprar;
	}
	public void setFecha_hora_comprar(Date fecha_hora_comprar) {
		this.fecha_hora_comprar = fecha_hora_comprar;
	}
	public long getImporte_total() {
		return importe_total;
	}
	public void setImporte_total(long importe_total) {
		this.importe_total = importe_total;
	}
	@Override
	public String toString() {
		return "GraficasMontoCategoria [id_categoria=" + id_categoria + ", cveOrdenCompra=" + cveOrdenCompra
				+ ", fecha_hora_comprar=" + fecha_hora_comprar + ", importe_total=" + importe_total + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cveOrdenCompra == null) ? 0 : cveOrdenCompra.hashCode());
		result = prime * result + ((fecha_hora_comprar == null) ? 0 : fecha_hora_comprar.hashCode());
		result = prime * result + id_categoria;
		result = prime * result + (int) (importe_total ^ (importe_total >>> 32));
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
		GraficasMontoCategoria other = (GraficasMontoCategoria) obj;
		if (cveOrdenCompra == null) {
			if (other.cveOrdenCompra != null)
				return false;
		} else if (!cveOrdenCompra.equals(other.cveOrdenCompra))
			return false;
		if (fecha_hora_comprar == null) {
			if (other.fecha_hora_comprar != null)
				return false;
		} else if (!fecha_hora_comprar.equals(other.fecha_hora_comprar))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		if (importe_total != other.importe_total)
			return false;
		return true;
	}
    
}
