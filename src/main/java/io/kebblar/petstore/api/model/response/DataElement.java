package io.kebblar.petstore.api.model.response;

import java.util.List;

public class DataElement {
    private int ordinal;
    private Cabecera cabecera;
    private List<ContenidoDetalle> contenido;
    public DataElement() {}
    public DataElement(int ordinal, Cabecera cabecera, List<ContenidoDetalle> contenido) {
        this.ordinal = ordinal;
        this.cabecera = cabecera;
        this.contenido = contenido;
    }
    public int getOrdinal() {
        return this.ordinal;
    }
    public Cabecera getCabecera() {
        return this.cabecera;
    }
    public List<ContenidoDetalle> getContenido() {
        return contenido;
    }
    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }
    public void setContenido(List<ContenidoDetalle> contenido) {
        this.contenido = contenido;
    }
    
}
