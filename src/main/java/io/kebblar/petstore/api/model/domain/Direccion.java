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
    private boolean activo;
    
    public Direccion() {
    }
    public Direccion(Integer id, String calleNumero, String colonia, int idPais, int idEstado, int idMunicipio,
            int idTipoDireccion, String cp, String referencias, boolean activo) {
        this.id = id;
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
        this.idTipoDireccion = idTipoDireccion;
        this.cp = cp;
        this.referencias = referencias;
        this.activo = activo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public int getIdPais() {
        return idPais;
    }
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public int getIdMunicipio() {
        return idMunicipio;
    }
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    public int getIdTipoDireccion() {
        return idTipoDireccion;
    }
    public void setIdTipoDireccion(int idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getReferencias() {
        return referencias;
    }
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    @Override
    public String toString() {
        return "Direccion [id=" + id + ", calleNumero=" + calleNumero + ", colonia=" + colonia + ", idPais=" + idPais
                + ", idEstado=" + idEstado + ", idMunicipio=" + idMunicipio + ", idTipoDireccion=" + idTipoDireccion
                + ", cp=" + cp + ", referencias=" + referencias + ", activo=" + activo + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + ((calleNumero == null) ? 0 : calleNumero.hashCode());
        result = prime * result + ((colonia == null) ? 0 : colonia.hashCode());
        result = prime * result + ((cp == null) ? 0 : cp.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + idEstado;
        result = prime * result + idMunicipio;
        result = prime * result + idPais;
        result = prime * result + idTipoDireccion;
        result = prime * result + ((referencias == null) ? 0 : referencias.hashCode());
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
        Direccion other = (Direccion) obj;
        if (activo != other.activo)
            return false;
        if (calleNumero == null) {
            if (other.calleNumero != null)
                return false;
        } else if (!calleNumero.equals(other.calleNumero))
            return false;
        if (colonia == null) {
            if (other.colonia != null)
                return false;
        } else if (!colonia.equals(other.colonia))
            return false;
        if (cp == null) {
            if (other.cp != null)
                return false;
        } else if (!cp.equals(other.cp))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (idEstado != other.idEstado)
            return false;
        if (idMunicipio != other.idMunicipio)
            return false;
        if (idPais != other.idPais)
            return false;
        if (idTipoDireccion != other.idTipoDireccion)
            return false;
        if (referencias == null) {
            if (other.referencias != null)
                return false;
        } else if (!referencias.equals(other.referencias))
            return false;
        return true;
    }

}
