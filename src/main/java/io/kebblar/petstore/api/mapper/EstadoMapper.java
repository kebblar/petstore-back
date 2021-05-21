/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   EstadoMapper.java
 * Tipo:        interface
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (19_14)
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Mapper
 *              20210516_0214 Creación del método getByNombre
 *              20210516_0214 Creación del método getEstadosByPais
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.domain.Pais;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Estado 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface EstadoMapper {
    static final String CAMPOS = " id, id_pais, nombre ";

    /**
     * Obtiene una lista de objetos de tipo 'estado'.
     *
     * @param  int id del estado.
     * @return Lista de obetos de tipo estado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="EstadoMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idPais", column = "id_pais"),
        @Result(property = "nombre", column = "nombre")  
    })
    @Select("SELECT " + CAMPOS + " FROM estado WHERE id = #{id} ") 
    Estado getById(Estado estado) throws SQLException;

    @Results(id="EstadoNombreMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idPais", column = "id_pais"),
            @Result(property = "nombrePais", column = "nombre_pais"),
            @Result(property = "nombre", column = "nombre")  
        })
    
    /**
     * Obtiene una lista de objetos de tipo 'estado' haciedo INNER JOIN con la tabla Pais para la obtencion del nombre del Pais.
     *
     * @return Lista de obetos de tipo estado 
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Select("SELECT e.id, e.id_pais, e.nombre, p.nombre as nombre_pais FROM estado e INNER JOIN pais p on  p.id=e.id_pais ") 
    List<Estado> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'Estado' con base en la información dada por el objeto de tipo 'estado'.
     *
     * @param  Estado a ser insertado.
     * @return El auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO estado(id_pais, nombre) VALUES(#{idPais}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Estado estado) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Estado' con base en la infrmación dada por el objeto de tipo 'estado'.
     *
     * @param  Estado a ser actualizado.
     * @return El numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE estado SET id_pais = #{idPais}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Estado estado) throws SQLException;

    /**
     * Borra (de manera física) el registro de estado.
     *
     * @param  id id del estado a ser borrado
     * @return El numero de registros borrados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM estado WHERE id = #{id} ") 
    int delete(int id) throws SQLException;
    
    /**
     * Obtiene una lista de objetos de tipo 'estado' filtrado por el nombre ingresado.
     *
     * @param  String nombre del estado.
     * @return Lista de objetos de tipo estado filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("EstadoMap")
    @Select("SELECT " + CAMPOS + " FROM estado WHERE nombre LIKE '%' #{nombre} '%'") 
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
