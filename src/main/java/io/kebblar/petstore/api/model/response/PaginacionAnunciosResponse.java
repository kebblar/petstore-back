package io.kebblar.petstore.api.model.response;

import java.util.List;

public class PaginacionAnunciosResponse {

    private int totalAnuncios;
    private List<BusquedaAdministracionResponse> listaAnuncios;
    
    
    public PaginacionAnunciosResponse(int totalAnuncios, List<BusquedaAdministracionResponse> listaAnuncios) {
        super();
        this.totalAnuncios = totalAnuncios;
        this.listaAnuncios = listaAnuncios;
    }

    @Override
    public String toString() {
        return "PaginacionAnunciosResponse [totalAnuncios=" + totalAnuncios + ", listaAnuncios=" + listaAnuncios + "]";
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
        PaginacionAnunciosResponse other = (PaginacionAnunciosResponse) obj;
        if (listaAnuncios == null) {
            if (other.listaAnuncios != null)
                return false;
        } else if (!listaAnuncios.equals(other.listaAnuncios))
            return false;
        if (totalAnuncios != other.totalAnuncios)
            return false;
        return true;
    }
    
    public int getTotalAnuncios() {
        return totalAnuncios;
    }
    public void setTotalAnuncios(int totalAnuncios) {
        this.totalAnuncios = totalAnuncios;
    }
    public List<BusquedaAdministracionResponse> getListaAnuncios() {
        return listaAnuncios;
    }
    public void setListaAnuncios(List<BusquedaAdministracionResponse> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }
    
    
}
