/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      DireccionConNombre
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:20:45
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

    /**
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

    /**
     * Getter para id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para calleNumero.
     */
    public String getCalleNumero() {
        return calleNumero;
    }

    /**
     * Setter para calleNumero.
     */
    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    /**
     * Getter para colonia.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Setter para colonia.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Getter para cp.
     */
    public String getCp() {
        return cp;
    }

    /**
     * Setter para cp.
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * Getter para municipioNombre.
     */
    public String getMunicipioNombre() {
        return municipioNombre;
    }

    /**
     * Setter para municipioNombre.
     */
    public void setMunicipioNombre(String municipioNombre) {
        this.municipioNombre = municipioNombre;
    }

    /**
     * Getter para estadoNombre.
     */
    public String getEstadoNombre() {
        return estadoNombre;
    }

    /**
     * Setter para estadoNombre.
     */
    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    /**
     * Getter para paisNombre.
     */
    public String getPaisNombre() {
        return paisNombre;
    }

    /**
     * Setter para paisNombre.
     */
    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }


    /**
     * Método toString para el pojo, representa al objeto en forma de cadena
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DireccionConNombre)) return false;
        DireccionConNombre that = (DireccionConNombre) o;
        return id == that.id && Objects.equals(calleNumero, that.calleNumero) && Objects.equals(colonia, that.colonia) && Objects.equals(cp, that.cp) && Objects.equals(municipioNombre, that.municipioNombre) && Objects.equals(estadoNombre, that.estadoNombre) && Objects.equals(paisNombre, that.paisNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calleNumero, colonia, cp, municipioNombre, estadoNombre, paisNombre);
    }
}
