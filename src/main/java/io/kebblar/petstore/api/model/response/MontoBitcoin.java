package io.kebblar.petstore.api.model.response;

import java.util.Objects;

public class MontoBitcoin {

    private double monto;
    private double cambio;

    public MontoBitcoin(){ }

    public MontoBitcoin(double monto, double cambio) {
        this.monto = monto;
        this.cambio = cambio;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MontoBitcoin)) return false;
        MontoBitcoin that = (MontoBitcoin) o;
        return Double.compare(that.monto, monto) == 0 && Double.compare(that.cambio, cambio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monto, cambio);
    }

    @Override
    public String toString() {
        return "MontoBitcoin{" +
                "monto=" + monto +
                ", cambio=" + cambio +
                '}';
    }
}
