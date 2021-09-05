/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      CategoriaMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:04:41
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

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Categoria.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see io.kebblar.petstore.api.model.domain.Categoria
 */
@Repository
public interface CategoriaMapper {

    /** Constant <code>CAMPOS_CATEGORIA=" id, categoria, activo "</code> */
    String CAMPOS_CATEGORIA = " id, categoria, activo ";

    /**
     * Obtiene un objeto de tipo 'Categoria' dado su id.
     *
     * @return Categoria que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
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
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CategoriaMap")
    @Select("SELECT " + CAMPOS_CATEGORIA + " FROM categoria ")
    List<Categoria> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Categoria' con base en la información dada por el objeto de tipo 'Categoria'.
     *
     * @param categoria a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO categoria(id, categoria, activo) "
   + "VALUES(#{id}, #{categoria}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Categoria categoria) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Categoria' con base en la información dada por el objeto de tipo 'Categoria'.
     *
     * @param categoria a ser actualizado.
     * @return el número de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
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
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM categoria WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria' filtrado por el nombre ingresado.
     *
     * @return Lista de objetos de tipo Categoria filtrado por el nombre ingresado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param nombre a {@link java.lang.String} object.
     */
    @ResultMap("CategoriaMap")
    @Select("SELECT " + CAMPOS_CATEGORIA + " FROM categoria WHERE categoria LIKE '%' #{nombre} '%'")
    List<Categoria> getByNombre(String nombre) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria'.
     *
     * @return Lista de objetos de tipo CategoriaDetallesTO
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
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
