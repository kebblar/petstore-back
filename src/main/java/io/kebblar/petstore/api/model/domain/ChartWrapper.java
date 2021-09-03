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

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link ChartWrapper}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class ChartWrapper {

    /*
     * Atributos de la clase.
     */
    private ChartData chart;

    /**
     * Constructor por default (sin parámetros).
     */
    public ChartWrapper() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     */
    public ChartWrapper(ChartData chart) {
        this.chart = chart;
    }

    /*
     * Getter y Setter.
     */
    public ChartData getChart() {
        return chart;
    }

    public void setChart(ChartData chart) {
        this.chart = chart;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Chart [chart=" + chart + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChartWrapper)) return false;
        ChartWrapper that = (ChartWrapper) o;
        return Objects.equals(chart, that.chart);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(chart);
    }
}
