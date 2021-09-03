/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   AtributoTOjava
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (21_41)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de clase
 *
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
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public int getEstatusCategoria() {
        return estatusCategoria;
    }

    public void setEstatusCategoria(int estatusCategoria) {
        this.estatusCategoria = estatusCategoria;
    }

    public int getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }

    public int getIdAtrib() {
        return idAtrib;
    }

    public void setIdAtrib(int idAtrib) {
        this.idAtrib = idAtrib;
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public int getEstatusAtributo() {
        return estatusAtributo;
    }

    public void setEstatusAtributo(int estatusAtributo) {
        this.estatusAtributo = estatusAtributo;
    }

    public int getIdRango() {
        return idRango;
    }

    public void setIdRango(int idRango) {
        this.idRango = idRango;
    }

    public int getRangoIdAtributo() {
        return rangoIdAtributo;
    }

    public void setRangoIdAtributo(int rangoIdAtributo) {
        this.rangoIdAtributo = rangoIdAtributo;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getEstatusRango() {
        return estatusRango;
    }

    public void setEstatusRango(int estatusRango) {
        this.estatusRango = estatusRango;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "CategoriaDetallesTO [idCategoria=" + idCategoria + ", categoriaNombre=" + categoriaNombre
                + ", estatusCategoria=" + estatusCategoria + ", id_categoria=" + idCateg + ", id_atributo="
                + idAtrib + ", idAtributo=" + idAtributo + ", nombreAtributo=" + nombreAtributo
                + ", estatusAtributo=" + estatusAtributo + ", idRango=" + idRango + ", rangoIdAtributo="
                + rangoIdAtributo + ", rango=" + rango + ", estatusRango=" + estatusRango + "]";
    }

}
