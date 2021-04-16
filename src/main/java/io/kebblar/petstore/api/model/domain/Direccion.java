package io.kebblar.petstore.api.model.domain;

public class Direccion {
    private int id;
    private String calleNumero;
    private String colonia;
    private int delegacion;
    private int estado;
    
    public Direccion() {
    }
    
    public Direccion(int id, String calleNumero, String colonia, int delegacion, int estado) {
        super();
        this.id = id;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.delegacion = delegacion;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCalleNumero() {
        return calleNumero;
    }
    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }
    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    public int getDelegacion() {
        return delegacion;
    }
    public void setDelegacion(int delegacion) {
        this.delegacion = delegacion;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Direccion [id=" + id + ", calleNumero=" + calleNumero + ", colonia=" + colonia + ", delegacion="
                + delegacion + ", estado=" + estado + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((calleNumero == null) ? 0 : calleNumero.hashCode());
        result = prime * result + ((colonia == null) ? 0 : colonia.hashCode());
        result = prime * result + delegacion;
        result = prime * result + estado;
        result = prime * result + id;
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
        Direccion other = (Direccion) obj;
        if (calleNumero == null) {
            if (other.calleNumero != null)
                return false;
        } else if (!calleNumero.equals(other.calleNumero))
            return false;
        if (colonia == null) {
            if (other.colonia != null)
                return false;
        } else if (!colonia.equals(other.colonia))
            return false;
        if (delegacion != other.delegacion)
            return false;
        if (estado != other.estado)
            return false;
        if (id != other.id)
            return false;
        return true;
    }
    public long getHash() {
        return hashCode();
    }
    
}
