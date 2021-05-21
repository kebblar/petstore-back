package io.kebblar.petstore.api.mapper;

import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.domain.TransaccionBtc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface CriptoMapper {

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
}
