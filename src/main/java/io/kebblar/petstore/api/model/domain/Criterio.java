/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Criterio
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:17:43
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
