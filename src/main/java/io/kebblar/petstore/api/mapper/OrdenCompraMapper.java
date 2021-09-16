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
 * Nombre:      OrdenCompraMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:10:04
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.DatosOrden;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad OrdenCompra.
 *
 * @author Daniel Alvarez
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see DatosOrden
 */
@Repository
public interface OrdenCompraMapper {

    /** Constant <code>CAMPOS_ORDEN=" id, id_usuario, id_direccion_envio, id"{trunked}</code> */
    String CAMPOS_ORDEN = " id, id_usuario, id_direccion_envio, id_paqueteria, id_metodo_pago, " +
            "id_moneda, id_anuncio, cve_orden_compra, importe_total, fecha_hora_comprar, estado_envio, recibo ";

    /**
     * Obtiene un objeto de tipo 'OrdenCompra' dado su id.
     *
     * @return MetodoPago que tiene asignado el id pasado como parametro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param cveOrdenCompra a {@link java.lang.String} object.
     */
    @Results(id="OrdenCompraMap", value = {
            @Result(property = "cveOrdenCompra",   column = "cve_orden_compra"),
            @Result(property = "idUsuario",   column = "id_usuario"),
            @Result(property = "idDireccion",   column = "id_direccion_envio"),
            @Result(property = "idPaqueteria",   column = "id_paqueteria"),
            @Result(property = "idMetodoPago",   column = "id_metodo_pago"),
            @Result(property = "idMoneda",   column = "id_moneda"),
            @Result(property = "total",   column = "importe_total"),
            @Result(property = "fecha",   column = "fecha_hora_comprar"),
            @Result(property = "estadoEnvio",   column = "estado_envio"),
            @Result(property = "recibo",   column = "recibo")
    })
    @Select("SELECT " + CAMPOS_ORDEN + " FROM orden_compra WHERE cveOrdenCompra = #{cveOrdenCompra}")
    DatosOrden getById(String cveOrdenCompra) throws SQLException ;

    /**
     * Obtiene una lista de objetos de tipo 'DatosOrden'.
     *
     * @return Lista de obetos de tipo DatosOrden
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("OrdenCompraMap")
    @Select("SELECT " + CAMPOS_ORDEN + " FROM orden_compra ")
    List<DatosOrden> getAll() throws SQLException;


    /**
     * Inserta un objeto de tipo 'DatosOrden' con base en la información dada por el objeto de tipo 'DatosOrden'.
     *
     * @param datosOrden a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO orden_compra(cve_orden_compra, id_usuario, id_direccion_envio, id_paqueteria, id_metodo_pago, id_moneda, importe_total, fecha_hora_comprar, estado_envio, recibo) "
   + "VALUES(#{cveOrdenCompra}, #{idUsuario}, #{idDireccion}, #{idPaqueteria}, #{idMetodoPago}, #{idMoneda}, #{total}, #{fecha}, #{estadoEnvio}, #{recibo} )")
    @Options(useGeneratedKeys=true, keyProperty="cveOrdenCompra", keyColumn = "cve_orden_compra")
    int insert(DatosOrden datosOrden) throws SQLException;


}
