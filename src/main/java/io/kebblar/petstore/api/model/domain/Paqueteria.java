
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
 * Artefacto:   Paqueteria .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'paqueteria'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class Paqueteria implements Serializable {

    private static final long serialVersionUID = 4781082860740788585L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private String nombre;
    private String breveDescripcion;
    private String htmlDescripcion;
    private int precio;

    /**
     * Constructor por default (sin parámetros).
     */
    public Paqueteria() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Paqueteria(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Paqueteria(Integer id, String nombre, String breveDescripcion, String htmlDescripcion, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.breveDescripcion = breveDescripcion;
        this.htmlDescripcion = htmlDescripcion;
        this.precio = precio;
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

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getHtmlDescripcion() {
        return htmlDescripcion;
    }

    public void setHtmlDescripcion(String htmlDescripcion) {
        this.htmlDescripcion = htmlDescripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[Paqueteria] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " breveDescripcion =" + this.breveDescripcion
                + " htmlDescripcion =" + this.htmlDescripcion
                + " precio =" + this.precio
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
        if (!(obj instanceof Paqueteria)) {
            return false;
        }
        Paqueteria other = (Paqueteria) obj;
        return
               id == other.id &&
               nombre == other.nombre &&
               breveDescripcion == other.breveDescripcion &&
               htmlDescripcion == other.htmlDescripcion &&
               precio == other.precio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            nombre,
            breveDescripcion,
            htmlDescripcion,
            precio
        );
    }

}
