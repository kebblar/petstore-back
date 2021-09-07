/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Preregistro.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_28)
 *
 * Historia:    .
 *              20210518_2028 Creación de éste POJO
 *              20210604_1314 Modificacion de 'sku' por 'folio'
 *
 */
package io.kebblar.petstore.api.model.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'Preregistro'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Preregistro {

    /*
     * Atributos de clase.
     */
    private int id;
    private String nick;
    private Date fechaNacimiento;
    private String randomString;
    private long instanteRegistro;

    @ApiModelProperty(example = "example@hotmail.com")
    @NotBlank(message = "Llénalo, por favor")
    @Email(message = "El correo electrónico proporcionado es inválido")
    private String correo;

    @ApiModelProperty(example = "12345678aA")
    @NotNull(message = "La clave no puede ser nula")
    @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$",
            message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de " +
                    "contener espacios. Además debe tener de 8 a 30 caracteres")
    private String claveHash;

    @ApiModelProperty(example = "5543562126")
    @Pattern(regexp="^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios")
    private String telefono;

    /**
     * Constructor por default.
     */
    public Preregistro() {
    }

    /**
     * Constructor basado en todos los atributos de la clase con id.
     */
    public Preregistro(
            int id, 
            String nick,
            String correo,
            String claveHash,
            String telefono,
            Date fechaNacimiento,
            String randomString,
            long instanteRegistro) {
        this.id = id;
        this.nick = nick;
        this.correo = correo;
        this.claveHash = claveHash;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.randomString = randomString;
        this.instanteRegistro = instanteRegistro;
    }

    /*
     * Setter y Getter.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public long getInstanteRegistro() {
        return instanteRegistro;
    }

    public void setInstanteRegistro(long instanteRegistro) {
        this.instanteRegistro = instanteRegistro;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "PreRegistroRequest [id=" + id + ", nick=" + nick + ", correo=" + correo + ", claveHash=" + claveHash
                + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", randomString=" + randomString
                + ", instanteRegistro=" + instanteRegistro + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((claveHash == null) ? 0 : claveHash.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + id;
        result = prime * result + (int) (instanteRegistro ^ (instanteRegistro >>> 32));
        result = prime * result + ((nick == null) ? 0 : nick.hashCode());
        result = prime * result + ((randomString == null) ? 0 : randomString.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preregistro)) return false;
        Preregistro that = (Preregistro) o;
        return id == that.id && instanteRegistro == that.instanteRegistro && Objects.equals(nick, that.nick) &&
                Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(randomString, that.randomString) &&
                Objects.equals(correo, that.correo) && Objects.equals(claveHash, that.claveHash) && Objects.equals(telefono, that.telefono);
    }
}
