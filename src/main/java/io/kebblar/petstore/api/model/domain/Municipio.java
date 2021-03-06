
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
 * Artefacto:   Municipio .java
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
 * POJO asociado a la entidad 'municipio'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Municipio implements Serializable {
    private static final long serialVersionUID = 5007490559310553080L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private int idEstado;
    private String nombre;
    private String nombrePais;
    private String nombreEstado;

    /**
     * Constructor por default (sin parámetros).
     */
    public Municipio() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Municipio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Municipio(Integer id, int idEstado, String nombre) {
        this.id = id;
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    /**
     * Constructor basado en atributos temporales para el nombre del Estado.
     */
    public Municipio(Integer id, int idEstado, String nombre, String nombrePais, String nombreEstado) {
        this.id = id;
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.nombrePais = nombrePais;
        this.nombreEstado = nombreEstado;
    }

    /**
     * Getter para id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter para id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter para idEstado.
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Setter para idEstado.
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * Getter para nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para nombrePais.
     */
    public String getNombrePais() {
        return nombrePais;
    }

    /**
     * Setter para nombrePais.
     */
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    /**
     * Getter para nombreEstado.
     */
    public String getNombreEstado() {
        return nombreEstado;
    }

    /**
     * Setter para nombreEstado.
     */
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public String toString() {
        return "[Municipio] : ["
                + " id =" + this.id
                + " idEstado =" + this.idEstado
                + " nombre =" + this.nombre
                + " nombrePais =" + this.nombrePais
                + " nombreEstado =" + this.nombreEstado
                + "]";
    }

    /**
     * Compara si dos instancias de la clase Municipio son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) obj;
        return
               id == other.id &&
               idEstado == other.idEstado &&
               nombre == other.nombre;
    }

    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idEstado,
            nombre
        );
    }

}
