/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   Grafica .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Ulises López
 * Fecha:       Tuesday 17 de Jun de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210610_1444 Implementación de clase
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link Grafica}.
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
     */
    public Grafica(String etiqueta, Long cantidad, Date fecha) {
        super();
        this.etiqueta = etiqueta;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Grafica() {
        super();
    }

    /*
     * Getter y Setter.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grafica)) return false;
        Grafica grafica = (Grafica) o;
        return Objects.equals(etiqueta, grafica.etiqueta) && Objects.equals(cantidad, grafica.cantidad) && Objects.equals(fecha, grafica.fecha);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(etiqueta, cantidad, fecha);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Grafica [etiqueta=" + etiqueta + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
    }

}
