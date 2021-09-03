
/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
<<<<<<< HEAD
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
=======
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
>>>>>>> refs/heads/develop
 *
 *              ------------------------------------------------
<<<<<<< HEAD
 *
 * Artefacto:   Pais .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
=======
 * Artefacto:   Pais.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (23_21)
>>>>>>> refs/heads/develop
 *
<<<<<<< HEAD
 * Historia:    20210511_1444 Implementación de clase
=======
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
>>>>>>> refs/heads/develop
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link Pais}.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class Pais implements Serializable {
    private static final long serialVersionUID = 4897377279463910357L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private String nombre;

    /**
     * Constructor por default (sin parámetros).
     */
    public Pais() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Pais(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Pais(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /*
     * Setter y Getter.
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


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[Pais] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
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
        if (!(obj instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) obj;
        return
               id == other.id &&
               nombre == other.nombre;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            nombre
        );
    }

}
