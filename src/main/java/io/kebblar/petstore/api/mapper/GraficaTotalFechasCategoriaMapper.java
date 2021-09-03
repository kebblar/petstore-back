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
 * Artefacto:   GraficaTotalFechasCategoriaMapper.java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Francisco Espinosa
 * Fecha:       Tuesday 16 de Jun de 2021 (10_00)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210616_1000 Implementación de interface
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
import io.kebblar.petstore.api.model.domain.GraficaTotalFechasCategoria;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad GraficaTotalFechasCategoria.
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaTotalFechasCategoria
 */

@Repository
public interface GraficaTotalFechasCategoriaMapper {

    String CAMPOS_GRAFICA1 = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, " +
            "cat.categoria as categoria, MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    String IJ_CARRITO_ORDEN = " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  " +
            "carrito.cve_orden_compra";
    String IJ_CATEGORIA_ANUNCIO = " inner join petstore.categoria as cat on cat.id = anuncio.id_categoria";
    String GROUP_CATEGORIA_M_A = " group by anio, mes, categoria";
    String IJ_ANUNCIO_CARRITO = " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio";

    /**
     * Obtiene una lista de tipo 'GraficaTotalFechasCategoria'.
     *
     * @return Una lista de las categorías más buscadas.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id = "GraficaTotalFechasCategoria", value = {
            @Result(property = "categoria", column = "categoria"),
            @Result(property = "total_venta", column = "total_venta"),
            @Result(property = "cantidad_ordenes", column = "cantidad_ordenes"),
            @Result(property = "mes", column = "mes"),
            @Result(property = "anio", column = "anio")})
    @Select("SELECT "+CAMPOS_GRAFICA1+ " from petstore.orden_compra as orden "
            +IJ_CARRITO_ORDEN+IJ_ANUNCIO_CARRITO+IJ_CATEGORIA_ANUNCIO
            +GROUP_CATEGORIA_M_A)
    List<GraficaTotalFechasCategoria> getTotalCategoria() throws SQLException;

    /**
     * Devuelve la información de compras por categoría basado en un rango de fechas.
     *
     * @param fechaIni cota inferior del rango de fechas
     * @param fechaFin cota superior del rango de fechas
     * @return Lista con la información deseada
     * @throws SQLException En caso de que ocurra algún error al momento de realizar la consulta
     */
    @ResultMap("GraficaTotalFechasCategoria")
    @Select("SELECT "+CAMPOS_GRAFICA1+ " from petstore.orden_compra as orden "
            +IJ_CARRITO_ORDEN+IJ_ANUNCIO_CARRITO+IJ_CATEGORIA_ANUNCIO
            +" where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin}"
            +GROUP_CATEGORIA_M_A)
    List<GraficaTotalFechasCategoria> getTotalCategoriaFiltroFechas(String fechaIni, String fechaFin) throws SQLException;

}

