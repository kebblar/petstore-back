/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   TablasContador.java
 * Tipo:        enum
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (09_31)
 *
 * Historia:    .
 *              20210503_0931 Creación de éste enum
 *              20210511_0859 Se modifica la fecha en la licencia
 *
 */
package io.kebblar.petstore.api.model.domain;

/**
 * <p>Descripción:</p>
 * Enum que sirve para enumerar las tablas que pueden usar el contador
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public enum TablasContador {
    PAISES("pais"),
    ESTADOS("estado"),
    MUNICIPIOS("municipio");

    private final String tabla;

    TablasContador(String tabla) {
        this.tabla = tabla;
    }

    public String getTabla() {
        return tabla;
    }
}