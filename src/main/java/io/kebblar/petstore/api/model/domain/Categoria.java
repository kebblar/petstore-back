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
 * Artefacto:   Categoria.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (00_02)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_0002 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'categoria'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Categoria implements Serializable {

    private static final long serialVersionUID = 7174821499103256578L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private String categ;
    private int activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public Categoria() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Categoria(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Categoria(Integer id, String categoria, int activo) {
        this.id = id;
        this.categ = categoria;
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

    public String getCategoria() {
        return categ;
    }

    public void setCategoria(String categoria) {
        this.categ = categoria;
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
        return "[Categoria] : ["
                + " id =" + this.id
                + " categoria =" + this.categ
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
        if (!(obj instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) obj;
        return
               id == other.id &&
               categ == other.categ &&
               activo == other.activo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            categ,
            activo
        );
    }

}
