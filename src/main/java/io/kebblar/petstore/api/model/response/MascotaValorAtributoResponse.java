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
 * Artefacto:   MascotaValorAtributoResponse.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       Wednesday 05 de May de 2021 (08_24)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210512_0824 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.response;

import io.kebblar.petstore.api.model.request.MascotaValorAtributoRequest;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'MascotaValorAtributoRequest'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MascotaValorAtributoResponse extends MascotaValorAtributoRequest {

    /*
     * Atributos de la clase.
     */
    private String rango;
    private int idAtributo;
    private String nombreAtributo;

    /**
     * Constructor por defecto.
     */
    public MascotaValorAtributoResponse() {
    }

    /**
     * Constructor basado en el id y el valor del atributo.
     */
    public MascotaValorAtributoResponse(int id, int idValorAtributo) {
        super(id, idValorAtributo);
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public MascotaValorAtributoResponse(int id, int idValorAtributo, String rango, int idAtributo, String nombreAtributo) {
        super(id, idValorAtributo);
        this.rango = rango;
        this.idAtributo = idAtributo;
        this.nombreAtributo = nombreAtributo;
    }

    /*
     * Setter y getter
     */
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + idAtributo;
        result = prime * result + ((nombreAtributo == null) ? 0 : nombreAtributo.hashCode());
        result = prime * result + ((rango == null) ? 0 : rango.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        MascotaValorAtributoResponse other = (MascotaValorAtributoResponse) obj;
        if (idAtributo != other.idAtributo)
            return false;
        if (nombreAtributo == null) {
            if (other.nombreAtributo != null)
                return false;
        } else if (!nombreAtributo.equals(other.nombreAtributo))
            return false;
        if (rango == null) {
            if (other.rango != null)
                return false;
        } else if (!rango.equals(other.rango))
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "MascotaValorAtributoResponse [rango=" + rango + ", idAtributo=" + idAtributo + ", nombreAtributo=" + nombreAtributo + "]";
    }

}
