/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      ValorAtributoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:11:42
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.ValorAtributo;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad ValorAtributo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see io.kebblar.petstore.api.model.domain.ValorAtributo
 */
@Repository
public interface ValorAtributoMapper {

    /** Constant <code>CAMPOS_V_A=" id, id_atributo, rango, activo "</code> */
    String CAMPOS_V_A = " id, id_atributo, rango, activo ";

    /**
     * Obtiene un objeto de tipo 'ValorAtributo' dado su id.
     *
     * @return ValorAtributo que tiene asignado el id pasado como parametro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
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
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("ValorAtributoMap")
    @Select("SELECT " + CAMPOS_V_A + " FROM valor_atributo ")
    List<ValorAtributo> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'ValorAtributo' con base en la información dada por el objeto de tipo 'ValorAtributo'.
     *
     * @param valorAtributo a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
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
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
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
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM valor_atributo WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'ValorAtributo' dado su id.
     *
     * @return ValorAtributo que tiene asignado el id pasado como parametro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @ResultMap("ValorAtributoMap")
    @Select("SELECT " + CAMPOS_V_A + " FROM valor_atributo WHERE  id_atributo = #{id}     ")
    List<ValorAtributo> getValorAtributoByIdAtributo(int id) throws SQLException;
}
