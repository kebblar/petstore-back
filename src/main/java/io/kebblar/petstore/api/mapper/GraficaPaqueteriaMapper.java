/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   GraficaPaqueteriaMapper .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Ulises López
 * Fecha:       Tuesday 10 de Jun de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210610_1444 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Chart;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Chart
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Chart
 */

@Repository
public interface GraficaPaqueteriaMapper {
    /**
     * Obtiene una lista de tipo 'Chart'.
     *
     * @return Una lista de las paqueterias mas usuadas
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Results(id = "GraficaPaqMap", value = { @Result(property = "label", column = "paqueteria"),
            @Result(property = "data", column = "cantidad"), @Result(property = "mes", column = "fecha") })
    @Select("SELECT paq.nombre as paqueteria,count(*) as cantidad, oc.fecha_hora_comprar as fecha from orden_compra oc  "
            + "inner join paqueteria paq on (paq.id = oc.id_paqueteria) "
            + "group by paq.nombre, MONTH(fecha) order by cantidad desc limit 5")
    List<Chart> getPaqueteria() throws SQLException;

    @ResultMap("GraficaPaqMap")
    @Select("SELECT paq.nombre as paqueteria,count(*) as cantidad, oc.fecha_hora_comprar as fecha from orden_compra oc  "
            + "inner join paqueteria paq on (paq.id = oc.id_paqueteria) "
            + "where oc.fecha_hora_comprar between #{fechaIni} and #{fechaFin} "
            + "group by paq.nombre, MONTH(fecha) order by cantidad desc limit 5")
    List<Chart> getPaqueteriaPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;

}
