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
import java.util.Objects;

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

    /**
     * <p>Constructor for AnuncioRequest.</p>
     */
    public AnuncioRequest() {
    }

    /**
     * <p>Constructor for AnuncioRequest.</p>
     *
     * @param titulo a {@link java.lang.String} object.
     * @param descripcion a {@link java.lang.String} object.
     * @param fechaInicioVigencia a {@link java.time.LocalDate} object.
     * @param fechaFinVigencia a {@link java.time.LocalDate} object.
     * @param idCategoria a int.
     * @param precio a {@link java.math.BigDecimal} object.
     * @param mascotaValorAtributo a {@link java.util.List} object.
     */
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

    /**
     * <p>Getter for the field <code>titulo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * <p>Setter for the field <code>titulo</code>.</p>
     *
     * @param titulo a {@link java.lang.String} object.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * <p>Getter for the field <code>descripcion</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * <p>Setter for the field <code>descripcion</code>.</p>
     *
     * @param descripcion a {@link java.lang.String} object.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * <p>Getter for the field <code>fechaInicioVigencia</code>.</p>
     *
     * @return a {@link java.time.LocalDate} object.
     */
    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    /**
     * <p>Setter for the field <code>fechaInicioVigencia</code>.</p>
     *
     * @param fechaInicioVigencia a {@link java.time.LocalDate} object.
     */
    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    /**
     * <p>Getter for the field <code>fechaFinVigencia</code>.</p>
     *
     * @return a {@link java.time.LocalDate} object.
     */
    public LocalDate getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    /**
     * <p>Setter for the field <code>fechaFinVigencia</code>.</p>
     *
     * @param fechaFinVigencia a {@link java.time.LocalDate} object.
     */
    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    /**
     * <p>Getter for the field <code>idCategoria</code>.</p>
     *
     * @return a int.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * <p>Setter for the field <code>idCategoria</code>.</p>
     *
     * @param idCategoria a int.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

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
     * <p>Getter for the field <code>mascotaValorAtributo</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<MascotaValorAtributoRequest> getMascotaValorAtributo() {
        return mascotaValorAtributo;
    }

    /**
     * <p>Setter for the field <code>mascotaValorAtributo</code>.</p>
     *
     * @param mascotaValorAtributo a {@link java.util.List} object.
     */
    public void setMascotaValorAtributo(List<MascotaValorAtributoRequest> mascotaValorAtributo) {
        this.mascotaValorAtributo = mascotaValorAtributo;
    }


    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioRequest)) return false;
        AnuncioRequest that = (AnuncioRequest) o;
        return idCategoria == that.idCategoria && Objects.equals(titulo, that.titulo) &&
                Objects.equals(descripcion, that.descripcion) && Objects.equals(fechaInicioVigencia, that.fechaInicioVigencia) &&
                Objects.equals(fechaFinVigencia, that.fechaFinVigencia) && Objects.equals(precio, that.precio) &&
                Objects.equals(mascotaValorAtributo, that.mascotaValorAtributo);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "AnuncioRequest [titulo=" + titulo + ", descripcion=" + descripcion + ", fechaInicioVigencia="
                + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia + ", idCategoria=" + idCategoria
                + ", precio=" + precio + ", mascotaValorAtributo=" + mascotaValorAtributo + "]";
    }

}
