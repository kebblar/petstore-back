/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.model
 * Modulo:      Direccion
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'direccion'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'direccion'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
public class Direccion implements Serializable {

    private static final long serialVersionUID = 147836237927646425L;

    private Integer id;
    private String calleNumero;
    private String colonia;
    private int idPais;
    private int idEstado;
    private int idMunicipio;
    private int idTipoDireccion;
    private String cp;
    private String referencias;

    /**
     * Constructor por default.
     */
    public Direccion() {
    }

    /**
     * Constructor basado en llaves.
     */
    public Direccion(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en atributos.
     */
    public Direccion(Integer id, String calleNumero, String colonia, int idPais, int idEstado, int idMunicipio, int idTipoDireccion, String cp, String referencias) {
        this.id = id;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
        this.idTipoDireccion = idTipoDireccion;
        this.cp = cp;
        this.referencias = referencias;
    }

    /**
     * Getter para id.
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Setter para id.
     */
    public void setId(Integer id) {
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
     * Getter para idPais.
     */
    public int getIdPais() {
        return idPais;
    }
    
    /**
     * Setter para idPais.
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    
    /**
     * Getter para idEstado.
     */
    public int getIdEstado() {
        return idEstado;
    }
    
    /**
     * Setter para idEstado.
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    /**
     * Getter para idMunicipio.
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }
    
    /**
     * Setter para idMunicipio.
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    
    /**
     * Getter para idTipoDireccion.
     */
    public int getIdTipoDireccion() {
        return idTipoDireccion;
    }
    
    /**
     * Setter para idTipoDireccion.
     */
    public void setIdTipoDireccion(int idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
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
     * Getter para referencias.
     */
    public String getReferencias() {
        return referencias;
    }
    
    /**
     * Setter para referencias.
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
    
    @Override
    public String toString() {
        return "[Direccion] : ["
                + " id =" + this.id
                + " calleNumero =" + this.calleNumero
                + " colonia =" + this.colonia
                + " idPais =" + this.idPais
                + " idEstado =" + this.idEstado
                + " idMunicipio =" + this.idMunicipio
                + " idTipoDireccion =" + this.idTipoDireccion
                + " cp =" + this.cp
                + " referencias =" + this.referencias
                + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) obj;
        return
               id == other.id && 
               calleNumero == other.calleNumero && 
               colonia == other.colonia && 
               idPais == other.idPais && 
               idEstado == other.idEstado && 
               idMunicipio == other.idMunicipio && 
               idTipoDireccion == other.idTipoDireccion && 
               cp == other.cp && 
               referencias == other.referencias; 
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            calleNumero, 
            colonia, 
            idPais, 
            idEstado, 
            idMunicipio, 
            idTipoDireccion, 
            cp, 
            referencias
        );
    }

}
