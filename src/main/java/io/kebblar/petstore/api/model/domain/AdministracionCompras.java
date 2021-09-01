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
 * Fecha:       Thursday 10 June 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'AdministracionCompras'.
 *
 * Historia:    .
 *              20210519_0935 Generado por LMtz
 *              20210610_0935 Actualizado por LMtz
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link AdministracionCompras}.
 *
 * @author  LMtz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class AdministracionCompras {

    /*
     * Atributos de la clase.
     */
    private Boolean estadoEnvio;
    private String cveOrden;
    private String nombreAnuncio;
    private String urlFactura;
    private String fechaCompra;
    private String calleNumero;
    private String colonia;
    private String cp;

    /**
     * Constructor basado en todos los atributos de la clase.
     */
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
    /*
     * Getter y Setter.
     */
    public String getCveOrden() {
        return cveOrden;
    }

    public void setCveOrden(String cveOrden) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AdministracionCompras [estadoEnvio=" + estadoEnvio + ", cveOrden=" + cveOrden + ", nombreAnuncio="
                + nombreAnuncio + ", urlFactura=" + urlFactura + ", fechaCompra=" + fechaCompra + ", calleNumero="
                + calleNumero + ", colonia=" + colonia + ", cp=" + cp + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdministracionCompras)) return false;
        AdministracionCompras that = (AdministracionCompras) o;
        return Objects.equals(estadoEnvio, that.estadoEnvio) && Objects.equals(cveOrden, that.cveOrden) &&
                Objects.equals(nombreAnuncio, that.nombreAnuncio) && Objects.equals(urlFactura, that.urlFactura) &&
                Objects.equals(fechaCompra, that.fechaCompra) && Objects.equals(calleNumero, that.calleNumero) &&
                Objects.equals(colonia, that.colonia) && Objects.equals(cp, that.cp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(estadoEnvio, cveOrden, nombreAnuncio, urlFactura, fechaCompra, calleNumero, colonia, cp);
    }
}
