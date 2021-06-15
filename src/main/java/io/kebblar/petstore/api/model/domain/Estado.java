
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
 * Artefacto:   Estado .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
=======
 * Artefacto:   Estado.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 4 de Mayo de 2021 (17_35)
>>>>>>> refs/heads/develop
 *
<<<<<<< HEAD
 * Historia:    20210511_1444 Implementación de clase
=======
 * Historia:    .
 *              20210504_1735 Creación de éste POJO
>>>>>>> refs/heads/develop
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link Estado}.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class Estado implements Serializable {
    private static final long serialVersionUID = -4082525936309639098L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private int idPais;
    private String nombre;
    private String nombrePais;

    /**
     * Constructor por default (sin parámetros).
     */
    public Estado() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Estado(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Estado(Integer id, int idPais, String nombre) {
        this.id = id;
        this.idPais = idPais;
        this.nombre = nombre;
    }
    
    /**
     * Constructor basado en atributos temporales para el nombre del Pais.
     */
    public Estado(Integer id, int idPais, String nombre, String nombrePais) {
        this.id = id;
        this.idPais = idPais;
        this.nombre = nombre;
        this.nombrePais = nombrePais;
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
     * Getter para idPais.
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * Setter para idPais.
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
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
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[Estado] : ["
                + " id =" + this.id
                + " idPais =" + this.idPais
                + " nombre =" + this.nombre
                + "]";
    }

    /**
     * Compara si dos instancias de la clase Estado son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) obj;
        return
               id == other.id &&
               idPais == other.idPais &&
               nombre == other.nombre;
    }

    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idPais,
            nombre
        );
    }

}
