/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioResponse.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_40)
 *
 * Historia:    .
 *              20210518_2040 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

/**
 * POJO asociado a la entidad 'anuncio' para mostrar la información base.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioResponse {

    /*
     * Atributos de clase.
     */
    private int id;
    private String folio;
    private String info;

    /**
     * Constructor por defecto (sin parámetros).
     */
    public AnuncioResponse() {
    }

    /**
     * Constructos basado en los atributos de la clase.
     */
    public AnuncioResponse(int id, String folio) {
        this.id = id;
        this.folio = folio;
    }

    /*
     * Getter y setter.
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((folio == null) ? 0 : folio.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * Método útil en pruebas de regresión.
     * @return Hashcode del objeto
     */
    public long getHash() {
        return this.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AnuncioResponse [id=" + id + ", folio=" + folio + ", info=" + info + "]";
    }

}
