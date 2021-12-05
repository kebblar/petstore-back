package io.kebblar.petstore.api.model.request;

public class DescripcionRequest {
    private String descripcionPlaneText;
    private String descripcion;
    private String correo;
    
    public DescripcionRequest() {
    }
    public DescripcionRequest(String descripcion, String descripcionPlaneText, String correo) {
        this.descripcion = descripcion;
        this.correo = correo;
        this.descripcionPlaneText = descripcionPlaneText;
    }
    public String getDescripcionPlaneText() {
        return descripcionPlaneText;
    }
    public void setDescripcionPlaneText(String descripcionPlaneText) {
        this.descripcionPlaneText = descripcionPlaneText;
    }    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
    public String toString() {
        return "DescripcionRequest [descripcion=" + descripcion + ", correo=" + correo + "]";
    }
    public int getHash() {
        return this.hashCode();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((descripcionPlaneText == null) ? 0 : descripcionPlaneText.hashCode());
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
        DescripcionRequest other = (DescripcionRequest) obj;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (descripcionPlaneText == null) {
            if (other.descripcionPlaneText != null)
                return false;
        } else if (!descripcionPlaneText.equals(other.descripcionPlaneText))
            return false;
        return true;
    }
    
}
