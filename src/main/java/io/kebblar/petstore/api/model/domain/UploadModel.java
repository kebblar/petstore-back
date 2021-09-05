/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
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
 */
public class UploadModel {

    /*
     * Atributos de clase.
     */
    private int id;
    private String nombreOriginal;
    private String nuevoNombre;
    private String md5;
    private Date fechaCarga;
    private long peso;
    private boolean activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public UploadModel() {
    }

    /**
     * Constructor basado en parámetros de la clase.
     */
    public UploadModel(int id, String nombreOriginal, String nuevoNombre, String md5, Date fechaCarga, long peso, boolean activo) {
        this.id = id;
        this.nombreOriginal = nombreOriginal;
        this.nuevoNombre = nuevoNombre;
        this.md5 = md5;
        this.fechaCarga = fechaCarga;
        this.peso = peso;
        this.activo = activo;
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
    public String getNombreOriginal() {
        return nombreOriginal;
    }
    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }
    public String getNuevoNombre() {
        return nuevoNombre;
    }
    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }
    public String getMd5() {
        return md5;
    }
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    public Date getFechaCarga() {
        return fechaCarga;
    }
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
    public long getPeso() {
        return peso;
    }
    public void setPeso(long peso) {
        this.peso = peso;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UploadModel [id=" + id + ", nombreOriginal=" + nombreOriginal + ", nuevoNombre=" + nuevoNombre
                + ", md5=" + md5 + ", fechaCarga=" + fechaCarga + ", peso=" + peso + ", activo=" + activo + "]";
    }
}
