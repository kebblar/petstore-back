/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   DireccionMapper.java
 * Tipo:        Interface
 * AUTOR:       Fabiola Camilo Victoriano (FCV)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_26)
 *
 * Historia:    .
 *              20210506_0926 Creación de éste Mapper
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import io.kebblar.petstore.api.model.domain.UsuarioDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Direccion;

import static io.kebblar.petstore.api.mapper.constants.Campos.CAMPOS_DIRECCION;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Direccion'.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface DireccionMapper {

    /**
     * Obtiene un objeto de tipo {@link Direccion} realizando la búsqueda con base a un id en especifico.
     *
     * @param direccion mail del usuario.
     * @return el {@link Direccion} encontrado con el criterio de búsqueda.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="DireccionMap", value = {
        @Result(property = "id",          column = "id"),
        @Result(property = "calleNumero", column = "calle_numero"),
        @Result(property = "colonia",     column = "colonia"),
        @Result(property = "idPais",      column = "id_pais"),
        @Result(property = "idEstado",    column = "id_estado"),
        @Result(property = "idMunicipio", column = "id_municipio"),
        @Result(property = "idTipoDireccion", column = "id_tipo_direccion"),
        @Result(property = "cp",          column = "cp"),
        @Result(property = "referencias", column = "referencias"),
        @Result(property = "activo",      column = "activo")
    })
    @Select("SELECT " + CAMPOS_DIRECCION + " FROM direccion WHERE id = #{id} ")
    Direccion getById(Direccion direccion) throws SQLException;

    /**
     * Obtiene una lista de objetos {@link Direccion}.
     *
     * @return Lista de objetos de tipo usuario
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("DireccionMap")
    @Select("SELECT " + CAMPOS_DIRECCION + " FROM direccion ")
    List<Direccion> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo {@link Direccion} con base en la información dada por el objeto de tipo {@link Direccion}.
     *
     * @param direccion {@link Direccion} a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO direccion(id, calle_numero, colonia, id_pais, id_estado, id_municipio, id_tipo_direccion, cp, referencias, activo) VALUES(#{id}, #{calleNumero}, #{colonia}, #{idPais}, #{idEstado}, #{idMunicipio}, #{idTipoDireccion}, #{cp}, #{referencias}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(Direccion direccion) throws SQLException;

    /**
     * Actualiza un objeto de tipo {@link Direccion} con base en la infrmación dada por el objeto de tipo {@link Direccion}.
     *
     * @param direccion {@link Direccion} a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE direccion SET calle_numero = #{calleNumero}, colonia = #{colonia}, id_pais = #{idPais}, id_estado = #{idEstado}, id_municipio = #{idMunicipio}, id_tipo_direccion = #{idTipoDireccion}, cp = #{cp}, referencias = #{referencias}, activo = #{activo} WHERE id = #{id} ")
    int update(Direccion direccion) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de {@link Direccion} .
     *
     * @param id del {@link Direccion}  a ser borrado
     * @return id del {@link Direccion}  borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE direccion SET activo=false WHERE id_usuario = #{id}")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos {@link Direccion}.
     *
     * @return Lista de obetos de tipo usuario
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("DireccionMap")
    @Select("select direccion.* from direccion, usuario_direccion where direccion.id=usuario_direccion.id_direccion and direccion.activo=true and id_usuario=#{idUser}")
    List<Direccion> getUserDirecciones(int idUser) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'DireccionConNombre' dado su id.
     *
     * @return DireccionConNombre que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="DireccionNombreMap", value = {
            @Result(property = "id",          column = "id_direccion"),
            @Result(property = "calleNumero", column = "calle_numero"),
            @Result(property = "colonia",     column = "colonia"),
            @Result(property = "cp",          column = "cp"),
            @Result(property = "municipioNombre", column = "municipio_nombre"),
            @Result(property = "estadoNombre",    column = "estado_nombre"),
            @Result(property = "paisNombre",      column = "pais_nombre")
    })
    @Select("SELECT id_direccion, calle_numero, colonia, cp, municipio_nombre, estado_nombre, pais_nombre " +
            "from usuario_direccion inner join direccion_con_nombre on id=id_direccion and id_usuario=#{id} and activo=true")
    List<DireccionConNombre> getDireccionesNombre(int id) throws SQLException;

    /**
     * Agrega a la tabla de intersección de usuarios y direcciones un nuevo elemento.
     * @param ud Elemento que corresponde al id del usuario y el id de la dirección relacionados.
     * @return Un entero si es que salió bien la consulta.
     */

    @Insert("INSERT INTO usuario_direccion(id_usuario, id_direccion) VALUES( #{idUsuario} , #{idDireccion} )")
    int insertUsuarioDireccion(UsuarioDireccion ud) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'DireccionConNombre' dado el id direccion y id usuario.
     *
     * @return DireccionConNombre que tiene asignado el id dirección y id usuario como parámetro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="DireccionEnvioMap", value = {
            @Result(property = "id",          column = "id_direccion"),
            @Result(property = "calleNumero", column = "calle_numero"),
            @Result(property = "colonia",     column = "colonia"),
            @Result(property = "cp",          column = "cp"),
            @Result(property = "municipioNombre", column = "municipio_nombre"),
            @Result(property = "estadoNombre",    column = "estado_nombre"),
            @Result(property = "paisNombre",      column = "pais_nombre")
    })
    @Select("SELECT id_direccion, calle_numero, colonia, cp, municipio_nombre, estado_nombre, pais_nombre " +
            "from usuario_direccion inner join direccion_con_nombre on id=id_direccion and id_usuario=#{idUser} and id_direccion=#{idDir} and activo=true")
    List<DireccionConNombre> getDireccionEnvio(int idUser, int idDir);
}
