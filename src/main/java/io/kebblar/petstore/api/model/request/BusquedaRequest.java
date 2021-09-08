/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      BusquedaRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:00:22
 */
package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Min;

/**
 * Implementacion del POJO de la entidad de 'BusquedaRequest'.
 *
 * @author  Edgar Uribe
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BusquedaRequest {
    private BigDecimal precio;
    private Long idCategoria;
    private List<Integer> atributos;
    @Min(value = 1, message = "{min.paginado}")
    private int numPaginas;
    @Min(value = 1, message = "{min.tamano.paginas}")
    private int tamPaginas;

    /**
     * <p>Getter for the field <code>precio</code>.</p>
     *
     * @return a {@link java.math.BigDecimal} object.
     */
    public BigDecimal getPrecio() {
        return precio;
    }
    /**
     * <p>Setter for the field <code>precio</code>.</p>
     *
     * @param precio a {@link java.math.BigDecimal} object.
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    /**
     * <p>Getter for the field <code>idCategoria</code>.</p>
     *
     * @return a {@link java.lang.Long} object.
     */
    public Long getIdCategoria() {
        return idCategoria;
    }
    /**
     * <p>Setter for the field <code>idCategoria</code>.</p>
     *
     * @param idCategoria a {@link java.lang.Long} object.
     */
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
    /**
     * <p>Getter for the field <code>atributos</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Integer> getAtributos() {
        return atributos;
    }
    /**
     * <p>Setter for the field <code>atributos</code>.</p>
     *
     * @param atributos a {@link java.util.List} object.
     */
    public void setAtributos(List<Integer> atributos) {
        this.atributos = atributos;
    }
    /**
     * <p>Getter for the field <code>numPaginas</code>.</p>
     *
     * @return a int.
     */
    public int getNumPaginas() {
        return numPaginas;
    }
    /**
     * <p>Setter for the field <code>numPaginas</code>.</p>
     *
     * @param numPaginas a int.
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    /**
     * <p>Getter for the field <code>tamPaginas</code>.</p>
     *
     * @return a int.
     */
    public int getTamPaginas() {
        return tamPaginas;
    }
    /**
     * <p>Setter for the field <code>tamPaginas</code>.</p>
     *
     * @param tamPaginas a int.
     */
    public void setTamPaginas(int tamPaginas) {
        this.tamPaginas = tamPaginas;
    }
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((atributos == null) ? 0 : atributos.hashCode());
        result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
        result = prime * result + numPaginas;
        result = prime * result + ((precio == null) ? 0 : precio.hashCode());
        result = prime * result + tamPaginas;
        return result;
    }
    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusquedaRequest)) return false;
        BusquedaRequest that = (BusquedaRequest) o;
        return numPaginas == that.numPaginas && tamPaginas == that.tamPaginas && Objects.equals(precio, that.precio) &&
                Objects.equals(idCategoria, that.idCategoria) && Objects.equals(atributos, that.atributos);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "BusquedaRequest [precio=" + precio + ", idCategoria=" + idCategoria + ", atributos=" + atributos
                + ", numPaginas=" + numPaginas + ", tamPaginas=" + tamPaginas + "]";
    }
    /**
     * <p>Constructor for BusquedaRequest.</p>
     *
     * @param precio a {@link java.math.BigDecimal} object.
     * @param idCategoria a {@link java.lang.Long} object.
     * @param atributos a {@link java.util.List} object.
     * @param numPaginas a int.
     * @param tamPaginas a int.
     */
    public BusquedaRequest(BigDecimal precio, Long idCategoria, List<Integer> atributos,
            @Min(value = 1, message = "{min.paginado}") int numPaginas,
            @Min(value = 1, message = "{min.tamano.paginas}") int tamPaginas) {
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.atributos = atributos;
        this.numPaginas = numPaginas;
        this.tamPaginas = tamPaginas;
    }
    /**
     * <p>Constructor for BusquedaRequest.</p>
     */
    public BusquedaRequest() {
    }

}
