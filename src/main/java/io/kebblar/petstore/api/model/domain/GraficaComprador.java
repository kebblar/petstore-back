/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      GraficaComprador
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:23:18
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.GraficaComprador}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaComprador implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    private String comprador;
    private Long cantidad;
    private Date fecha;

    /**
     * Constructor por default (sin parámetros).
     */
    public GraficaComprador() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param comprador a {@link java.lang.String} object.
     * @param cantidad a {@link java.lang.Long} object.
     * @param fecha a {@link java.util.Date} object.
     */
    public GraficaComprador(String comprador, Long cantidad, Date fecha) {
        this.comprador = comprador;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>comprador</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getComprador() {
        return comprador;
    }

    /**
     * <p>Setter for the field <code>comprador</code>.</p>
     *
     * @param comprador a {@link java.lang.String} object.
     */
    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    /**
     * <p>Getter for the field <code>cantidad</code>.</p>
     *
     * @return a {@link java.lang.Long} object.
     */
    public Long getCantidad() {
        return cantidad;
    }

    /**
     * <p>Setter for the field <code>cantidad</code>.</p>
     *
     * @param cantidad a {@link java.lang.Long} object.
     */
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * <p>Getter for the field <code>fecha</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * <p>Setter for the field <code>fecha</code>.</p>
     *
     * @param fecha a {@link java.util.Date} object.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * <p>getSerialversionuid.</p>
     *
     * @return a long.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "GraficaComprador [comprador=" + comprador + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
        result = prime * result + ((comprador == null) ? 0 : comprador.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
        GraficaComprador other = (GraficaComprador) obj;
        if (cantidad == null) {
            if (other.cantidad != null)
                return false;
        } else if (!cantidad.equals(other.cantidad))
            return false;
        if (comprador == null) {
            if (other.comprador != null)
                return false;
        } else if (!comprador.equals(other.comprador))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        return true;
    }

}
