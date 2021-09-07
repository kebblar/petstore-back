/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AtributoResponse.java
 * Tipo:        clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Martes 18 de Mayo de 2021 (20_45)
 *
 * Historia:    .
 *              20210518_2045 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.response;

import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'atributo' para mostrar el detalle.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AtributoResponse {

    /*
     * Atributos de clase.
     */
    private int id;
    private String descAtributo;
    private int valor;
    private String descValor;

    /**
     * Constructor por defecto.
     */
    public AtributoResponse() {
    }

    /**
     * Contructor por id, valor.
     */
    public AtributoResponse(int id, int valor) {
        this.id = id;
        this.valor = valor;
    }

    /**
     * Constructos basado en todos los atributos de la clase.
     */
    public AtributoResponse(int id, String descAtributo, int valor, String descValor) {
        super();
        this.id = id;
        this.descAtributo = descAtributo;
        this.valor = valor;
        this.descValor = descValor;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescAtributo() {
        return descAtributo;
    }

    public void setDescAtributo(String descAtributo) {
        this.descAtributo = descAtributo;
    }

    public String getDescValor() {
        return descValor;
    }

    public void setDescValor(String descValor) {
        this.descValor = descValor;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtributoResponse)) return false;
        AtributoResponse that = (AtributoResponse) o;
        return id == that.id && valor == that.valor && Objects.equals(descAtributo, that.descAtributo) &&
                Objects.equals(descValor, that.descValor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AtributoResponse [id=" + id + ", descAtributo=" + descAtributo + ", valor=" + valor + ", descValor="
                + descValor + "]";
    }


}