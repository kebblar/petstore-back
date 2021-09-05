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
 * Nombre:      GraficaTipoPago
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:48:08
 */
package io.kebblar.petstore.api.model.domain;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.GraficaTipoPago}.
 *
 * @author Diego González
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaTipoPago {

    /*
     * Atributos de la clase.
     */
    private String tipoPago;
    private Long totalVenta;
    private int cantidadOrdenes;
    private int mes;
    private int anio;

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param tipoPago a {@link java.lang.String} object.
     * @param totalVenta a {@link java.lang.Long} object.
     * @param cantidadOrdenes a int.
     * @param mes a int.
     * @param anio a int.
     */
    public GraficaTipoPago(String tipoPago, Long totalVenta, int cantidadOrdenes, int mes, int anio) {
        super();
        this.tipoPago = tipoPago;
        this.totalVenta = totalVenta;
        this.cantidadOrdenes = cantidadOrdenes;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Constructor por default (sin parámetros).
     */
    public GraficaTipoPago() {
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>tipoPago</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTipoPago() {
        return tipoPago;
    }

    /**
     * <p>Setter for the field <code>tipoPago</code>.</p>
     *
     * @param tipoPago a {@link java.lang.String} object.
     */
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    /**
     * <p>Getter for the field <code>totalVenta</code>.</p>
     *
     * @return a {@link java.lang.Long} object.
     */
    public Long getTotalVenta() {
        return totalVenta;
    }

    /**
     * <p>Setter for the field <code>totalVenta</code>.</p>
     *
     * @param totalVenta a {@link java.lang.Long} object.
     */
    public void setTotalVenta(Long totalVenta) {
        this.totalVenta = totalVenta;
    }

    /**
     * <p>Getter for the field <code>cantidadOrdenes</code>.</p>
     *
     * @return a int.
     */
    public int getCantidadOrdenes() {
        return cantidadOrdenes;
    }

    /**
     * <p>Setter for the field <code>cantidadOrdenes</code>.</p>
     *
     * @param cantidadOrdenes a int.
     */
    public void setCantidadOrdenes(int cantidadOrdenes) {
        this.cantidadOrdenes = cantidadOrdenes;
    }

    /**
     * <p>Getter for the field <code>mes</code>.</p>
     *
     * @return a int.
     */
    public int getMes() {
        return mes;
    }

    /**
     * <p>Setter for the field <code>mes</code>.</p>
     *
     * @param mes a int.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * <p>Getter for the field <code>anio</code>.</p>
     *
     * @return a int.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * <p>Setter for the field <code>anio</code>.</p>
     *
     * @param anio a int.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "GraficaTipoPago [tipo_pago=" + tipoPago + ", total_venta=" + totalVenta + ", cantidad_ordenes="
                + cantidadOrdenes + ", mes=" + mes + ", anio=" + anio + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + anio;
        result = prime * result + cantidadOrdenes;
        result = prime * result + mes;
        result = prime * result + ((tipoPago == null) ? 0 : tipoPago.hashCode());
        result = prime * result + ((totalVenta == null) ? 0 : totalVenta.hashCode());
        return result;
    }

    /** {@inheritDoc} */
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
        if (cantidadOrdenes != other.cantidadOrdenes)
            return false;
        if (mes != other.mes)
            return false;
        if (tipoPago == null) {
            if (other.tipoPago != null)
                return false;
        } else if (!tipoPago.equals(other.tipoPago))
            return false;
        if (totalVenta == null) {
            if (other.totalVenta != null)
                return false;
        } else if (!totalVenta.equals(other.totalVenta))
            return false;
        return true;
    }





}
