/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      ConfirmaRegistroRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:00:31
 */
package io.kebblar.petstore.api.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * <p>ConfirmaRegistroRequest class.</p>
 *
 * @author garellano
 * @version $Id: $Id
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
    private int idMunicipio = 1;

    @ApiModelProperty(example = "2000-07-24")
    @Past(message = "La fecha de nacimiendo no valida, debe de ser una fecha en el pasado")
    @NotNull(message = "La fecha de nacimiendo no puede ser null")
    private Date fNacimiento = new Date();

    /**
     * <p>Constructor for ConfirmaRegistroRequest.</p>
     */
    public ConfirmaRegistroRequest() {
    }

    /**
     * <p>Constructor for ConfirmaRegistroRequest.</p>
     *
     * @param token a {@link java.lang.String} object.
     * @param calleNumero a {@link java.lang.String} object.
     * @param idMunicipio a int.
     * @param fNacimiento a {@link java.util.Date} object.
     */
    public ConfirmaRegistroRequest(String token, String calleNumero, int idMunicipio, Date fNacimiento) {
        this.token = token;
        this.calleNumero = calleNumero;
        this.idMunicipio = idMunicipio;
        this.fNacimiento = fNacimiento;
    }

    /**
     * <p>Getter for the field <code>token</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getToken() {
        return token;
    }

    /**
     * <p>Setter for the field <code>token</code>.</p>
     *
     * @param token a {@link java.lang.String} object.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * <p>Getter for the field <code>calleNumero</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCalleNumero() {
        return calleNumero;
    }

    /**
     * <p>Setter for the field <code>calleNumero</code>.</p>
     *
     * @param calleNumero a {@link java.lang.String} object.
     */
    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    /**
     * <p>Getter for the field <code>idMunicipio</code>.</p>
     *
     * @return a int.
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * <p>Setter for the field <code>idMunicipio</code>.</p>
     *
     * @param idMunicipio a int.
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /**
     * <p>Getter for the field <code>fNacimiento</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getfNacimiento() {
        return fNacimiento;
    }

    /**
     * <p>Setter for the field <code>fNacimiento</code>.</p>
     *
     * @param fNacimiento a {@link java.util.Date} object.
     */
    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

}
