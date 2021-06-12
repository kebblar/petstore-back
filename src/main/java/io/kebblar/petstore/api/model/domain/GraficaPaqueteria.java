
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
 * Artefacto:   GraficaPaqueteria .java
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

/**
 * Implementacion del POJO de la entidad de {@link GraficaPaqueteria}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class GraficaPaqueteria implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    /**
     * Atributos de la clase
     */
    private String paqueteria;
    private Long cantidad;

    public GraficaPaqueteria(String paqueteria, Long cantidad) {
        super();
        this.paqueteria = paqueteria;
        this.cantidad = cantidad;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getPaqueteria() {
        return paqueteria;
    }

    public void setPaqueteria(String paqueteria) {
        this.paqueteria = paqueteria;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "GraficaPaqueteria [paqueteria=" + paqueteria + ", cantidad=" + cantidad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
        result = prime * result + ((paqueteria == null) ? 0 : paqueteria.hashCode());
        return result;
    }

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
        if (paqueteria == null) {
            if (other.paqueteria != null)
                return false;
        } else if (!paqueteria.equals(other.paqueteria))
            return false;
        return true;
    }

}
