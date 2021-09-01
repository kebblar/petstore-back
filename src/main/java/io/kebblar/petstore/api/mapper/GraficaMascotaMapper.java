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
 * Artefacto:   GraficaMascotaMapper .java
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
public interface GraficaMascotaMapper {
    /**
     * Obtiene una lista de tipo 'Chart'.
     *
     * @return Una lista de las mascotas mas vendidas
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Results(id = "GraficaMap", value = { @Result(property = "etiqueta", column = "mascota"),
            @Result(property = "cantidad", column = "cantidad"), @Result(property = "fecha", column = "fecha") })
    @Select("SELECT cat.categoria as mascota,count(*) as cantidad, oc.fecha_hora_comprar as fecha from orden_compra oc "
            + "inner join carrito car on (car.cve_orden_compra= oc.cve_orden_compra) "
            + "inner join anuncio anun on (anun.id = car.id_anuncio) "
            + "inner join categoria cat on (cat.id = anun.id_categoria) "
            + "where YEAR(oc.fecha_hora_comprar) = YEAR(CURDATE()) "
            + "group by cat.categoria order by cantidad desc limit 5 ")
    List<Grafica> getAll() throws SQLException;

    @ResultMap("GraficaMap")
    @Select("SELECT cat.categoria as mascota,count(*) as cantidad, oc.fecha_hora_comprar as fecha from orden_compra oc "
            + "inner join carrito car on (car.cve_orden_compra= oc.cve_orden_compra) "
            + "inner join anuncio anun on (anun.id = car.id_anuncio) "
            + "inner join categoria cat on (cat.id = anun.id_categoria) "
            + "where oc.fecha_hora_comprar between #{fechaIni} and #{fechaFin} "
            + "group by cat.categoria order by cantidad desc limit 5")
    List<Grafica> getMascotaPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;

}
