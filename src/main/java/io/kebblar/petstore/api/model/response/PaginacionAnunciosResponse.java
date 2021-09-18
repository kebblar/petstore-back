/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      PaginacionAnunciosResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:21:27
 */
package io.kebblar.petstore.api.model.response;

import java.util.List;

/**
 * <p>PaginacionAnunciosResponse class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class PaginacionAnunciosResponse {
    private int totalAnuncios;
    private List<BusquedaAdministracionResponse> listaAnuncios;

    /**
     * <p>Constructor for PaginacionAnunciosResponse.</p>
     *
     * @param totalAnuncios a int.
     * @param listaAnuncios a {@link java.util.List} object.
     */
    public PaginacionAnunciosResponse(int totalAnuncios, List<BusquedaAdministracionResponse> listaAnuncios) {
        this.totalAnuncios = totalAnuncios;
        this.listaAnuncios = listaAnuncios;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "PaginacionAnunciosResponse [totalAnuncios=" + totalAnuncios + ", listaAnuncios=" + listaAnuncios + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listaAnuncios == null) ? 0 : listaAnuncios.hashCode());
        result = prime * result + totalAnuncios;
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
        PaginacionAnunciosResponse other = (PaginacionAnunciosResponse) obj;
        if (listaAnuncios == null) {
            if (other.listaAnuncios != null)
                return false;
        } else if (!listaAnuncios.equals(other.listaAnuncios))
            return false;
        return (totalAnuncios == other.totalAnuncios);
    }

    /**
     * <p>Getter for the field <code>totalAnuncios</code>.</p>
     *
     * @return a int.
     */
    public int getTotalAnuncios() {
        return totalAnuncios;
    }

    /**
     * <p>Setter for the field <code>totalAnuncios</code>.</p>
     *
     * @param totalAnuncios a int.
     */
    public void setTotalAnuncios(int totalAnuncios) {
        this.totalAnuncios = totalAnuncios;
    }

    /**
     * <p>Getter for the field <code>listaAnuncios</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<BusquedaAdministracionResponse> getListaAnuncios() {
        return listaAnuncios;
    }

    /**
     * <p>Setter for the field <code>listaAnuncios</code>.</p>
     *
     * @param listaAnuncios a {@link java.util.List} object.
     */
    public void setListaAnuncios(List<BusquedaAdministracionResponse> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

}
