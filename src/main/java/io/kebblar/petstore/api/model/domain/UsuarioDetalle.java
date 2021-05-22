
/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion 
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 * 
 * Artefacto:   UsuarioDetalle .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       viernes 05 de mayo de 2021 (21_01)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210521_2101 Implementación de clase 
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;
/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'usuario_detalle'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class UsuarioDetalle implements Serializable {

    private static final long serialVersionUID = 6608759821875290806L;

    /**
     * Atributos de la clase
     */
    private Integer idUsuario;
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
     * Constructor basado en la llave primaria.
     */
    public UsuarioDetalle(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public UsuarioDetalle(Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String nickName, String telefonoCelular) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nickName = nickName;
        this.telefonoCelular = telefonoCelular;
    }

    /**
     * Getter para idUsuario.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * Setter para idUsuario.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * Getter para nombre.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Setter para nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Getter para apellidoPaterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    
    /**
     * Setter para apellidoPaterno.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    /**
     * Getter para apellidoMaterno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    
    /**
     * Setter para apellidoMaterno.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    /**
     * Getter para fechaNacimiento.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Setter para fechaNacimiento.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /**
     * Getter para nickName.
     */
    public String getNickName() {
        return nickName;
    }
    
    /**
     * Setter para nickName.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    /**
     * Getter para telefonoCelular.
     */
    public String getTelefonoCelular() {
        return telefonoCelular;
    }
    
    /**
     * Setter para telefonoCelular.
     */
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[UsuarioDetalle] : ["
                + " idUsuario =" + this.idUsuario
                + " nombre =" + this.nombre
                + " apellidoPaterno =" + this.apellidoPaterno
                + " apellidoMaterno =" + this.apellidoMaterno
                + " fechaNacimiento =" + this.fechaNacimiento
                + " nickName =" + this.nickName
                + " telefonoCelular =" + this.telefonoCelular
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase UsuarioDetalle son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsuarioDetalle)) {
            return false;
        }
        UsuarioDetalle other = (UsuarioDetalle) obj;
        return
               idUsuario == other.idUsuario && 
               nombre == other.nombre && 
               apellidoPaterno == other.apellidoPaterno && 
               apellidoMaterno == other.apellidoMaterno && 
               fechaNacimiento == other.fechaNacimiento && 
               nickName == other.nickName && 
               telefonoCelular == other.telefonoCelular; 
    }
    
    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            idUsuario, 
            nombre, 
            apellidoPaterno, 
            apellidoMaterno, 
            fechaNacimiento, 
            nickName, 
            telefonoCelular
        );
    }

}
