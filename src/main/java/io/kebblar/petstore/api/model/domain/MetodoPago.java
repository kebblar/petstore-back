
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
 * Artefacto:   MetodoPago .java
 * Proyecto:    petstore
 * Tipo:        clase 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de clase 
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'metodo_pago'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class MetodoPago implements Serializable {

    private static final long serialVersionUID = -8185694508799189335L;

    /**
     * Atributos de la clase
     */
    private Integer id;
    private int idUsuario;
    private int tipopago;
    private String numTarjetaCartera;
    private String expiracion;
    private boolean activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public MetodoPago() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public MetodoPago(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public MetodoPago(Integer id, int idUsuario, int tipopago, String numTarjetaCartera, String expiracion, boolean activo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.tipopago = tipopago;
        this.numTarjetaCartera = numTarjetaCartera;
        this.expiracion = expiracion;
        this.activo=activo;
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
     * Getter para id.
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Setter para id.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Getter para idUsuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * Setter para idUsuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * Getter para tipopago.
     */
    public int getTipopago() {
        return tipopago;
    }
    
    /**
     * Setter para tipopago.
     */
    public void setTipopago(int tipopago) {
        this.tipopago = tipopago;
    }
    
    /**
     * Getter para numTarjetaCartera.
     */
    public String getNumTarjetaCartera() {
        return numTarjetaCartera;
    }
    
    /**
     * Setter para numTarjetaCartera.
     */
    public void setNumTarjetaCartera(String numTarjetaCartera) {
        this.numTarjetaCartera = numTarjetaCartera;
    }
    
    /**
     * Getter para expiracion.
     */
    public String getExpiracion() {
        return expiracion;
    }
    
    /**
     * Setter para expiracion.
     */
    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }
    

    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
     */
    @Override
    public String toString() {
        return "[MetodoPago] : ["
                + " id =" + this.id
                + " idUsuario =" + this.idUsuario
                + " tipopago =" + this.tipopago
                + " numTarjetaCartera =" + this.numTarjetaCartera
                + " expiracion =" + this.expiracion
                + " activo =" + this.activo
                + "]";
    }
    
    /**
     * Compara si dos instancias de la clase MetodoPago son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetodoPago)) return false;
        MetodoPago that = (MetodoPago) o;
        return idUsuario == that.idUsuario && tipopago == that.tipopago && activo == that.activo && Objects.equals(id, that.id) && Objects.equals(numTarjetaCartera, that.numTarjetaCartera) && Objects.equals(expiracion, that.expiracion);
    }


    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, tipopago, numTarjetaCartera, expiracion, activo);
    }

}
