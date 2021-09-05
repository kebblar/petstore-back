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
 * Nombre:      GraficaTO
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:48:19
 */
package io.kebblar.petstore.api.model.domain;

import java.util.List;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.GraficaTO}.
 *
 * @author ulopez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class GraficaTO {

    /*
     * Atributos de la clase.
     */
    List<ChartData> chart;

    /**
     * Constructor por default (sin parámetros).
     */
    public GraficaTO() {
        super();
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param chart a {@link java.util.List} object.
     */
    public GraficaTO(List<ChartData> chart) {
        super();
        this.chart = chart;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>chart</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<ChartData> getChart() {
        return chart;
    }

    /**
     * <p>Setter for the field <code>chart</code>.</p>
     *
     * @param chart a {@link java.util.List} object.
     */
    public void setChart(List<ChartData> chart) {
        this.chart = chart;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chart == null) ? 0 : chart.hashCode());
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
        GraficaTO other = (GraficaTO) obj;
        if (chart == null) {
            if (other.chart != null)
                return false;
        } else if (!chart.equals(other.chart))
            return false;
        return true;
    }

}
