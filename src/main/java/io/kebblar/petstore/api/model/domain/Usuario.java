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
 * Nombre:      Usuario
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:22
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'Usuario'.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Usuario {

    /*
     * Atributos de la clase.
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

    /**
     * Constructor por default (sin parámetros).
     */
    public Usuario() {
    }

    /**
     * Constructor basado en correo y clave con su id.
     */
    public Usuario(int id, String correo, String clave) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        // Default values
        this.activo = true;
        this.accesoNegadoContador = 0;
        this.creado = System.currentTimeMillis();
        this.instanteBloqueo = 0;
        this.instanteUltimoAcceso = 0;
        this.instanteUltimoCambioClave = 0;
        this.regeneraClaveInstante = 0;
        this.regeneraClaveToken = "NA";
    }

    /**
     * Constructor basado en los atributos de la clase.
     */
    public Usuario(
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
            long regeneraClaveInstante) {
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
        return this.clave;
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

    /**
     * Método especial (y adicional) de soporte al proceso de pruebas de regresión.
     */
    public long getHash() {
        return this.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", correo=" + correo + ", clave=" + clave + ", creado=" + creado + ", activo="
                + activo + ", accesoNegadoContador=" + accesoNegadoContador + ", instanteBloqueo=" + instanteBloqueo
                + ", instanteUltimoAcceso=" + instanteUltimoAcceso + ", instanteUltimoCambioClave="
                + instanteUltimoCambioClave + ", regeneraClaveToken=" + regeneraClaveToken + ", regeneraClaveInstante="
                + regeneraClaveInstante + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accesoNegadoContador;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + (int) (creado ^ (creado >>> 32));
        result = prime * result + id;
        result = prime * result + (int) (instanteBloqueo ^ (instanteBloqueo >>> 32));
        result = prime * result + (int) (instanteUltimoAcceso ^ (instanteUltimoAcceso >>> 32));
        result = prime * result + (int) (instanteUltimoCambioClave ^ (instanteUltimoCambioClave >>> 32));
        result = prime * result + (int) (regeneraClaveInstante ^ (regeneraClaveInstante >>> 32));
        result = prime * result + ((regeneraClaveToken == null) ? 0 : regeneraClaveToken.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && creado == usuario.creado && activo == usuario.activo &&
                accesoNegadoContador == usuario.accesoNegadoContador && instanteBloqueo == usuario.instanteBloqueo &&
                instanteUltimoAcceso == usuario.instanteUltimoAcceso &&
                instanteUltimoCambioClave == usuario.instanteUltimoCambioClave &&
                regeneraClaveInstante == usuario.regeneraClaveInstante && Objects.equals(correo, usuario.correo) &&
                Objects.equals(clave, usuario.clave) && Objects.equals(regeneraClaveToken, usuario.regeneraClaveToken);
    }
}
