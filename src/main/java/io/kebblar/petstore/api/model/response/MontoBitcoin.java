/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      MontoBitcoin
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:21:19
 */
package io.kebblar.petstore.api.model.response;

import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'MontoBitcoin'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MontoBitcoin {

    /**
     * Atributos de clase
     */
    private double monto;
    private double cambio;

    /**
     * Constructor por default (sin parámetros).
     */
    public MontoBitcoin(){ }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param monto a double.
     * @param cambio a double.
     */
    public MontoBitcoin(double monto, double cambio) {
        this.monto = monto;
        this.cambio = cambio;
    }

    /**
     * Getter para monto.
     *
     * @return a double.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Setter para monto.
     *
     * @param monto a double.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Getter para cambio.
     *
     * @return a double.
     */
    public double getCambio() {
        return cambio;
    }

    /**
     * Setter para cambio.
     *
     * @param cambio a double.
     */
    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    /**
     * {@inheritDoc}
     *
     * Método equals para el pojo, para saber si dos objetos son iguales.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MontoBitcoin)) return false;
        MontoBitcoin that = (MontoBitcoin) o;
        return Double.compare(that.monto, monto) == 0 && Double.compare(that.cambio, cambio) == 0;
    }

    /**
     * {@inheritDoc}
     *
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(monto, cambio);
    }

    /**
     * {@inheritDoc}
     *
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "MontoBitcoin{" +
                "monto=" + monto +
                ", cambio=" + cambio +
                '}';
    }
}
