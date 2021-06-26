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
 * Fecha:       Tuesday 25 de Jun de 2021 (20_02)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210625_1002 Implementación de clase
 */
package io.kebblar.petstore.api.model.domain;

/**
 * Implementacion del POJO de la entidad de {@link ChartWrapper}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class ChartWrapper {
    private ChartData chart;

    public ChartWrapper() {
    }

    public ChartWrapper(ChartData chart) {
        this.chart = chart;
    }

    public ChartData getGraphData() {
        return chart;
    }

    public void setGraphData(ChartData chart) {
        this.chart = chart;
    }

    @Override
    public String toString() {
        return "Chart [graphData=" + chart + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chart == null) ? 0 : chart.hashCode());
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
        ChartWrapper other = (ChartWrapper) obj;
        if (chart == null) {
            if (other.chart != null)
                return false;
        } else if (!chart.equals(other.chart))
            return false;
        return true;
    }

}
