/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UsuarioDetalle.java
 * Tipo:        clase
 * AUTOR:       Luz Cuahonte (LC)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_38)
 *
 * Historia:    .
 *              20210506_0938 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'UsuarioDetalle'.
 *
 * @author  luz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class UsuarioDetalle {

    /*
     * Atributos de clase.
     */
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String nickName;
    private String telefonoCelular;

    /**
     * Constructor por default (sin parámetros).
     */
    public UsuarioDetalle() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     */
    public UsuarioDetalle(
            int id,
            String nombre,
            String apellidoPaterno,
            String apellidoMaterno,
            String nickName,
            Date fechaNacimiento,
            String telefonoCelular) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nickName = nickName;
        this.telefonoCelular = telefonoCelular;
    }

    /*
     * Getter y Setter.
     */
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UsuarioDetalle [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
                + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", nickName="
                + nickName + ", telefonoCelular=" + telefonoCelular + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
        result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + id;
        result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((telefonoCelular == null) ? 0 : telefonoCelular.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDetalle)) return false;
        UsuarioDetalle that = (UsuarioDetalle) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(apellidoPaterno, that.apellidoPaterno)
                && Objects.equals(apellidoMaterno, that.apellidoMaterno) && Objects.equals(fechaNacimiento, that.fechaNacimiento)
                && Objects.equals(nickName, that.nickName) && Objects.equals(telefonoCelular, that.telefonoCelular);
    }
}
