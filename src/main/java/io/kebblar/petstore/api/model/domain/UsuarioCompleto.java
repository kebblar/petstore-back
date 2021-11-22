/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
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
    private int num;
    private String nickName;
    private String correo;
    private String telefonoCelular;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String clave;
    private long creado;
    private boolean activo;
    private int accesoNegadoContador;
    private long instanteBloqueo;
    private long instanteUltimoAcceso;
    private long instanteUltimoCambioClave;
    private String regeneraClaveToken;
    private long regeneraClaveInstante;

    /**
     * Constructor por default (sin parámetros).
     */
    public UsuarioCompleto() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param id a int.
     * @param correo a {@link java.lang.String} object.
     * @param clave a {@link java.lang.String} object.
     * @param creado a long.
     * @param activo a boolean.
     * @param accesoNegadoContador a int.
     * @param instanteBloqueo a long.
     * @param instanteUltimoAcceso a long.
     * @param instanteUltimoCambioClave a long.
     * @param regeneraClaveToken a {@link java.lang.String} object.
     * @param regeneraClaveInstante a long.
     * @param nombre a {@link java.lang.String} object.
     * @param apellidoPaterno a {@link java.lang.String} object.
     * @param apellidoMaterno a {@link java.lang.String} object.
     * @param fechaNacimiento a {@link java.util.Date} object.
     * @param nickName a {@link java.lang.String} object.
     * @param telefonoCelular a {@link java.lang.String} object.
     */
    public UsuarioCompleto(
            int id,
            int num,
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
        this.num = num;
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
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>correo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * <p>Setter for the field <code>correo</code>.</p>
     *
     * @param correo a {@link java.lang.String} object.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * <p>Getter for the field <code>clave</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getClave() {
        return clave;
    }

    /**
     * <p>Setter for the field <code>clave</code>.</p>
     *
     * @param clave a {@link java.lang.String} object.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * <p>Getter for the field <code>creado</code>.</p>
     *
     * @return a long.
     */
    public long getCreado() {
        return creado;
    }

    /**
     * <p>Setter for the field <code>creado</code>.</p>
     *
     * @param creado a long.
     */
    public void setCreado(long creado) {
        this.creado = creado;
    }

    /**
     * <p>isActivo.</p>
     *
     * @return a boolean.
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * <p>Setter for the field <code>activo</code>.</p>
     *
     * @param activo a boolean.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * <p>Getter for the field <code>accesoNegadoContador</code>.</p>
     *
     * @return a int.
     */
    public int getAccesoNegadoContador() {
        return accesoNegadoContador;
    }

    /**
     * <p>Setter for the field <code>accesoNegadoContador</code>.</p>
     *
     * @param accesoNegadoContador a int.
     */
    public void setAccesoNegadoContador(int accesoNegadoContador) {
        this.accesoNegadoContador = accesoNegadoContador;
    }

    /**
     * <p>Getter for the field <code>instanteBloqueo</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteBloqueo() {
        return instanteBloqueo;
    }

    /**
     * <p>Setter for the field <code>instanteBloqueo</code>.</p>
     *
     * @param instanteBloqueo a long.
     */
    public void setInstanteBloqueo(long instanteBloqueo) {
        this.instanteBloqueo = instanteBloqueo;
    }

    /**
     * <p>Getter for the field <code>instanteUltimoAcceso</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteUltimoAcceso() {
        return instanteUltimoAcceso;
    }

    /**
     * <p>Setter for the field <code>instanteUltimoAcceso</code>.</p>
     *
     * @param instanteUltimoAcceso a long.
     */
    public void setInstanteUltimoAcceso(long instanteUltimoAcceso) {
        this.instanteUltimoAcceso = instanteUltimoAcceso;
    }

    /**
     * <p>Getter for the field <code>instanteUltimoCambioClave</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteUltimoCambioClave() {
        return instanteUltimoCambioClave;
    }

    /**
     * <p>Setter for the field <code>instanteUltimoCambioClave</code>.</p>
     *
     * @param instanteUltimoCambioClave a long.
     */
    public void setInstanteUltimoCambioClave(long instanteUltimoCambioClave) {
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
    }

    /**
     * <p>Getter for the field <code>regeneraClaveToken</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRegeneraClaveToken() {
        return regeneraClaveToken;
    }

    public int getnum() {
        return num;
    }

    public void setnum(int num) {
        this.num = num;
    }

    /**
     * <p>Setter for the field <code>regeneraClaveToken</code>.</p>
     *
     * @param regeneraClaveToken a {@link java.lang.String} object.
     */
    public void setRegeneraClaveToken(String regeneraClaveToken) {
        this.regeneraClaveToken = regeneraClaveToken;
    }

    /**
     * <p>Getter for the field <code>regeneraClaveInstante</code>.</p>
     *
     * @return a long.
     */
    public long getRegeneraClaveInstante() {
        return regeneraClaveInstante;
    }

    /**
     * <p>Setter for the field <code>regeneraClaveInstante</code>.</p>
     *
     * @param regeneraClaveInstante a long.
     */
    public void setRegeneraClaveInstante(long regeneraClaveInstante) {
        this.regeneraClaveInstante = regeneraClaveInstante;
    }

    /**
     * <p>Getter for the field <code>nombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Setter for the field <code>nombre</code>.</p>
     *
     * @param nombre a {@link java.lang.String} object.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <p>Getter for the field <code>apellidoPaterno</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * <p>Setter for the field <code>apellidoPaterno</code>.</p>
     *
     * @param apellidoPaterno a {@link java.lang.String} object.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * <p>Getter for the field <code>apellidoMaterno</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * <p>Setter for the field <code>apellidoMaterno</code>.</p>
     *
     * @param apellidoMaterno a {@link java.lang.String} object.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * <p>Getter for the field <code>fechaNacimiento</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * <p>Setter for the field <code>fechaNacimiento</code>.</p>
     *
     * @param fechaNacimiento a {@link java.util.Date} object.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * <p>Getter for the field <code>nickName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * <p>Setter for the field <code>nickName</code>.</p>
     *
     * @param nickName a {@link java.lang.String} object.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * <p>Getter for the field <code>telefonoCelular</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    /**
     * <p>Setter for the field <code>telefonoCelular</code>.</p>
     *
     * @param telefonoCelular a {@link java.lang.String} object.
     */
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[UsuarioCompleto] : ["
                + " id =" + this.id
                + " num =" + this.num
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

    /** {@inheritDoc} */
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
               num == other.num &&
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

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            num,
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

    public int getHash() {
        return this.hashCode();
    }
    
}
