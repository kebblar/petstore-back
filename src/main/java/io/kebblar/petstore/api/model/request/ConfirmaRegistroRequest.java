/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ConfirmaRegistroRequest.java
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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'ConfirmaRegistroRequest'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ConfirmaRegistroRequest {

    /*
     * Atributos de la clase.
     */
    @ApiModelProperty(example = "xSw312")
    @NotBlank(message = "El token no puede ser null ni vacio")
    @Pattern(regexp = "\\p{Alnum}{6}",message = "El token debe tener 6 caracteres alfanuméricos")
    private String token;

    @ApiModelProperty(example = "Calle 20, número 54")
    @NotBlank(message = "La calle y el número no pueden ser null ni vacio")
    private String calleNumero;

    @ApiModelProperty(notes = "No es necesario especificar el estado pues internamente cada municipio ya tiene un estado relacionado",example = "1")
    @NotNull(message = "El id del municipio no puede ser null ni vacio")
    private int idMunicipio;

    @ApiModelProperty(example = "2000-07-24")
    @Past(message = "La fecha de nacimiendo no valida, debe de ser una fecha en el pasado")
    @NotNull(message = "La fecha de nacimiendo no puede ser null")
    private Date fNacimiento;

    /**
     * Constructor por defecto.
     */
    public ConfirmaRegistroRequest() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public ConfirmaRegistroRequest(String token, String calleNumero, int idMunicipio, Date fNacimiento) {
        this.token = token;
        this.calleNumero = calleNumero;
        this.idMunicipio = idMunicipio;
        this.fNacimiento = fNacimiento;
    }

    /*
     * Getter y Setter.
     */
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

}
