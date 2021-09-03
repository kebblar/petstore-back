/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UsuarioDetalle.java
 * Tipo:        clase
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_38)
 *
 * Historia:    .
 *              20210506_0938 Creación de éste POJO
 *
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
