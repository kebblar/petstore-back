
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
 * Artefacto:   UsuarioDetalleMapper .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       viernes 05 de mayo de 2021 (21_01)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210521_2101 Implementación de interface 
 *
 */

package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad UsuarioDetalle 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.UsuarioDetalle
 */

@Repository
public interface UsuarioDetalleMapper {
    static final String CAMPOS = " id_usuario, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, nick_name, telefono_celular ";

    /**
     * Obtiene un objeto de tipo 'UsuarioDetalle' dado su id.
     *
     * @return UsuarioDetalle que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="UsuarioDetalleMap", value = {
            @Result(property = "idUsuario",   column = "id_usuario"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "apellidoPaterno",   column = "apellido_paterno"),
            @Result(property = "apellidoMaterno",   column = "apellido_materno"),
            @Result(property = "fechaNacimiento",   column = "fecha_nacimiento"),
            @Result(property = "nickName",   column = "nick_name"),
            @Result(property = "telefonoCelular",   column = "telefono_celular")    
    })
    @Select("SELECT " + CAMPOS + " FROM usuario_detalle WHERE     id_usuario = #{idUsuario}     ") 
    UsuarioDetalle getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'UsuarioDetalle'.
     *
     * @return Lista de obetos de tipo UsuarioDetalle
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("UsuarioDetalleMap")
    @Select("SELECT " + CAMPOS + " FROM usuario_detalle ") 
    List<UsuarioDetalle> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'UsuarioDetalle' con base en la información dada por el objeto de tipo 'UsuarioDetalle'.
     *
     * @param usuarioDetalle a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO usuario_detalle(id_usuario, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, nick_name, telefono_celular) "
   + "VALUES(#{idUsuario}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno}, #{fechaNacimiento}, #{nickName}, #{telefonoCelular} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(UsuarioDetalle usuarioDetalle) throws SQLException;

/**
     * Actualiza un objeto de tipo 'UsuarioDetalle' con base en la infrmación dada por el objeto de tipo 'UsuarioDetalle'.
     *
     * @param usuarioDetalle a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE usuario_detalle" 
    + " SET nombre = #{nombre}, apellido_paterno = #{apellidoPaterno}, apellido_materno = #{apellidoMaterno}, fecha_nacimiento = #{fechaNacimiento}, nick_name = #{nickName}, telefono_celular = #{telefonoCelular}"
    + " WHERE id_usuario = #{idUsuario} ")
    int update(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de UsuarioDetalle.
     *
     * @param id id del UsuarioDetalle a ser borrado
     * @return id del UsuarioDetalle borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM usuario_detalle WHERE id_usuario = #{idUsuario} ") 
    int delete(int id) throws SQLException;

}
