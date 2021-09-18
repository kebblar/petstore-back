/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CategoriaTO
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:17:14
 */
package io.kebblar.petstore.api.model.domain;

import java.util.List;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'categoria'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CategoriaTO {

    /*
     * Atributos de la clase.
     */
    Categoria categoria;
    List<AtributoTO> atributos;

    /*
     * Setter y getter.
     */
    /**
     * <p>Getter for the field <code>categoria</code>.</p>
     *
     * @return a {@link io.kebblar.petstore.api.model.domain.Categoria} object.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * <p>Setter for the field <code>categoria</code>.</p>
     *
     * @param categoria a {@link io.kebblar.petstore.api.model.domain.Categoria} object.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * <p>Getter for the field <code>atributos</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AtributoTO> getAtributos() {
        return atributos;
    }

    /**
     * <p>Setter for the field <code>atributos</code>.</p>
     *
     * @param atributos a {@link java.util.List} object.
     */
    public void setAtributos(List<AtributoTO> atributos) {
        this.atributos = atributos;
    }

}
