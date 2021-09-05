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
 * Nombre:      Grafica
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:23:02
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.Grafica}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Grafica implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    /*
     * Atributos de la clase.
     */
    private String etiqueta;
    private Long cantidad;
    private Date fecha;

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param etiqueta a {@link java.lang.String} object.
     * @param cantidad a {@link java.lang.Long} object.
     * @param fecha a {@link java.util.Date} object.
     */
    public Grafica(String etiqueta, Long cantidad, Date fecha) {
        super();
        this.etiqueta = etiqueta;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /**
     * <p>Constructor for Grafica.</p>
     */
    public Grafica() {
        super();
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>etiqueta</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * <p>Setter for the field <code>etiqueta</code>.</p>
     *
     * @param etiqueta a {@link java.lang.String} object.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grafica)) return false;
        Grafica grafica = (Grafica) o;
        return Objects.equals(etiqueta, grafica.etiqueta) && Objects.equals(cantidad, grafica.cantidad) && Objects.equals(fecha, grafica.fecha);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(etiqueta, cantidad, fecha);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Grafica [etiqueta=" + etiqueta + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
    }

}
