/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ProcesaMascotaResponse.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (16_55)
 *
 * Historia:    .
 *              20210504_1655 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

/**
 * Implementacion del POJO de la entidad de {@link ProcesaMascotaResponse}.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ProcesaMascotaResponse {

    /*
     * Atributos de la clase.
     */
    private String mensaje;
    private int id;

    /**
     * Constructor por atributos de la clase.
     */
    public ProcesaMascotaResponse(String mensaje, int id) {
        this.mensaje = mensaje;
        this.id = id;
    }

    /*
     * Getter y setter.
     */
    public String getMensaje() {
        return mensaje;
    }
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "InsertaMascotaResponse [mensaje=" + mensaje + ", id=" + id + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
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
        ProcesaMascotaResponse other = (ProcesaMascotaResponse) obj;
        if (id != other.id)
            return false;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        return true;
    }

    /**
     * Para las pruebas de regresion.
     * @return hashcode del objeto
     */
    public int getHash() {
        return this.hashCode();
    }

}
