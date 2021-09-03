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
 * Artefacto:   AtributoMapper.java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (21_41)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2141 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.AtributoDetalleTO;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Atributo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.Atributo
 */
@Repository
public interface AtributoMapper {

    String CAMPOS_ATRIBUTO = " id, nombre, activo ";

    /**
     * Obtiene un objeto de tipo 'Atributo' dado su id.
     *
     * @return Atributo que tiene asignado el id pasado como parámetro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos
     */
    @Results(id="AtributoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS_ATRIBUTO + " FROM atributo WHERE     id = #{id}     ")
    Atributo getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Atributo'.
     *
     * @return Lista de objetos de tipo Atributo
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("AtributoMap")
    @Select("SELECT " + CAMPOS_ATRIBUTO + " FROM atributo ")
    List<Atributo> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Atributo' con base en la información dada por el objeto de tipo 'Atributo'.
     *
     * @param atributo a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO atributo(id, nombre, activo) "
   + "VALUES(#{id}, #{nombre}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Atributo atributo) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Atributo' con base en la información dada por el objeto de tipo 'Atributo'.
     *
     * @param atributo a ser actualizado.
     * @return el número de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE atributo"
    + " SET nombre = #{nombre}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(Atributo atributo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Atributo.
     *
     * @param id id del Atributo a ser borrado
     * @return id del Atributo borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM atributo WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'atributo' filtrado por el nombre ingresado.
     *
     * @param  nombre nombre de atributo.
     * @return Lista de objetos de tipo Atributo filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("AtributoMap")
    @Select("SELECT " + CAMPOS_ATRIBUTO + " FROM atributo WHERE nombre LIKE '%' #{nombre} '%'")
    List<Atributo> getByNombre(String nombre) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria'.
     *
     * @return Lista de objetos de tipo AtributoDetallesTO
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Select("select a.id as idAtributo, a.nombre as nombreAtributo, a.activo as estatusAtributo, va.id as idRango, va.id_atributo as rangoIdAtributo, va.rango as rango, va.activo as estatusRango  from  atributo a left join valor_atributo va on va.id_atributo = a.id order by a.id, va.id")
    List<AtributoDetalleTO> getAllAtributoDetalle() throws SQLException;
}
