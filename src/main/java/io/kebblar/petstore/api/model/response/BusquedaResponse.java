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
 * Nombre:      BusquedaResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:02:42
 */
package io.kebblar.petstore.api.model.response;

import java.util.List;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'anuncio' para realizar la busqueda.
 *
 * @author Edgar Uribe Mendez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class BusquedaResponse {

    /**
     * Atributos de clase.
     */
    private int totalAnuncios;
    private List<DetalleAnuncioResponse> listaAnuncios;

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
    public List<DetalleAnuncioResponse> getListaAnuncios() {
        return listaAnuncios;
    }

    /**
     * <p>Setter for the field <code>listaAnuncios</code>.</p>
     *
     * @param listaAnuncios a {@link java.util.List} object.
     */
    public void setListaAnuncios(List<DetalleAnuncioResponse> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusquedaResponse)) return false;
        BusquedaResponse that = (BusquedaResponse) o;
        return totalAnuncios == that.totalAnuncios && Objects.equals(listaAnuncios, that.listaAnuncios);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "BusquedaResponse [totalAnuncios=" + totalAnuncios + ", listaAnuncios=" + listaAnuncios + "]";
    }

    /**
     * <p>Constructor for BusquedaResponse.</p>
     *
     * @param totalAnuncios a int.
     * @param listaAnuncios a {@link java.util.List} object.
     */
    public BusquedaResponse(int totalAnuncios, List<DetalleAnuncioResponse> listaAnuncios) {
        this.totalAnuncios = totalAnuncios;
        this.listaAnuncios = listaAnuncios;
    }

    /**
     * <p>Constructor for BusquedaResponse.</p>
     */
    public BusquedaResponse() {
    }

}
