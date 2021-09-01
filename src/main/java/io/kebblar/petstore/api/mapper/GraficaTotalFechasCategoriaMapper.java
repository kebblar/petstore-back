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

import static io.kebblar.petstore.api.mapper.constants.Campos.*;

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
    @Select("SELECT "+CAMPOS_GRAFICA1+ " from petstore.orden_compra as orden "
            +IJ_CARRITO_ORDEN+IJ_ANUNCIO_CARRITO+IJ_CATEGORIA_ANUNCIO
            +GROUP_CATEGORIA_M_A)
    List<GraficaTotalFechasCategoria> getTotalCategoria() throws SQLException;

    @ResultMap("GraficaTotalFechasCategoria")
    @Select("SELECT "+CAMPOS_GRAFICA1+ " from petstore.orden_compra as orden "
            +IJ_CARRITO_ORDEN+IJ_ANUNCIO_CARRITO+IJ_CATEGORIA_ANUNCIO
            +" where orden.fecha_hora_comprar between #{fechaIni} and #{fechaFin}"
            +GROUP_CATEGORIA_M_A)
    List<GraficaTotalFechasCategoria> getTotalCategoriaFiltroFechas(String fechaIni, String fechaFin) throws SQLException;

}

