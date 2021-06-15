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
 *              20210516_0214 Creación del método getByNombre
 *              20210516_0214 Creación del método getEstadosByPais *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Estado;

/**
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
    @Insert("INSERT INTO estado(id, id_pais, nombre) VALUES(#{id}, #{idPais}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Estado estado) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Estado' con base en la infrmación dada por el objeto de tipo 'Estado'.
     *
     * @param estado a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE estado SET id_pais = #{idPais}, nombre = #{nombre} WHERE id = #{id} ")
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
     * Dado el id de un pais, se retornan todos los estados que pertenecen a este.
     * @param id id del país que contiene a los estados retornados.
     * @return Lista de estados pertenecientes al país recibido.
     * @throws SQLException Si ocurre un error en la consulta o en el sistema.
     */
    @Select("SELECT " + CAMPOS + " FROM estado WHERE id_pais=#{id}" )
    List<Estado> getByPais(int id) throws SQLException;
    
    /**
     * Obtiene una lista de objetos de tipo 'estado' haciedo INNER JOIN con la tabla Pais para la obtencion del nombre del Pais.
     *
     * @return Lista de obetos de tipo estado 
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */	
    @Results(id="EstadoNombreMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idPais", column = "id_pais"),
            @Result(property = "nombrePais", column = "nombre_pais"),
            @Result(property = "nombre", column = "nombre")  
        })
    @Select("SELECT e.id, e.id_pais, e.nombre, p.nombre as nombre_pais FROM estado e INNER JOIN pais p on  p.id=e.id_pais ") 
    List<Estado> getAllNombrePais() throws SQLException;
    
    /**
     * Obtiene una lista de objetos de tipo 'estado' filtrado por el nombre ingresado.
     *
     * @param  String nombre del estado.
     * @return Lista de objetos de tipo estado filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("EstadoNombreMap")
    @Select("SELECT e.id, e.id_pais, e.nombre, p.nombre as nombre_pais FROM estado e INNER JOIN pais p on  p.id=e.id_pais WHERE e.nombre LIKE '%' #{nombre} '%'") 
    List<Estado> getByNombre(String nombre) throws SQLException;
    
    /**
     * Obtiene una lista de objetos de tipo 'estado' filtrado por el id ingresado.
     *
     * @param  int id del estado.
     * @return Lista de obetos de tipo estado filtrado por el id ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("EstadoMap")
    @Select("SELECT " + CAMPOS + " FROM estado WHERE id_pais = #{id} ") 
	List<Estado> getEstadosByPais(int idPais);

}
