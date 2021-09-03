/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   CredencialesRequest.java
 * Tipo:        clase
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_38)
 *
 * Historia:    .
 *              20210506_0938 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.request;

/**
 * Implementacion del POJO de la entidad de 'CredencialesRequest'.
 *
 * @author  luz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class CredencialesRequest {

    /*
     * Atributos de la clase.
     */
    private String usuario;
    private String clave;

    /**
     * Constructor por defecto.
     */
    public CredencialesRequest() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public CredencialesRequest(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    /*
     * Getter y Setter.
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "CredencialesRequest [usuario=" + usuario + ", clave=" + clave + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
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
