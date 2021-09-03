/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Criterio.java
 * Tipo:        Clase
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_25)
 *
 * Historia:    .
 *              0210506_0925 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.model.domain;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'Criterio'.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Criterio {

    /*
     * Atributos de la clase.
     */
    private int idCategoria;
    private int valor;

    /**
     * Constructor por default (sin parámetros).
     */
    public Criterio() {
    }

    /**
     * Constructor basado en los atributos de la clase.
     */
    public Criterio(int idCategoria, int valor) {
        this.idCategoria = idCategoria;
        this.valor = valor;
    }

    /*
     * Setter y Getter.
     */
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Criterio)) return false;
        Criterio criterio = (Criterio) o;
        return idCategoria == criterio.idCategoria && valor == criterio.valor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, valor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Criterio [idCategoria=" + idCategoria + ", valor=" + valor + "]";
    }

}
