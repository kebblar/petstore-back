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
 * Artefacto:   UsuarioCompletoMapper .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Sunday 06 de June de 2021 (09_35)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210627_0935 Implementación de interface 
 *
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
 *
 * @see io.kebblar.petstore.api.model.domain.UsuarioCompleto
 */
@Repository
public interface UsuarioCompletoMapper {

    static final String CAMPOS_USER_C = " id, correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, nick_name, telefono_celular ";

    /**
     * Obtiene un objeto de tipo 'UsuarioCompleto' dado su id.
     *
     * @return UsuarioCompleto que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
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
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
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
     * 
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE usuario" 
    + " SET activo = #{activo}, acceso_negado_contador = #{accesoNegadoContador}, instante_bloqueo = #{instanteBloqueo}, instante_ultimo_acceso = #{instanteUltimoAcceso}, instante_ultimo_cambio_clave = #{instanteUltimoCambioClave}, regenera_clave_token = #{regeneraClaveToken}, regenera_clave_instante = #{regeneraClaveInstante}"
    + " WHERE id = #{id}")
    int updateUsuarioPlano(Usuario usuario) throws SQLException;

    /**
     * Cuenta el número de usuarios.
     * @return Entero representando el número de usuarios
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Select("SELECT count(*) from usuario_completo ")
    int countUsuarios() throws SQLException;

    /**
     *
     * @param startRow
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @ResultMap("UsuarioCompletoMap")
    @Select("SELECT " + CAMPOS_USER_C + " FROM usuario_completo LIMIT #{startRow},#{pageSize}")
    List<UsuarioCompleto> getAllPaginated(int startRow, int pageSize) throws SQLException;    
}
