package io.kebblar.petstore.api.model.response;

import java.util.Date;

public class LoginResponse {
    private int id;
    private String nombre;
    private Date fecha;
    public LoginResponse() {
    }
    public LoginResponse(int id, String nombre, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    // agregar toString, hash y equals aqui...
}
