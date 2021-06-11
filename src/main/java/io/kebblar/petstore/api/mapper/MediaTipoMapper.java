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
 * Artefacto:   MediaTipoMapper .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (23_19)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210605_2319 Implementación de interface 
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.MediaTipo;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad MediaTipo 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.MediaTipo
 */
@Repository
public interface MediaTipoMapper {
    static final String CAMPOS = " id, descripcion, activo ";

    /**
     * Obtiene un objeto de tipo 'MediaTipo' dado su id.
     *
     * @return MediaTipo que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="MediaTipoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "descripcion",   column = "descripcion"),
            @Result(property = "activo",   column = "activo")    
    })
    @Select("SELECT " + CAMPOS + " FROM media_tipo WHERE     id = #{id}     ") 
    MediaTipo getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'MediaTipo'.
     *
     * @return Lista de obetos de tipo MediaTipo
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("MediaTipoMap")
    @Select("SELECT " + CAMPOS + " FROM media_tipo ") 
    List<MediaTipo> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'MediaTipo' con base en la información dada por el objeto de tipo 'MediaTipo'.
     *
     * @param mediaTipo a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO media_tipo(id, descripcion, activo) "
   + "VALUES(#{id}, #{descripcion}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(MediaTipo mediaTipo) throws SQLException;

/**
     * Actualiza un objeto de tipo 'MediaTipo' con base en la infrmación dada por el objeto de tipo 'MediaTipo'.
     *
     * @param mediaTipo a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE media_tipo" 
    + " SET descripcion = #{descripcion}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(MediaTipo mediaTipo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de MediaTipo.
     *
     * @param id id del MediaTipo a ser borrado
     * @return id del MediaTipo borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM media_tipo WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'MediaTipo' filtrado por el nombre ingresado.
     *
     * @param  String nombre de MediaTipo.
     * @return Lista de objetos de tipo MediaTipo filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("MediaTipoMap")
    @Select("SELECT " + CAMPOS + " FROM media_tipo WHERE descripcion LIKE '%' #{nombre} '%'") 
    List<MediaTipo> getByNombre(String nombre) throws SQLException;
}
