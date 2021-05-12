
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
 * Artefacto:   PaisMapper .java
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
import io.kebblar.petstore.api.model.domain.Pais;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Pais 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Pais
 */

@Repository
public interface PaisMapper {
    static final String CAMPOS = " id, nombre ";

    /**
     * Obtiene un objeto de tipo 'Pais' dado su id.
     *
     * @return Pais que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="PaisMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM pais WHERE     id = #{id}     ") 
    Pais getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Pais'.
     *
     * @return Lista de obetos de tipo Pais
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS + " FROM pais ") 
    List<Pais> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'Pais' con base en la información dada por el objeto de tipo 'Pais'.
     *
     * @param pais a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO pais(id, nombre) "
   + "VALUES(#{id}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Pais pais) throws SQLException;

/**
     * Actualiza un objeto de tipo 'Pais' con base en la infrmación dada por el objeto de tipo 'Pais'.
     *
     * @param pais a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE pais" 
    + " SET nombre = #{nombre}"
    + " WHERE id = #{id} ")
    int update(Pais pais) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Pais.
     *
     * @param id id del Pais a ser borrado
     * @return id del Pais borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM pais WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
