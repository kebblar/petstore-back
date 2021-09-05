/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      ProcesaMascotaResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:21:41
 */
package io.kebblar.petstore.api.model.response;

/**
 * Implementacion del POJO de la entidad de {@link io.kebblar.petstore.api.model.response.ProcesaMascotaResponse}.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ProcesaMascotaResponse {
    private String mensaje;
    private int id;

    /**
     * <p>Constructor for ProcesaMascotaResponse.</p>
     *
     * @param mensaje a {@link java.lang.String} object.
     * @param id a int.
     */
    public ProcesaMascotaResponse(String mensaje, int id) {
        this.mensaje = mensaje;
        this.id = id;
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
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "InsertaMascotaResponse [mensaje=" + mensaje + ", id=" + id + "]";
    }
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
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
     * <p>getHash.</p>
     *
     * @return a int.
     */
    public int getHash() {
        return this.hashCode();
    }
}
