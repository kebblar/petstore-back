package io.kebblar.petstore.api.model.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Preregistro {
    private int id;
    private String nick;

    @ApiModelProperty(example = "example@hotmail.com")
    @NotBlank(message = "Llénalo, por favor")
    @Email(message = "El correo electrónico proporcionado es inválido")
    private String correo;

    @ApiModelProperty(example = "12345678aA")
    @NotNull(message = "La clave no puede ser nula")
    @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$",
            message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de " +
                    "contener espacios. Además debe tener de 8 a 30 caracteres")
    private String claveHash = "";

    @ApiModelProperty(example = "5543562126")
    @Pattern(regexp="^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios")
    private String telefono;

    private Date fechaNacimiento;

    private String randomString;

    private long instanteRegistro;

    public Preregistro() {
    }

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

    @Override
    public String toString() {
        return "PreRegistroRequest [id=" + id + ", nick=" + nick + ", correo=" + correo + ", claveHash=" + claveHash
                + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", randomString=" + randomString
                + ", instanteRegistro=" + instanteRegistro + "]";
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Preregistro other = (Preregistro) obj;
        if (claveHash == null) {
            if (other.claveHash != null)
                return false;
        } else if (!claveHash.equals(other.claveHash))
            return false;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
            return false;
        if (fechaNacimiento == null) {
            if (other.fechaNacimiento != null)
                return false;
        } else if (!fechaNacimiento.equals(other.fechaNacimiento))
            return false;
        if (id != other.id)
            return false;
        if (instanteRegistro != other.instanteRegistro)
            return false;
        if (nick == null) {
            if (other.nick != null)
                return false;
        } else if (!nick.equals(other.nick))
            return false;
        if (randomString == null) {
            if (other.randomString != null)
                return false;
        } else if (!randomString.equals(other.randomString))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        return true;
    }

}
