/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.model
 * Modulo:      AdministracionCompras
 * Tipo:        clase
 * Autor:       Luis Martinez
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'AdministracionCompras'.
 *
 * Historia:    .
 *              20210519_0935 Generado por LMtz
 *
 */
package io.kebblar.petstore.api.model.domain;

/**
 * Implementacion del POJO de la entidad de {@link AdministracionCompras}.
 *
 * @author  LMtz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class AdministracionCompras {
    private Boolean estadoEnvio;
    private String cveOrden;
    private String nombreAnuncio;
    private String urlFactura;
    private String fechaCompra;
    private String calleNumero;
    private String colonia;
    private String cp;

    public AdministracionCompras(Boolean estadoEnvio, String calleNumero, String colonia, String cp, String cveOrden, String nombreAnuncio,
            String urlFactura, String fechaCompra) {
        super();
        this.estadoEnvio = estadoEnvio;
        this.cveOrden = cveOrden;
        this.nombreAnuncio = nombreAnuncio;
        this.urlFactura = urlFactura;
        this.fechaCompra = fechaCompra;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.cp = cp;
    }
    public String getCve_orden() {
        return cveOrden;
    }
    public void setCve_orden(String cveOrden) {
        this.cveOrden = cveOrden;
    }
    public String getNombreAnuncio() {
        return nombreAnuncio;
    }
    public void setNombreAnuncio(String nombreAnuncio) {
        this.nombreAnuncio = nombreAnuncio;
    }
    public String getUrlFactura() {
        return urlFactura;
    }
    public void setUrlFactura(String urlFactura) {
        this.urlFactura = urlFactura;
    }
    public String getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getCalleNumero() {
        return calleNumero;
    }
    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }

    
    @Override
	public String toString() {
		return "AdministracionCompras [estadoEnvio=" + estadoEnvio + ", cveOrden=" + cveOrden + ", nombreAnuncio="
				+ nombreAnuncio + ", urlFactura=" + urlFactura + ", fechaCompra=" + fechaCompra + ", calleNumero="
				+ calleNumero + ", colonia=" + colonia + ", cp=" + cp + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calleNumero == null) ? 0 : calleNumero.hashCode());
		result = prime * result + ((colonia == null) ? 0 : colonia.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((cveOrden == null) ? 0 : cveOrden.hashCode());
		result = prime * result + ((estadoEnvio == null) ? 0 : estadoEnvio.hashCode());
		result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
		result = prime * result + ((nombreAnuncio == null) ? 0 : nombreAnuncio.hashCode());
		result = prime * result + ((urlFactura == null) ? 0 : urlFactura.hashCode());
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
		AdministracionCompras other = (AdministracionCompras) obj;
		if (calleNumero == null) {
			if (other.calleNumero != null)
				return false;
		} else if (!calleNumero.equals(other.calleNumero))
			return false;
		if (colonia == null) {
			if (other.colonia != null)
				return false;
		} else if (!colonia.equals(other.colonia))
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (cveOrden == null) {
			if (other.cveOrden != null)
				return false;
		} else if (!cveOrden.equals(other.cveOrden))
			return false;
		if (estadoEnvio == null) {
			if (other.estadoEnvio != null)
				return false;
		} else if (!estadoEnvio.equals(other.estadoEnvio))
			return false;
		if (fechaCompra == null) {
			if (other.fechaCompra != null)
				return false;
		} else if (!fechaCompra.equals(other.fechaCompra))
			return false;
		if (nombreAnuncio == null) {
			if (other.nombreAnuncio != null)
				return false;
		} else if (!nombreAnuncio.equals(other.nombreAnuncio))
			return false;
		if (urlFactura == null) {
			if (other.urlFactura != null)
				return false;
		} else if (!urlFactura.equals(other.urlFactura))
			return false;
		return true;
	}
	public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    public Boolean getEstadoEnvio() {
        return estadoEnvio;
    }
    public void setEstadoEnvio(Boolean estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }



}
