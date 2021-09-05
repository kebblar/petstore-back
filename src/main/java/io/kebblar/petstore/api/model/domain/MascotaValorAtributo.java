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
 * Nombre:      MascotaValorAtributo
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:49:48
 */
package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;

/**
 * POJO asociado a la entidad 'mascota_valor_atributo'.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MascotaValorAtributo implements Serializable {

    private static final long serialVersionUID = 8636526037194157358L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private Integer idAnuncio;
    private Integer idValorAtributo;

    /**
     * Constructor por default (sin parámetros).
     */
    public MascotaValorAtributo() {
    }

    /**
     * Constructor basado en el id del objeto.
     */
    public MascotaValorAtributo(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en los atributos de la clase.
     */
    public MascotaValorAtributo(Integer id, Integer idAnuncio, Integer idValorAtributo) {
        this.id = id;
        this.idAnuncio = idAnuncio;
        this.idValorAtributo = idValorAtributo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public Integer getIdValorAtributo() {
        return idValorAtributo;
    }

    public void setIdValorAtributo(Integer idValorAtributo) {
        this.idValorAtributo = idValorAtributo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((idAnuncio == null) ? 0 : idAnuncio.hashCode());
        result = prime * result + ((idValorAtributo == null) ? 0 : idValorAtributo.hashCode());
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
        MascotaValorAtributo other = (MascotaValorAtributo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (idAnuncio == null) {
            if (other.idAnuncio != null)
                return false;
        } else if (!idAnuncio.equals(other.idAnuncio))
            return false;
        if (idValorAtributo == null) {
            if (other.idValorAtributo != null)
                return false;
        } else if (!idValorAtributo.equals(other.idValorAtributo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MascotaValorAtributo [id=" + id + ", idAnuncio=" + idAnuncio + ", idValorAtributo=" + idValorAtributo + "]";
    }

}
