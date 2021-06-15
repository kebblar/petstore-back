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
 * Artefacto:   MunicipioMapper .java
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
import io.kebblar.petstore.api.model.domain.Municipio;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Municipio
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Municipio
 */

@Repository
public interface MunicipioMapper {
    static final String CAMPOS = " id, id_estado, nombre ";
    static final String AUX_CAMPOS = " m.id, m.id_estado, m.nombre, e.nombre as nombre_estado , p.nombre as nombre_pais";

    /**
     * Obtiene un objeto de tipo 'Municipio' dado su id.
     *
     * @return Municipio que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="MunicipioMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idEstado",   column = "id_estado"),
            @Result(property = "nombre",   column = "nombre")
    })
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE     id = #{id}     ")
    Municipio getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Municipio'.
     *
     * @return Lista de obetos de tipo Municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio ")
    List<Municipio> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Municipio' con base en la información dada por el objeto de tipo 'Municipio'.
     *
     * @param municipio a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
            "INSERT INTO municipio(id, id_estado, nombre) "
                    + "VALUES(#{id}, #{idEstado}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Municipio municipio) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Municipio' con base en la infrmación dada por el objeto de tipo 'Municipio'.
     *
     * @param municipio a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
            "UPDATE municipio"
                    + " SET id_estado = #{idEstado}, nombre = #{nombre}"
                    + " WHERE id = #{id} ")
    int update(Municipio municipio) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Municipio.
     *
     * @param id id del Municipio a ser borrado
     * @return id del Municipio borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM municipio WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Dado determinado estado, el método retorna los municipios pertenecientes a este.
     * @param id id del estado que contiene a los municipios.
     * @return Lista con los municipios de determinado estado.
     * @throws SQLException en caso de un error en el servidor o en la consulta.
     */
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id_estado=#{id}" )
    List<Municipio> getByEstado(int id) throws SQLException;

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
    
    /**
     * Obtiene una lista de objetos de tipo 'Municipio' que trae el nombre del pais
     * y el nombre del estado filtrando el nombre del municipio.
     *
     * @return Lista de obetos de tipo Municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="PaisEstadoMunicipioMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idEstado", column = "id_estado"),
            @Result(property = "nombreEstado", column = "nombre_estado"),
            @Result(property = "nombrePais", column = "nombre_pais"),
            @Result(property = "nombre", column = "nombre")    
        })
    @Select("SELECT " + AUX_CAMPOS + " FROM municipio m "
    		+ "INNER JOIN estado e on m.id_estado = e.id "
    		+ "INNER JOIN pais p on e.id_pais = p.id "
    		+ "WHERE m.nombre LIKE '%' #{nombre} '%'") 
    List<Municipio> getByNombre(String nombre) throws SQLException;

    

    /**
     * Obtiene una lista de objetos de tipo 'Municipio' que trae el nombre del pais
     * y el nombre del estado.
     *
     * @return Lista de obetos de tipo Municipio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("PaisEstadoMunicipioMap")
    @Select("SELECT " + AUX_CAMPOS + " FROM municipio m "
    		+ "INNER JOIN estado e on m.id_estado = e.id "
    		+ "INNER JOIN pais p on e.id_pais = p.id  ") 
	List<Municipio> getMunicipiosDescripcion();

}