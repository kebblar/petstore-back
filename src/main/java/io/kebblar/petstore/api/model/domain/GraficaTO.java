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
 * Artefacto:   GraficaTO .java
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

import java.util.List;

/**
 * Implementacion del POJO de la entidad de {@link GraficaTO}.
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
     */
    public GraficaTO(List<ChartData> chart) {
        super();
        this.chart = chart;
    }

    /*
     * Setter y Getter.
     */
    public List<ChartData> getChart() {
        return chart;
    }

    public void setChart(List<ChartData> chart) {
        this.chart = chart;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chart == null) ? 0 : chart.hashCode());
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
        GraficaTO other = (GraficaTO) obj;
        if (chart == null) {
            if (other.chart != null)
                return false;
        } else if (!chart.equals(other.chart))
            return false;
        return true;
    }

}
