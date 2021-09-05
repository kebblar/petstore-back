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
 * Nombre:      AnuncioResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:02:15
 */
package io.kebblar.petstore.api.model.response;

/**
 * POJO asociado a la entidad 'anuncio' para mostrar la informacion base.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioResponse {
    private int id;
    private String folio;
    private String info;

    public AnuncioResponse() {
    }

    public AnuncioResponse(int id, String folio) {
        this.id = id;
        this.folio = folio;
    }

    public AnuncioResponse(int id, String folio, String info) {
        this.id = id;
        this.folio = folio;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((folio == null) ? 0 : folio.hashCode());
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
        AnuncioResponse other = (AnuncioResponse) obj;
        if (id != other.id)
            return false;
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        if (folio == null) {
            if (other.folio != null)
                return false;
        } else if (!folio.equals(other.folio))
            return false;
        return true;
    }

    public long getHash() {
        return this.hashCode();
    }

    @Override
    public String toString() {
        return "AnuncioResponse [id=" + id + ", folio=" + folio + ", info=" + info + "]";
    }

}
