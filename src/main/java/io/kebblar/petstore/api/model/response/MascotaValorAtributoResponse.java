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
 * Nombre:      MascotaValorAtributoResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:21:10
 */
package io.kebblar.petstore.api.model.response;

import io.kebblar.petstore.api.model.request.MascotaValorAtributoRequest;

public class MascotaValorAtributoResponse extends MascotaValorAtributoRequest {
    private String rango;
    private int idAtributo;
    private String nombreAtributo;

    public MascotaValorAtributoResponse() {
    }

    public MascotaValorAtributoResponse(int id, int idValorAtributo) {
        super(id, idValorAtributo);
    }

    public MascotaValorAtributoResponse(int id, int idValorAtributo, String rango, int idAtributo, String nombreAtributo) {
        super(id, idValorAtributo);
        this.rango = rango;
        this.idAtributo = idAtributo;
        this.nombreAtributo = nombreAtributo;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + idAtributo;
        result = prime * result + ((nombreAtributo == null) ? 0 : nombreAtributo.hashCode());
        result = prime * result + ((rango == null) ? 0 : rango.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        MascotaValorAtributoResponse other = (MascotaValorAtributoResponse) obj;
        if (idAtributo != other.idAtributo)
            return false;
        if (nombreAtributo == null) {
            if (other.nombreAtributo != null)
                return false;
        } else if (!nombreAtributo.equals(other.nombreAtributo))
            return false;
        if (rango == null) {
            if (other.rango != null)
                return false;
        } else if (!rango.equals(other.rango))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MascotaValorAtributoResponse [rango=" + rango + ", idAtributo=" + idAtributo + ", nombreAtributo=" + nombreAtributo + "]";
    }

}
