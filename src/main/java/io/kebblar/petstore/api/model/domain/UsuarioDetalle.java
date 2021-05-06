/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.model
 * Modulo:      Municipio
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'UsuarioDetalle'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Date;
/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'UsuarioDetalle'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
public class UsuarioDetalle {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String nickName;
    private String telefonoCasa;
    private String telefonoCelular;

    /**
     * Constructor por default.
     */
    public UsuarioDetalle() {
    }

    /**
     * Constructor basado en atributos.
     */
    public UsuarioDetalle(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
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

    /**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the telefonoCasa
	 */
	public String getTelefonoCasa() {
		return telefonoCasa;
	}

	/**
	 * @param telefonoCasa the telefonoCasa to set
	 */
	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	/**
	 * @return the telefonoCelular
	 */
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	/**
	 * @param telefonoCelular the telefonoCelular to set
	 */
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
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
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
