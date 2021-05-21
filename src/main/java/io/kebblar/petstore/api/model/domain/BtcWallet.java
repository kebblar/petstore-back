package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

public class BtcWallet {

    private int idUser;
    private String address;
    private String privateKey;

    public BtcWallet() {
    }

    public BtcWallet(int idUser, String address, String privateKey) {
        this.idUser = idUser;
        this.address = address;
        this.privateKey = privateKey;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BtcWallet)) return false;
        BtcWallet btcWallet = (BtcWallet) o;
        return idUser == btcWallet.idUser && address.equals(btcWallet.address) && privateKey.equals(btcWallet.privateKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, address, privateKey);
    }

    @Override
    public String toString() {
        return "BtcWallet{" +
                "idUser=" + idUser +
                ", address='" + address + '\'' +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
