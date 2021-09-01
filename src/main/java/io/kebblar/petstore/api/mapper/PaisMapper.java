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
 *              20210516_0214 Creación del metodo getByNombre
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Pais;

import static io.kebblar.petstore.api.mapper.constants.Campos.CAMPOS_PAIS;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Pais.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Pais
 */
@Repository
public interface PaisMapper {

    /**
     * Obtiene un objeto de tipo 'Pais' dado su id.
     *
     * @return Pais que tiene asignado el id pasado como parámetro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="PaisMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre")
    })
    @Select("SELECT " + CAMPOS_PAIS + " FROM pais WHERE id = #{id} ")
    Pais getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Pais'.
     *
     * @return Lista de obetos de tipo Pais
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS_PAIS + " FROM pais ")
    List<Pais> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Pais' con base en la información dada por el objeto de tipo 'Pais'.
     *
     * @param pais a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO pais(id, nombre) VALUES(#{id}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Pais pais) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Pais' con base en la información dada por el objeto de tipo 'Pais'.
     *
     * @param pais a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE pais SET nombre = #{nombre} WHERE id = #{id} ")
    int update(Pais pais) throws SQLException;

    /**
     * Borra (física) el registro de Pais.
     *
     * @param id id del Pais a ser borrado
     * @return id del Pais borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM pais WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'pais' filtrado por el nombre ingresado.
     *
     * @param  nombre del pais.
     * @return Lista de objetos de tipo pais filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS_PAIS + " FROM pais WHERE nombre LIKE '%' #{nombre} '%'")
    List<Pais> getByNombre(String nombre) throws SQLException;

}
