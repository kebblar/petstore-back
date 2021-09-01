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
 * Artefacto:   CategoriaMapper .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (00_02)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_0002 Implementación de interface
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
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.domain.CategoriaDetallesTO;

import static io.kebblar.petstore.api.mapper.constants.Campos.CAMPOS_CATEGORIA;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Categoria.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.Categoria
 */
@Repository
public interface CategoriaMapper {

    /**
     * Obtiene un objeto de tipo 'Categoria' dado su id.
     *
     * @return Categoria que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="CategoriaMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "categoria",   column = "categoria"),
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS_CATEGORIA + " FROM categoria WHERE     id = #{id}     ")
    Categoria getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria'.
     *
     * @return Lista de obetos de tipo Categoria
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CategoriaMap")
    @Select("SELECT " + CAMPOS_CATEGORIA + " FROM categoria ")
    List<Categoria> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Categoria' con base en la información dada por el objeto de tipo 'Categoria'.
     *
     * @param categoria a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO categoria(id, categoria, activo) "
   + "VALUES(#{id}, #{categoria}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Categoria categoria) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Categoria' con base en la infrmación dada por el objeto de tipo 'Categoria'.
     *
     * @param categoria a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE categoria"
    + " SET categoria = #{categoria}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(Categoria categoria) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Categoria.
     *
     * @param id id del Categoria a ser borrado
     * @return id del Categoria borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM categoria WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria' filtrado por el nombre ingresado.
     *
     * @param  String nombre de Categoria.
     * @return Lista de objetos de tipo Categoria filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CategoriaMap")
    @Select("SELECT " + CAMPOS_CATEGORIA + " FROM categoria WHERE categoria LIKE '%' #{nombre} '%'")
    List<Categoria> getByNombre(String nombre) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria'.
     *
     * @return Lista de obetos de tipo CategoriaDetallesTO
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Select("select c.id as idCategoria, c.categoria as categoriaNombre,"
            + " c.activo as estatusCategoria,"
            + " ca.id_categoria, ca.id_atributo , a.id as idAtributo,"
            + " a.nombre as nombreAtributo, a.activo as estatusAtributo,"
            + " va.id as idRango, va.id_atributo as rangoIdAtributo, "
            + " va.rango as rango, va.activo as estatusRango "
            + " from categoria c left join categoria_atributo ca"
            + " on c.id = ca.id_categoria left join atributo a "
            + " on a.id = ca.id_atributo left join valor_atributo "
            + "va on va.id_atributo = a.id order by c.id, a.id, va.id")
    List<CategoriaDetallesTO> getAllCategoriaDetalle() throws SQLException;
}
