package io.kebblar.petstore.api.model.response;

public class ContenidoDetalle {
    private int valor;
    private String leyenda;
    public ContenidoDetalle() {}
    public ContenidoDetalle(int valor, String leyenda) {
        this.valor = valor;
        this.leyenda = leyenda;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getLeyenda() {
        return leyenda;
    }
    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }
    
}
