package io.kebblar.petstore.api.model.domain;

import java.util.List;

public class UserFoundWrapper {
    private List<Rol> roles;
    private List<Direccion> direcciones;
    private UsuarioDetalle usuarioDetalle;
    private String jwt;
    public UserFoundWrapper() {
    }
    public UserFoundWrapper(List<Rol> roles, List<Direccion> direcciones, UsuarioDetalle usuarioDetalle, String jwt) {
        this.roles = roles;
        this.direcciones = direcciones;
        this.usuarioDetalle = usuarioDetalle;
        this.jwt = jwt;
    }
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    public List<Direccion> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }
    public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
    }
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    @Override
    public String toString() {
        return "UserFoundWrapper [roles=" + roles + ", direcciones=" + direcciones + ", usuarioDetalle="
                + usuarioDetalle + ", jwt=" + jwt + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((direcciones == null) ? 0 : direcciones.hashCode());
        result = prime * result + ((jwt == null) ? 0 : jwt.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((usuarioDetalle == null) ? 0 : usuarioDetalle.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserFoundWrapper other = (UserFoundWrapper) obj;
        if (direcciones == null) {
            if (other.direcciones != null)
                return false;
        } else if (!direcciones.equals(other.direcciones))
            return false;
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
}
