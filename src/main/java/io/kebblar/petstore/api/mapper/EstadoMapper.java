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
 * Fecha:       Lunes 4 de Mayo de 2021 (09_12)
 *
 * Historia:    .
 *              20210503_0912 Creación de éste Mapper
 *
 */

package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Estado;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Estado'.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Estado
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Repository
public interface EstadoMapper {
    static final String CAMPOS = " id, id_pais, nombre ";

    /**
     * Obtiene un objeto de tipo 'Estado'.
     * @param estado a buscar por su id
     * @return estado que coincida con el id dentro del objeto estado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="EstadoMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idPais", column = "id_pais"),
        @Result(property = "nombre", column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM estado WHERE id = #{id} ") 
    Estado getById(Estado estado) throws SQLException;

    /**
     * Obtiene la lista de todos los objetos de tipo Estado
     * @return lista de objetos de tipo "Estado"
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("EstadoMap")
    @Select("SELECT " + CAMPOS + " FROM estado ") 
    List<Estado> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'Estado' con base en la información dada por el objeto de tipo 'Estado'.
     *
     * @param Estado a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO estado(id_pais, nombre) VALUES(#{idPais}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Estado estado) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Estado' con base en la infrmación dada por el objeto de tipo 'Estado'.
     *
     * @param Estado a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE estado SET id_pais = #{idPais}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Estado estado) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de usuario.
     *
     * @param id id del Estado a ser borrado
     * @return id del Estado borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM estado WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}