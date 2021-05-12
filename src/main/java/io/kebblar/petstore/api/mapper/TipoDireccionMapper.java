
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
 * Artefacto:   TipoDireccionMapper .java
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
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.TipoDireccion;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad TipoDireccion 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see TipoDireccion
 */

@Repository
public interface TipoDireccionMapper {
    static final String CAMPOS = " id, nombre, activo ";

    /**
     * Obtiene un objeto de tipo 'TipoDireccion' dado su id.
     *
     * @return TipoDireccion que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="TipoDireccionMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "activo",   column = "activo")    
    })
    @Select("SELECT " + CAMPOS + " FROM tipo_direccion WHERE     id = #{id}     ") 
    TipoDireccion getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'TipoDireccion'.
     *
     * @return Lista de obetos de tipo TipoDireccion
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("TipoDireccionMap")
    @Select("SELECT " + CAMPOS + " FROM tipo_direccion ") 
    List<TipoDireccion> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'TipoDireccion' con base en la información dada por el objeto de tipo 'TipoDireccion'.
     *
     * @param tipoDireccion a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO tipo_direccion(id, nombre, activo) "
   + "VALUES(#{id}, #{nombre}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(TipoDireccion tipoDireccion) throws SQLException;

/**
     * Actualiza un objeto de tipo 'TipoDireccion' con base en la infrmación dada por el objeto de tipo 'TipoDireccion'.
     *
     * @param tipoDireccion a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE tipo_direccion" 
    + " SET nombre = #{nombre}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(TipoDireccion tipoDireccion) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de TipoDireccion.
     *
     * @param id id del TipoDireccion a ser borrado
     * @return id del TipoDireccion borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM tipo_direccion WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
