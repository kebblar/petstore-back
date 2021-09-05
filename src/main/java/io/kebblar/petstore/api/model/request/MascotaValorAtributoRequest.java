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
 * Nombre:      MascotaValorAtributoRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:01:19
 */
package io.kebblar.petstore.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implementacion del POJO de la entidad de 'ActualizaAnuncioRequest'.
 *
 * @author  Isabel Contreras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class MascotaValorAtributoRequest {
    private int id;
    @JsonProperty("valor")
    private int idValorAtributo;

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>idValorAtributo</code>.</p>
     *
     * @return a int.
     */
    public int getIdValorAtributo() {
        return idValorAtributo;
    }

    /**
     * <p>Setter for the field <code>idValorAtributo</code>.</p>
     *
     * @param idValorAtributo a int.
     */
    public void setIdValorAtributo(int idValorAtributo) {
        this.idValorAtributo = idValorAtributo;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + idValorAtributo;
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
        MascotaValorAtributoRequest other = (MascotaValorAtributoRequest) obj;
        if (id != other.id)
            return false;
        if (idValorAtributo != other.idValorAtributo)
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "MascotaValorAtributoRequest [id=" + id + ", idValorAtributo=" + idValorAtributo + "]";
    }

    /**
     * <p>Constructor for MascotaValorAtributoRequest.</p>
     *
     * @param id a int.
     * @param idValorAtributo a int.
     */
    public MascotaValorAtributoRequest(int id, int idValorAtributo) {
        this.id = id;
        this.idValorAtributo = idValorAtributo;
    }

    /**
     * <p>Constructor for MascotaValorAtributoRequest.</p>
     */
    public MascotaValorAtributoRequest() {
    }

}
