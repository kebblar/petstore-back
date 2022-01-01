package io.kebblar.petstore.api.model.response;

public class HabilidadResponse {
    private int usuarioId;
    private int habilidadId;
    private String nombre;
    private int costo;
    
    public HabilidadResponse() {}
    
    public HabilidadResponse(int usuarioId, int habilidadId, String nombre, int costo) {
        this.usuarioId = usuarioId;
        this.habilidadId = habilidadId;
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(int habilidadId) {
        this.habilidadId = habilidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }



    @Override
    public String toString() {
        return "HabilidadResponse [getUsuarioId()=" + getUsuarioId() + ", getHabilidadId()=" + getHabilidadId()
                + ", getNombre()=" + getNombre() + ", getCosto()=" + getCosto() + ", hashCode()=" + hashCode() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + costo;
        result = prime * result + habilidadId;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + usuarioId;
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
        HabilidadResponse other = (HabilidadResponse) obj;
        if (costo != other.costo)
            return false;
        if (habilidadId != other.habilidadId)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (usuarioId != other.usuarioId)
            return false;
        return true;
    }
    
    public int getHash() {
        return this.hashCode();
    }
}
