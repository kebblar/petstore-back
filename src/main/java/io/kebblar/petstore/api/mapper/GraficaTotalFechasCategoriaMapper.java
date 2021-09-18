/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      GraficaTotalFechasCategoriaMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:09:06
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
 * @see GraficaTotalFechasCategoria
 */

@Repository
public interface GraficaTotalFechasCategoriaMapper {

    /** Constant <code>CAMPOS_GRAFICA1="count(*) as cantidad_ordenes, sum(orden"{trunked}</code> */
    String CAMPOS_GRAFICA1 = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, " +
            "cat.categoria as categoria, MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    /** Constant <code>IJ_CARRITO_ORDEN=" inner join petstore.carrito as carrito"{trunked}</code> */
    String IJ_CARRITO_ORDEN = " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  " +
            "carrito.cve_orden_compra";
    /** Constant <code>IJ_CATEGORIA_ANUNCIO=" inner join petstore.categoria as cat o"{trunked}</code> */
    String IJ_CATEGORIA_ANUNCIO = " inner join petstore.categoria as cat on cat.id = anuncio.id_categoria";
    /** Constant <code>GROUP_CATEGORIA_M_A=" group by anio, mes, categoria"</code> */
    String GROUP_CATEGORIA_M_A = " group by anio, mes, categoria";
    /** Constant <code>IJ_ANUNCIO_CARRITO=" inner join petstore.anuncio as anuncio"{trunked}</code> */
    String IJ_ANUNCIO_CARRITO = " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio";

    /**
     * Obtiene una lista de tipo 'GraficaTotalFechasCategoria'.
     *
     * @return Una lista de las categorías más buscadas.
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
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
     * @throws java.sql.SQLException En caso de que ocurra algún error al momento de realizar la consulta
     */
    @ResultMap("GraficaTotalFechasCategoria")
    @Select("SELECT "+CAMPOS_GRAFICA1+ " from petstore.orden_compra as orden "
            +IJ_CARRITO_ORDEN+IJ_ANUNCIO_CARRITO+IJ_CATEGORIA_ANUNCIO
            +" where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin}"
            +GROUP_CATEGORIA_M_A)
    List<GraficaTotalFechasCategoria> getTotalCategoriaFiltroFechas(String fechaIni, String fechaFin) throws SQLException;

}

