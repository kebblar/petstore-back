package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Clase pojo para generar objetos que representan el balance de una cartera bitcoin
 */
public class BlockCyperChecker {

    private String address;
    private long totalReceived;
    private long totalSent;
    private long balance;
    private long finalBalance;
    private long nTx;
    private long unconfirmedNTx;
    private long finalNTx;

    /*
     * Constructor sin parametros
     */
    public BlockCyperChecker() {
    }

    public String getAddress() {
        return address;
    }

    public BlockCyperChecker(String address, long totalReceived, long totalSent, long balance, long finalBalance, long nTx, long unconfirmedNTx, long finalNTx) {
        this.address = address;
        this.totalReceived = totalReceived;
        this.totalSent = totalSent;
        this.balance = balance;
        this.finalBalance = finalBalance;
        this.nTx = nTx;
        this.unconfirmedNTx = unconfirmedNTx;
        this.finalNTx = finalNTx;
    }

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

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(long totalReceived) {
        this.totalReceived = totalReceived;
    }

    public long getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(long totalSent) {
        this.totalSent = totalSent;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(long finalBalance) {
        this.finalBalance = finalBalance;
    }

    public long getnTx() {
        return nTx;
    }

    public void setnTx(long nTx) {
        this.nTx = nTx;
    }

    public long getUnconfirmedNTx() {
        return unconfirmedNTx;
    }

    public void setUnconfirmedNTx(long unconfirmedNTx) {
        this.unconfirmedNTx = unconfirmedNTx;
    }

    public long getFinalNTx() {
        return finalNTx;
    }

    public void setFinalNTx(long finalNTx) {
        this.finalNTx = finalNTx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlockCyperChecker)) return false;
        BlockCyperChecker that = (BlockCyperChecker) o;
        return totalReceived == that.totalReceived && totalSent == that.totalSent && balance == that.balance && finalBalance == that.finalBalance && nTx == that.nTx && unconfirmedNTx == that.unconfirmedNTx && finalNTx == that.finalNTx && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, totalReceived, totalSent, balance, finalBalance, nTx, unconfirmedNTx, finalNTx);
    }
}
