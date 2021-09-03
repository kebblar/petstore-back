/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 *              --------------------------------------------------
 * Paquete:     mx.qbits.unam.proyecto.api.mapper
 * Modulo:      Registro
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano
 * Fecha:       miércoles 08 de agosto de 2020 (00_58)
 * Version:     0.1.1-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Registro
 *
 * Historia:    .
 *              20200812_0058 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */
package io.kebblar.petstore.api.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.request.Preregistro;

import java.sql.SQLException;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Registro.
 *
 * @author Gustavo A. Arellano
 * @version 0.1.1-SNAPSHOT
 */
public interface RegistroMapper {

    String CAMPOS_REG = " id, nick, correo, clave_hash, telefono, fecha_nacimiento, random_string, " +
            "instante_registro ";

            /**
             * Recupera un elemento del preregistro utilizando el correo electrónico que ingresó.
             *
             * @param correo mail de registro
             * @return Objeto con la información de los datos del preregistro
             * @throws SQLException En caso de que haya un problema con la consulta
             */
    @Results(id="RegistroMap", value = {
            @Result(property = "id",  column = "id"),
            @Result(property = "nick",      column = "nick"),
            @Result(property = "correo",    column = "correo"),
            @Result(property = "claveHash", column = "clave_hash"),
            @Result(property = "telefono",  column = "telefono"),
            @Result(property = "fechaNacimiento",  column = "fecha_nacimiento"),
            @Result(property = "randomString",     column = "random_string"),
            @Result(property = "instanteRegistro", column = "instante_registro")
          })
    @Select("SELECT " + CAMPOS_REG + " FROM preregistro WHERE correo = #{correo} ")
    Preregistro getByMail(String correo) throws SQLException;

    /**
     * Recupera el registro por medio del código random generado.
     *
     * @param randomString código random generado
     * @return Objeto con la información de los datos del preregistro
     * @throws SQLException En caso de que haya un problema con la consulta
     */
    @ResultMap("RegistroMap")
    @Select("SELECT " + CAMPOS_REG + " FROM preregistro WHERE random_string = #{randomString} ")
    Preregistro getByRandomString(String randomString) throws SQLException;

    /**
     * Asocia un rol a determinado usuario.
     *
     * @param idUsuario id del usuario al que se le asociará el rol
     * @param idRol id del rol a asociar
     * @return Un entero que indica que la operación fue exitosa
     * @throws SQLException En caso de que haya un problema con la consulta
     */
    @Insert("INSERT into usuario_rol(id_usuario, id_rol) values(#{idUsuario}, #{idRol})")
    Integer asociateRol(int idUsuario, int idRol) throws SQLException;

    /**
     * Inserta un objeto de tipo 'usuario_detalle' con base en la información dada por el objeto de tipo 'usuarioDetalle'.
     *
     * @param usuarioDetalle a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO usuario_detalle(id_usuario, nombre, telefono, calle_y_numero, fecha_nacimiento, id_estado, id_municipio) VALUES(#{idUsuario}, #{nombre}, #{telefono},#{calleNumero}, #{fechaNacimiento}, #{idEstado}, #{idMunicipio} )")
    Integer insertUsuarioDetalles(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'usuario_detalle' con base en la información dada por el objeto de tipo 'usuarioDetalle'.
     *
     * @param usuarioDetalle a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE usuario_detalle SET nombre=#{nombre}, telefono=#{telefono}, calle_y_numero=#{calleNumero}, fecha_nacimiento=#{fechaNacimiento}, id_estado=#{idEstado}, id_municipio=#{idMunicipio} WHERE id_usuario=#{idUsuario}")
    Integer updateUsuarioDetalles(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Genera un usuario en la base de datos con los datos ya completos del preregistro.
     *
     * @param preregistro Datos de inscripción al sistema de un usuario
     * @return Entero que indica que la consulta tuvo éxito
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO preregistro(nick, clave_hash, correo, telefono, fecha_nacimiento, random_string, instante_registro) VALUES(#{nick}, #{claveHash}, #{correo}, #{telefono}, #{fechaNacimiento}, #{randomString}, #{instanteRegistro} ) ON DUPLICATE KEY UPDATE nick=#{nick}, telefono=#{telefono}, fecha_nacimiento=#{fechaNacimiento}, clave_hash=#{claveHash}, random_string=#{randomString}, instante_registro=#{instanteRegistro}")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    Integer insertRegistro(Preregistro preregistro) throws SQLException;

    /**
     * Modifica un preregistro ya existente.
     *
     * @param registro Datos del registro que se desea modificar
     * @return Entro que indica que se tuvo éxito en la modificación
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos
     */
    @Update("UPDATE preregistro SET nick = #{nick}, telefono = #{telefono}, fecha_nacimiento = #{fechaNacimiento}, clave_hash = #{claveHash}, random_string = #{randomString}, instante_registro = #{instanteRegistro} WHERE correo = #{correo} ")
    Integer update(Preregistro registro) throws SQLException;

    /**
     * Borra un preregistro existente por medio de su código.
     *
     * @param randomString Clave random asociada a un registro
     * @return Entro que indica que se tuvo éxito en la modificación
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos
     */
    @Select("DELETE FROM preregistro WHERE random_string = #{randomString} ")
    Integer deleteByRandomString(String randomString) throws SQLException;

}
