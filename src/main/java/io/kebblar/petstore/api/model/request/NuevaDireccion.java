/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   NuevaDireccion.java
 * Tipo:        clase
 * AUTOR:       Fhernanda
 * Fecha:       Jueves 6 de Mayo de 2021 (10_40)
 *
 * Historia:    20210506_1040 Creación de éste POJO
 *              20210604_1540 Se renombran las propiedades.
 *
 */
package io.kebblar.petstore.api.model.request;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'NuevaDireccion'.
 *
 * @author Fhernanda
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class NuevaDireccion {

    /*
     * Atributos de la clase.
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
     * Constructor sin parámetros.
     */
    public NuevaDireccion() {}

    /**
     * Constructor basado en todos los atributos de la clase.
     */
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

    /*
     * Getter y Setter.
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NuevaDireccion)) return false;
        NuevaDireccion that = (NuevaDireccion) o;
        return id == that.id && idUsuario == that.idUsuario && tipo == that.tipo && idPais == that.idPais && idEstado == that.idEstado && idMunicipio == that.idMunicipio && Objects.equals(nombre, that.nombre) && Objects.equals(calleNumero, that.calleNumero) && Objects.equals(colonia, that.colonia) && Objects.equals(referencias, that.referencias) && Objects.equals(cp, that.cp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, nombre, tipo, calleNumero, colonia, referencias, cp, idPais, idEstado, idMunicipio);
    }

    /**
     * {@inheritDoc}
     */
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
