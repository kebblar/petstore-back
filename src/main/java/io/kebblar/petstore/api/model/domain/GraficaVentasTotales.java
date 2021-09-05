/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      GraficaVentasTotales
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:49:13
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.GraficaVentasTotales}.
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaVentasTotales implements Serializable {

    private static final long serialVersionUID = 4897377279463910357L;
    /*
     * Atributos de la clase.
     */
    private Long totalVenta;
    private int cantidadOrdenes;
    private int mes;
    private int anio;

    /**
     * Constructor por default (sin parámetros).
     */
    public GraficaVentasTotales() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param totalVenta a {@link java.lang.Long} object.
     * @param cantidadOrdenes a int.
     * @param mes a int.
     * @param anio a int.
     */
    public GraficaVentasTotales(Long totalVenta, int cantidadOrdenes, int mes, int anio) {
        this.totalVenta = totalVenta;
    this.cantidadOrdenes = cantidadOrdenes;
        this.mes = mes;
        this.anio = anio;
    }

    /*
     * Setter y Getter.
     */
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
        return "GraficaVentasTotales [total_venta=" + totalVenta + ", cantidad_ordenes=" + cantidadOrdenes + ", mes="
            + mes + ", anio=" + anio + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + anio;
        result = prime * result + cantidadOrdenes;
        result = prime * result + mes;
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
        GraficaVentasTotales other = (GraficaVentasTotales) obj;
        if (anio != other.anio)
            return false;
        if (cantidadOrdenes != other.cantidadOrdenes)
            return false;
        if (mes != other.mes)
            return false;
        if (totalVenta == null) {
            if (other.totalVenta != null)
                return false;
        } else if (!totalVenta.equals(other.totalVenta))
            return false;
        return true;
    }
}
