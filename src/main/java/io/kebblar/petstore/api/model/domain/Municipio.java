package io.kebblar.petstore.api.model.domain;

public class Municipio {
    private int id;
    private int idEstado;
    private int idOrden;
    private String nombre;
    
    public Municipio() {}
    
    public Municipio(int id, int idEstado, int idOrden, String nombre) {
        this.id = id;
        this.idEstado = idEstado;
        this.idOrden = idOrden;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
