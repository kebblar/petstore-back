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
 * Nombre:      CategoriaDetallesTO
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:17:03
 */
package io.kebblar.petstore.api.model.domain;

/**
 * <p>
 * Descripción:
 * </p>
 * POJO asociado a la entidad 'categoria', 'categoria_atributo', 'atributo' y 'valor_atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CategoriaDetallesTO {

    /*
     * Atributos de la clase.
     */
    private Integer idCategoria;
    private String categoriaNombre;
    private int estatusCategoria;
    private int idCateg;
    private int idAtrib;
    private int idAtributo;
    private String nombreAtributo;
    private int estatusAtributo;
    private int idRango;
    private int rangoIdAtributo;
    private String rango;
    private int estatusRango;

    /*
     * Setter y getter.
     */
    /**
     * <p>Getter for the field <code>idCategoria</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * <p>Setter for the field <code>idCategoria</code>.</p>
     *
     * @param idCategoria a {@link java.lang.Integer} object.
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * <p>Getter for the field <code>categoriaNombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    /**
     * <p>Setter for the field <code>categoriaNombre</code>.</p>
     *
     * @param categoriaNombre a {@link java.lang.String} object.
     */
    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    /**
     * <p>Getter for the field <code>estatusCategoria</code>.</p>
     *
     * @return a int.
     */
    public int getEstatusCategoria() {
        return estatusCategoria;
    }

    /**
     * <p>Setter for the field <code>estatusCategoria</code>.</p>
     *
     * @param estatusCategoria a int.
     */
    public void setEstatusCategoria(int estatusCategoria) {
        this.estatusCategoria = estatusCategoria;
    }

    /**
     * <p>Getter for the field <code>idCateg</code>.</p>
     *
     * @return a int.
     */
    public int getIdCateg() {
        return idCateg;
    }

    /**
     * <p>Setter for the field <code>idCateg</code>.</p>
     *
     * @param idCateg a int.
     */
    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }

    /**
     * <p>Getter for the field <code>idAtrib</code>.</p>
     *
     * @return a int.
     */
    public int getIdAtrib() {
        return idAtrib;
    }

    /**
     * <p>Setter for the field <code>idAtrib</code>.</p>
     *
     * @param idAtrib a int.
     */
    public void setIdAtrib(int idAtrib) {
        this.idAtrib = idAtrib;
    }

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
        return "CategoriaDetallesTO [idCategoria=" + idCategoria + ", categoriaNombre=" + categoriaNombre
                + ", estatusCategoria=" + estatusCategoria + ", id_categoria=" + idCateg + ", id_atributo="
                + idAtrib + ", idAtributo=" + idAtributo + ", nombreAtributo=" + nombreAtributo
                + ", estatusAtributo=" + estatusAtributo + ", idRango=" + idRango + ", rangoIdAtributo="
                + rangoIdAtributo + ", rango=" + rango + ", estatusRango=" + estatusRango + "]";
    }

}
