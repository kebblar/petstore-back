/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   MontoBitcoin.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (21_41)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de clase
 *
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

    /*
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
     */
    public MontoBitcoin(double monto, double cambio) {
        this.monto = monto;
        this.cambio = cambio;
    }

    /*
     * Getter y setter.
     */
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    /**
     * {@inheritDoc}
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
     */
    @Override
    public int hashCode() {
        return Objects.hash(monto, cambio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "MontoBitcoin{" +
                "monto=" + monto +
                ", cambio=" + cambio +
                '}';
    }

}
