 /*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 * Proyecto:    petstore-back
 * Paquete:     io.kebblar.petstore.api.model.domain.Rol
 * Modulo:      Rol
 * Artefacto:   Rol.java
 * Tipo:        Clase
 * AUTOR:       Diego González Sánchez
 * Fecha:       Jueves 6 de Mayo de 2021 (09_14)
 * Version:     1.0-SNAPSHOT
 *
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

/**
 * Implementacion del POJO de la entidad de 'Rol'.
 * 
 * @author  Diego G. Sánchez.
 * @see     io.kebblar.petstore.api.model.domain.Rol
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Rol {
    private int id;
    private String nombre;
    private boolean activo;

    public Rol() {
    }

    public Rol(int id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Rol [id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (activo ? 1231 : 1237);
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
        Rol other = (Rol) obj;
        if (activo != other.activo)
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
