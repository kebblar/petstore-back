/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   SmsRequest.java
 * Tipo:        clase
 * AUTOR:       Daniel Alvarez (DA)
 * Fecha:       20 de Junio de 2021
 *
 * Historia:    20210620_0938 Creación de éste POJO
 *
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
     * @param telefono
     * @param mensaje
     */
    public SmsRequest(String telefono, String mensaje) {
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

       /**
        * Método toString para el pojo, representa al objeto en forma de cadena
        */
    @Override
    public String toString() {
        return "SmsRequest [telefono=" + telefono + ", mensaje=" + mensaje + "]";
    }

       /**
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
