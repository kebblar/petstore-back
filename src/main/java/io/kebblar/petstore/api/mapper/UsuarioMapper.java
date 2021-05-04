/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   UsuarioMapper.java
 * Tipo:        interface
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (19_14)
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Mapper
 *
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Usuario;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Usuario'.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Repository
public interface UsuarioMapper {
    static final String CAMPOS = " id, correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, "
            + "instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante ";

    /**
     * Obtiene una lista de objetos de tipo 'usuario'.
     *
     * @return Lista de obetos de tipo usuario
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="UsuarioMap", value = {
        @Result(property = "id",     column = "id"),
        @Result(property = "correo", column = "correo"),
        @Result(property = "clave",  column = "clave"),
        @Result(property = "creado", column = "creado"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "accesoNegadoContador",      column = "acceso_negado_contador"),
        @Result(property = "instanteBloqueo",           column = "instante_bloqueo"),
        @Result(property = "instanteUltimoAcceso",      column = "instante_ultimo_acceso"),
        @Result(property = "instanteUltimoCambioClave", column = "instante_ultimo_cambio_clave"),
        @Result(property = "regeneraClaveToken",        column = "regenera_clave_token"),
        @Result(property = "regeneraClaveInstante",     column = "regenera_clave_instante")
        })
    @Select("SELECT " + CAMPOS + " FROM usuario WHERE id = #{id} ")
    Usuario getById(int id) throws SQLException;

    /**
     * Obtiene la lista de todos los tipo 'Usuario'
     * @return Lista de objetos de tipo 'Usuario'
     * @throws SQLException Se dispara en caso de que se dispare 
     * un error en esta operación desde la base de datos.
     */
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS + " FROM usuario ")
    List<Usuario> getAll() throws SQLException;

    /**
     * Obtiene la lista de todos los objetos de tipo 
     * 'Usuario' ordenados por correo de manera ascendente.
     * @return Lista de objetos de tipo 'Usuario'
     * @throws SQLException Se dispara en caso de que se dispare 
     * un error en esta operación desde la base de datos.
     */
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS + " FROM usuario order by correo asc")
    List<Usuario> getAllAscendingByCorreo() throws SQLException;

    /**
     * Obtiene un objeto de tipo 'usuario' realizando la búsqueda con base en el 'mail' del Usuario.
     *
     * @param String mail del usuario.
     * @return el usuario encontrado con el criterio de búsqueda.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS + " FROM usuario WHERE correo = #{correo} ")
    Usuario getByCorreo(String correo) throws SQLException;

    /**
     * Inserta un objeto de tipo 'usuario' con base en la información dada por el objeto de tipo 'usuario'.
     *
     * @param Usuario a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO usuario(correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, "
            + "instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante) "
            + "VALUES(#{correo}, #{clave}, #{creado}, #{activo}, #{accesoNegadoContador}, #{instanteBloqueo}, "
            + "#{instanteUltimoAcceso}, #{instanteUltimoCambioClave}, #{regeneraClaveToken}, #{regeneraClaveInstante} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Usuario usr) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'usuario' con base en la infrmación dada por el objeto de tipo 'usuario'.
     *
     * @param Usuario a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE usuario SET correo = #{correo}, clave = #{clave}, creado = #{creado}, activo = #{activo}, "
            + "acceso_negado_contador = #{accesoNegadoContador}, instante_bloqueo = #{instanteBloqueo}, "
            + "instante_ultimo_acceso = #{instanteUltimoAcceso}, instante_ultimo_cambio_clave = #{instanteUltimoCambioClave}, "
            + "regenera_clave_token = #{regeneraClaveToken}, regenera_clave_instante = #{regeneraClaveInstante} "
            + "WHERE id = #{id} ")
    int update(Usuario usr) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de usuario.
     *
     * @param id id del usuario a ser borrado
     * @return id del usuario borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("Update usuario SET actvo=false where id=#{id}")
    int delete(int id) throws SQLException;

}
