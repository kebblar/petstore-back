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
 * Nombre:      CriptoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:05:36
 */
package io.kebblar.petstore.api.mapper;

import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>CriptoMapper interface.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@Repository
public interface CriptoMapper {

    /** Constant <code>CAMPOS_CRIPTO="id, id_usuario, id_direccion, wallet, i"{trunked}</code> */
    String CAMPOS_CRIPTO = "id, id_usuario, id_direccion, wallet, id_paqueteria, status, monto, fecha, " +
            "descripcion, last_balance";

    /**
     * Obtiene la dirección de la cartera digital de bitcoin del usuario cuyo id es introducido.
     *
     * @param id Id del usuario del que se desea recuperar la cartera.
     * @return Cartera en forma de cadena
     * @throws java.sql.SQLException Si hay un error en la recuperación de esta.
     */
    @Results(id="CriptoMap", value = {
    @Result(property = "address", column = "address")
    })
    @Select("SELECT address FROM btc_wallet WHERE id_user = #{id} ")
    String getByUser(int id) throws SQLException;

    /**
     * Nos da el usuario al que está asociada una cartera bitcoin.
     *
     * @param address Dirección de la cartera.
     * @return El id del usuario al que le pertenece la cartera.
     * @throws java.sql.SQLException Si ocurre un problema en el proceso de recuperación.
     */
    @Select("SELECT id_user FROM btc_wallet WHERE address = #{address} ")
    int getUserByAddress(String address) throws SQLException;

    /**
     * Inserta una nueva solicitud de orden a pagar con bitcoin en la base de datos.
     *
     * @param transaccionBtc objeto con los datos de la orden si esta se genera.
     * @return entero si se inserta con éxito el objeto.
     * @throws java.sql.SQLException Si ocurre un problema de inserción.
     */
    @Insert("Insert into transaccion_btc(id_usuario, id_direccion, wallet, id_paqueteria, status, monto, fecha, descripcion, last_balance) VALUES (#{idUsuario}, #{idDireccion}, #{wallet}, #{idPaqueteria}, #{status}, #{monto}, #{fecha}, #{descripcion}, #{lastBalance})")
    int insertTransaccion(TransaccionBtc transaccionBtc) throws SQLException;

    /**
     * Actualiza una transacción de bitcoin con información nueva.
     *
     * @param transaccionBtc objeto que simboliza una petición.
     * @return Entero si no hay ningún problema
     * @throws java.sql.SQLException En caso de un problema con la consulta.
     */
    @Update("UPDATE transaccion_btc SET id_usuario = #{idUsuario}, id_direccion = #{idDireccion}, wallet = #{wallet}, id_paqueteria = #{idPaqueteria}, status = #{status}, monto = #{monto}, fecha = #{fecha}, descripcion = #{descripcion}, last_balance = #{lastBalance}")
    int updateTransaccion(TransaccionBtc transaccionBtc) throws  SQLException;

    /**
     * Regresa una lista de todos las transacciones pendientes de validación.
     *
     * @return Lista de transacciones que aún no aparecen en la blockchain.
     * @throws java.sql.SQLException En caso de que haya problemas recuperando la información.
     */
    @Results(id="TransaccionMap", value = {
            @Result(property = "id",          column = "id"),
            @Result(property = "idUsuario", column = "id_usuario"),
            @Result(property = "idDireccion",     column = "id_direccion"),
            @Result(property = "wallet",      column = "wallet"),
            @Result(property = "idPaqueteria",    column = "id_paqueteria"),
            @Result(property = "status", column = "status"),
            @Result(property = "monto", column = "monto"),
            @Result(property = "fecha",          column = "fecha"),
            @Result(property = "descripcion", column = "descripcion"),
            @Result(property = "lastBalance", column = "last_balance")
    })
    @Select("SELECT " +CAMPOS_CRIPTO+ " FROM transaccion_btc WHERE status=false")
    List<TransaccionBtc> getAll() throws SQLException;

    /**
     * Eliminba una transacción porporcionando su id.
     *
     * @param id Id de la transacción a eliminar.
     * @return Entero si se realizo la acción.
     * @throws java.sql.SQLException En caso de que haya problemas recuperando la información.
     */
    @Delete("DELETE from transaccion_btc WHERE id=#{id}")
    int delete(int id) throws SQLException;
}
