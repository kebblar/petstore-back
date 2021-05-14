package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

public class UsuarioDireccion {

     private int idUsuario;
     private int idDireccion;

    public UsuarioDireccion() {
    }

    public UsuarioDireccion(int idUsuario, int idDireccion) {
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDireccion)) return false;
        UsuarioDireccion that = (UsuarioDireccion) o;
        return idUsuario == that.idUsuario && idDireccion == that.idDireccion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDireccion);
    }

    @Override
    public String toString() {
        return "UsuarioDireccion{" +
                "idUsuario=" + idUsuario +
                ", idDireccion=" + idDireccion +
                '}';
    }
}
