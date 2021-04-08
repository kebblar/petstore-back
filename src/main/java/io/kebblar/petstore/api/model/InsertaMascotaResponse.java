package io.kebblar.petstore.api.model;

public class InsertaMascotaResponse {
    private String mensaje="La mascota fué insertada correctamente";
    private int id;

    public InsertaMascotaResponse(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "InsertaMascotaResponse [mensaje=" + mensaje + ", id=" + id + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
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
        InsertaMascotaResponse other = (InsertaMascotaResponse) obj;
        if (id != other.id)
            return false;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        return true;
    }
    public int getHash() {
        return this.hashCode();
    }
}
