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
 * Artefacto:   GraficaComprador .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       ULises López
 * Fecha:       Tuesday 10 de Jun de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210610_1444 Implementación de clase
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Implementacion del POJO de la entidad de {@link GraficaComprador}.
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
     */
    public GraficaComprador(String comprador, Long cantidad, Date fecha) {
        this.comprador = comprador;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /*
     * Setter y Getter.
     */
    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
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
    public String toString() {
        return "GraficaComprador [comprador=" + comprador + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
        result = prime * result + ((comprador == null) ? 0 : comprador.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
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
