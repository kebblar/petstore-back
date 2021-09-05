/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      SmsRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:01:55
 */
package io.kebblar.petstore.api.model.request;

/**
 * Implementacion del POJO de la entidad de 'SmsRequest'.
 *
 * @author  Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class SmsRequest {

       /**
        * Atributos de la clase
        */
    private String telefono;
    private String mensaje;

    /**
     * Constructor por default (sin parámetros).
     */
    public SmsRequest() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param telefono a {@link java.lang.String} object.
     * @param mensaje a {@link java.lang.String} object.
     */
    public SmsRequest(String telefono, String mensaje) {
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    /**
     * <p>Getter for the field <code>telefono</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * <p>Setter for the field <code>telefono</code>.</p>
     *
     * @param telefono a {@link java.lang.String} object.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * <p>Getter for the field <code>mensaje</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * <p>Setter for the field <code>mensaje</code>.</p>
     *
     * @param mensaje a {@link java.lang.String} object.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * {@inheritDoc}
     *
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "SmsRequest [telefono=" + telefono + ", mensaje=" + mensaje + "]";
    }

    /**
     * {@inheritDoc}
     *
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * Compara si dos instancias de la clase son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SmsRequest other = (SmsRequest) obj;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        return true;
    }
}
