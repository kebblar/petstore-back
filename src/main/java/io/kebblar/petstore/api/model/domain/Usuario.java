package io.kebblar.petstore.api.model.domain;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
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

    public Usuario() {
    }

    public Usuario(int id, String correo, String clave) {
        this.setId(id);
        this.setCorreo(correo);
        this.setClave(clave);
        // Default values
        this.setActivo(true);
        this.setAccesoNegadoContador(0);
        this.setCreado(System.currentTimeMillis());
        this.setInstanteBloqueo(0);
        this.setInstanteUltimoAcceso(0);
        this.setInstanteUltimoCambioClave(0);
        this.setRegeneraClaveInstante(0);
        this.setRegeneraClaveToken("NA");
    }

    public Usuario(int id, String correo, String clave, long creado, boolean activo, int accesoNegadoContador,
            long instanteBloqueo, long instanteUltimoAcceso, long instanteUltimoCambioClave, String regeneraClaveToken,
            long regeneraClaveInstante) {
        super();
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
        return toHexString(calculateSHA256(clave, correo));
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
    public long getHash() {
        return this.hashCode();
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", correo=" + correo + ", clave=" + clave + ", creado=" + creado + ", activo="
                + activo + ", accesoNegadoContador=" + accesoNegadoContador + ", instanteBloqueo=" + instanteBloqueo
                + ", instanteUltimoAcceso=" + instanteUltimoAcceso + ", instanteUltimoCambioClave="
                + instanteUltimoCambioClave + ", regeneraClaveToken=" + regeneraClaveToken + ", regeneraClaveInstante="
                + regeneraClaveInstante + "]";
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (accesoNegadoContador != other.accesoNegadoContador)
            return false;
        if (activo != other.activo)
            return false;
        if (clave == null) {
            if (other.clave != null)
                return false;
        } else if (!clave.equals(other.clave))
            return false;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
            return false;
        if (creado != other.creado)
            return false;
        if (id != other.id)
            return false;
        if (instanteBloqueo != other.instanteBloqueo)
            return false;
        if (instanteUltimoAcceso != other.instanteUltimoAcceso)
            return false;
        if (instanteUltimoCambioClave != other.instanteUltimoCambioClave)
            return false;
        if (regeneraClaveInstante != other.regeneraClaveInstante)
            return false;
        if (regeneraClaveToken == null) {
            if (other.regeneraClaveToken != null)
                return false;
        } else if (!regeneraClaveToken.equals(other.regeneraClaveToken))
            return false;
        return true;
    }

    private byte[] calculateSHA256(String source, String salt) {
        try {
            String input = source + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch(NoSuchAlgorithmException e) {}
        return "String digest error".getBytes();
    }

    private String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
