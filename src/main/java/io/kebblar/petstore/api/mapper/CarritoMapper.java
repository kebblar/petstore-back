/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      CarritoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:04:14
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Carrito;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Carrito.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Carrito
 */
@Repository
public interface CarritoMapper {

    /** Constant <code>CAMPOS_CARRITO=" id, id_usuario, id_anuncio, cve_orden_"{trunked}</code> */
    String CAMPOS_CARRITO = " id, id_usuario, id_anuncio, cve_orden_compra ";

    /**
     * Obtiene un objeto de tipo 'Carrito' dado su id.
     *
     * @return Carrito que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="CarritoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idUsuario",   column = "id_usuario"),
            @Result(property = "idAnuncio",   column = "id_anuncio"),
            @Result(property = "cveOrdenCompra",   column = "cve_orden_compra")
    })
    @Select("SELECT " + CAMPOS_CARRITO + " FROM carrito WHERE     id = #{id}     ")
    Carrito getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Carrito'.
     *
     * @param id Id del usuario que posee determinado carrito.
     * @return Lista de objetos de tipo Carrito
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CarritoMap")
    @Select("SELECT " + CAMPOS_CARRITO + " FROM carrito WHERE id_usuario = #{id} AND cve_orden_compra is NULL")
    List<Carrito> getAll(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Carrito' asignados a la orden btc de un usuario.
     *
     * @param idUser Id del usuario que posee determinado carrito.
     * @return Lista de objetos de tipo Carrito
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CarritoMap")
    @Select("SELECT " + CAMPOS_CARRITO + " FROM carrito WHERE id_usuario = #{idUser} AND cve_orden_compra='btcPen'")
    List<Carrito> getBtcCarrito(int idUser) throws SQLException;

    /**
     * Inserta un objeto de tipo 'Carrito' con base en la información dada por el objeto de tipo 'Carrito'.
     *
     * @param carrito a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO carrito(id_usuario, id_anuncio, cve_orden_compra) VALUES(#{idUsuario}, #{idAnuncio}, NULL )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Carrito carrito) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Carrito' con base en la información dada por el objeto de tipo 'Carrito'.
     *
     * @param carrito a ser actualizado.
     * @return el número de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE carrito SET id_usuario = #{idUsuario}, id_anuncio = #{idAnuncio}, cve_orden_compra = #{cveOrdenCompra} WHERE id = #{id} ")
    int update(Carrito carrito) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Carrito.
     *
     * @param id id del Carrito a ser borrado
     * @return id del Carrito borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM carrito WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Recupera los datos necesarios de los artículos de un carrito para generar el pdf de la compra.
     *
     * @param cve cadena que representa el id de la compra.
     * @return Lista de datos sobre los elementos comprados.
     * @throws java.sql.SQLException Si ocurre algún problema en la consulta.
     */
    @Results(id="CarritoDatos", value = {
            @Result(property = "titulo",   column = "titulo"),
            @Result(property = "descripcion",   column = "descripcion"),
            @Result(property = "precio",   column = "precio")
    })
    @Select("SELECT titulo,precio,descripcion FROM anuncio, carrito WHERE anuncio.id = carrito.id_anuncio AND cve_orden_compra = #{cve}")
    List<CarritoDatosFactura> getByCve(String cve) throws SQLException;
}
