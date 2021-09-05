/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AnuncioImagenRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:59:54
 */
package io.kebblar.petstore.api.model.request;

/**
 * <p>AnuncioImagenRequest class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class AnuncioImagenRequest {
    private int idAnuncio;
    private String uuid;

    /**
     * <p>Constructor for AnuncioImagenRequest.</p>
     */
    public AnuncioImagenRequest() {
    }

    /**
     * <p>Constructor for AnuncioImagenRequest.</p>
     *
     * @param idAnuncio a int.
     * @param uuid a {@link java.lang.String} object.
     */
    public AnuncioImagenRequest(int idAnuncio, String uuid) {
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
    }

    /**
     * <p>Getter for the field <code>idAnuncio</code>.</p>
     *
     * @return a int.
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * <p>Setter for the field <code>idAnuncio</code>.</p>
     *
     * @param idAnuncio a int.
     */
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * <p>Getter for the field <code>uuid</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * <p>Setter for the field <code>uuid</code>.</p>
     *
     * @param uuid a {@link java.lang.String} object.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idAnuncio;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
        AnuncioImagenRequest other = (AnuncioImagenRequest) obj;
        if (idAnuncio != other.idAnuncio)
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "AnuncioImagenRequest [idAnuncio=" + idAnuncio + ", uuid=" + uuid + "]";
    }

}
