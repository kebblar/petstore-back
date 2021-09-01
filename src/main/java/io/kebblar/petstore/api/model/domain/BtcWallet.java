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
 * Artefacto:   Atributo .java
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
     */
    public BtcWallet(int idUser, String address, String privateKey) {
        this.idUser = idUser;
        this.address = address;
        this.privateKey = privateKey;
    }

    /*
     * getter y setter.
     */
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BtcWallet)) return false;
        BtcWallet btcWallet = (BtcWallet) o;
        return idUser == btcWallet.idUser && address.equals(btcWallet.address) && privateKey.equals(btcWallet.privateKey);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(idUser, address, privateKey);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "BtcWallet{" +
                "idUser=" + idUser +
                ", address='" + address + '\'' +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
