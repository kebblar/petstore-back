/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MunicipioMapper.java
 * Tipo:        interface
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (19_14)
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Mapper
 *              20210511_0832 Actualización de licencia
 *
 */

package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Municipio;

/**
 * Interface 'Mapper' MyBatis asociado a la entidad Municipio
 *
 * @author Gustavo A. Arellano
 * @see io.kebblar.petstore.api.mapper.MunicipioMapper
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Repository
public interface MunicipioMapper {
    static final String CAMPOS = " id, id_estado, nombre ";

    /**
     * Obtiene una lista de objetos de tipo 'municipio' realizando la busqueda por
     * idEstado.
     *
     * @return Lista de obetos de tipo municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Results(id = "MunicipioMap", value = { @Result(property = "id", column = "id"),
            @Result(property = "idEstado", column = "id_estado"), @Result(property = "nombre", column = "nombre") })
    
    /**
     * Obtiene una lista de objetos de tipo 'municipio' realizando la busqueda por
     * id.
     *
     * @return Lista de obetos de tipo municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id = #{id} ")
    Municipio getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'municipio'.
     *
     * @return Lista de obetos de tipo municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio ")
    List<Municipio> getAll() throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'municipio' realizando la busqueda por
     * idEstado.
     *
     * @return Lista de obetos de tipo municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     *                      operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id_estado = #{idEstado}")
    List<Municipio> getByEstado(int idEstado) throws SQLException;

    /**
     * Inserta un objeto de tipo 'municipio' con base en la información dada por el
     * objeto de tipo 'municipio'.
     *
     * @param Municipio a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta
     *                      operación desde la base de datos.
     */
    @Insert("INSERT INTO municipio(id_estado, nombre) VALUES(#{idEstado}, #{nombre} )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Municipio municipio) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'municipio' con base en la infrmación dada por el
     * objeto de tipo 'municipio'.
     *
     * @param Municipio a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta
     *                      operación desde la base de datos.
     */
    @Update("UPDATE municipio SET id_estado = #{idEstado}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Municipio municipio) throws SQLException;

    /**
     * Borra (de manera física) el registro de municipio.
     *
     * @param id id del municipio a ser borrado
     * @return id del municipio borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta
     *                      operación desde la base de datos.
     */
    @Delete("DELETE FROM municipio WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id_estado=#{idEstado} LIMIT #{startRow},#{pageSize}")
    List<Municipio> getPaginatedMunicipios(int idEstado, int startRow, int pageSize);

}
