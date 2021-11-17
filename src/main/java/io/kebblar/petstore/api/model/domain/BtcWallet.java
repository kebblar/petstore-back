/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      BtcWallet
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:13:32
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class BtcWallet {

    /*
     * Atributos de la clase.
     */
    private int idUser;
    private String address;
    private String privateKey;

    /**
     * Constructor por default (sin parámetros).
     */
    public BtcWallet() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param idUser a int.
     * @param address a {@link java.lang.String} object.
     * @param privateKey a {@link java.lang.String} object.
     */
    public BtcWallet(int idUser, String address, String privateKey) {
        this.idUser = idUser;
        this.address = address;
        this.privateKey = privateKey;
    }

    /*
     * getter y setter.
     */
    /**
     * <p>Getter for the field <code>idUser</code>.</p>
     *
     * @return a int.
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * <p>Setter for the field <code>idUser</code>.</p>
     *
     * @param idUser a int.
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

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
     * <p>Getter for the field <code>privateKey</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * <p>Setter for the field <code>privateKey</code>.</p>
     *
     * @param privateKey a {@link java.lang.String} object.
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BtcWallet)) return false;
        BtcWallet btcWallet = (BtcWallet) o;
        return idUser == btcWallet.idUser && address.equals(btcWallet.address) && privateKey.equals(btcWallet.privateKey);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(idUser, address, privateKey);
    }
    
    public int getHash() {
        return this.hashCode();
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "BtcWallet{" +
                "idUser=" + idUser +
                ", address='" + address + '\'' +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
