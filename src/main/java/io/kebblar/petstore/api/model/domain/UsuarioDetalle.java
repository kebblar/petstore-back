package io.kebblar.petstore.api.model.domain;

import java.util.Date;
import java.util.Objects;

public class UsuarioDetalle {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String nickName;
    private String telefonoCasa;
    private String telefonoCelular;

    public UsuarioDetalle() {
    }

    public UsuarioDetalle(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String nickName, String telefonoCasa, String telefonoCelular) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nickName = nickName;
        this.telefonoCasa = telefonoCasa;
        this.telefonoCelular = telefonoCelular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public long getHash() {
        return hashCode();
    }

    @Override
    public String toString() {
        return "UsuarioDetalle [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
                + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", nickName="
                + nickName + ", telefonoCasa=" + telefonoCasa + ", telefonoCelular=" + telefonoCelular + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDetalle)) return false;
        UsuarioDetalle that = (UsuarioDetalle) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(apellidoPaterno, that.apellidoPaterno) && Objects.equals(apellidoMaterno, that.apellidoMaterno) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(nickName, that.nickName) && Objects.equals(telefonoCasa, that.telefonoCasa) && Objects.equals(telefonoCelular, that.telefonoCelular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, nickName, telefonoCasa, telefonoCelular);
    }
}
