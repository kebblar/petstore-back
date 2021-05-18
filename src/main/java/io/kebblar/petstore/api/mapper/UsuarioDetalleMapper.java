/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      UsuarioDetalle
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Thursday 04 de April de 2021 (14_01)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad UsuarioDetalle 
 *
 * Historia:    .
 *              20210422_1401 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
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
 * Interface 'Mapper' MyBatis asociado a la entidad UsuarioDetalle 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface UsuarioDetalleMapper {
    static final String CAMPOS = " id_usuario, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, nick_name, telefono_celular ";

    @Results(id="UsuarioDetalleMap", value = {
        @Result(property = "id", column = "id_usuario"),
        @Result(property = "nombre", column = "nombre"),
        @Result(property = "apellidoPaterno", column = "apellido_paterno"),
        @Result(property = "apellidoMaterno", column = "apellido_materno"),
        @Result(property = "fechaNacimiento", column = "fecha_nacimiento"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "telefonoCelular", column = "telefono_celular")    
    })
    @Select("SELECT " + CAMPOS + " FROM usuario_detalle WHERE id_usuario = #{idUsuario} ") 
    UsuarioDetalle getById(int idUsuario) throws SQLException;

    @ResultMap("UsuarioDetalleMap")
    @Select("SELECT " + CAMPOS + " FROM usuario_detalle ") 
    List<UsuarioDetalle> getAll() throws SQLException;
    
    @Insert("INSERT INTO usuario_detalle(id_usuario, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, nick_name, telefono_celular) VALUES(#{idUsuario}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno}, #{fechaNacimiento}, #{nickName}, #{telefonoCasa}, #{telefonoCelular} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(UsuarioDetalle usuarioDetalle) throws SQLException;

    @Update("UPDATE usuario_detalle SET nombre = #{nombre}, apellido_paterno = #{apellidoPaterno}, apellido_materno = #{apellidoMaterno}, fecha_nacimiento = #{fechaNacimiento}, nick_name = #{nickName}, telefono_celular = #{telefonoCelular} WHERE id_usuario = #{idUsuario} ")
    int update(UsuarioDetalle usuarioDetalle) throws SQLException;

    @Delete("DELETE FROM usuario_detalle WHERE id_usuario = #{idUsuario} ") 
    int delete(int id) throws SQLException;

}
