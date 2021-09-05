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
 * Nombre:      UsuarioCompletoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:11:11
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Usuario;
import io.kebblar.petstore.api.model.domain.UsuarioCompleto;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad UsuarioCompleto.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see io.kebblar.petstore.api.model.domain.UsuarioCompleto
 */
@Repository
public interface UsuarioCompletoMapper {

    /** Constant <code>CAMPOS_USER_C=" id, correo, clave, creado, activo, acc"{trunked}</code> */
    String CAMPOS_USER_C = " id, correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, nick_name, telefono_celular ";

    /**
     * Obtiene un objeto de tipo 'UsuarioCompleto' dado su id.
     *
     * @return UsuarioCompleto que tiene asignado el id pasado como parametro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="UsuarioCompletoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "correo",   column = "correo"),
            @Result(property = "clave",   column = "clave"),
            @Result(property = "creado",   column = "creado"),
            @Result(property = "activo",   column = "activo"),
            @Result(property = "accesoNegadoContador",   column = "acceso_negado_contador"),
            @Result(property = "instanteBloqueo",   column = "instante_bloqueo"),
            @Result(property = "instanteUltimoAcceso",   column = "instante_ultimo_acceso"),
            @Result(property = "instanteUltimoCambioClave",   column = "instante_ultimo_cambio_clave"),
            @Result(property = "regeneraClaveToken",   column = "regenera_clave_token"),
            @Result(property = "regeneraClaveInstante",   column = "regenera_clave_instante"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "apellidoPaterno",   column = "apellido_paterno"),
            @Result(property = "apellidoMaterno",   column = "apellido_materno"),
            @Result(property = "fechaNacimiento",   column = "fecha_nacimiento"),
            @Result(property = "nickName",   column = "nick_name"),
            @Result(property = "telefonoCelular",   column = "telefono_celular")
    })
    @Select("SELECT " + CAMPOS_USER_C + " FROM usuario_completo WHERE id=#{id}")
    UsuarioCompleto getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'UsuarioCompleto'.
     *
     * @return Lista de obetos de tipo UsuarioCompleto
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("UsuarioCompletoMap")
    @Select("SELECT " + CAMPOS_USER_C + " FROM usuario_completo ")
    List<UsuarioCompleto> getAll() throws SQLException;

    /**
     * OJO : Actualiza un objeto de tipo 'Usuario' con base en la
     * infrmación dada por el objeto de tipo 'UsuarioCompleto'.
     *
     * @param usuario a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE usuario"
    + " SET activo = #{activo}, acceso_negado_contador = #{accesoNegadoContador}, instante_bloqueo = #{instanteBloqueo}, instante_ultimo_acceso = #{instanteUltimoAcceso}, instante_ultimo_cambio_clave = #{instanteUltimoCambioClave}, regenera_clave_token = #{regeneraClaveToken}, regenera_clave_instante = #{regeneraClaveInstante}"
    + " WHERE id = #{id}")
    int updateUsuarioPlano(Usuario usuario) throws SQLException;

    /**
     * Cuenta el número de usuarios.
     *
     * @return Entero representando el número de usuarios
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Select("SELECT count(*) from usuario_completo ")
    int countUsuarios() throws SQLException;

    /**
     * <p>getAllPaginated.</p>
     *
     * @param startRow a int.
     * @param pageSize a int.
     * @throws java.sql.SQLException
     * @return a {@link java.util.List} object.
     */
    @ResultMap("UsuarioCompletoMap")
    @Select("SELECT " + CAMPOS_USER_C + " FROM usuario_completo LIMIT #{startRow},#{pageSize}")
    List<UsuarioCompleto> getAllPaginated(int startRow, int pageSize) throws SQLException;
}
