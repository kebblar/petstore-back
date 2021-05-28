/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UsuarioDetalleMapper.java
 * Tipo:        interface 
 * AUTOR:       Gustavo A. Arellano
 * Fecha:       Martes 04 de Mayo de 2021 (14_01)
 *
 * Historia:    .
 *              20210504_1401 Creación de éste Mapper
 */

package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad {@link UsuarioDetalle} 
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.UsuarioDetalle
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 * 
 */
@Repository
public interface UsuarioDetalleMapper {
    static final String CAMPOS = " id_usuario, nombre, apellido_paterno, apellido_materno, nick_name, fecha_nacimiento, telefono_celular ";

    /**
     * Obtiene un objeto de tipo '{@link UsuarioDetalle} ' realizando la búsqueda con base en el 'id' del Usuario.
     *
     * @param idUsuario representa el identificador de un objeto {@link UsuarioDetalle} .
     * @return el {@link UsuarioDetalle}  encontrado con el criterio de búsqueda.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="UsuarioDetalleMap", value = {
        @Result(property = "id", column = "id_usuario"),
        @Result(property = "nombre", column = "nombre"),
        @Result(property = "apellidoPaterno", column = "apellido_paterno"),
        @Result(property = "apellidoMaterno", column = "apellido_materno"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "fechaNacimiento", column = "fecha_nacimiento"),
        @Result(property = "telefonoCelular", column = "telefono_celular")    
    })
    @Select("SELECT " + CAMPOS + " FROM usuario_detalle WHERE id_usuario = #{idUsuario} ") 
    UsuarioDetalle getById(int idUsuario) throws SQLException;
    
    /**
     * Obtiene una lista de objetos de tipo {@link UsuarioDetalle} .
     *
     * @return Lista de objetos de tipo {@link UsuarioDetalle} 
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("UsuarioDetalleMap")
    @Select("SELECT " + CAMPOS + " FROM usuario_detalle ") 
    List<UsuarioDetalle> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo {@link UsuarioDetalle}  con base en la información dada por el objeto de tipo 'UsuarioDetalle'.
     *
     * @param usuarioDetalle objeto de tipo {@link UsuarioDetalle} a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO usuario_detalle(id_usuario, nombre, apellido_paterno, apellido_materno, nick_name, fecha_nacimiento, telefono_celular) VALUES(#{id}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno}, #{nickName}, #{fechaNacimiento}, #{telefonoCelular} )")
    Integer insert(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Actualiza un objeto de tipo {@link UsuarioDetalle} con base en la información dada por el objeto de tipo 'UsuarioDetalle'.
     *
     * @param usuarioDetalle objeto de tipo {@link UsuarioDetalle} a ser actualizado.
     * @return el número de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE usuario_detalle SET nombre = #{nombre}, apellido_paterno = #{apellidoPaterno}, apellido_materno = #{apellidoMaterno}, fecha_nacimiento = #{fechaNacimiento}, nick_name = #{nickName}, telefono_celular = #{telefonoCelular} WHERE id_usuario = #{id} ")
    Integer update(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de {@link UsuarioDetalle}.
     * 
     * @param id que representa el identificador del usuario a borrar
     * @return id del usuario borrado
     * @throws SQLException dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM usuario_detalle WHERE id_usuario = #{id} ") 
    Integer delete(int id) throws SQLException;

}
