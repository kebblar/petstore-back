/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AnuncioImagenResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:02:08
 */
package io.kebblar.petstore.api.model.response;

/**
 * POJO asociado a la entidad 'anuncio_imagen' para mostrar el detalle de la imagen.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioImagenResponse {
    private Integer idImagen;
    private Integer idAnuncio;
    private String uuid;
    private Integer idTipo;
    private Boolean principal;

    public AnuncioImagenResponse() {
    }

    public AnuncioImagenResponse(Integer idImagen, Integer idAnuncio, String uuid, Integer idTipo, Boolean principal) {
        this.idImagen = idImagen;
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
        this.idTipo = idTipo;
        this.principal = principal;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AnuncioImagenResponse other = (AnuncioImagenResponse) obj;
        if (idAnuncio == null) {
            if (other.idAnuncio != null)
                return false;
        } else if (!idAnuncio.equals(other.idAnuncio))
            return false;
        if (idImagen == null) {
            if (other.idImagen != null)
                return false;
        } else if (!idImagen.equals(other.idImagen))
            return false;
        if (idTipo == null) {
            if (other.idTipo != null)
                return false;
        } else if (!idTipo.equals(other.idTipo))
            return false;
        if (principal == null) {
            if (other.principal != null)
                return false;
        } else if (!principal.equals(other.principal))
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AnuncioImagenResponse [idImagen=" + idImagen + ", idAnuncio=" + idAnuncio + ", uuid=" + uuid
                + ", idTipo=" + idTipo + ", principal=" + principal + "]";
    }

}
