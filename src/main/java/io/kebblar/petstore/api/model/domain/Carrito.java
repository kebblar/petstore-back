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
 * Nombre:      Carrito
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:13:41
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'carrito'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class Carrito implements Serializable {

    private static final long serialVersionUID = 7302776955762312368L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private int idUsuario;
    private int idAnuncio;
    private String cveOrdenCompra;

    /**
     * Constructor por default (sin parámetros).
     */
    public Carrito() {
    }

    /**
     * Constructor basado en la llave primaria.
     */
    public Carrito(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public Carrito(Integer id, int idUsuario, int idAnuncio, String cveOrdenCompra) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idAnuncio = idAnuncio;
        this.cveOrdenCompra = cveOrdenCompra;
    }

    /*
     * Getter y setter.
     */
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

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getCveOrdenCompra() {
        return cveOrdenCompra;
    }

    public void setCveOrdenCompra(String cveOrdenCompra) {
        this.cveOrdenCompra = cveOrdenCompra;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[Carrito] : ["
                + " id =" + this.id
                + " idUsuario =" + this.idUsuario
                + " idAnuncio =" + this.idAnuncio
                + " idOrdenCompra =" + this.cveOrdenCompra
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
        if (!(obj instanceof Carrito)) {
            return false;
        }
        Carrito other = (Carrito) obj;
        return
               id == other.id &&
               idUsuario == other.idUsuario &&
               idAnuncio == other.idAnuncio &&
               cveOrdenCompra == other.cveOrdenCompra;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idUsuario,
            idAnuncio,
                cveOrdenCompra
        );
    }

}
