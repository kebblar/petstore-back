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
 * Nombre:      MetodoPago
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:50:10
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

    /*
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

    /*
     * Getter y Setter.
     */
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTipopago() {
        return tipopago;
    }

    public void setTipopago(int tipopago) {
        this.tipopago = tipopago;
    }

    public String getNumTarjetaCartera() {
        return numTarjetaCartera;
    }

    public void setNumTarjetaCartera(String numTarjetaCartera) {
        this.numTarjetaCartera = numTarjetaCartera;
    }

    public String getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }


    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetodoPago)) return false;
        MetodoPago that = (MetodoPago) o;
        return idUsuario == that.idUsuario && tipopago == that.tipopago && activo == that.activo && Objects.equals(id, that.id) && Objects.equals(numTarjetaCartera, that.numTarjetaCartera) && Objects.equals(expiracion, that.expiracion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, tipopago, numTarjetaCartera, expiracion, activo);
    }

}
