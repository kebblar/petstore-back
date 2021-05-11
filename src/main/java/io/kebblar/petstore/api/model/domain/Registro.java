/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 * Artefacto:   Registro.java
 * Tipo:        clase
 * Autor:       Francisco Javier Moreno Romero (FJMR)
 * Fecha:       Viernes 7 de Mayo de 2021 08:34pm 
 *
 * Historia:    .
 *              20200812_0058 Creación de éste POJO
 *
 */

package io.kebblar.petstore.api.model.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import io.kebblar.petstore.api.model.request.RegistroRequest;
import io.kebblar.petstore.api.utils.DigestEncoder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'registro'.
 *
 * @author javier
 * @version 0.1.1-SNAPSHOT
 */
public class Registro implements Serializable {

    private static final long serialVersionUID = 7205872265753757625L;

    @NotBlank
    private String nombre;

    @NotBlank
    private String telefono;

    private String calleNumero;

    @Email
    private String correo;

    @NotNull
    @Past(message = "La fecha de nacimiendo no valida, debe de ser una fecha en el pasado")
    private long fechaRegistro;

    private LocalDate fechaNacimiento;
    private String claveHash;
    private String randomString;
    private Integer idEstado;
    private Integer idMunicipio;

    /**
     * Constructor por default.
     */
    public Registro() {
        this.fechaRegistro = System.currentTimeMillis();
    }

    public Registro(RegistroRequest registroRequest) {
        this.randomString = DigestEncoder.getRandomString(6);
        this.correo = registroRequest.getCorreo();
        this.nombre = registroRequest.getNombre();
        this.telefono = registroRequest.getTelefono();
        this.claveHash = DigestEncoder.digest(
                registroRequest.getClave(),
                registroRequest.getCorreo());
        this.fechaRegistro = System.currentTimeMillis();
        this.idEstado = 1;
        this.idMunicipio = 1;
    }

    /**
     * Getter para nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para telefono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter para telefono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Getter para fechaNacimiento.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Setter para fechaNacimiento.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getter para correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Setter para correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Getter para claveHash.
     */
    public String getClaveHash() {
        return claveHash;
    }

    /**
     * Setter para claveHash.
     */
    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    /**
     * Getter para fechaRegistro.
     */
    public long getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Setter para fechaRegistro.
     */
    public void setFechaRegistro(long fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getter para randomString
     */
    public String getRandomString() {
        return randomString;
    }

    /**
     * Setter para randomString
     */
    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public String toString() {
        return "[Registro] : ["
                + " correo =" + this.correo
                + " nombre =" + this.nombre
                + " telefono =" + this.telefono
                + "calle y numero = " + this.calleNumero
                + " fechaNacimiento =" + this.fechaNacimiento
                + " claveHash =" + this.claveHash
                + " fechaRegistro =" + this.fechaRegistro
                + " randomString =" + this.randomString
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) obj;
        return
               nombre.equals(other.nombre) &&
               telefono.equals(other.telefono) &&
               calleNumero.equals(other.calleNumero) &&
               correo.equals(other.correo) &&
               claveHash.equals(other.claveHash) &&
               fechaRegistro == other.fechaRegistro &&
               randomString.equals(other.randomString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            nombre,
            telefono,
            calleNumero,
            fechaNacimiento,
            correo,
            claveHash,
            fechaRegistro,
            randomString
        );
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

}
