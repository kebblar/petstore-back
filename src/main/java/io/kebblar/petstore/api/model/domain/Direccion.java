/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Direccion.java
 * Tipo:        clase
 * AUTOR:       Fabiola Camilo Victoriano (FCV)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_03)
 *
 * Historia:    .
 *              20210506_0903 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * <p>Descripcion:</p>
 * Implementacion del POJO de la entidad de {@link Direccion}.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Direccion implements Serializable {
    private static final long serialVersionUID = 147836237927646425L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    @NotEmpty(message = "El campo Calle y número debe ser no vacio")
    @Size(max = 5, message = "La longitud máxima para el campo de Calle y número es 5")
    private String calleNumero;
    @NotEmpty(message = "El campo Colonia debe ser no vacio")
    @Size(max = 6, message = "La longitud máxima para el campo de Colonia es 6")
    private String colonia;
    private int idPais;
    private int idEstado;
    private int idMunicipio;
    private int idTipoDireccion;
    @Pattern(regexp = "\\d{5}$", message = "El código postal debe ser 5 digitos exactamente")
    private String cp;
    @Size(max = 7, message = "La longitud máxima para el campo de Referencias es 7")
    private String referencias;
    private boolean activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public Direccion() {}

    /**
     * Constructor basado en los atributos de la clase.
     */
    public Direccion(Integer id, String calleNumero, String colonia, int idPais, int idEstado, int idMunicipio,
            int idTipoDireccion, String cp, String referencias, boolean activo) {
        this.id = id;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
        this.idTipoDireccion = idTipoDireccion;
        this.cp = cp;
        this.referencias = referencias;
        this.activo = activo;
    }

    /*
     * Setter y Getter.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getIdTipoDireccion() {
        return idTipoDireccion;
    }

    public void setIdTipoDireccion(int idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Direccion [id=" + id + ", calleNumero=" + calleNumero + ", colonia=" + colonia + ", idPais=" + idPais
                + ", idEstado=" + idEstado + ", idMunicipio=" + idMunicipio + ", idTipoDireccion=" + idTipoDireccion
                + ", cp=" + cp + ", referencias=" + referencias + ", activo=" + activo + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + ((calleNumero == null) ? 0 : calleNumero.hashCode());
        result = prime * result + ((colonia == null) ? 0 : colonia.hashCode());
        result = prime * result + ((cp == null) ? 0 : cp.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + idEstado;
        result = prime * result + idMunicipio;
        result = prime * result + idPais;
        result = prime * result + idTipoDireccion;
        result = prime * result + ((referencias == null) ? 0 : referencias.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direccion)) return false;
        Direccion direccion = (Direccion) o;
        return idPais == direccion.idPais && idEstado == direccion.idEstado && idMunicipio == direccion.idMunicipio &&
                idTipoDireccion == direccion.idTipoDireccion && activo == direccion.activo && Objects.equals(id, direccion.id) &&
                Objects.equals(calleNumero, direccion.calleNumero) && Objects.equals(colonia, direccion.colonia) &&
                Objects.equals(cp, direccion.cp) && Objects.equals(referencias, direccion.referencias);
    }
}
