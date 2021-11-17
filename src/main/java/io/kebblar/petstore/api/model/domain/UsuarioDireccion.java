/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
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
     *
     * @param idUsuario a int.
     * @param idDireccion a int.
     */
    public UsuarioDireccion(int idUsuario, int idDireccion) {
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>idUsuario</code>.</p>
     *
     * @return a int.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * <p>Setter for the field <code>idUsuario</code>.</p>
     *
     * @param idUsuario a int.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * <p>Getter for the field <code>idDireccion</code>.</p>
     *
     * @return a int.
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * <p>Setter for the field <code>idDireccion</code>.</p>
     *
     * @param idDireccion a int.
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDireccion)) return false;
        UsuarioDireccion that = (UsuarioDireccion) o;
        return idUsuario == that.idUsuario && idDireccion == that.idDireccion;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDireccion);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "UsuarioDireccion{" +
                "idUsuario=" + idUsuario +
                ", idDireccion=" + idDireccion +
                '}';
    }

    public int getHash() {
        return this.hashCode();
    }
    
}
