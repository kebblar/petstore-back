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
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      Direccion
 * Tipo:        interface 
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * 
 * Interface 'Mapper' MyBatis asociado a la entidad Direccion 
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Mapper
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
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
    static final String CAMPOS = " id, calle_numero, colonia, id_pais, id_estado, id_municipio, id_tipo_direccion, cp, referencias, activo ";

    /**
     * Obtiene un objeto de tipo {@link Dirreccion} realizando la búsqueda con base a un id en especifico.
     *
     * @param String mail del usuario.
     * @return el {@link Dirreccion} encontrado con el criterio de búsqueda.
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
    @Select("SELECT " + CAMPOS + " FROM direccion WHERE id = #{id} ") 
    Direccion getById(Direccion direccion) throws SQLException;

    /**
     * Obtiene una lista de objetos {@link Dirreccion}.
     *
     * @return Lista de obetos de tipo usuario
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("DireccionMap")
    @Select("SELECT " + CAMPOS + " FROM direccion ") 
    List<Direccion> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo {@link Dirreccion} con base en la información dada por el objeto de tipo {@link Dirreccion}.
     *
     * @param {@link Dirreccion} a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO direccion(id, calle_numero, colonia, id_pais, id_estado, id_municipio, id_tipo_direccion, cp, referencias, activo) VALUES(#{id}, #{calleNumero}, #{colonia}, #{idPais}, #{idEstado}, #{idMunicipio}, #{idTipoDireccion}, #{cp}, #{referencias}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Direccion direccion) throws SQLException;

    /**
     * Actualiza un objeto de tipo {@link Dirreccion} con base en la infrmación dada por el objeto de tipo {@link Dirreccion}.
     *
     * @param {@link Dirreccion} a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE direccion SET calle_numero = #{calleNumero}, colonia = #{colonia}, id_pais = #{idPais}, id_estado = #{idEstado}, id_municipio = #{idMunicipio}, id_tipo_direccion = #{idTipoDireccion}, cp = #{cp}, referencias = #{referencias}, activo = #{activo} WHERE id = #{id} ")
    int update(Direccion direccion) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de {@link Dirreccion} .
     *
     * @param id del {@link Dirreccion}  a ser borrado
     * @return id del {@link Dirreccion}  borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM direccion WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos {@link Dirreccion}.
     *
     * @return Lista de obetos de tipo usuario
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("DireccionMap")
    @Select("select direccion.* from direccion, usuario_direccion where direccion.id=usuario_direccion.id_direccion and direccion.activo=true and id_usuario=#{idUser}")
    List<Direccion> getUserDirecciones(int idUser) throws SQLException;

}
