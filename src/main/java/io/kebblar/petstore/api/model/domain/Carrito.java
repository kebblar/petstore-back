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
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public Carrito(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idUsuario a int.
     * @param idAnuncio a int.
     * @param cveOrdenCompra a {@link java.lang.String} object.
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
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>idUsuario</code>.</p>
     *
     * @return a int.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * <p>Setter for the field <code>idUsuario</code>.</p>
     *
     * @param idUsuario a int.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * <p>Getter for the field <code>idAnuncio</code>.</p>
     *
     * @return a int.
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * <p>Setter for the field <code>idAnuncio</code>.</p>
     *
     * @param idAnuncio a int.
     */
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * <p>Getter for the field <code>cveOrdenCompra</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCveOrdenCompra() {
        return cveOrdenCompra;
    }

    /**
     * <p>Setter for the field <code>cveOrdenCompra</code>.</p>
     *
     * @param cveOrdenCompra a {@link java.lang.String} object.
     */
    public void setCveOrdenCompra(String cveOrdenCompra) {
        this.cveOrdenCompra = cveOrdenCompra;
    }


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[Carrito] : ["
                + " id =" + this.id
                + " idUsuario =" + this.idUsuario
                + " idAnuncio =" + this.idAnuncio
                + " idOrdenCompra =" + this.cveOrdenCompra
                + "]";
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
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
