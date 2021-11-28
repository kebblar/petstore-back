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
 * Nombre:      UserFoundWrapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:13
 */
package io.kebblar.petstore.api.model.domain;

import java.util.List;

/**
 * <p>UserFoundWrapper class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class UserFoundWrapper {

    /*
     * Atributos de clase.
     */
    private List<Rol> roles;
    private UsuarioDetalle usuarioDetalle;
    private String jwt;

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param roles a {@link java.util.List} object.
     * @param usuarioDetalle a {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} object.
     * @param jwt a {@link java.lang.String} object.
     */
    public UserFoundWrapper(List<Rol> roles, UsuarioDetalle usuarioDetalle, String jwt) {
        this.roles = roles;
        this.usuarioDetalle = usuarioDetalle;
        this.jwt = jwt;
    }

    /*
     * Getter y Setter.
     */
    /**
     * <p>Getter for the field <code>roles</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Rol> getRoles() {
        return roles;
    }
    /**
     * <p>Setter for the field <code>roles</code>.</p>
     *
     * @param roles a {@link java.util.List} object.
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    /**
     * <p>Getter for the field <code>usuarioDetalle</code>.</p>
     *
     * @return a {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} object.
     */
    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }
    /**
     * <p>Setter for the field <code>usuarioDetalle</code>.</p>
     *
     * @param usuarioDetalle a {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} object.
     */
    public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
    }
    /**
     * <p>Getter for the field <code>jwt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getJwt() {
        return jwt;
    }
    /**
     * <p>Setter for the field <code>jwt</code>.</p>
     *
     * @param jwt a {@link java.lang.String} object.
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "UserFoundWrapper [roles=" + roles +  ", usuarioDetalle="
                + usuarioDetalle + ", jwt=" + jwt + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((jwt == null) ? 0 : jwt.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((usuarioDetalle == null) ? 0 : usuarioDetalle.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserFoundWrapper other = (UserFoundWrapper) obj;
        if (jwt == null) {
            if (other.jwt != null)
                return false;
        } else if (!jwt.equals(other.jwt))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        if (usuarioDetalle == null) {
            if (other.usuarioDetalle != null)
                return false;
        } else if (!usuarioDetalle.equals(other.usuarioDetalle))
            return false;
        return true;
    }

    public int getHash() {
        return this.hashCode();
    }

}
