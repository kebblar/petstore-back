/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MascotaValorAtributoRequest.java
 * Tipo:        clase
 * AUTOR:       Isabel Contreras (IS)
 * Fecha:       Jueves 6 de Mayo de 2021 (10_40)
 *
 * Historia:    20210506_1040 Creación de éste POJO
 *              20210604_1540 Se renombran las propiedades.
 *
 */
package io.kebblar.petstore.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implementacion del POJO de la entidad de 'ActualizaAnuncioRequest'.
 *
 * @author  Isabel Contreras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class MascotaValorAtributoRequest {

    /*
     * Atributos de la clase.
     */
    private int id;
    @JsonProperty("valor")
    private int idValorAtributo;

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public MascotaValorAtributoRequest(int id, int idValorAtributo) {
        this.id = id;
        this.idValorAtributo = idValorAtributo;
    }

    /**
     * Constructor por defecto.
     */
    public MascotaValorAtributoRequest() {
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

    public int getIdValorAtributo() {
        return idValorAtributo;
    }

    public void setIdValorAtributo(int idValorAtributo) {
        this.idValorAtributo = idValorAtributo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + idValorAtributo;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MascotaValorAtributoRequest)) return false;
        MascotaValorAtributoRequest that = (MascotaValorAtributoRequest) o;
        return id == that.id && idValorAtributo == that.idValorAtributo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "MascotaValorAtributoRequest [id=" + id + ", idValorAtributo=" + idValorAtributo + "]";
    }

}
