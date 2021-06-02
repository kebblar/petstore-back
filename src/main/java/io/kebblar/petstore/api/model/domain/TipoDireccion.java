
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
 * Artefacto:   TipoDireccion .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
=======
 * Artefacto:   TipoDireccion.java
 * Tipo:        Clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_25)
>>>>>>> refs/heads/develop
 *
<<<<<<< HEAD
 * Historia:    20210511_1444 Implementación de clase
=======
 * Historia:    .
 *              0210506_0925 Creación de éste POJO
>>>>>>> refs/heads/develop
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'TipoDireccion'.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class TipoDireccion implements Serializable {
    private static final long serialVersionUID = 6627523800922208745L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private String nombre;
    private boolean activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public TipoDireccion() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public TipoDireccion(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public TipoDireccion(Integer id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[TipoDireccion] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " activo =" + this.activo
                + "]";
    }

    /**
     * Compara si dos instancias de la clase TipoDireccion son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TipoDireccion)) {
            return false;
        }
        TipoDireccion other = (TipoDireccion) obj;
        return
               id == other.id &&
               nombre == other.nombre &&
               activo == other.activo;
    }

    /**
     * Genera un hash del objeto
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
