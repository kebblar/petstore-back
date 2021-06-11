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
 * Artefacto:   MediaTipo .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (23_19)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2319 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'media_tipo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MediaTipo implements Serializable {

    private static final long serialVersionUID = 6403288927902223553L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private String descripcion;
    private int activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public MediaTipo() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public MediaTipo(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public MediaTipo(Integer id, String descripcion, int activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
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
     * Getter para descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter para descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter para activo.
     */
    public int getActivo() {
        return activo;
    }

    /**
     * Setter para activo.
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }


    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[MediaTipo] : ["
                + " id =" + this.id
                + " descripcion =" + this.descripcion
                + " activo =" + this.activo
                + "]";
    }

    /**
     * Compara si dos instancias de la clase MediaTipo son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTipo)) {
            return false;
        }
        MediaTipo other = (MediaTipo) obj;
        return
               id == other.id &&
               descripcion == other.descripcion &&
               activo == other.activo;
    }

    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            descripcion,
            activo
        );
    }

}
