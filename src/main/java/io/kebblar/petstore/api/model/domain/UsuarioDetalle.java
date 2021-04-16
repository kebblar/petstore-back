package io.kebblar.petstore.api.model.domain;

public class UsuarioDetalle {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    
    public UsuarioDetalle() {
    }
    
    public UsuarioDetalle(int id, String nombre, String apellidoPaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Override
    public String toString() {
        return "UsuarioDetalle [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        UsuarioDetalle other = (UsuarioDetalle) obj;
        if (apellidoPaterno == null) {
            if (other.apellidoPaterno != null)
                return false;
        } else if (!apellidoPaterno.equals(other.apellidoPaterno))
            return false;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    public long getHash() {
        return hashCode();
    }
}
