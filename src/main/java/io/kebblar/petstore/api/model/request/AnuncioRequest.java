/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AnuncioRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:00:01
 */
package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Implementacion del POJO de la entidad de 'AnuncioRequest'.
 *
 * @author  Edgar Uribe
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class AnuncioRequest {

    @NotBlank(message = "{notblank.anuncio.titulo}")
    @NotNull(message = "{notnull.anuncio.titulo}")
    private String titulo = "";
    @NotBlank(message = "{notblank.anuncio.descripcion}")
    @NotNull(message = "{notnull.anuncio.descripcion}")
    private String descripcion = "";
    private LocalDate fechaInicioVigencia;
    private LocalDate fechaFinVigencia;
    @Min(value = 1, message = "{min.anuncio.idcategoria}")
    private int idCategoria;
    @NotNull(message = "{notnull.anuncio.precio}")
    private BigDecimal precio = new BigDecimal(0);
    private List <MascotaValorAtributoRequest> mascotaValorAtributo;

    public AnuncioRequest() {
    }

    public AnuncioRequest(String titulo, String descripcion, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia,
            int idCategoria, BigDecimal precio, List<MascotaValorAtributoRequest> mascotaValorAtributo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.idCategoria = idCategoria;
        this.precio = precio;
        this.mascotaValorAtributo = mascotaValorAtributo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public LocalDate getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<MascotaValorAtributoRequest> getMascotaValorAtributo() {
        return mascotaValorAtributo;
    }

    public void setMascotaValorAtributo(List<MascotaValorAtributoRequest> mascotaValorAtributo) {
        this.mascotaValorAtributo = mascotaValorAtributo;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((fechaFinVigencia == null) ? 0 : fechaFinVigencia.hashCode());
        result = prime * result + ((fechaInicioVigencia == null) ? 0 : fechaInicioVigencia.hashCode());
        result = prime * result + idCategoria;
        result = prime * result + ((mascotaValorAtributo == null) ? 0 : mascotaValorAtributo.hashCode());
        result = prime * result + ((precio == null) ? 0 : precio.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
        AnuncioRequest other = (AnuncioRequest) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (fechaFinVigencia == null) {
            if (other.fechaFinVigencia != null)
                return false;
        } else if (!fechaFinVigencia.equals(other.fechaFinVigencia))
            return false;
        if (fechaInicioVigencia == null) {
            if (other.fechaInicioVigencia != null)
                return false;
        } else if (!fechaInicioVigencia.equals(other.fechaInicioVigencia))
            return false;
        if (idCategoria != other.idCategoria)
            return false;
        if (mascotaValorAtributo == null) {
            if (other.mascotaValorAtributo != null)
                return false;
        } else if (!mascotaValorAtributo.equals(other.mascotaValorAtributo))
            return false;
        if (precio == null) {
            if (other.precio != null)
                return false;
        } else if (!precio.equals(other.precio))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AnuncioRequest [titulo=" + titulo + ", descripcion=" + descripcion + ", fechaInicioVigencia="
                + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia + ", idCategoria=" + idCategoria
                + ", precio=" + precio + ", mascotaValorAtributo=" + mascotaValorAtributo + "]";
    }

}
