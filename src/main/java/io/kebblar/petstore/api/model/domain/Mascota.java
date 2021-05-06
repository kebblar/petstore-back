/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Mascota.java
 * Tipo:        clase
 * AUTOR:       Edgar Uribe (EUM)
 * Fecha:       Martes 04 de Mayo del 2021 (09 10)
 *
 * Historia:    .
 *              20210503_2321 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * Implementacion del POJO de la entidad de 'Mascota'.
 * 
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Mascota {
    @Range(min = 1, max = 13, message = "El ID de la mascota debe ser mínimo {min} y máximo {max}")
    private int id;

    @Size(min = 4, max = 8, message = "El nombre de la mascota debe tener una longitud mínima de {min} y máxima de {max}")
    private String nombre;

    @NotBlank(message="La descripción de la mascota debe ser no vacia")
    private String descripcion;

    public Mascota() {
    }
    public Mascota(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "Mascota [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
        Mascota other = (Mascota) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
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

    public int getHash() {
        return this.hashCode();
    }
}
