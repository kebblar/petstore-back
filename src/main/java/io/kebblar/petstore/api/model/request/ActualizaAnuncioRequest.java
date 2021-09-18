/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      ActualizaAnuncioRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:59:38
 */
package io.kebblar.petstore.api.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;

/**
 * Implementacion del POJO de la entidad de 'ActualizaAnuncioRequest'.
 *
 * @author  Isabel Contreras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ActualizaAnuncioRequest extends AnuncioRequest {

    @Min(value = 1, message = "{min.anuncio.id}")
    private int id;

    /**
     * <p>Constructor for ActualizaAnuncioRequest.</p>
     */
    public ActualizaAnuncioRequest() {
    }

    /**
     * <p>Constructor for ActualizaAnuncioRequest.</p>
     *
     * @param id a int.
     */
    public ActualizaAnuncioRequest(int id) {
        this.id = id;
    }

    /**
     * <p>Constructor for ActualizaAnuncioRequest.</p>
     *
     * @param id a int.
     * @param titulo a {@link java.lang.String} object.
     * @param descripcion a {@link java.lang.String} object.
     * @param fechaInicioVigencia a {@link java.time.LocalDate} object.
     * @param fechaFinVigencia a {@link java.time.LocalDate} object.
     * @param idCategoria a int.
     * @param precio a {@link java.math.BigDecimal} object.
     * @param atributos a {@link java.util.List} object.
     */
    public ActualizaAnuncioRequest(int id,String titulo, String descripcion, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia,
            int idCategoria, BigDecimal precio, List<MascotaValorAtributoRequest> atributos) {
        super(titulo, descripcion, fechaInicioVigencia, fechaFinVigencia, idCategoria, precio, atributos);
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActualizaAnuncioRequest)) return false;
        if (!super.equals(o)) return false;
        ActualizaAnuncioRequest that = (ActualizaAnuncioRequest) o;
        return id == that.id;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ActualizaAnuncioRequest [id=" + id + "]";
    }

}
