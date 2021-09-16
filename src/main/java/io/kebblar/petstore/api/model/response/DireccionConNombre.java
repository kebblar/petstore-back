/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
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
     * Atributos de la clase.
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
     *
     * @param id a int.
     * @param calleNumero a {@link java.lang.String} object.
     * @param colonia a {@link java.lang.String} object.
     * @param cp a {@link java.lang.String} object.
     * @param municipioNombre a {@link java.lang.String} object.
     * @param estadoNombre a {@link java.lang.String} object.
     * @param paisNombre a {@link java.lang.String} object.
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
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para id.
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para calleNumero.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCalleNumero() {
        return calleNumero;
    }

    /**
     * Setter para calleNumero.
     *
     * @param calleNumero a {@link java.lang.String} object.
     */
    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    /**
     * Getter para colonia.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Setter para colonia.
     *
     * @param colonia a {@link java.lang.String} object.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Getter para cp.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCp() {
        return cp;
    }

    /**
     * Setter para cp.
     *
     * @param cp a {@link java.lang.String} object.
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * Getter para municipioNombre.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMunicipioNombre() {
        return municipioNombre;
    }

    /**
     * Setter para municipioNombre.
     *
     * @param municipioNombre a {@link java.lang.String} object.
     */
    public void setMunicipioNombre(String municipioNombre) {
        this.municipioNombre = municipioNombre;
    }

    /**
     * Getter para estadoNombre.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEstadoNombre() {
        return estadoNombre;
    }

    /**
     * Setter para estadoNombre.
     *
     * @param estadoNombre a {@link java.lang.String} object.
     */
    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    /**
     * Getter para paisNombre.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPaisNombre() {
        return paisNombre;
    }

    /**
     * Setter para paisNombre.
     *
     * @param paisNombre a {@link java.lang.String} object.
     */
    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }


    /**
     * {@inheritDoc}
     *
     * <p>Método toString para el pojo, representa al objeto en forma de cadena.</p>
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

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DireccionConNombre)) return false;
        DireccionConNombre that = (DireccionConNombre) o;
        return id == that.id && Objects.equals(calleNumero, that.calleNumero) && Objects.equals(colonia, that.colonia) && Objects.equals(cp, that.cp) && Objects.equals(municipioNombre, that.municipioNombre) && Objects.equals(estadoNombre, that.estadoNombre) && Objects.equals(paisNombre, that.paisNombre);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(id, calleNumero, colonia, cp, municipioNombre, estadoNombre, paisNombre);
    }
}
