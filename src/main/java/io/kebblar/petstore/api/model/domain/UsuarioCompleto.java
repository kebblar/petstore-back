/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      UsuarioCompleto
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:30
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

    /*
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

    /*
     * Setter y Getter.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public long getCreado() {
        return creado;
    }

    public void setCreado(long creado) {
        this.creado = creado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getAccesoNegadoContador() {
        return accesoNegadoContador;
    }

    public void setAccesoNegadoContador(int accesoNegadoContador) {
        this.accesoNegadoContador = accesoNegadoContador;
    }

    public long getInstanteBloqueo() {
        return instanteBloqueo;
    }

    public void setInstanteBloqueo(long instanteBloqueo) {
        this.instanteBloqueo = instanteBloqueo;
    }

    public long getInstanteUltimoAcceso() {
        return instanteUltimoAcceso;
    }

    public void setInstanteUltimoAcceso(long instanteUltimoAcceso) {
        this.instanteUltimoAcceso = instanteUltimoAcceso;
    }

    public long getInstanteUltimoCambioClave() {
        return instanteUltimoCambioClave;
    }

    public void setInstanteUltimoCambioClave(long instanteUltimoCambioClave) {
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
    }

    public String getRegeneraClaveToken() {
        return regeneraClaveToken;
    }

    public void setRegeneraClaveToken(String regeneraClaveToken) {
        this.regeneraClaveToken = regeneraClaveToken;
    }

    public long getRegeneraClaveInstante() {
        return regeneraClaveInstante;
    }

    public void setRegeneraClaveInstante(long regeneraClaveInstante) {
        this.regeneraClaveInstante = regeneraClaveInstante;
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


    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
