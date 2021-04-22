package io.kebblar.petstore.api.model.domain;

public class UsuarioDetalle {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private long fechaNacimiento;
    private String nickName;
    private String telefonoCasa;
    private String telefonoCelular;

    public UsuarioDetalle() {
    }

    public UsuarioDetalle(int id, String nombre, String apellidoPaterno, String apellidoMaterno, long fechaNacimiento,
            String nickName, String telefonoCasa, String telefonoCelular) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nickName = nickName;
        this.telefonoCasa = telefonoCasa;
        this.telefonoCelular = telefonoCelular;
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

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public long getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(long fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public long getHash() {
        return hashCode();
    }

    @Override
    public String toString() {
        return "UsuarioDetalle [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
                + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", nickName="
                + nickName + ", telefonoCasa=" + telefonoCasa + ", telefonoCelular=" + telefonoCelular + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
        result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
        result = prime * result + (int) (fechaNacimiento ^ (fechaNacimiento >>> 32));
        result = prime * result + id;
        result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((telefonoCasa == null) ? 0 : telefonoCasa.hashCode());
        result = prime * result + ((telefonoCelular == null) ? 0 : telefonoCelular.hashCode());
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
        if (apellidoMaterno == null) {
            if (other.apellidoMaterno != null)
                return false;
        } else if (!apellidoMaterno.equals(other.apellidoMaterno))
            return false;
        if (apellidoPaterno == null) {
            if (other.apellidoPaterno != null)
                return false;
        } else if (!apellidoPaterno.equals(other.apellidoPaterno))
            return false;
        if (fechaNacimiento != other.fechaNacimiento)
            return false;
        if (id != other.id)
            return false;
        if (nickName == null) {
            if (other.nickName != null)
                return false;
        } else if (!nickName.equals(other.nickName))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (telefonoCasa == null) {
            if (other.telefonoCasa != null)
                return false;
        } else if (!telefonoCasa.equals(other.telefonoCasa))
            return false;
        if (telefonoCelular == null) {
            if (other.telefonoCelular != null)
                return false;
        } else if (!telefonoCelular.equals(other.telefonoCelular))
            return false;
        return true;
    }
    
}