/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      UploadModel
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:03
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Date;

/**
 * Clase que modela la estructura de datos que será empleada para registrar una carga de un archivo
 * al sistema. La variable md5 representa el digest MD5 asociado a los bytes del archivo cargado.
 *
 * @author garellano
 * @version $Id: $Id
 */
public class UploadModel {

    /*
     * Atributos de clase.
     */
    private int id;
    private int idAnuncio;
    private String nombreOriginal;
    private String nuevoNombre;
    private String md5;
    private String mimeType;
    private int idTipo;
    private Date fechaCarga;
    private long peso;
    private boolean principal;

    /**
     * Constructor por default (sin parámetros).
     */
    public UploadModel() {
    }

    /**
     * Constructor basado en parámetros de la clase.
     *
     * @param id a int.
     * @param nombreOriginal a {@link java.lang.String} object.
     * @param nuevoNombre a {@link java.lang.String} object.
     * @param md5 a {@link java.lang.String} object.
     * @param fechaCarga a {@link java.util.Date} object.
     * @param peso a long.
     * @param activo a boolean.
     */
    public UploadModel(
            int id, 
            int idAnuncio,
            String nombreOriginal, 
            String nuevoNombre, 
            String md5, 
            String mimeType, 
            int idTipo,
            Date fechaCarga, 
            long peso, 
            boolean principal) {
        this.id = id;
        this.idAnuncio = idAnuncio;
        this.nombreOriginal = nombreOriginal;
        this.nuevoNombre = nuevoNombre;
        this.idTipo = idTipo;
        this.principal = principal;
        this.md5 = md5;
        this.peso = peso;

        this.mimeType = mimeType;
        this.fechaCarga = fechaCarga;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }
    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdAnuncio() {
        return idAnuncio;
    }
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }    
    
    /**
     * <p>Getter for the field <code>nombreOriginal</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombreOriginal() {
        return nombreOriginal;
    }
    /**
     * <p>Setter for the field <code>nombreOriginal</code>.</p>
     *
     * @param nombreOriginal a {@link java.lang.String} object.
     */
    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }
    /**
     * <p>Getter for the field <code>nuevoNombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNuevoNombre() {
        return nuevoNombre;
    }
    /**
     * <p>Setter for the field <code>nuevoNombre</code>.</p>
     *
     * @param nuevoNombre a {@link java.lang.String} object.
     */
    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }
    /**
     * <p>Getter for the field <code>md5</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMd5() {
        return md5;
    }
    /**
     * <p>Setter for the field <code>md5</code>.</p>
     *
     * @param md5 a {@link java.lang.String} object.
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    /**
     * <p>Getter for the field <code>fechaCarga</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaCarga() {
        return fechaCarga;
    }
    /**
     * <p>Setter for the field <code>fechaCarga</code>.</p>
     *
     * @param fechaCarga a {@link java.util.Date} object.
     */
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
    /**
     * <p>Getter for the field <code>peso</code>.</p>
     *
     * @return a long.
     */
    public long getPeso() {
        return peso;
    }
    /**
     * <p>Setter for the field <code>peso</code>.</p>
     *
     * @param peso a long.
     */
    public void setPeso(long peso) {
        this.peso = peso;
    }
    /**
     * <p>isActivo.</p>
     *
     * @return a boolean.
     */
    public boolean isPrincipal() {
        return principal;
    }
    /**
     * <p>Setter for the field <code>activo</code>.</p>
     *
     * @param activo a boolean.
     */
    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    
    public String getMimeType() {
        return this.mimeType;
    }
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    
    public int getIdTipo() {
        return idTipo;
    }
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "UploadModel [id=" + id + 
                ", idAnuncio=" + idAnuncio + 
                ", nombreOriginal=" + nombreOriginal + 
                ", nuevoNombre=" + nuevoNombre + 
                ", md5=" + md5 + 
                ", mimeType=" + mimeType +
                ", idTipo=" + idTipo +
                ", fechaCarga=" + fechaCarga + 
                ", peso=" + peso + 
                ", principal=" + principal + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (principal ? 1231 : 1237);
        result = prime * result + ((fechaCarga == null) ? 0 : fechaCarga.hashCode());
        result = prime * result + id;
        result = prime * result + idTipo;
        result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
        result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
        result = prime * result + ((nombreOriginal == null) ? 0 : nombreOriginal.hashCode());
        result = prime * result + ((nuevoNombre == null) ? 0 : nuevoNombre.hashCode());
        result = prime * result + (int) (peso ^ (peso >>> 32));
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
        UploadModel other = (UploadModel) obj;
        if (principal != other.principal)
            return false;
        if (fechaCarga == null) {
            if (other.fechaCarga != null)
                return false;
        } else if (!fechaCarga.equals(other.fechaCarga))
            return false;
        if (id != other.id)
            return false;
        if (idTipo != other.idTipo)
            return false;
        if (md5 == null) {
            if (other.md5 != null)
                return false;
        } else if (!md5.equals(other.md5))
            return false;
        if (mimeType == null) {
            if (other.mimeType != null)
                return false;
        } else if (!mimeType.equals(other.mimeType))
            return false;
        if (nombreOriginal == null) {
            if (other.nombreOriginal != null)
                return false;
        } else if (!nombreOriginal.equals(other.nombreOriginal))
            return false;
        if (nuevoNombre == null) {
            if (other.nuevoNombre != null)
                return false;
        } else if (!nuevoNombre.equals(other.nuevoNombre))
            return false;
        if (peso != other.peso)
            return false;
        return true;
    }

    public int getHash() {
        return this.hashCode();
    }

}
