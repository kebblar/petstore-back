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
 * Nombre:      AtributoDetalleTO
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:12:58
 */
package io.kebblar.petstore.api.model.domain;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'atributo' y valor_atributo
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AtributoDetalleTO {

    /*
     * Atributos de la clase.
     */
    private int idAtributo;
    private String nombreAtributo;
    private int estatusAtributo;
    private int idRango;
    private int rangoIdAtributo;
    private String rango;
    private int estatusRango;

    public AtributoDetalleTO(){}

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>idAtributo</code>.</p>
     *
     * @return a int.
     */
    public int getIdAtributo() {
        return idAtributo;
    }

    /**
     * <p>Setter for the field <code>idAtributo</code>.</p>
     *
     * @param idAtributo a int.
     */
    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    /**
     * <p>Getter for the field <code>nombreAtributo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombreAtributo() {
        return nombreAtributo;
    }

    /**
     * <p>Setter for the field <code>nombreAtributo</code>.</p>
     *
     * @param nombreAtributo a {@link java.lang.String} object.
     */
    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    /**
     * <p>Getter for the field <code>estatusAtributo</code>.</p>
     *
     * @return a int.
     */
    public int getEstatusAtributo() {
        return estatusAtributo;
    }

    /**
     * <p>Setter for the field <code>estatusAtributo</code>.</p>
     *
     * @param estatusAtributo a int.
     */
    public void setEstatusAtributo(int estatusAtributo) {
        this.estatusAtributo = estatusAtributo;
    }

    /**
     * <p>Getter for the field <code>idRango</code>.</p>
     *
     * @return a int.
     */
    public int getIdRango() {
        return idRango;
    }

    /**
     * <p>Setter for the field <code>idRango</code>.</p>
     *
     * @param idRango a int.
     */
    public void setIdRango(int idRango) {
        this.idRango = idRango;
    }

    /**
     * <p>Getter for the field <code>rangoIdAtributo</code>.</p>
     *
     * @return a int.
     */
    public int getRangoIdAtributo() {
        return rangoIdAtributo;
    }

    /**
     * <p>Setter for the field <code>rangoIdAtributo</code>.</p>
     *
     * @param rangoIdAtributo a int.
     */
    public void setRangoIdAtributo(int rangoIdAtributo) {
        this.rangoIdAtributo = rangoIdAtributo;
    }

    /**
     * <p>Getter for the field <code>rango</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRango() {
        return rango;
    }

    /**
     * <p>Setter for the field <code>rango</code>.</p>
     *
     * @param rango a {@link java.lang.String} object.
     */
    public void setRango(String rango) {
        this.rango = rango;
    }

    /**
     * <p>Getter for the field <code>estatusRango</code>.</p>
     *
     * @return a int.
     */
    public int getEstatusRango() {
        return estatusRango;
    }

    /**
     * <p>Setter for the field <code>estatusRango</code>.</p>
     *
     * @param estatusRango a int.
     */
    public void setEstatusRango(int estatusRango) {
        this.estatusRango = estatusRango;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "AtributoDetalleTO [idAtributo=" + idAtributo + ", nombreAtributo=" + nombreAtributo
                + ", estatusAtributo=" + estatusAtributo + ", idRango=" + idRango + ", rangoIdAtributo="
                + rangoIdAtributo + ", rango=" + rango + ", estatusRango=" + estatusRango + "]";
    }



}
