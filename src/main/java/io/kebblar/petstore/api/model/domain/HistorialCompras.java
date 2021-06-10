/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.model
 * Modulo:      HistorialCompras
 * Tipo:        clase
 * Autor:       Luis Martinez
 * Fecha:       Thursday 10 June 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'HistorialCompras'.
 *
 * Historia:    .
 *              20210519_0935 Generado por LMtz
 *              20210610_0935 Actualizado por LMtz
 *
 */
package io.kebblar.petstore.api.model.domain;

/**
 * Implementacion del POJO de la entidad de {@link HistorialCompras}.
 *
 * @author  LMtz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class HistorialCompras {
    /**
     * Atributos de la clase
     */
    private String cveOrden;
    private String fechaHoraCompra;
    private int estadoEnvio;
    private int idUsuario;
    private String nombreAnuncio;
    private String metodoPago;
    private String correo;
    private String urlPdf;
    private String urlImagen;

    /**
     * Constructor por default.
     */
    public HistorialCompras() {}

    public HistorialCompras(String cveOrden,String fechaHoraCompra, int estadoEnvio, int idUsuario, String nombreAnuncio,
            String metodoPago, String correo, String urlPdf, String urlImagen) {
        super();
        this.cveOrden = cveOrden;
        this.fechaHoraCompra = fechaHoraCompra;
        this.estadoEnvio = estadoEnvio;
        this.idUsuario = idUsuario;
        this.nombreAnuncio = nombreAnuncio;
        this.metodoPago = metodoPago;
        this.correo = correo;
        this.urlPdf = urlPdf;
        this.urlImagen = urlImagen;
    }

    public String getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(String fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }


    public String getUrlPdf() {
        return urlPdf;
    }

    public void setUrlPdf(String urlPdf) {
        this.urlPdf = urlPdf;
    }
    
    

    @Override
	public String toString() {
		return "HistorialCompras [cveOrden=" + cveOrden + ", fechaHoraCompra=" + fechaHoraCompra + ", estadoEnvio="
				+ estadoEnvio + ", idUsuario=" + idUsuario + ", nombreAnuncio=" + nombreAnuncio + ", metodoPago="
				+ metodoPago + ", correo=" + correo + ", urlPdf=" + urlPdf + ", urlImagen=" + urlImagen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((cveOrden == null) ? 0 : cveOrden.hashCode());
		result = prime * result + estadoEnvio;
		result = prime * result + ((fechaHoraCompra == null) ? 0 : fechaHoraCompra.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((metodoPago == null) ? 0 : metodoPago.hashCode());
		result = prime * result + ((nombreAnuncio == null) ? 0 : nombreAnuncio.hashCode());
		result = prime * result + ((urlImagen == null) ? 0 : urlImagen.hashCode());
		result = prime * result + ((urlPdf == null) ? 0 : urlPdf.hashCode());
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
		HistorialCompras other = (HistorialCompras) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (cveOrden == null) {
			if (other.cveOrden != null)
				return false;
		} else if (!cveOrden.equals(other.cveOrden))
			return false;
		if (estadoEnvio != other.estadoEnvio)
			return false;
		if (fechaHoraCompra == null) {
			if (other.fechaHoraCompra != null)
				return false;
		} else if (!fechaHoraCompra.equals(other.fechaHoraCompra))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (metodoPago == null) {
			if (other.metodoPago != null)
				return false;
		} else if (!metodoPago.equals(other.metodoPago))
			return false;
		if (nombreAnuncio == null) {
			if (other.nombreAnuncio != null)
				return false;
		} else if (!nombreAnuncio.equals(other.nombreAnuncio))
			return false;
		if (urlImagen == null) {
			if (other.urlImagen != null)
				return false;
		} else if (!urlImagen.equals(other.urlImagen))
			return false;
		if (urlPdf == null) {
			if (other.urlPdf != null)
				return false;
		} else if (!urlPdf.equals(other.urlPdf))
			return false;
		return true;
	}

	public String getNombreAnuncio() {
        return nombreAnuncio;
    }

    public void setNombreAnuncio(String nombreAnuncio) {
        this.nombreAnuncio = nombreAnuncio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(int estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

	public String getCveOrden() {
		return cveOrden;
	}

	public void setCveOrden(String cveOrden) {
		this.cveOrden = cveOrden;
	}

}
