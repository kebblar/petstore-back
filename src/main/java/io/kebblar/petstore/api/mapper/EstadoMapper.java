
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
 * Artefacto:   EstadoMapper .java
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
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Estado;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Estado 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Estado
 */

@Repository
public interface EstadoMapper {
    static final String CAMPOS = " id, id_pais, nombre ";

    /**
     * Obtiene un objeto de tipo 'Estado' dado su id.
     *
     * @return Estado que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="EstadoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idPais",   column = "id_pais"),
            @Result(property = "nombre",   column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM estado WHERE     id = #{id}     ") 
    Estado getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Estado'.
     *
     * @return Lista de obetos de tipo Estado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("EstadoMap")
    @Select("SELECT " + CAMPOS + " FROM estado ") 
    List<Estado> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'Estado' con base en la información dada por el objeto de tipo 'Estado'.
     *
     * @param estado a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO estado(id, id_pais, nombre) "
   + "VALUES(#{id}, #{idPais}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Estado estado) throws SQLException;

/**
     * Actualiza un objeto de tipo 'Estado' con base en la infrmación dada por el objeto de tipo 'Estado'.
     *
     * @param estado a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE estado" 
    + " SET id_pais = #{idPais}, nombre = #{nombre}"
    + " WHERE id = #{id} ")
    int update(Estado estado) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Estado.
     *
     * @param id id del Estado a ser borrado
     * @return id del Estado borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM estado WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

    /**
     *
     * @param id
     * @return Esta
     * @throws SQLException
     */
    @Select("SELECT " + CAMPOS + " FROM estado WHERE id_pais=#{id}" )
    List<Estado> getByPais(int id) throws SQLException;
}
