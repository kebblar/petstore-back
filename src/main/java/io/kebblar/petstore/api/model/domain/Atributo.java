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
 * Artefacto:   Atributo .java
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

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Atributo implements Serializable {

    private static final long serialVersionUID = 8063110643925882553L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private String nombre;
    private int activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public Atributo() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Atributo(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Atributo(Integer id, String nombre, int activo) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }


    /**
     *{@inheritDoc}
     */
    @Override
    public String toString() {
        return "[Atributo] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " activo =" + this.activo
                + "]";
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Atributo)) {
            return false;
        }
        Atributo other = (Atributo) obj;
        return
               id == other.id &&
               nombre == other.nombre &&
               activo == other.activo;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            nombre,
            activo
        );
    }

}
