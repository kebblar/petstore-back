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
 * Artefacto:   Carrito .java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 06 de June de 2021 (13_15)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210608_1315 Implementación de clase
 *
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
