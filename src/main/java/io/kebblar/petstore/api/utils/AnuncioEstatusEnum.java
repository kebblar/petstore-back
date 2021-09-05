/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Enum
 * Nombre:      AnuncioEstatusEnum
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:32:38
 */
package io.kebblar.petstore.api.utils;

/**
 * ENUM asociado a los estatud de la entidad 'anuncio'.
 *
 * @author Maria Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public enum AnuncioEstatusEnum {
    EN_EDICION ((short)1, "En edición"),
    ACTIVO ((short)2, "Activo"),
    PUBLICADO ((short)3, "Publicado"),
    VENCIDO ((short)4, "Vencido"),
    ELIMINADO ((short)5, "Eliminado"),
    CANCELADO ((short)6, "Cancelado");

    private short id;
    private String desEstatus;

    AnuncioEstatusEnum(short id, String desEstatus) {
        this.id = id;
        this.desEstatus = desEstatus;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a short.
     */
    public short getId() {
        return id;
    }

    /**
     * <p>Getter for the field <code>desEstatus</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDesEstatus() {
        return desEstatus;
    }

    /**
     * <p>getDescripcion.</p>
     *
     * @param idEnum a short.
     * @return a {@link java.lang.String} object.
     */
    public static String getDescripcion(short idEnum){
        for(AnuncioEstatusEnum eu:AnuncioEstatusEnum.values()){
            if(eu.getId() == idEnum){
                return eu.getDesEstatus();
            }
        }
        return "";
    }

}
