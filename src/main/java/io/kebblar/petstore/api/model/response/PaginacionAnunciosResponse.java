/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   PaginacionAnunciosResponse.java
 * Proyecto:    petstore
 * Tipo:        clase
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (21_41)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de clase
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.List;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'PaginacionAnunciosResponse'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class PaginacionAnunciosResponse {

    /*
     * Atributos de la clase
     */
    private int totalAnuncios;
    private List<BusquedaAdministracionResponse> listaAnuncios;

    /**
     * Constructor basado en todos los atributos de la clase.
     */
    public PaginacionAnunciosResponse(int totalAnuncios, List<BusquedaAdministracionResponse> listaAnuncios) {
        this.totalAnuncios = totalAnuncios;
        this.listaAnuncios = listaAnuncios;
    }

    /*
     * Setter y getter.
     */
    public int getTotalAnuncios() {
        return totalAnuncios;
    }

    public void setTotalAnuncios(int totalAnuncios) {
        this.totalAnuncios = totalAnuncios;
    }

    public List<BusquedaAdministracionResponse> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(List<BusquedaAdministracionResponse> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "PaginacionAnunciosResponse [totalAnuncios=" + totalAnuncios + ", listaAnuncios=" + listaAnuncios + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listaAnuncios == null) ? 0 : listaAnuncios.hashCode());
        result = prime * result + totalAnuncios;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaginacionAnunciosResponse)) return false;
        PaginacionAnunciosResponse that = (PaginacionAnunciosResponse) o;
        return totalAnuncios == that.totalAnuncios && Objects.equals(listaAnuncios, that.listaAnuncios);
    }
}
