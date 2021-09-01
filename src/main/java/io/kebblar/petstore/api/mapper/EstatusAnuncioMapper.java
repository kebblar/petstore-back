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
 * Artefacto:   EstatusAnuncioMapper .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (00_13)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210606_0013 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.EstatusAnuncio;

import static io.kebblar.petstore.api.mapper.constants.Campos.CAMPOS_ESTATUS_ANUNCIO;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad EstatusAnuncio.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.EstatusAnuncio
 */
@Repository
public interface EstatusAnuncioMapper {

    /**
     * Obtiene un objeto de tipo 'EstatusAnuncio' dado su id.
     *
     * @return EstatusAnuncio que tiene asignado el id pasado como parámetro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="EstatusAnuncioMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "descripcion",   column = "descripcion")
    })
    @Select("SELECT " + CAMPOS_ESTATUS_ANUNCIO + " FROM estatus_anuncio WHERE     id = #{id}     ")
    EstatusAnuncio getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'EstatusAnuncio'.
     *
     * @return Lista de objetos de tipo EstatusAnuncio
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("EstatusAnuncioMap")
    @Select("SELECT " + CAMPOS_ESTATUS_ANUNCIO + " FROM estatus_anuncio ")
    List<EstatusAnuncio> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'EstatusAnuncio' con base en la información dada por el objeto de tipo 'EstatusAnuncio'.
     *
     * @param estatusAnuncio a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO estatus_anuncio(id, descripcion) "
   + "VALUES(#{id}, #{descripcion} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(EstatusAnuncio estatusAnuncio) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'EstatusAnuncio' con base en la información dada por el objeto de tipo 'EstatusAnuncio'.
     *
     * @param estatusAnuncio a ser actualizado.
     * @return el número de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE estatus_anuncio"
    + " SET descripcion = #{descripcion}"
    + " WHERE id = #{id} ")
    int update(EstatusAnuncio estatusAnuncio) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de EstatusAnuncio.
     *
     * @param id id del EstatusAnuncio a ser borrado
     * @return id del EstatusAnuncio borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM estatus_anuncio WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'EstatusAnuncio' filtrado por el nombre ingresado.
     *
     * @param  nombre de EstatusAnuncio.
     * @return Lista de objetos de tipo EstatusAnuncio filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("EstatusAnuncioMap")
    @Select("SELECT " + CAMPOS_ESTATUS_ANUNCIO + " FROM estatus_anuncio WHERE descripcion LIKE '%' #{nombre} '%'")
    List<EstatusAnuncio> getByNombre(String nombre) throws SQLException;

}
