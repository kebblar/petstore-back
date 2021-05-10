
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
 * Artefacto:   MetodoPagoMapper .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Monday 05 de May de 2021 (15_02)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210510_1502 Implementación de interface 
 *
 */

package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.MetodoPago;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad MetodoPago 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see MetodoPago
 */

@Repository
public interface MetodoPagoMapper {
    static final String CAMPOS = " id, id_usuario, tipopago, num_tarjeta_cartera, expiracion ";

    /**
     * Obtiene un objeto de tipo 'MetodoPago' dado su id.
     *
     * @return MetodoPago que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="MetodoPagoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idUsuario",   column = "id_usuario"),
            @Result(property = "tipopago",   column = "tipopago"),
            @Result(property = "numTarjetaCartera",   column = "num_tarjeta_cartera"),
            @Result(property = "expiracion",   column = "expiracion")    
    })
    @Select("SELECT " + CAMPOS + " FROM metodo_pago WHERE     id = #{id}     ") 
    MetodoPago getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'MetodoPago'.
     *
     * @return Lista de obetos de tipo MetodoPago
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("MetodoPagoMap")
    @Select("SELECT " + CAMPOS + " FROM metodo_pago ") 
    List<MetodoPago> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'MetodoPago' con base en la información dada por el objeto de tipo 'MetodoPago'.
     *
     * @param metodoPago a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO metodo_pago(id, id_usuario, tipopago, num_tarjeta_cartera, expiracion) "
   + "VALUES(#{id}, #{idUsuario}, #{tipopago}, #{numTarjetaCartera}, #{expiracion} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(MetodoPago metodoPago) throws SQLException;

/**
     * Actualiza un objeto de tipo 'MetodoPago' con base en la infrmación dada por el objeto de tipo 'MetodoPago'.
     *
     * @param metodoPago a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE metodo_pago" 
    + "SET id_usuario = #{idUsuario}, tipopago = #{tipopago}, num_tarjeta_cartera = #{numTarjetaCartera}, expiracion = #{expiracion}"
    + "WHERE id = #{id} ")
    int update(MetodoPago metodoPago) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de MetodoPago.
     *
     * @param id id del MetodoPago a ser borrado
     * @return id del MetodoPago borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM metodo_pago WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

    @ResultMap("MetodoPagoMap")
    @Select("select * from metodo_pago where id_usuario=#{id}")
    List<MetodoPago> getByUser(int id) throws SQLException;
}
