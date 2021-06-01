/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   HistorialComprasMapper.java
 * Tipo:        Interface
 * AUTOR:       Luis Martinez (LMtz)
 * Fecha:       Jueves 19 de Mayo de 2021 (09_25)
 *
 * Historia:    .
 *              0210519_0925 Creación de éste Mapper
 *
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import io.kebblar.petstore.api.model.domain.HistorialCompras;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'AdministracionCompras'.
 *
 * @author  LMtz
 * @see     io.kebblar.petstore.api.model.domain.AdministracionCompras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface HistorialComprasMapper {
	
    /**
     * Obtiene todas las compras hechas por un usuario.
     *
     * @param int idUsuario el id del usuario del que queremos saber sus compras.
     * @return Una lista de las compras hechas por un usuario.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="HistorialMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "fechaHoraCompra", column = "fecha_hora_comprar"),
            @Result(property = "estadoEnvio", column = "estado_envio"),
            @Result(property = "nombreAnuncio", column = "nombre_anuncio"),
            @Result(property = "metodoPago", column = "tipo"),
            @Result(property = "correo", column = "correo"),
            @Result(property = "urlPdf", column = "recibo"),
            @Result(property = "urlImagen", column = "imagen"),
        })
    @Select("SELECT id,DATE_FORMAT(fecha_hora_comprar, '%d/%m/%y') as fecha_hora_comprar,estado_envio,nombre_anuncio,tipo,correo,recibo,imagen,id_usuario FROM historial_compras WHERE id_usuario = #{idUsuario}; ") 
    List<HistorialCompras> getAll(@Param("idUsuario") int idUsuario) throws SQLException;
}
