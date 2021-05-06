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
 * Tipo:        Interface
 * AUTOR:       Javier Chávez Barrios (JCHB)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_25)
 *
 * Historia:    .
 *              0210506_0925 Creación de éste Mapper
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Municipio;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Municipio'.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Municipio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Repository
public interface MunicipioMapper {
	
    static final String CAMPOS = " id, id_estado, nombre ";

    /**
     * Obtiene una lista de objetos de tipo 'Municipio'.
     *
     * @return Lista de obetos de tipo Municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="MunicipioMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idEstado", column = "id_estado"),
        @Result(property = "nombre", column = "nombre")    
    })
    
    /**
     * Obtiene un objeto de tipo 'municipio' realizando la búsqueda con base en el 'id' del municipio.
     *
     * @param int id identificador del municipio
     * @return el municipio encontrado con el criterio de búsqueda.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id = #{id} ") 
    Municipio getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objectos de tipo 'municipio'
     *
     * @return todos los municipios
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio ") 
    List<Municipio> getAll() throws SQLException;

    /**
     * Obtiene una lista de objectos de tipo 'municipio' realizando la búsqueda con base en el 'idEstado' del estado.
     *
     * @param int idEstado identificador del estado
     * @return una lista de municipios encontrados con los criterios de búsqueda.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id_estado = #{idEstado}")  
    List<Municipio> getByEstado(int idEstado) throws SQLException;

    /**
     * Inserta un objeto de tipo 'municipio' con base en la información dada por el objeto de tipo 'municipio'.
     *
     * @param Municipio a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO municipio(id_estado, nombre) VALUES(#{idEstado}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Municipio municipio) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'municipio' con base en la información dada por el objeto de tipo 'municipio'.
     *
     * @param Municipio a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE municipio SET id_estado = #{idEstado}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Municipio municipio) throws SQLException;

    /**
     * Borra de manera física el registro del municipio.
     *
     * @param id id del municipio a ser borrado
     * @return id del municipio borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM municipio WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objectos de tipo 'municipio' realizando la búsqueda con base en el 'idEstado','starRow','pageSize'.
     *
     * @param int idEstado identificador del estado
     * @param int starRow Inicio de la fila
     * @param int pageSize Número de registros por pagina
     * @return una lista de municipios encontrados con los criterios de búsqueda.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id_estado=#{idEstado} LIMIT #{startRow},#{pageSize}") 
    List<Municipio> getPaginatedMunicipios(int idEstado, int startRow, int pageSize);

}
