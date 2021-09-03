/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.api.model
 * Modulo:      cinepolis
 * Tipo:        clase
 * Autor:       Gustavo Adolfo Arellano Sandoval
 * Fecha:       24 de marzo del 2020
 * Version:     1.0-SNAPSHOT
 * .
 * Clase que contendr&aacute; las excepciones derivadas de errores de negocio como por ejemplo no existen salas disponibles para realizar la reservaci&oactute;n
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
