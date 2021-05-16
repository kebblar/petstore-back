package io.kebblar.petstore.api.model.request;

import java.util.Objects;

public class NuevaDireccion {

    /**
     * Atributos de la clase
     */
    private int id;
    private int idUsuario;
    private String nombre;
    private int tipo;
    private String calleNumero;
    private String colonia;
    private String referencias;
    private String cp;
    private int idPais;
    private int idEstado;
    private int idMunicipio;

    /**
     * Constructor sin parametros
     */
    public NuevaDireccion() {}

    public NuevaDireccion(int id, int idUsuario, String nombre, int tipo, String calleNumero, String colonia, String referencias, String cp, int idPais, int idEstado, int idMunicipio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipo = tipo;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.referencias = referencias;
        this.cp = cp;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NuevaDireccion)) return false;
        NuevaDireccion that = (NuevaDireccion) o;
        return id == that.id && idUsuario == that.idUsuario && tipo == that.tipo && idPais == that.idPais && idEstado == that.idEstado && idMunicipio == that.idMunicipio && Objects.equals(nombre, that.nombre) && Objects.equals(calleNumero, that.calleNumero) && Objects.equals(colonia, that.colonia) && Objects.equals(referencias, that.referencias) && Objects.equals(cp, that.cp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, nombre, tipo, calleNumero, colonia, referencias, cp, idPais, idEstado, idMunicipio);
    }

    @Override
    public String toString() {
        return "NuevaDireccion{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", calleNumero='" + calleNumero + '\'' +
                ", colonia='" + colonia + '\'' +
                ", referencias='" + referencias + '\'' +
                ", cp='" + cp + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", idMunicipio=" + idMunicipio +
                '}';
    }
}
