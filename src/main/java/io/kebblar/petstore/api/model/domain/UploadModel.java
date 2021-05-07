/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Usuario.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (09_10)
 *
 * Historia:    .
 *              20210504_0910 Creación
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Date;

/**
 * Implementacion del POJO de la entidad de 'UploadModel'.
 * 
 * <p>Clase que modela la estructura de datos que será empleada para registrar una carga de un archivo
 * al sistema. La variable md5 representa el digest MD5 asociado a los bytes del archivo cargado.
 * 
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class UploadModel {
    private int id;
    private String nombreOriginal;
    private String nuevoNombre;
    private String md5;
    private Date fechaCarga;
    private long peso;
    private boolean activo;

    public UploadModel() {
    }

    public UploadModel(int id,
            String nombreOriginal,
            String nuevoNombre,
            String md5,
            Date fechaCarga,
            long peso,
            boolean activo) {
        this.id = id;
        this.nombreOriginal = nombreOriginal;
        this.nuevoNombre = nuevoNombre;
        this.md5 = md5;
        this.fechaCarga = fechaCarga;
        this.peso = peso;
        this.activo = activo;
    }
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
    @Override
    public String toString() {
        return "UploadModel [id=" + id + ", nombreOriginal=" + nombreOriginal + ", nuevoNombre=" + nuevoNombre
                + ", md5=" + md5 + ", fechaCarga=" + fechaCarga + ", peso=" + peso + ", activo=" + activo + "]";
    }
}
