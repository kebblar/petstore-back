package io.kebblar.petstore.api.model.domain;

import java.util.List;

public class UserFoundWrapper {
    private List<Rol> roles;
    private UsuarioDetalle usuarioDetalle;
    private String jwt;

    public UserFoundWrapper(List<Rol> roles, UsuarioDetalle usuarioDetalle, String jwt) {
        this.roles = roles;
        this.usuarioDetalle = usuarioDetalle;
        this.jwt = jwt;
    }
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
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
        return "UserFoundWrapper [roles=" + roles +  ", usuarioDetalle="
                + usuarioDetalle + ", jwt=" + jwt + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
