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
 * Artefacto:   PaqueteriaMapper .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Paqueteria;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Paqueteria.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Paqueteria
 */

@Repository
public interface PaqueteriaMapper {

    static final String CAMPOS_PAQ = " id, nombre, breve_descripcion, html_descripcion, precio ";

    /**
     * Obtiene un objeto de tipo 'Paqueteria' dado su id.
     *
     * @return Paqueteria que tiene asignado el id pasado como parámetro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="PaqueteriaMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "breveDescripcion",   column = "breve_descripcion"),
            @Result(property = "htmlDescripcion",   column = "html_descripcion"),
            @Result(property = "precio",   column = "precio")
    })
    @Select("SELECT " + CAMPOS_PAQ + " FROM paqueteria WHERE     id = #{id}     ")
    Paqueteria getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Paqueteria'.
     *
     * @return Lista de obetos de tipo Paqueteria
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaqueteriaMap")
    @Select("SELECT " + CAMPOS_PAQ + " FROM paqueteria ")
    List<Paqueteria> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Paqueteria' con base en la información dada por el objeto de tipo 'Paqueteria'.
     *
     * @param paqueteria a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO paqueteria(id, nombre, breve_descripcion, html_descripcion, precio) "
   + "VALUES(#{id}, #{nombre}, #{breveDescripcion}, #{htmlDescripcion}, #{precio} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Paqueteria paqueteria) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Paqueteria' con base en la infrmación dada por el objeto de tipo 'Paqueteria'.
     *
     * @param paqueteria a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE paqueteria"
    + " SET nombre = #{nombre}, breve_descripcion = #{breveDescripcion}, html_descripcion = #{htmlDescripcion}, precio = #{precio}"
    + " WHERE id = #{id} ")
    int update(Paqueteria paqueteria) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Paqueteria.
     *
     * @param id id del Paqueteria a ser borrado
     * @return id del Paqueteria borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM paqueteria WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'paqueteria' filtrado por el nombre ingresado.
     *
     * @param nombre la paqueteria.
     * @return Lista de objetos de tipo paqueteria filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaqueteriaMap")
    @Select("SELECT " + CAMPOS_PAQ + " FROM paqueteria WHERE nombre LIKE '%' #{nombre} '%'")
    List<Paqueteria> getByNombre(String nombre) throws SQLException;

}
