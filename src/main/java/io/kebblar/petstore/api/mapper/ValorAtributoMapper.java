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
 * Artefacto:   ValorAtributoMapper .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       martes 06 de junio de 2021 (00_43)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210608_0043 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.ValorAtributo;

import static io.kebblar.petstore.api.mapper.constants.Campos.CAMPOS_V_A;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad ValorAtributo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.ValorAtributo
 */
@Repository
public interface ValorAtributoMapper {

    /**
     * Obtiene un objeto de tipo 'ValorAtributo' dado su id.
     *
     * @return ValorAtributo que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="ValorAtributoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idAtributo",   column = "id_atributo"),
            @Result(property = "rango",   column = "rango"),
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS_V_A + " FROM valor_atributo WHERE     id = #{id}     ")
    ValorAtributo getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'ValorAtributo'.
     *
     * @return Lista de obetos de tipo ValorAtributo
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("ValorAtributoMap")
    @Select("SELECT " + CAMPOS_V_A + " FROM valor_atributo ")
    List<ValorAtributo> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'ValorAtributo' con base en la información dada por el objeto de tipo 'ValorAtributo'.
     *
     * @param valorAtributo a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO valor_atributo(id, id_atributo, rango, activo) "
   + "VALUES(#{id}, #{idAtributo}, #{rango}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(ValorAtributo valorAtributo) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'ValorAtributo' con base en la infrmación dada por el objeto de tipo 'ValorAtributo'.
     *
     * @param valorAtributo a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE valor_atributo"
    + " SET id_atributo = #{idAtributo}, rango = #{rango}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(ValorAtributo valorAtributo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de ValorAtributo.
     *
     * @param id id del ValorAtributo a ser borrado
     * @return id del ValorAtributo borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM valor_atributo WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'ValorAtributo' dado su id.
     *
     * @return ValorAtributo que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("ValorAtributoMap")
    @Select("SELECT " + CAMPOS_V_A + " FROM valor_atributo WHERE  id_atributo = #{id}     ")
    List<ValorAtributo> getValorAtributoByIdAtributo(int id) throws SQLException;
}
