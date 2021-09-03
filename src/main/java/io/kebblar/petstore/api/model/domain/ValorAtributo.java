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
 * Artefacto:   ValorAtributo.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       martes 06 de junio de 2021 (00_43)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210608_0043 Implementación de clase
 *
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
