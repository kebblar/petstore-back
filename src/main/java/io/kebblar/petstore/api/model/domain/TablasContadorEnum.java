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
 * Tipo:        ENUM
 * Nombre:      TablasContadorEnum
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:51:25
 */
package io.kebblar.petstore.api.model.domain;

/**
 * <p>TablasContadorEnum class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public enum TablasContadorEnum {

    /*
     * Enums.
     */
    PAISES("pais"),
    ESTADOS("estado"),
    MUNICIPIOS("municipio");

package io.kebblar.petstore.api.model.domain;

public enum TablasContadorEnum {

    /*
     * Enums.
     */
    PAISES("pais"),
    ESTADOS("estado"),
    MUNICIPIOS("municipio");
    private final String tabla;

    /**
     * Constructor.
     */
    TablasContadorEnum(String tabla) {
        this.tabla = tabla;
    }

    /**
     * Getter.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTabla() {
        return tabla;
    }
}
