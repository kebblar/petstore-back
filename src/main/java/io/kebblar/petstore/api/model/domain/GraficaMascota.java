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
 * Nombre:      GraficaMascota
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:23:34
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.GraficaMascota}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaMascota implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    /*
     * Atributos de la clase.
     */
    private String mascota;
    private Long cantidad;
    private Date fecha;

    /**
     * Constructor por default (sin parámetros).
     */
    public GraficaMascota() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param mascota a {@link java.lang.String} object.
     * @param cantidad a {@link java.lang.Long} object.
     * @param fecha a {@link java.util.Date} object.
     */
    public GraficaMascota(String mascota, Long cantidad, Date fecha) {
        super();
        this.mascota = mascota;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>mascota</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMascota() {
        return mascota;
    }

    /**
     * <p>Setter for the field <code>mascota</code>.</p>
     *
     * @param mascota a {@link java.lang.String} object.
     */
    public void setMascota(String mascota) {
        this.mascota = mascota;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((mascota == null) ? 0 : mascota.hashCode());
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
        GraficaMascota other = (GraficaMascota) obj;
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
        if (mascota == null) {
            if (other.mascota != null)
                return false;
        } else if (!mascota.equals(other.mascota))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "GraficaMascota [mascota=" + mascota + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
    }

}
