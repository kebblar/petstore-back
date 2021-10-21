/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      ProcesaMascotaResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:21:41
 */
package io.kebblar.petstore.api.model.response;

import java.util.Objects;
/**
 * <p>Descripción:</p>
 * Apoya a recupoerar almacenar la informacion de on objeto media.
 *
 * @author fher
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class InformacionMedia {
    /*
     * Atributos de la clase.
     */
    private String nombre;
    private String uuid;
    private Integer idTipo;

    /**
     * Constructor sin parametros.
     */
    public InformacionMedia() {}

    /**
     * Constructor con parametros.
     * @param uuid identificador de la imagen.
     * @param nuevoNombre nombre que se le dara a la imagen en el sistema.
     * @param tipoMedia tipo de archivo.
     */
    public InformacionMedia(String uuid, String nuevoNombre, int tipoMedia) {
        this.nombre=nuevoNombre;
        this.uuid=uuid;
        this.idTipo=tipoMedia;
    }

    /**
     * Getter para <code>nombre</code>.
     * @return objeto {@link String}.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para nombre.
     * @param nombre nombre de la imagen.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para <code>uuid</code>.
     * @return objeto {@link String}.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Setter para uuid.
     * @param uuid identificador de la imagen.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter para <code>idTipo</code>.
     * @return objeto {@link Integer}.
     */
    public Integer getIdTipo() {
        return idTipo;
    }

    /**
     * Setter para idTipo.
     * @param idTipo tipo de la imagen.
     */
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformacionMedia)) return false;
        InformacionMedia that = (InformacionMedia) o;
        return nombre.equals(that.nombre) && uuid.equals(that.uuid) && idTipo.equals(that.idTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, uuid, idTipo);
    }

    @Override
    public String toString() {
        return "InformacionMedia{" +
                "nombre='" + nombre + '\'' +
                ", uuid='" + uuid + '\'' +
                ", idTipo=" + idTipo +
                '}';
    }
}
