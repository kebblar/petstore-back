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
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.GraficaTotalFechasCategoria;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad GraficaTotalFechasCategoria
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaTotalFechasCategoria
 */

@Repository
public interface GraficaTotalFechasCategoriaMapper {
    static final String CAMPOS = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, cat.categoria as categoria, MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    static final String IJCarritoOrden = " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra";
    static final String IJAnuncioCarrito = " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio";
    static final String IJCategoriaAnuncio = " inner join petstore.categoria as cat on cat.id = anuncio.id_categoria";
    static final String GroupCategoriaMesAnio = " group by anio, mes, categoria";

    /**
     * Obtiene una lista de tipo 'GraficaTotalFechasCategoria'.
     *
     * @return Una lista de las paqueterias mas usuadas
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Results(id = "GraficaTotalFechasCategoria", value = {
            @Result(property = "categoria", column = "categoria"),
            @Result(property = "total_venta", column = "total_venta"),
            @Result(property = "cantidad_ordenes", column = "cantidad_ordenes"),
            @Result(property = "mes", column = "mes"),
            @Result(property = "anio", column = "anio")})
    @Select("SELECT "+CAMPOS+ " from petstore.orden_compra as orden "
            +IJCarritoOrden+IJAnuncioCarrito+IJCategoriaAnuncio
            +GroupCategoriaMesAnio)
    List<GraficaTotalFechasCategoria> getTotalCategoria() throws SQLException;

    @ResultMap("GraficaTotalFechasCategoria")
    @Select("SELECT "+CAMPOS+ " from petstore.orden_compra as orden "
            +IJCarritoOrden+IJAnuncioCarrito+IJCategoriaAnuncio
            +" where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin}"
            +GroupCategoriaMesAnio)
    List<GraficaTotalFechasCategoria> getTotalCategoriaFiltroFechas(String fechaIni, String fechaFin) throws SQLException;

}

