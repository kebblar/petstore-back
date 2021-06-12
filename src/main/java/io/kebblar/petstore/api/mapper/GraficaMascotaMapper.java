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
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.GraficaMascota;

/**
 * <p>
 * Descripción:
 * </p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Grafica
 *
 * @author Ulises López
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaMascota
 */

@Repository
public interface GraficaMascotaMapper {
    static final String CAMPOS = " mascota, cantidad ";

    /**
     * Obtiene una lista de tipo 'GraficaMascota'.
     *
     * @return Una lista de las mascotas mas vendidas
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Results(id = "GraficaMap", value = { @Result(property = "mascota", column = "mascota"),
            @Result(property = "cantidad", column = "cantidad") })
    @Select("SELECT cat.categoria as mascota,count(*) as cantidad from orden_compra oc "
            + "inner join anuncio anun on (anun.id = oc.id_anuncio) "
            + "inner join categoria cat on (cat.id = anun.id_categoria) group by cat.categoria ")
    List<GraficaMascota> getAll() throws SQLException;

    @ResultMap("GraficaMap")
    @Select("SELECT cat.categoria as mascota,count(*) as cantidad from orden_compra oc "
            + "inner join anuncio anun on (anun.id = oc.id_anuncio) "
            + "inner join categoria cat on (cat.id = anun.id_categoria) "
            + "where oc.fecha_hora_comprar between #{fechaIni} and #{fechaFin} " + "group by cat.categoria ")
    List<GraficaMascota> getMascotaPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;

}
