/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   LoginResponse.java
 * Tipo:        clase
 * AUTOR:       Edgar Uribe (EU)
 * Fecha:       Martes 04 de Mayo del 2021 (09 10)
 *
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.Date;
import java.util.List;

import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;

/**
 * Implementacion del POJO de la entidad de 'LoginResponse'.
 * 
 * @author  Euribe
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class LoginResponse {
    private UsuarioDetalle usuarioDetalle;
    private String correo;
    private String jwt;
    private Date ultimoAcceso;
    private List<Rol> roles;
    private List<Direccion> direcciones;

    public LoginResponse() {
    }

    public LoginResponse(
            UsuarioDetalle usuarioDetalle,
            Date ultimoAcceso,
            String correo,
            String jwt,
            List<Rol> roles,
            List<Direccion> direcciones) {
        this.usuarioDetalle = usuarioDetalle;
        this.ultimoAcceso = ultimoAcceso;
        this.correo = correo;
        this.jwt = jwt;
        this.roles = roles;
        this.direcciones = direcciones;
    }

    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
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

    @Override
    public String toString() {
        return "LoginResponse [usuarioDetalle=" + usuarioDetalle + ", correo=" + correo + ", jwt=" + jwt
                + ", ultimoAcceso=" + ultimoAcceso + ", roles=" + roles + ", direcciones=" + direcciones + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((usuarioDetalle == null) ? 0 : usuarioDetalle.hashCode());
        result = prime * result + ((direcciones == null) ? 0 : direcciones.hashCode());
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
        LoginResponse other = (LoginResponse) obj;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
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
        if (direcciones == null) {
            if (other.direcciones != null)
                return false;
        } else if (!direcciones.equals(other.direcciones))
            return false;
        return true;
    }

    public long getHash() {
        return this.hashCode();
    }

}