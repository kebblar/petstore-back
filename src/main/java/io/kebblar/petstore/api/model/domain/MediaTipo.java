/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      MediaTipo
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:49:58
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

    /*
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

    /*
     * Getter y Setter.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "[MediaTipo] : ["
                + " id =" + this.id
                + " descripcion =" + this.descripcion
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
     * {@inheritDoc}
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
