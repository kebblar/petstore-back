/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      GraficaPaqueteriaMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:08:43
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Grafica;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Chart.
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@Repository
public interface GraficaPaqueteriaMapper {

    /** Constant <code>CAMPOS_G_P="paq.nombre as paqueteria,count(*) as ca"{trunked}</code> */
    String CAMPOS_G_P = "paq.nombre as paqueteria,count(*) as cantidad, oc.fecha_hora_comprar as fecha";
    /**
     * Obtiene una lista de tipo 'Chart'.
     *
     * @return Una lista de las paqueterías más usadas
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id = "GraficaPaqMap", value = { @Result(property = "etiqueta", column = "paqueteria"),
            @Result(property = "cantidad", column = "cantidad"), @Result(property = "fecha", column = "fecha") })
    @Select("SELECT "+CAMPOS_G_P+" from orden_compra oc  "
            + "inner join paqueteria paq on (paq.id = oc.id_paqueteria) "
            + "where YEAR(oc.fecha_hora_comprar) = YEAR(CURDATE()) "
            + "group by paq.nombre, MONTH(fecha) order by cantidad desc limit 5")
    List<Grafica> getPaqueteria() throws SQLException;

    /**
     * Devuelve la información de compras de un las paqueterías basado en un rango de fechas.
     *
     * @param fechaIni cota inferior del rango de fechas
     * @param fechaFin cota superior del rango de fechas
     * @return Lista con la información deseada
     * @throws java.sql.SQLException En caso de que ocurra algún error al momento de realizar la consulta
     */
    @ResultMap("GraficaPaqMap")
    @Select("SELECT "+CAMPOS_G_P+" from orden_compra oc  "
            + "inner join paqueteria paq on (paq.id = oc.id_paqueteria) "
            + "where oc.fecha_hora_comprar between #{fechaIni} and #{fechaFin} "
            + "group by paq.nombre, MONTH(fecha) order by cantidad desc limit 5")
    List<Grafica> getPaqueteriaPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;

}
