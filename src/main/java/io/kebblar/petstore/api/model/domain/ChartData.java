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
 * Artefacto:   Chart .java
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
import java.util.List;
import java.util.Set;

/**
 * Implementacion del POJO de la entidad de {@link ChartData}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ChartData implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    private List<String> label;
    private List<Long> data;
    private Set<String> mes;

    public ChartData() {
    }

    public ChartData(List<String> label, List<Long> data, Set<String> mes) {
        super();
        this.label = label;
        this.data = data;
        this.mes = mes;
    }

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }

    public Set<String> getMes() {
        return mes;
    }

    public void setMes(Set<String> mes) {
        this.mes = mes;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((mes == null) ? 0 : mes.hashCode());
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

    @Override
    public String toString() {
        return "ChartData [label=" + label + ", data=" + data + ", mes=" + mes + "]";
    }

}
