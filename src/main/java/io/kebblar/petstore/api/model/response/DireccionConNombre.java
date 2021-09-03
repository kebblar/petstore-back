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
 * Artefacto:   DireccionConNombre .java
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

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'direccion_con_nombre'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public class DireccionConNombre implements Serializable {

    private static final long serialVersionUID = 6990145017462317631L;

    /*
     * Atributos de la clase
     */
    private int id;
    private String calleNumero;
    private String colonia;
    private String cp;
    private String municipioNombre;
    private String estadoNombre;
    private String paisNombre;

    /**
     * Constructor por default (sin parámetros).
     */
    public DireccionConNombre() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public DireccionConNombre(int id, String calleNumero, String colonia, String cp, String municipioNombre, String estadoNombre, String paisNombre) {
        this.id = id;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.cp = cp;
        this.municipioNombre = municipioNombre;
        this.estadoNombre = estadoNombre;
        this.paisNombre = paisNombre;
    }

    /*
     * Getter y setter.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getMunicipioNombre() {
        return municipioNombre;
    }

    public void setMunicipioNombre(String municipioNombre) {
        this.municipioNombre = municipioNombre;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "DireccionConNombre{" +
                "id=" + id +
                ", calleNumero='" + calleNumero + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp='" + cp + '\'' +
                ", municipioNombre='" + municipioNombre + '\'' +
                ", estadoNombre='" + estadoNombre + '\'' +
                ", paisNombre='" + paisNombre + '\'' +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DireccionConNombre)) return false;
        DireccionConNombre that = (DireccionConNombre) o;
        return id == that.id && Objects.equals(calleNumero, that.calleNumero) && Objects.equals(colonia, that.colonia) && Objects.equals(cp, that.cp) && Objects.equals(municipioNombre, that.municipioNombre) && Objects.equals(estadoNombre, that.estadoNombre) && Objects.equals(paisNombre, that.paisNombre);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, calleNumero, colonia, cp, municipioNombre, estadoNombre, paisNombre);
    }
}
