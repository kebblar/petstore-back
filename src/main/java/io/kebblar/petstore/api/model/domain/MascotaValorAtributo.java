/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MascotaValorAtributo.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_28)
 *
 * Historia:    .
 *              20210518_2028 Creación de éste POJO
 *              20210604_2028 Se  modificar  para  agregar  los 
 *              nuevos campos
 *              202106041315 Se renombra de la clase y se quitan
 *              campos que ya no son necesarios
 *
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
    
    private Integer id;
    private Integer idAnuncio;
    private Integer idValorAtributo;
    
    public MascotaValorAtributo() {
    }

    public MascotaValorAtributo(Integer id) {
        this.id = id;
    }

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
