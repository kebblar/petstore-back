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
 * Artefacto:   GraficaCompradorMapper .java
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

import io.kebblar.petstore.api.model.domain.Grafica;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad GraficaComprador
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaComprador
 */

@Repository
public interface GraficaCompradorMapper {
    static final String CAMPOS = " comprador, cantidad, fecha ";

    /**
     * Obtiene una lista de tipo 'GraficaComprador'.
     *
     * @return Una lista de los compradores mas asiduos
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Results(id = "GraficaComMap", value = { @Result(property = "etiqueta", column = "comprador"),
            @Result(property = "cantidad", column = "cantidad"),
            @Result(property = "fecha", column = "fecha")})
    @Select("SELECT usu.nombre as comprador,count(*) as cantidad , oc.fecha_hora_comprar as fecha from orden_compra oc "
            + "inner join usuario_detalle usu on (usu.id_usuario = oc.id_usuario) "
            + "where YEAR(oc.fecha_hora_comprar) = YEAR(CURDATE()) "
            + "group by usu.nombre order by cantidad desc limit 5")
    List<Grafica> getComprador() throws SQLException;

    @ResultMap("GraficaComMap")
    @Select("SELECT usu.nombre as comprador,count(*) as cantidad , oc.fecha_hora_comprar as fecha from orden_compra oc "
            + "inner join usuario_detalle usu on (usu.id_usuario = oc.id_usuario) "
            + "where oc.fecha_hora_comprar between #{fechaIni} and #{fechaFin} " + "group by usu.nombre order by cantidad desc limit 5")
    List<Grafica> getCompradorPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;

}
