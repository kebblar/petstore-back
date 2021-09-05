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

    public ActualizaAnuncioRequest() {
    }

    public ActualizaAnuncioRequest(int id) {
        this.id = id;
    }

    public ActualizaAnuncioRequest(int id,String titulo, String descripcion, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia,
            int idCategoria, BigDecimal precio, List<MascotaValorAtributoRequest> atributos) {
        super(titulo, descripcion, fechaInicioVigencia, fechaFinVigencia, idCategoria, precio, atributos);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ActualizaAnuncioRequest other = (ActualizaAnuncioRequest) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ActualizaAnuncioRequest [id=" + id + "]";
    }

}
