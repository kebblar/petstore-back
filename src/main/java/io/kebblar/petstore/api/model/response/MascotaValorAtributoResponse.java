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
