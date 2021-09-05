/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      GraficaTipoPagoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:08:56
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.GraficaTipoPago;

/**
 * <p>GraficaTipoPagoMapper interface.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@Repository
public interface GraficaTipoPagoMapper {

    String CAMPOS_T_P = "count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, pago.tipo as tipo_pago, " +
            /** Constant <code>CAMPOS_T_P="count(*) as cantidad_ordenes, sum(orden"{trunked}</code> */
            "MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio ";
    /**
     * Obtiene una lista de tipo 'GraficaMontoTotalTipoPago'.
     *
     * @return Una lista del monto total por tipo de pago
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */

    @Results(id = "GraficaTipoPago", value = { @Result(property = "tipo_pago", column = "tipo_pago"),
            @Result(property = "total_venta", column = "total_venta"),
            @Result(property = "cantidad_ordenes", column = "cantidad_ordenes"),
            @Result(property = "mes", column = "mes"),
            @Result(property = "anio", column = "anio")})

    @Select(" select "+CAMPOS_T_P+" from  petstore.orden_compra as orden " +
            " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra " +
            " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio " +
            " inner join petstore.metodo_pago as pago on pago.id = orden.id_metodo_pago " +
            " group by tipo, mes, anio ")
    List<GraficaTipoPago> getAll() throws SQLException;

    /**
     * Devuelve la información de compras por el tipo de pago basado en un rango de fechas.
     *
     * @param fechaIni cota inferior del rango de fechas
     * @param fechaFin cota superior del rango de fechas
     * @return Lista con la información deseada
     * @throws java.sql.SQLException En caso de que ocurra algún error al momento de realizar la consulta
     */
    @ResultMap("GraficaTipoPago")
    @Select(" select "+CAMPOS_T_P+" from  petstore.orden_compra as orden " +
            " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra " +
            " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio " +
            " inner join petstore.metodo_pago as pago on pago.id = orden.id_metodo_pago " +
            " where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin} " +
            " group by tipo, mes, anio ")
    List<GraficaTipoPago> getTipoPagoPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;
}
