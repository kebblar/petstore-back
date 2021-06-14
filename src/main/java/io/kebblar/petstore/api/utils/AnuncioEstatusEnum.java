/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioEstatusEnum.java
 * Tipo:        Enum
 * AUTOR:       Maria Isabel Contreras Garcia
 * Fecha:       Jueves 20 de Mayo de 2021 (23_03)
 *
 * Historia:    .
 *              20210520_2303 Creación de éste POJO
 *
 */
package io.kebblar.petstore.api.utils;

/**
 * <p>Descripción:</p>
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

    public short getId() {
        return id;
    }

    public String getDesEstatus() {
        return desEstatus;
    }
    public static String getDescripcion(short idEnum){
        for(AnuncioEstatusEnum eu:AnuncioEstatusEnum.values()){
            if(eu.getId() == idEnum){
                return eu.getDesEstatus();
            }
        }
        return "";
    }

}
