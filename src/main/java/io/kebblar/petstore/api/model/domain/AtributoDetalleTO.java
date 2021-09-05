/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
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

    /*
     * Getter y Setter.
     */
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

    @Override
    public String toString() {
        return "AtributoDetalleTO [idAtributo=" + idAtributo + ", nombreAtributo=" + nombreAtributo
                + ", estatusAtributo=" + estatusAtributo + ", idRango=" + idRango + ", rangoIdAtributo="
                + rangoIdAtributo + ", rango=" + rango + ", estatusRango=" + estatusRango + "]";
    }



}
