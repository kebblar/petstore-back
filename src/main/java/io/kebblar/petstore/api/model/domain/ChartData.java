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
 * Nombre:      ChartData
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:17:23
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.ChartData}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ChartData implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    /*
     * Atributos de la clase.
     */
    private List<String> label;
    private List<Long> data;
    private Set<String> mes;

    /**
     * Constructor por default (sin parámetros).
     */
    public ChartData() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param label a {@link java.util.List} object.
     * @param data a {@link java.util.List} object.
     * @param mes a {@link java.util.Set} object.
     */
    public ChartData(List<String> label, List<Long> data, Set<String> mes) {
        super();
        this.label = label;
        this.data = data;
        this.mes = mes;
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>label</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<String> getLabel() {
        return label;
    }

    /**
     * <p>Setter for the field <code>label</code>.</p>
     *
     * @param label a {@link java.util.List} object.
     */
    public void setLabel(List<String> label) {
        this.label = label;
    }

    /**
     * <p>Getter for the field <code>data</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Long> getData() {
        return data;
    }

    /**
     * <p>Setter for the field <code>data</code>.</p>
     *
     * @param data a {@link java.util.List} object.
     */
    public void setData(List<Long> data) {
        this.data = data;
    }

    /**
     * <p>Getter for the field <code>mes</code>.</p>
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<String> getMes() {
        return mes;
    }

    /**
     * <p>Setter for the field <code>mes</code>.</p>
     *
     * @param mes a {@link java.util.Set} object.
     */
    public void setMes(Set<String> mes) {
        this.mes = mes;
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
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((mes == null) ? 0 : mes.hashCode());
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
        ChartData other = (ChartData) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (mes == null) {
            if (other.mes != null)
                return false;
        } else if (!mes.equals(other.mes))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ChartData [label=" + label + ", data=" + data + ", mes=" + mes + "]";
    }

}
