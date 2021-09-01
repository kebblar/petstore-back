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
 *
 * @see ChartData
 */

@Repository
public interface GraficaPaqueteriaMapper {
    /**
     * Obtiene una lista de tipo 'Chart'.
     *
     * @return Una lista de las paqueterías más usadas
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id = "GraficaPaqMap", value = { @Result(property = "etiqueta", column = "paqueteria"),
            @Result(property = "cantidad", column = "cantidad"), @Result(property = "fecha", column = "fecha") })
    @Select("SELECT paq.nombre as paqueteria,count(*) as cantidad, oc.fecha_hora_comprar as fecha from orden_compra oc  "
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
     * @throws SQLException En caso de que ocurra algún error al momento de realizar la consulta
     */
    @ResultMap("GraficaPaqMap")
    @Select("SELECT paq.nombre as paqueteria,count(*) as cantidad, oc.fecha_hora_comprar as fecha from orden_compra oc  "
            + "inner join paqueteria paq on (paq.id = oc.id_paqueteria) "
            + "where oc.fecha_hora_comprar between #{fechaIni} and #{fechaFin} "
            + "group by paq.nombre, MONTH(fecha) order by cantidad desc limit 5")
    List<Grafica> getPaqueteriaPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;

}
