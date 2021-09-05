/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      HistorialCompras
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:49:24
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link HistorialCompras}.
 *
 * @author  LMtz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class HistorialCompras {
    /**
     * Atributos de la clase.
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

    /**
     * Constructor basado en los atributos de la clase.
     */
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

    /*
     * Setter y Getter.
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "HistorialCompras [cveOrden=" + cveOrden + ", fechaHoraCompra=" + fechaHoraCompra + ", estadoEnvio="
                + estadoEnvio + ", idUsuario=" + idUsuario + ", nombreAnuncio=" + nombreAnuncio + ", metodoPago="
                + metodoPago + ", correo=" + correo + ", urlPdf=" + urlPdf + ", urlImagen=" + urlImagen + "]";
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistorialCompras)) return false;
        HistorialCompras that = (HistorialCompras) o;
        return estadoEnvio == that.estadoEnvio && idUsuario == that.idUsuario && Objects.equals(cveOrden, that.cveOrden)
                && Objects.equals(fechaHoraCompra, that.fechaHoraCompra) && Objects.equals(nombreAnuncio, that.nombreAnuncio)
                && Objects.equals(metodoPago, that.metodoPago) && Objects.equals(correo, that.correo) && Objects.equals(urlPdf, that.urlPdf)
                && Objects.equals(urlImagen, that.urlImagen);
    }
}
