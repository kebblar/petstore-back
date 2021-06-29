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
 * Artefacto:   UsuarioCompleto .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Sunday 06 de June de 2021 (09_35)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210627_0935 Implementación de clase 
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

/**
 * POJO asociado a la entidad 'usuario_completo'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class UsuarioCompleto implements Serializable {

    private static final long serialVersionUID = 2323351447441561757L;

    /**
     * Atributos de la clase
     */
    private int id;
    private String correo;
    private String clave;
    private long creado;
    private boolean activo;
    private int accesoNegadoContador;
    private long instanteBloqueo;
    private long instanteUltimoAcceso;
    private long instanteUltimoCambioClave;
    private String regeneraClaveToken;
    private long regeneraClaveInstante;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String nickName;
    private String telefonoCelular;

    /**
     * Constructor por default (sin parámetros).
     */
    public UsuarioCompleto() {
    }


    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public UsuarioCompleto(
            int id, 
            String correo, 
            String clave, 
            long creado, 
            boolean activo, 
            int accesoNegadoContador, 
            long instanteBloqueo, 
            long instanteUltimoAcceso, 
            long instanteUltimoCambioClave, 
            String regeneraClaveToken, 
            long regeneraClaveInstante, 
            String nombre, 
            String apellidoPaterno, 
            String apellidoMaterno, 
            Date fechaNacimiento, 
            String nickName, 
            String telefonoCelular) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        this.creado = creado;
        this.activo = activo;
        this.accesoNegadoContador = accesoNegadoContador;
        this.instanteBloqueo = instanteBloqueo;
        this.instanteUltimoAcceso = instanteUltimoAcceso;
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
        this.regeneraClaveToken = regeneraClaveToken;
        this.regeneraClaveInstante = regeneraClaveInstante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nickName = nickName;
        this.telefonoCelular = telefonoCelular;
    }

    /**
     * Getter para id.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Setter para id.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter para correo.
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * Setter para correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Getter para clave.
     */
    public String getClave() {
        return clave;
    }
    
    /**
     * Setter para clave.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * Getter para creado.
     */
    public long getCreado() {
        return creado;
    }
    
    /**
     * Setter para creado.
     */
    public void setCreado(long creado) {
        this.creado = creado;
    }
    
    /**
     * Getter para activo.
     */
    public boolean isActivo() {
        return activo;
    }
    
    /**
     * Setter para activo.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    /**
     * Getter para accesoNegadoContador.
     */
    public int getAccesoNegadoContador() {
        return accesoNegadoContador;
    }
    
    /**
     * Setter para accesoNegadoContador.
     */
    public void setAccesoNegadoContador(int accesoNegadoContador) {
        this.accesoNegadoContador = accesoNegadoContador;
    }
    
    /**
     * Getter para instanteBloqueo.
     */
    public long getInstanteBloqueo() {
        return instanteBloqueo;
    }
    
    /**
     * Setter para instanteBloqueo.
     */
    public void setInstanteBloqueo(long instanteBloqueo) {
        this.instanteBloqueo = instanteBloqueo;
    }
    
    /**
     * Getter para instanteUltimoAcceso.
     */
    public long getInstanteUltimoAcceso() {
        return instanteUltimoAcceso;
    }
    
    /**
     * Setter para instanteUltimoAcceso.
     */
    public void setInstanteUltimoAcceso(long instanteUltimoAcceso) {
        this.instanteUltimoAcceso = instanteUltimoAcceso;
    }
    
    /**
     * Getter para instanteUltimoCambioClave.
     */
    public long getInstanteUltimoCambioClave() {
        return instanteUltimoCambioClave;
    }
    
    /**
     * Setter para instanteUltimoCambioClave.
     */
    public void setInstanteUltimoCambioClave(long instanteUltimoCambioClave) {
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
    }
    
    /**
     * Getter para regeneraClaveToken.
     */
    public String getRegeneraClaveToken() {
        return regeneraClaveToken;
    }
    
    /**
     * Setter para regeneraClaveToken.
     */
    public void setRegeneraClaveToken(String regeneraClaveToken) {
        this.regeneraClaveToken = regeneraClaveToken;
    }
    
    /**
     * Getter para regeneraClaveInstante.
     */
    public long getRegeneraClaveInstante() {
        return regeneraClaveInstante;
    }
    
    /**
     * Setter para regeneraClaveInstante.
     */
    public void setRegeneraClaveInstante(long regeneraClaveInstante) {
        this.regeneraClaveInstante = regeneraClaveInstante;
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
        return "[UsuarioCompleto] : ["
                + " id =" + this.id
                + " correo =" + this.correo
                + " clave =" + this.clave
                + " creado =" + this.creado
                + " activo =" + this.activo
                + " accesoNegadoContador =" + this.accesoNegadoContador
                + " instanteBloqueo =" + this.instanteBloqueo
                + " instanteUltimoAcceso =" + this.instanteUltimoAcceso
                + " instanteUltimoCambioClave =" + this.instanteUltimoCambioClave
                + " regeneraClaveToken =" + this.regeneraClaveToken
                + " regeneraClaveInstante =" + this.regeneraClaveInstante
                + " nombre =" + this.nombre
                + " apellidoPaterno =" + this.apellidoPaterno
                + " apellidoMaterno =" + this.apellidoMaterno
                + " fechaNacimiento =" + this.fechaNacimiento
                + " nickName =" + this.nickName
                + " telefonoCelular =" + this.telefonoCelular
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase UsuarioCompleto son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsuarioCompleto)) {
            return false;
        }
        UsuarioCompleto other = (UsuarioCompleto) obj;
        return
               id == other.id && 
               correo == other.correo && 
               clave == other.clave && 
               creado == other.creado && 
               activo == other.activo && 
               accesoNegadoContador == other.accesoNegadoContador && 
               instanteBloqueo == other.instanteBloqueo && 
               instanteUltimoAcceso == other.instanteUltimoAcceso && 
               instanteUltimoCambioClave == other.instanteUltimoCambioClave && 
               regeneraClaveToken == other.regeneraClaveToken && 
               regeneraClaveInstante == other.regeneraClaveInstante && 
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
            id, 
            correo, 
            clave, 
            creado, 
            activo, 
            accesoNegadoContador, 
            instanteBloqueo, 
            instanteUltimoAcceso, 
            instanteUltimoCambioClave, 
            regeneraClaveToken, 
            regeneraClaveInstante, 
            nombre, 
            apellidoPaterno, 
            apellidoMaterno, 
            fechaNacimiento, 
            nickName, 
            telefonoCelular
        );
    }

}
