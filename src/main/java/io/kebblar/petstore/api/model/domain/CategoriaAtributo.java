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
 * Artefacto:   CategoriaAtributo .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (19_06)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210606_1906 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'categoria_atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CategoriaAtributo implements Serializable {

    private static final long serialVersionUID = 2560581152871158325L;

    /*
     * Atributos de la clase.
     */
    private Integer idCategoria;
    private Integer idAtributo;
    private String nombreAtributo;


    /**
     * Constructor por default (sin parámetros).
     */
    public CategoriaAtributo() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public CategoriaAtributo(Integer idCategoria, Integer idAtributo) {
        this.idCategoria = idCategoria;
        this.idAtributo = idAtributo;
    }

    /**
     * Constructor basado en los atributos de la clase.
     */
    public CategoriaAtributo(Integer idCategoria, Integer idAtributo,String nombreAtributo) {
        this.idCategoria = idCategoria;
        this.idAtributo = idAtributo;
        this.nombreAtributo = nombreAtributo;
    }

    /*
     * Getter y Setter.
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Integer idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[CategoriaAtributo] : ["
                + " idCategoria =" + this.idCategoria
                + " idAtributo =" + this.idAtributo
                + " nombreAtributo =" + this.nombreAtributo
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
        if (!(obj instanceof CategoriaAtributo)) {
            return false;
        }
        CategoriaAtributo other = (CategoriaAtributo) obj;
        return
               idCategoria == other.idCategoria &&
               idAtributo == other.idAtributo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            idCategoria,
            idAtributo
        );
    }

}
