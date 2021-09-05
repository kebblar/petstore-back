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
 * Nombre:      MetodoPagoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:09:46
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.MetodoPago;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad MetodoPago.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see MetodoPago
 */

@Repository
public interface MetodoPagoMapper {

    /** Constant <code>CAMPOS_PAGO=" id, id_usuario, tipopago, num_tarjeta_"{trunked}</code> */
    String CAMPOS_PAGO = " id, id_usuario, tipopago, num_tarjeta_cartera, expiracion, activo ";

    /**
     * Obtiene un objeto de tipo 'MetodoPago' dado su id.
     *
     * @return MetodoPago que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="MetodoPagoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idUsuario",   column = "id_usuario"),
            @Result(property = "tipopago",   column = "tipopago"),
            @Result(property = "numTarjetaCartera",   column = "num_tarjeta_cartera"),
            @Result(property = "expiracion",   column = "expiracion")    ,
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS_PAGO + " FROM metodo_pago WHERE     id = #{id}     ")
    MetodoPago getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'MetodoPago'.
     *
     * @return Lista de objetos de tipo MetodoPago
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("MetodoPagoMap")
    @Select("SELECT " + CAMPOS_PAGO + " FROM metodo_pago ")
    List<MetodoPago> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'MetodoPago' con base en la información dada por el objeto de tipo 'MetodoPago'.
     *
     * @param metodoPago a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO metodo_pago(id, id_usuario, tipopago, num_tarjeta_cartera, expiracion, activo) "
   + "VALUES(#{id}, #{idUsuario}, #{tipopago}, #{numTarjetaCartera}, #{expiracion}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(MetodoPago metodoPago) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'MetodoPago' con base en la información dada por el objeto de tipo 'MetodoPago'.
     *
     * @param metodoPago a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE metodo_pago"
    + " SET id_usuario = #{idUsuario}, tipopago = #{tipopago}, activo = #{activo}, num_tarjeta_cartera = #{numTarjetaCartera}, expiracion = #{expiracion}"
    + " WHERE id = #{id} ")
    int update(MetodoPago metodoPago) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de MetodoPago.
     *
     * @param id id del MetodoPago a ser borrado
     * @return id del MetodoPago borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("UPDATE metodo_pago SET activo=false WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Regresa la lista de métodos de pago registrados con el usuario 'id'.
     *
     * @param id id del usuario buscado
     * @return Lista de métodos de pago asociados al usuario
     * @throws java.sql.SQLException si ocurre un problema con el sistema o la consulta
     */
    @ResultMap("MetodoPagoMap")
    @Select("SELECT "+ CAMPOS_PAGO +" from metodo_pago WHERE id_usuario=#{id} AND activo=true")
    List<MetodoPago> getByIdUser(int id) throws SQLException;
}
