/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioImagenRequest.java
 * Tipo:        clase
 * AUTOR:       Isabel Contreras (IC)
 * Fecha:       Miercoles 9 de Junio de 2021 (20_05)
 *
 * Historia:    20210609_2005 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.request;

import java.util.Objects;

/**
 * Implementación del POJO de la entidad de 'AnuncioImagenRequest'.
 *
 * @author  Isabel Contreras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class AnuncioImagenRequest {

    /*
     * Atributos de la clase.
     */
    private int idAnuncio;
    private String uuid;

    /**
     * Constructor por defecto.
     */
    public AnuncioImagenRequest() {
    }

    /**
     * Constructor basado en todos los atributos de la clase con id único.
     */
    public AnuncioImagenRequest(int idAnuncio, String uuid) {
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
    }

    /*
     * Setter y Getter.
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idAnuncio;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioImagenRequest)) return false;
        AnuncioImagenRequest that = (AnuncioImagenRequest) o;
        return idAnuncio == that.idAnuncio && Objects.equals(uuid, that.uuid);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AnuncioImagenRequest [idAnuncio=" + idAnuncio + ", uuid=" + uuid + "]";
    }

}
