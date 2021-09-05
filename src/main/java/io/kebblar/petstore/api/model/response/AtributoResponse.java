/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      AtributoResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:02:25
 */
package io.kebblar.petstore.api.model.response;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'atributo' para mostrar el detalle.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AtributoResponse {

    private int id;
    private String descAtributo;
    private int valor;
    private String descValor;

    /**
     * <p>Constructor for AtributoResponse.</p>
     */
    public AtributoResponse() {
    }

    /**
     * <p>Constructor for AtributoResponse.</p>
     *
     * @param id a int.
     * @param valor a int.
     */
    public AtributoResponse(int id, int valor) {
        this.id = id;
        this.valor = valor;
    }

    /**
     * <p>Constructor for AtributoResponse.</p>
     *
     * @param id a int.
     * @param descAtributo a {@link java.lang.String} object.
     * @param valor a int.
     * @param descValor a {@link java.lang.String} object.
     */
    public AtributoResponse(int id, String descAtributo, int valor, String descValor) {
        super();
        this.id = id;
        this.descAtributo = descAtributo;
        this.valor = valor;
        this.descValor = descValor;
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

    /**
     * <p>Getter for the field <code>valor</code>.</p>
     *
     * @return a int.
     */
    public int getValor() {
        return valor;
    }

    /**
     * <p>Setter for the field <code>valor</code>.</p>
     *
     * @param valor a int.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * <p>Getter for the field <code>descAtributo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescAtributo() {
        return descAtributo;
    }

    /**
     * <p>Setter for the field <code>descAtributo</code>.</p>
     *
     * @param descAtributo a {@link java.lang.String} object.
     */
    public void setDescAtributo(String descAtributo) {
        this.descAtributo = descAtributo;
    }

    /**
     * <p>Getter for the field <code>descValor</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescValor() {
        return descValor;
    }

    /**
     * <p>Setter for the field <code>descValor</code>.</p>
     *
     * @param descValor a {@link java.lang.String} object.
     */
    public void setDescValor(String descValor) {
        this.descValor = descValor;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descAtributo == null) ? 0 : descAtributo.hashCode());
        result = prime * result + ((descValor == null) ? 0 : descValor.hashCode());
        result = prime * result + id;
        result = prime * result + valor;
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AtributoResponse other = (AtributoResponse) obj;
        if (descAtributo == null) {
            if (other.descAtributo != null)
                return false;
        } else if (!descAtributo.equals(other.descAtributo))
            return false;
        if (descValor == null) {
            if (other.descValor != null)
                return false;
        } else if (!descValor.equals(other.descValor))
            return false;
        if (id != other.id)
            return false;
        if (valor != other.valor)
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "AtributoResponse [id=" + id + ", descAtributo=" + descAtributo + ", valor=" + valor + ", descValor="
                + descValor + "]";
    }


}
