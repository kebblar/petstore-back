/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioImagenResponse.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_35)
 *
 * Historia:    .
 *              20210518_2035 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.Objects;

/**
 * POJO asociado a la entidad 'anuncio_imagen' para mostrar el detalle de la imagen.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioImagenResponse {

    /*
     * Atributos de clase.
     */
    private Integer idImagen;
    private Integer idAnuncio;
    private String uuid;
    private Integer idTipo;
    private Boolean principal;

    /**
     * Constructor por defecto (sin parámetros).
     */
    public AnuncioImagenResponse() {
    }

    /**
     * Constructos basado en los atributos de la clase.
     */
    public AnuncioImagenResponse(Integer idImagen, Integer idAnuncio, String uuid, Integer idTipo, Boolean principal) {
        this.idImagen = idImagen;
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
        this.idTipo = idTipo;
        this.principal = principal;
    }

    /*
     * Setter y getter.
     */
    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAnuncio == null) ? 0 : idAnuncio.hashCode());
        result = prime * result + ((idImagen == null) ? 0 : idImagen.hashCode());
        result = prime * result + ((idTipo == null) ? 0 : idTipo.hashCode());
        result = prime * result + ((principal == null) ? 0 : principal.hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioImagenResponse)) return false;
        AnuncioImagenResponse that = (AnuncioImagenResponse) o;
        return Objects.equals(idImagen, that.idImagen) && Objects.equals(idAnuncio, that.idAnuncio) &&
                Objects.equals(uuid, that.uuid) && Objects.equals(idTipo, that.idTipo) &&
                Objects.equals(principal, that.principal);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AnuncioImagenResponse [idImagen=" + idImagen + ", idAnuncio=" + idAnuncio + ", uuid=" + uuid
                + ", idTipo=" + idTipo + ", principal=" + principal + "]";
    }

}
