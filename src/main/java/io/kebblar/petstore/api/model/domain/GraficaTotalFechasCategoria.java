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
 * Artefacto:   GraficaTotalFechasCategoria.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Francisco Espinosa
 * Fecha:       Tuesday 16 de Jun de 2021 (09_00)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210616_0900 Creación de este POJO
 */
    package io.kebblar.petstore.api.model.domain;

    import java.io.Serializable;

    /**
     * Implementacion del POJO de la entidad de {@link GraficaTotalFechasCategoria}.
     *
     * @author FranciscoEspinosa
     * @version 1.0-SNAPSHOT
     * @since 1.0-SNAPSHOT
     */
    public class GraficaTotalFechasCategoria implements Serializable {

        private static final long serialVersionUID = 4897377279463910357L;

        /*
         * Atributos de la clase.
         */
        private String categoria;
        private Long totalVenta;
        private int cantidadOrdenes;
        private int mes;
        private int anio;

        /**
         * Constructor por default (sin parámetros).
         */
        public GraficaTotalFechasCategoria() {
        }

        /**
         * Constructor basado en los atributos de la clase.
         */
        public GraficaTotalFechasCategoria(String categoria, Long totalVenta, int cantidadOrdenes, int mes,
                int anio) {
            super();
            this.categoria = categoria;
            this.totalVenta = totalVenta;
            this.cantidadOrdenes = cantidadOrdenes;
            this.mes = mes;
            this.anio = anio;
        }

        /*
         * Setter y Getter.
         */
        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public Long getTotalVenta() {
            return totalVenta;
        }

        public void setTotalVenta(Long totalVenta) {
            this.totalVenta = totalVenta;
        }

        public int getCantidadOrdenes() {
            return cantidadOrdenes;
        }

        public void setCantidadOrdenes(int cantidadOrdenes) {
            this.cantidadOrdenes = cantidadOrdenes;
        }

        public int getMes() {
            return mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "GraficaTotalFechasCategoria [categoria=" + categoria + ", total_venta=" + totalVenta
                    + ", cantidad_ordenes=" + cantidadOrdenes + ", mes=" + mes + ", anio=" + anio + "]";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + anio;
            result = prime * result + cantidadOrdenes;
            result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
            result = prime * result + mes;
            result = prime * result + ((totalVenta == null) ? 0 : totalVenta.hashCode());
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
            GraficaTotalFechasCategoria other = (GraficaTotalFechasCategoria) obj;
            if (anio != other.anio)
                return false;
            if (cantidadOrdenes != other.cantidadOrdenes)
                return false;
            if (categoria == null) {
                if (other.categoria != null)
                    return false;
            } else if (!categoria.equals(other.categoria))
                return false;
            if (mes != other.mes)
                return false;
            if (totalVenta == null) {
                if (other.totalVenta != null)
                    return false;
            } else if (!totalVenta.equals(other.totalVenta))
                return false;
            return true;
        }



}
