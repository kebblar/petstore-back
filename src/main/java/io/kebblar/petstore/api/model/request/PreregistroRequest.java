/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   PreregistroRequest.java
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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'PreregistroRequest'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class PreregistroRequest {

    /*
     * Atributos de clase.
     */
    private int id;
    private String randomString;
    private long instanteRegistro;

    @ApiModelProperty(example = "superboy")
    @Size(message = "El nick debe medir entre 3 y 15 caracteres", min=3, max=15)
    private String nick;

    @ApiModelProperty(example = "example@hotmail.com")
    @NotBlank(message = "El correo es un dato requerido")
    @Email(message = "El correo electrónico proporcionado es inválido")
    private String correo;

    @ApiModelProperty(example = "12345678aA")
    @NotNull(message = "La clave no puede ser nula")
    @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$",
            message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de " +
                    "contener espacios. Además debe tener de 8 a 30 caracteres")
    private String claveHash;

    @ApiModelProperty(example = "5543562126")
    //@Pattern(regexp="^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios")
    private String telefono;
    
    @ApiModelProperty(example = "1997")
    @Max(message = "El año debe ser menor o igual a 2001", value = 2001)
    @Min(message = "El año debe ser mayor o igual a 1900", value = 1900)
    private int year;
    
    @ApiModelProperty(example = "10")
    @Max(message = "El mes debe ser menor o igual a 12", value = 12)
    @Min(message = "El mes debe ser mayor o igual a 1", value = 1)
    private int month;
    
    @ApiModelProperty(example = "23")
    @Max(message = "El dia debe ser menor o igual a 31", value = 31)
    @Min(message = "El dia debe ser mayor o igual a 1", value = 1)
    private int day;

    /**
     * Constructor por default.
     */
    public PreregistroRequest() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public PreregistroRequest(
            int id, 
            @Size(message = "El nick debe medir entre 3 y 15 caracteres", min=3, max=15) String nick,
            @NotBlank(message = "El correo es un dato requerido") @Email(message = "El correo electrónico proporcionado es inválido") String correo,
            @NotNull(message = "La clave no puede ser nula") @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$", message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de contener espacios. Además debe tener de 8 a 30 caracteres") String claveHash,
            @Pattern(regexp = "^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios") String telefono,
            String randomString, 
            long instanteRegistro,
            @Max(message = "El año debe ser menor a 2021", value = 2001) int year,
            @Max(message = "El mes debe ser menor a 12", value = 12) int month,
            @Max(message = "El año debe ser menor a 31", value = 31) int day) {
        this.id = id;
        this.nick = nick;
        this.correo = correo;
        this.claveHash = claveHash;
        this.telefono = telefono;
        this.randomString = randomString;
        this.instanteRegistro = instanteRegistro;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /*
     * Setter y getter.
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
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "PreregistroRequest [id=" + id + ", nick=" + nick + ", correo=" + correo + ", claveHash=" + claveHash
                + ", telefono=" + telefono + ", randomString=" + randomString + ", instanteRegistro=" + instanteRegistro
                + ", year=" + year + ", month=" + month + ", day=" + day + "]";
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
        result = prime * result + day;
        result = prime * result + id;
        result = prime * result + (int) (instanteRegistro ^ (instanteRegistro >>> 32));
        result = prime * result + month;
        result = prime * result + ((nick == null) ? 0 : nick.hashCode());
        result = prime * result + ((randomString == null) ? 0 : randomString.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        result = prime * result + year;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreregistroRequest)) return false;
        PreregistroRequest that = (PreregistroRequest) o;
        return id == that.id && instanteRegistro == that.instanteRegistro && year == that.year && month == that.month
                && day == that.day && Objects.equals(randomString, that.randomString) && Objects.equals(nick, that.nick)
                && Objects.equals(correo, that.correo) && Objects.equals(claveHash, that.claveHash) && Objects.equals(telefono, that.telefono);
    }
}
