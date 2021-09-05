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
 * Nombre:      BlockCyperChecker
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:13:19
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Clase pojo para generar objetos que representan el balance de una cartera bitcoin.
 *
 * @author garellano
 * @version $Id: $Id
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
     *
     * @param address a {@link java.lang.String} object.
     * @param totalReceived a double.
     * @param totalSent a double.
     * @param balance a double.
     * @param finalBalance a double.
     * @param nTx a double.
     * @param unconfirmedNTx a double.
     * @param finalNTx a double.
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
    /**
     * <p>Getter for the field <code>address</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>Setter for the field <code>address</code>.</p>
     *
     * @param address a {@link java.lang.String} object.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <p>Getter for the field <code>totalReceived</code>.</p>
     *
     * @return a double.
     */
    public double getTotalReceived() {
        return totalReceived;
    }

    /**
     * <p>Setter for the field <code>totalReceived</code>.</p>
     *
     * @param totalReceived a double.
     */
    public void setTotalReceived(double totalReceived) {
        this.totalReceived = totalReceived;
    }

    /**
     * <p>Getter for the field <code>totalSent</code>.</p>
     *
     * @return a double.
     */
    public double getTotalSent() {
        return totalSent;
    }

    /**
     * <p>Setter for the field <code>totalSent</code>.</p>
     *
     * @param totalSent a double.
     */
    public void setTotalSent(double totalSent) {
        this.totalSent = totalSent;
    }

    /**
     * <p>Getter for the field <code>balance</code>.</p>
     *
     * @return a double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * <p>Setter for the field <code>balance</code>.</p>
     *
     * @param balance a double.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * <p>Getter for the field <code>finalBalance</code>.</p>
     *
     * @return a double.
     */
    public double getFinalBalance() {
        return finalBalance;
    }

    /**
     * <p>Setter for the field <code>finalBalance</code>.</p>
     *
     * @param finalBalance a double.
     */
    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    /**
     * <p>Getter for the field <code>nTx</code>.</p>
     *
     * @return a double.
     */
    public double getnTx() {
        return nTx;
    }

    /**
     * <p>Setter for the field <code>nTx</code>.</p>
     *
     * @param nTx a double.
     */
    public void setnTx(double nTx) {
        this.nTx = nTx;
    }

    /**
     * <p>Getter for the field <code>unconfirmedNTx</code>.</p>
     *
     * @return a double.
     */
    public double getUnconfirmedNTx() {
        return unconfirmedNTx;
    }

    /**
     * <p>Setter for the field <code>unconfirmedNTx</code>.</p>
     *
     * @param unconfirmedNTx a double.
     */
    public void setUnconfirmedNTx(double unconfirmedNTx) {
        this.unconfirmedNTx = unconfirmedNTx;
    }

    /**
     * <p>Getter for the field <code>finalNTx</code>.</p>
     *
     * @return a double.
     */
    public double getFinalNTx() {
        return finalNTx;
    }

    /**
     * <p>Setter for the field <code>finalNTx</code>.</p>
     *
     * @param finalNTx a double.
     */
    public void setFinalNTx(double finalNTx) {
        this.finalNTx = finalNTx;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlockCyperChecker)) return false;
        BlockCyperChecker that = (BlockCyperChecker) o;
        return totalReceived == that.totalReceived && totalSent == that.totalSent && balance == that.balance && finalBalance == that.finalBalance && nTx == that.nTx && unconfirmedNTx == that.unconfirmedNTx && finalNTx == that.finalNTx && Objects.equals(address, that.address);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(address, totalReceived, totalSent, balance, finalBalance, nTx, unconfirmedNTx, finalNTx);
    }

    /** {@inheritDoc} */
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
