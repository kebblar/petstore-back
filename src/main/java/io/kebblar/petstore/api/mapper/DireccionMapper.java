/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      DireccionMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:07:30
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

    String CAMPOS_DIRECCION = " id, calle_numero, colonia, id_pais, id_estado, id_municipio, " +
            /** Constant <code>CAMPOS_DIRECCION=" id, calle_numero, colonia, id_pais, id"{trunked}</code> */
            "id_tipo_direccion, cp, referencias, activo ";

    /**
     * Obtiene un objeto de tipo {@link io.kebblar.petstore.api.model.domain.Direccion} realizando la búsqueda con base a un id en especifico.
     *
     * @param direccion mail del usuario.
     * @return el {@link io.kebblar.petstore.api.model.domain.Direccion} encontrado con el criterio de búsqueda.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
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
     * Obtiene una lista de objetos {@link io.kebblar.petstore.api.model.domain.Direccion}.
     *
     * @return Lista de objetos de tipo usuario
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("DireccionMap")
    @Select("SELECT " + CAMPOS_DIRECCION + " FROM direccion ")
    List<Direccion> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo {@link io.kebblar.petstore.api.model.domain.Direccion} con base en la información dada por el objeto de tipo {@link io.kebblar.petstore.api.model.domain.Direccion}.
     *
     * @param direccion {@link io.kebblar.petstore.api.model.domain.Direccion} a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO direccion(id, calle_numero, colonia, id_pais, id_estado, id_municipio, id_tipo_direccion, cp, referencias, activo) VALUES(#{id}, #{calleNumero}, #{colonia}, #{idPais}, #{idEstado}, #{idMunicipio}, #{idTipoDireccion}, #{cp}, #{referencias}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(Direccion direccion) throws SQLException;

    /**
     * Actualiza un objeto de tipo {@link io.kebblar.petstore.api.model.domain.Direccion} con base en la infrmación dada por el objeto de tipo {@link io.kebblar.petstore.api.model.domain.Direccion}.
     *
     * @param direccion {@link io.kebblar.petstore.api.model.domain.Direccion} a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE direccion SET calle_numero = #{calleNumero}, colonia = #{colonia}, id_pais = #{idPais}, id_estado = #{idEstado}, id_municipio = #{idMunicipio}, id_tipo_direccion = #{idTipoDireccion}, cp = #{cp}, referencias = #{referencias}, activo = #{activo} WHERE id = #{id} ")
    int update(Direccion direccion) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de {@link io.kebblar.petstore.api.model.domain.Direccion} .
     *
     * @param id del {@link io.kebblar.petstore.api.model.domain.Direccion}  a ser borrado
     * @return id del {@link io.kebblar.petstore.api.model.domain.Direccion}  borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE direccion SET activo=false WHERE id_usuario = #{id}")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos {@link io.kebblar.petstore.api.model.domain.Direccion}.
     *
     * @return Lista de obetos de tipo usuario
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param idUser a int.
     */
    @ResultMap("DireccionMap")
    @Select("select direccion.* from direccion, usuario_direccion where direccion.id=usuario_direccion.id_direccion and direccion.activo=true and id_usuario=#{idUser}")
    List<Direccion> getUserDirecciones(int idUser) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'DireccionConNombre' dado su id.
     *
     * @return DireccionConNombre que tiene asignado el id pasado como parametro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
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
     *
     * @param ud Elemento que corresponde al id del usuario y el id de la dirección relacionados.
     * @return Un entero si es que salió bien la consulta.
     * @throws java.sql.SQLException if any.
     */

    @Insert("INSERT INTO usuario_direccion(id_usuario, id_direccion) VALUES( #{idUsuario} , #{idDireccion} )")
    int insertUsuarioDireccion(UsuarioDireccion ud) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'DireccionConNombre' dado el id direccion y id usuario.
     *
     * @return DireccionConNombre que tiene asignado el id dirección y id usuario como parámetro
     * @param idUser a int.
     * @param idDir a int.
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
