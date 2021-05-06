package io.kebblar.petstore.api.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class CredencialesRequest {
	

    @ApiModelProperty(example = "usuario")
    @NotNull(message = "El usuario no puede ser nulo")
    @Pattern(regexp="^\\p{Alpha}{2,30}$",
            message = "Nombre inválido, solo se permiten de 2 a 30 caracteres alfabeticos")
    private String usuario;

    @ApiModelProperty(example = "clave")
    @NotNull(message = "La clave no puede ser nula")
    @Pattern(regexp="^\\p{Alpha}{30}$",
            message = "Clave inválida, solo se permiten de 2 a 30 caracteres alfabeticos")
    private String clave;
    
    public CredencialesRequest() {
    }
    public CredencialesRequest(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    @Override
    public String toString() {
        return "CredencialesRequest [usuario=" + usuario + ", clave=" + clave + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
        CredencialesRequest other = (CredencialesRequest) obj;
        if (clave == null) {
            if (other.clave != null)
                return false;
        } else if (!clave.equals(other.clave))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }
}
