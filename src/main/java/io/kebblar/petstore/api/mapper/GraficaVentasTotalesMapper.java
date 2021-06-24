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
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.GraficaVentasTotales;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad GraficaVentasTotales
 *
 * @author FranciscoEspinosa
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see GraficaVentasTotales
 */
@Repository
public interface GraficaVentasTotalesMapper {
    static final String CAMPOS = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio";
    static final String IJCarritoOrden = " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra";
    static final String IJAnuncioCarrito = " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio";
    static final String GroupMesAnio = " group by anio, mes";
    
    /**
     * Obtiene una lista de tipo 'GraficaVentasTotales'.
     *
     * @return Una lista de las paqueterias mas usuadas
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Results(id = "GraficaVentasTotales", value = {
        @Result(property = "total_venta", column = "total_venta"),
    	@Result(property = "cantidad_ordenes", column = "cantidad_ordenes"),
    	@Result(property = "mes", column = "mes"),
    	@Result(property = "anio", column = "anio")})
    @Select("SELECT " + CAMPOS + " from petstore.orden_compra as orden "
        + IJCarritoOrden + IJAnuncioCarrito + GroupMesAnio)
    List<GraficaVentasTotales> getTotalVentas() throws SQLException;
    
    @ResultMap("GraficaVentasTotales")
    @Select("SELECT " + CAMPOS + " from petstore.orden_compra as orden "
        + IJCarritoOrden + IJAnuncioCarrito
        + " where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin}" 
        + GroupMesAnio)
    List<GraficaVentasTotales> getTotalVentasFiltroFechas(String fechaIni, String fechaFin) throws SQLException;

}
