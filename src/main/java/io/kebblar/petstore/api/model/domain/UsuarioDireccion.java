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
 * Nombre:      UsuarioDireccion
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:47
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'UsuarioDireccion'.
 *
 * @author  luz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

public class UsuarioDireccion {

    /*
     * Atributos de la clase.
     */
     private int idUsuario;
     private int idDireccion;

    /**
     * Constructor por default (sin parámetros).
     */
    public UsuarioDireccion() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     */
    public UsuarioDireccion(int idUsuario, int idDireccion) {
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
    }

    /*
     * Getter y Setter.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDireccion)) return false;
        UsuarioDireccion that = (UsuarioDireccion) o;
        return idUsuario == that.idUsuario && idDireccion == that.idDireccion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDireccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UsuarioDireccion{" +
                "idUsuario=" + idUsuario +
                ", idDireccion=" + idDireccion +
                '}';
    }
}
