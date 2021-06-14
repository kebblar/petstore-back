/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   BusquedaRequest.java
 * Tipo:        clase
 * AUTOR:       Edgar Uribe (EU)
 * Fecha:       Sabado 8 de Mayo de 2021 (11_22)
 *
 * Historia:    20210508_1122 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Min;
import io.kebblar.petstore.api.model.domain.MascotaValorAtributo;

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
    
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Long getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
    public List<Integer> getAtributos() {
        return atributos;
    }
    public void setAtributos(List<Integer> atributos) {
        this.atributos = atributos;
    }
    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public int getTamPaginas() {
        return tamPaginas;
    }
    public void setTamPaginas(int tamPaginas) {
        this.tamPaginas = tamPaginas;
    }
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BusquedaRequest other = (BusquedaRequest) obj;
        if (atributos == null) {
            if (other.atributos != null)
                return false;
        } else if (!atributos.equals(other.atributos))
            return false;
        if (idCategoria == null) {
            if (other.idCategoria != null)
                return false;
        } else if (!idCategoria.equals(other.idCategoria))
            return false;
        if (numPaginas != other.numPaginas)
            return false;
        if (precio == null) {
            if (other.precio != null)
                return false;
        } else if (!precio.equals(other.precio))
            return false;
        if (tamPaginas != other.tamPaginas)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "BusquedaRequest [precio=" + precio + ", idCategoria=" + idCategoria + ", atributos=" + atributos
                + ", numPaginas=" + numPaginas + ", tamPaginas=" + tamPaginas + "]";
    }
    public BusquedaRequest(BigDecimal precio, Long idCategoria, List<Integer> atributos,
            @Min(value = 1, message = "{min.paginado}") int numPaginas,
            @Min(value = 1, message = "{min.tamano.paginas}") int tamPaginas) {
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.atributos = atributos;
        this.numPaginas = numPaginas;
        this.tamPaginas = tamPaginas;
    }
    public BusquedaRequest() {
    }

}
