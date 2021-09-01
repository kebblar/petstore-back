package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.GraficaTipoPago;

@Repository
public interface GraficaTipoPagoMapper {

    /**
     * Obtiene una lista de tipo 'GraficaMontoTotalTipoPago'.
     *
     * @return Una lista del monto total por tipo de pago
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */

    @Results(id = "GraficaTipoPago", value = { @Result(property = "tipo_pago", column = "tipo_pago"),
            @Result(property = "total_venta", column = "total_venta"),
            @Result(property = "cantidad_ordenes", column = "cantidad_ordenes"),
            @Result(property = "mes", column = "mes"),
            @Result(property = "anio", column = "anio")})

    @Select(" select count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, pago.tipo as tipo_pago, " +
            " MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio from  petstore.orden_compra as orden " +
            " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra " +
            " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio " +
            " inner join petstore.metodo_pago as pago on pago.id = orden.id_metodo_pago " +
            " group by tipo, mes, anio ")
    List<GraficaTipoPago> getAll() throws SQLException;

    @ResultMap("GraficaTipoPago")
    @Select(" select count(*) as cantidad_ordenes, sum(orden.importe_total) as total_venta, pago.tipo as tipo_pago, " +
            " MONTH(orden.fecha_hora_comprar) as mes, YEAR(orden.fecha_hora_comprar) as anio from  petstore.orden_compra as orden " +
            " inner join petstore.carrito as carrito on  orden.cve_orden_compra =  carrito.cve_orden_compra " +
            " inner join petstore.anuncio as anuncio on anuncio.id =  carrito.id_anuncio " +
            " inner join petstore.metodo_pago as pago on pago.id = orden.id_metodo_pago " +
            " where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin} " +
            " group by tipo, mes, anio ")
    List<GraficaTipoPago> getTipoPagoPorRangoDeFechas(String fechaIni, String fechaFin) throws SQLException;
}
