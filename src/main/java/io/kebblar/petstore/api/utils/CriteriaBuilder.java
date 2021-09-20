/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      CriteriaBuilder
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:34:14
 */
package io.kebblar.petstore.api.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.kebblar.petstore.api.model.domain.Criterio;

/**
 * <p>CriteriaBuilder class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class CriteriaBuilder {
    private static final String TEMPLATE = "select id_mascota from data where id_categoria=%d and valor=%d";
    private List<Criterio> criterios = null;

    /**
     * <p>Constructor for CriteriaBuilder.</p>
     *
     * @param criterios a {@link java.util.List} object.
     */
    public CriteriaBuilder(List<Criterio> criterios) {
        this.criterios = criterios;
    }

    private String buildSql() {
        int i=1;
        StringBuilder sb = new StringBuilder();
        int size = criterios.size();
        for(Criterio cri : criterios) {
            sb.append("(");
            sb.append(String.format(TEMPLATE, cri.getIdCategoria(), cri.getValor()));
            sb.append(")");
            sb.append((i++<size)?" INTERSECT ":"");
        }
        return sb.toString();
    }

    /**
     * <p>produceMap.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, String> produceMap() {
        Map<String, String> map = new HashMap<>();
        map.put("goose", buildSql());
        map.put("tavo", "select 99");
        return map;
    }

}

