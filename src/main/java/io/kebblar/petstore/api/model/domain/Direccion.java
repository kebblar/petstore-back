/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Direccion
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:22:21
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * <p>Descripcion:</p>
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.domain.Direccion}.
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
     *
     * @param id a {@link java.lang.Integer} object.
     * @param calleNumero a {@link java.lang.String} object.
     * @param colonia a {@link java.lang.String} object.
     * @param idPais a int.
     * @param idEstado a int.
     * @param idMunicipio a int.
     * @param idTipoDireccion a int.
     * @param cp a {@link java.lang.String} object.
     * @param referencias a {@link java.lang.String} object.
     * @param activo a boolean.
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
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        this.id = id;
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
     * <p>Getter for the field <code>colonia</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * <p>Setter for the field <code>colonia</code>.</p>
     *
     * @param colonia a {@link java.lang.String} object.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * <p>Getter for the field <code>idPais</code>.</p>
     *
     * @return a int.
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * <p>Setter for the field <code>idPais</code>.</p>
     *
     * @param idPais a int.
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    /**
     * <p>Getter for the field <code>idEstado</code>.</p>
     *
     * @return a int.
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * <p>Setter for the field <code>idEstado</code>.</p>
     *
     * @param idEstado a int.
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
     * <p>Getter for the field <code>idTipoDireccion</code>.</p>
     *
     * @return a int.
     */
    public int getIdTipoDireccion() {
        return idTipoDireccion;
    }

    /**
     * <p>Setter for the field <code>idTipoDireccion</code>.</p>
     *
     * @param idTipoDireccion a int.
     */
    public void setIdTipoDireccion(int idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    /**
     * <p>Getter for the field <code>cp</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCp() {
        return cp;
    }

    /**
     * <p>Setter for the field <code>cp</code>.</p>
     *
     * @param cp a {@link java.lang.String} object.
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * <p>Getter for the field <code>referencias</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * <p>Setter for the field <code>referencias</code>.</p>
     *
     * @param referencias a {@link java.lang.String} object.
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    /**
     * <p>isActivo.</p>
     *
     * @return a boolean.
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * <p>Setter for the field <code>activo</code>.</p>
     *
     * @param activo a boolean.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * <p>getSerialversionuid.</p>
     *
     * @return a long.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Direccion [id=" + id + ", calleNumero=" + calleNumero + ", colonia=" + colonia + ", idPais=" + idPais
                + ", idEstado=" + idEstado + ", idMunicipio=" + idMunicipio + ", idTipoDireccion=" + idTipoDireccion
                + ", cp=" + cp + ", referencias=" + referencias + ", activo=" + activo + "]";
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
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
