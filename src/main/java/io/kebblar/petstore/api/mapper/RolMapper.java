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
 * Artefacto:   RolMapper .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       jueves 06 de junio de 2021 (17_26)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210624_1726 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Rol;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Rol
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.Rol
 */

@Repository
public interface RolMapper {
    static final String CAMPOS = " id, nombre, activo ";

    @Select("SELECT id, nombre, activo FROM rol")
    List<Rol> getAll() throws SQLException;

    @Select("SELECT id, nombre, activo FROM rol WHERE id = #{id} and activo=true")
    Rol getRol(int id) throws SQLException;

    @Select("select rol.* from usuario, rol, usuario_rol WHERE usuario.id=usuario_rol.id_usuario and usuario.id=#{idUser} and rol.id=usuario_rol.id_rol and rol.activo=true;")
    List<Rol> getUserRoles(int idUser) throws SQLException;

    @Insert("INSERT INTO usuario_rol VALUES(#{idUsuario}, #{idRol})")
    int insertUserRol(int idUsuario, int idRol) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'Rol' dado su id.
     *
     * @return Rol que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="RolMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS + " FROM rol WHERE     id = #{id}     ")
    Rol getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Rol'.
     *
     * @return Lista de obetos de tipo Rol
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("RolMap")
    @Select("SELECT " + CAMPOS + " FROM rol ")
    List<Rol> getAllSinFiltros() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Rol' con base en la información dada por el objeto de tipo 'Rol'.
     *
     * @param rol a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO rol(id, nombre, activo) "
   + "VALUES(#{id}, #{nombre}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Rol rol) throws SQLException;

/**
     * Actualiza un objeto de tipo 'Rol' con base en la infrmación dada por el objeto de tipo 'Rol'.
     *
     * @param rol a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE rol"
    + " SET nombre = #{nombre}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(Rol rol) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Rol.
     *
     * @param id id del Rol a ser borrado
     * @return id del Rol borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM rol WHERE id = #{id} ")
    int delete(int id) throws SQLException;

}