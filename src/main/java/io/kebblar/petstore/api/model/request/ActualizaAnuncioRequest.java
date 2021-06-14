/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ActualizaAnuncioRequest.java
 * Tipo:        clase
 * AUTOR:       Isabel Contreras (IS)
 * Fecha:       viernes 7 de Mayo de 2021 (09_38)
 *
 * Historia:    20210507_0938 Creación de éste POJO
 *
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
public class ActualizaAnuncioRequest extends AnuncioRequest{

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
