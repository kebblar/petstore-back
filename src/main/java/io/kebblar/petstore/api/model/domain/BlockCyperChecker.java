package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Clase pojo para generar objetos que representan el balance de una cartera bitcoin.
 */
public class BlockCyperChecker {

    /*
     * Atributos de la clase.
     */
    private String address;
    private double totalReceived;
    private double totalSent;
    private double balance;
    private double finalBalance;
    private double nTx;
    private double unconfirmedNTx;
    private double finalNTx;

    /**
     * Constructor por default (sin parámetros).
     */
    public BlockCyperChecker() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public BlockCyperChecker(String address, double totalReceived, double totalSent, double balance, double finalBalance, double nTx, double unconfirmedNTx, double finalNTx) {
        this.address = address;
        this.totalReceived = totalReceived;
        this.totalSent = totalSent;
        this.balance = balance;
        this.finalBalance = finalBalance;
        this.nTx = nTx;
        this.unconfirmedNTx = unconfirmedNTx;
        this.finalNTx = finalNTx;
    }

    /*
     * Getter y Setter.
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(double totalReceived) {
        this.totalReceived = totalReceived;
    }

    public double getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(double totalSent) {
        this.totalSent = totalSent;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public double getnTx() {
        return nTx;
    }

    public void setnTx(double nTx) {
        this.nTx = nTx;
    }

    public double getUnconfirmedNTx() {
        return unconfirmedNTx;
    }

    public void setUnconfirmedNTx(double unconfirmedNTx) {
        this.unconfirmedNTx = unconfirmedNTx;
    }

    public double getFinalNTx() {
        return finalNTx;
    }

    public void setFinalNTx(double finalNTx) {
        this.finalNTx = finalNTx;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlockCyperChecker)) return false;
        BlockCyperChecker that = (BlockCyperChecker) o;
        return totalReceived == that.totalReceived && totalSent == that.totalSent && balance == that.balance && finalBalance == that.finalBalance && nTx == that.nTx && unconfirmedNTx == that.unconfirmedNTx && finalNTx == that.finalNTx && Objects.equals(address, that.address);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(address, totalReceived, totalSent, balance, finalBalance, nTx, unconfirmedNTx, finalNTx);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "BlockCyperChecker{" +
                "address='" + address + '\'' +
                ", totalReceived=" + totalReceived +
                ", totalSent=" + totalSent +
                ", balance=" + balance +
                ", finalBalance=" + finalBalance +
                ", nTx=" + nTx +
                ", unconfirmedNTx=" + unconfirmedNTx +
                ", finalNTx=" + finalNTx +
                '}';
    }
}
