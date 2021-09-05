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
 * Nombre:      ValorAtributo
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:55
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'valor_atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ValorAtributo implements Serializable {

    private static final long serialVersionUID = -2847669026644607055L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private int idAtributo;
    private String rango;
    private int activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public ValorAtributo() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public ValorAtributo(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public ValorAtributo(Integer id, int idAtributo, String rango, int activo) {
        this.id = id;
        this.idAtributo = idAtributo;
        this.rango = rango;
        this.activo = activo;
    }

    /*
     * Getter y Setter.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[ValorAtributo] : ["
                + " id =" + this.id
                + " idAtributo =" + this.idAtributo
                + " rango =" + this.rango
                + " activo =" + this.activo
                + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValorAtributo)) {
            return false;
        }
        ValorAtributo other = (ValorAtributo) obj;
        return
               id == other.id &&
               idAtributo == other.idAtributo &&
               rango == other.rango &&
               activo == other.activo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idAtributo,
            rango,
            activo
        );
    }

}
