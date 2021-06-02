package io.kebblar.petstore.api.mapper;

import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CriptoMapper {
    static final String CAMPOS = "id, id_usuario, id_direccion, wallet, id_anuncio, status, monto, fecha, descripcion";

    /**
     * Obtiene la direccion de la cartera digital de bitcoin del usuario cuyo id es introducido.
     * @param id Id del usuario del que se desea recuperar la cartera.
     * @return Cartera en forma de cadena
     * @throws SQLException Si hay un error en la recuperaci'on de esta.
     */
    @Results(id="CriptoMap", value = {
    @Result(property = "address", column = "address")
    })
    @Select("SELECT address FROM btc_wallet WHERE id_user = #{id} ")
    String getByUser(int id) throws SQLException;

    /**
     * Nos da el usuario al que est'a asociada una cartera bitcoin.
     * @param address Direccion de la cartera.
     * @return el id del usuario al que le pertenece la cartera.
     * @throws SQLException Si ocurre un problema en el proceso de recuperacion.
     */
    @Select("SELECT id_user FROM btc_wallet WHERE address = #{address} ")
    int getUserByAddress(String address) throws SQLException;

    /**
     * Inserta una nueva solicitud de orden a pagar con bitcoin en la base de datos.
     * @param transaccionBtc objeto con los datos de la orden si esta se genera.
     * @return entero si se inserta con 'exito el objeto.
     * @throws SQLException Si ocurre un problema de inserci'on.
     */
    @Insert("Insert into transaccion_btc(id_usuario, id_direccion, wallet, id_anuncio, status, monto, fecha, descripcion) VALUES (#{idUsuario}, #{idDireccion}, #{wallet}, #{idAnuncio}, #{status}, #{monto}, #{fecha}, #{descripcion})")
    int insertTransaccion(TransaccionBtc transaccionBtc) throws SQLException;

    /**
     * Regresa una lista de todos las transacciones pendientes de validacion.
     * @return Lista de transacciones que aun no aparecen en la blockchain.
     * @throws SQLException En caso que haya problemas recuperando la informacion.
     */
    @Results(id="TransaccionMap", value = {
            @Result(property = "id",          column = "id"),
            @Result(property = "idUsuario", column = "id_usuario"),
            @Result(property = "idDireccion",     column = "id_direccion"),
            @Result(property = "wallet",      column = "wallet"),
            @Result(property = "idAnuncio",    column = "id_anuncio"),
            @Result(property = "status", column = "status"),
            @Result(property = "monto", column = "monto"),
            @Result(property = "fecha",          column = "fecha"),
            @Result(property = "descripcion", column = "descripcion")
    })
    @Select("SELECT " +CAMPOS+ " FROM transaccion_btc WHERE status=false")
    List<TransaccionBtc> getAll() throws SQLException;

    /**
     * Eliminba una transaccion porporcionando su id.
     * @param id Id de la transaccion a eliminar.
     * @return Entero si se realizo la accion.
     * @throws SQLException En caso que haya problemas recuperando la informacion.
     */
    @Delete("DELETE from transaccion_btc WHERE id=#{id}")
    int delete(int id) throws SQLException;
}
