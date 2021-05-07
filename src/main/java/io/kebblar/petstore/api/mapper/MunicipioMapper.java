/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      Municipio
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Municipio 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
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
 * Interface 'Mapper' MyBatis asociado a la entidad Municipio 
 *
 * @author Gustavo A. Arellano
 * @see     io.kebblar.petstore.api.model.domain.Municipio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Repository
public interface MunicipioMapper {
    static final String CAMPOS = " id, id_estado, nombre ";
    
    /**
     * Obtiene el municipio cuyo id se paso como parametro.
     *
     * @return Un objeto de tipo Municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="MunicipioMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idEstado", column = "id_estado"),
        @Result(property = "nombre", column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id = #{id} ") 
    Municipio getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Municipio'.
     *
     * @return Lista de objetos de tipo municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio ") 
    List<Municipio> getAll() throws SQLException;
    
    /**
     * Obtiene un objeto de tipo 'Estado' realizando la búsqueda con base en el 'idEstado' del Municipio.
     *
     * @param int id del estado.
     * @return el municipio encontrado con el criterio de búsqueda.
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
     * Borra (de manera lógica y no física) el registro de un municipio.
     *
     * @param id id del municipio a ser borrado
     * @return id del municipio borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM municipio WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

    /**
     * Regresa los pageSize resultados a partir del startRow de la tabla de Municipio, donde se
     * cumpla que idEstado es igual al estado pasado como parametro.
     *
     * @param idEstado id del estado a buscar
     * @param startRow desde que renglon se deben de regresar los resultados
     * @param pageSize hasta que renglon se deben de regresar los resultados
     * @return una lista de municipios que cumplieron con los criterios de busqueda
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id_estado=#{idEstado} LIMIT #{startRow},#{pageSize}") 
    List<Municipio> getPaginatedMunicipios(int idEstado, int startRow, int pageSize);

}
