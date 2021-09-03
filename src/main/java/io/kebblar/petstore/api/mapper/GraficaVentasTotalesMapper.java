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
 * Artefacto:   GraficaVentasTotalesMapper.java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Francisco Espinosa
 * Fecha:       Tuesday 23 de Jun de 2021 (10_00)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210623_1000 Implementación de interface
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
import io.kebblar.petstore.api.model.domain.GraficaVentasTotales;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad GraficaVentasTotales.
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaVentasTotales
 */
@Repository
public interface GraficaVentasTotalesMapper {

    String CAMPOS_GRAFICA2 = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, " +
            "MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    String GROUP_MES_ANIO = " group by anio, mes";
    String IJ_CARRITO_ORDEN = " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  " +
            "carrito.cve_orden_compra";
    String IJ_ANUNCIO_CARRITO = " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio";

    /**
     * Obtiene una lista de tipo 'GraficaVentasTotales'.
     *
     * @return Una lista de las ventas totales
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id = "GraficaVentasTotales", value = {
        @Result(property = "total_venta", column = "total_venta"),
        @Result(property = "cantidad_ordenes", column = "cantidad_ordenes"),
        @Result(property = "mes", column = "mes"),
        @Result(property = "anio", column = "anio")})
    @Select("SELECT " + CAMPOS_GRAFICA2 + " from petstore.orden_compra as orden "
        + IJ_CARRITO_ORDEN + IJ_ANUNCIO_CARRITO + GROUP_MES_ANIO)
    List<GraficaVentasTotales> getTotalVentas() throws SQLException;

    /**
     * Devuelve la información de ventas totales basado en un rango de fechas.
     *
     * @param fechaIni cota inferior del rango de fechas
     * @param fechaFin cota superior del rango de fechas
     * @return Lista con la información deseada
     * @throws SQLException En caso de que ocurra algún error al momento de realizar la consulta
     */
    @ResultMap("GraficaVentasTotales")
    @Select("SELECT " + CAMPOS_GRAFICA2 + " from petstore.orden_compra as orden "
        + IJ_CARRITO_ORDEN + IJ_ANUNCIO_CARRITO
        + " where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin}"
        + GROUP_MES_ANIO)
    List<GraficaVentasTotales> getTotalVentasFiltroFechas(String fechaIni, String fechaFin) throws SQLException;

}
