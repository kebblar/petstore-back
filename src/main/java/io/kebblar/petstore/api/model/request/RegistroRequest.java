/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   RegistroRequest.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 4 de Mayo de 2021 (09_26)
 *
 * Historia:    .
 *              20210503_0926 Creación de éste Request
 *
 */
package io.kebblar.petstore.api.model.request;


import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>Descripción:</p>
 * Clase que sirve para hacer validaciones a los campos que estan en una peticion de tipo registro
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.request
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public class RegistroRequest {

    @ApiModelProperty(example = "Bob")
    @NotNull(message = "El nombre no puede ser nulo")
    @Pattern(regexp="^\\p{Alpha}{2,64}$",
            message = "Nombre inválido, solo se permiten de 2 a 64 caracteres alfabeticos")
    private String nombre;

    @ApiModelProperty(example = "12345678aA")
    @NotNull(message = "La clave no puede ser nula")
    @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$",
            message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de " +
                    "contener espacios. Además debe tener de 8 a 30 caracteres")
    private String clave;

    @ApiModelProperty(example = "example@hotmail.com")
    @NotBlank(message = "Llénalo, por favor")
    @Email(message = "El correo electrónico proporcionado es inválido")
    private String correo;

    @ApiModelProperty(example = "5543562126")
    @Pattern(regexp="^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios")
    private String telefono;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "RegistroRequest{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}