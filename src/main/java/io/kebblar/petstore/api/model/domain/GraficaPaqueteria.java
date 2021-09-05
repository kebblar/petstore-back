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
 * Nombre:      GraficaPaqueteria
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:23:53
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.GraficaPaqueteria}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaPaqueteria implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    /*
     * Atributos de la clase.
     */
    private String paqueteria;
    private Long cantidad;
    private Date fecha;

    /**
     * Constructor por default (sin parámetros).
     */
    public GraficaPaqueteria() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param paqueteria a {@link java.lang.String} object.
     * @param cantidad a {@link java.lang.Long} object.
     * @param fecha a {@link java.util.Date} object.
     */
    public GraficaPaqueteria(String paqueteria, Long cantidad, Date fecha) {
        this.paqueteria = paqueteria;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>paqueteria</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPaqueteria() {
        return paqueteria;
    }

    /**
     * <p>Setter for the field <code>paqueteria</code>.</p>
     *
     * @param paqueteria a {@link java.lang.String} object.
     */
    public void setPaqueteria(String paqueteria) {
        this.paqueteria = paqueteria;
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
        return "GraficaPaqueteria [paqueteria=" + paqueteria + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((paqueteria == null) ? 0 : paqueteria.hashCode());
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
        GraficaPaqueteria other = (GraficaPaqueteria) obj;
        if (cantidad == null) {
            if (other.cantidad != null)
                return false;
        } else if (!cantidad.equals(other.cantidad))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (paqueteria == null) {
            if (other.paqueteria != null)
                return false;
        } else if (!paqueteria.equals(other.paqueteria))
            return false;
        return true;
    }

}
