/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
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

/**
 * POJO asociado a la entidad 'anuncio' para realizar la busqueda.
 *
 * @author Edgar Uribe Mendez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class BusquedaResponse {
    private int totalAnuncios;
    private List<DetalleAnuncioResponse> listaAnuncios;

    public int getTotalAnuncios() {
        return totalAnuncios;
    }

    public void setTotalAnuncios(int totalAnuncios) {
        this.totalAnuncios = totalAnuncios;
    }

    public List<DetalleAnuncioResponse> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(List<DetalleAnuncioResponse> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listaAnuncios == null) ? 0 : listaAnuncios.hashCode());
        result = prime * result + totalAnuncios;
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
        BusquedaResponse other = (BusquedaResponse) obj;
        if (listaAnuncios == null) {
            if (other.listaAnuncios != null)
                return false;
        } else if (!listaAnuncios.equals(other.listaAnuncios))
            return false;
        if (totalAnuncios != other.totalAnuncios)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BusquedaResponse [totalAnuncios=" + totalAnuncios + ", listaAnuncios=" + listaAnuncios + "]";
    }

    public BusquedaResponse(int totalAnuncios, List<DetalleAnuncioResponse> listaAnuncios) {
        this.totalAnuncios = totalAnuncios;
        this.listaAnuncios = listaAnuncios;
    }

    public BusquedaResponse() {
    }

}
