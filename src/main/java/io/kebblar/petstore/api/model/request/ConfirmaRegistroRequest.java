 /*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 * Proyecto:    petstore-back
 * Paquete:     io.kebblar.petstore.api.model.request.ConfirmaRegistroRequest
 * Modulo:      Registro
 * Artefacto:   ConfirmaRegistroRequest.java
 * Tipo:        Clase
 * AUTOR:       Diego González Sánchez
 * Fecha:       Jueves 6 de Mayo de 2021 (9_10)
 * Version:     1.0-SNAPSHOT
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Request
 *
 */
package io.kebblar.petstore.api.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * <p> Solicitud, su utilidad es la de acceder a los parametros y atributos,
 *  para asi poder trabajar con ellos en nuestra página.
 * 
 * 
 * @author  Diego G. Sánchez.
 * @see     io.kebblar.petstore.api.model.request.ConfirmaRegistroRequest
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ConfirmaRegistroRequest {

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
    private LocalDate fNacimiento;

    public ConfirmaRegistroRequest() {
    }

    public ConfirmaRegistroRequest(String token, String calleNumero, int idMunicipio, LocalDate fNacimiento) {
        this.token = token;
        this.calleNumero = calleNumero;
        this.idMunicipio = idMunicipio;
        this.fNacimiento = fNacimiento;
    }

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

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

}
