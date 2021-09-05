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
 * Nombre:      ChartWrapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:17:32
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
