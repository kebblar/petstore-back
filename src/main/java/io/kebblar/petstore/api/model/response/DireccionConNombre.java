
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

    private String destinatario;

    /**
     * Constructor por default (sin parámetros).
     */
    public DireccionConNombre() {
    }


    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public DireccionConNombre(int id, String calleNumero, String colonia, String cp, String municipioNombre, String estadoNombre, String paisNombre, String destinatario) {
        this.id = id;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.cp = cp;
        this.municipioNombre = municipioNombre;
        this.estadoNombre = estadoNombre;
        this.paisNombre = paisNombre;
        this.destinatario = destinatario;
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
     * Getter para destinatario.
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * Setter para destinatario.
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
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
                ", destinatario='" + destinatario + '\'' +
                '}';
    }

    /**
     * Compara si dos instancias de la clase DireccionConNombre son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DireccionConNombre)) return false;
        DireccionConNombre that = (DireccionConNombre) o;
        return id == that.id && Objects.equals(calleNumero, that.calleNumero) && Objects.equals(colonia, that.colonia) && Objects.equals(cp, that.cp) && Objects.equals(municipioNombre, that.municipioNombre) && Objects.equals(estadoNombre, that.estadoNombre) && Objects.equals(paisNombre, that.paisNombre) && Objects.equals(destinatario, that.destinatario);
    }

    /**
     * Genera un hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, calleNumero, colonia, cp, municipioNombre, estadoNombre, paisNombre, destinatario);
    }

}
