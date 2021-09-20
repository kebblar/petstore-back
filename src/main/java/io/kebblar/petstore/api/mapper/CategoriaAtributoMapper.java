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
 * Nombre:      CategoriaAtributoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:04:26
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

import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.CategoriaAtributo;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad CategoriaAtributo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see io.kebblar.petstore.api.model.domain.CategoriaAtributo
 */
@Repository
public interface CategoriaAtributoMapper {

    /** Constant <code>CAMPOS_CAT_ATRIBUTO=" id_categoria, id_atributo "</code> */
    String CAMPOS_CAT_ATRIBUTO = " id_categoria, id_atributo ";

    /**
     * Obtiene un objeto de tipo 'CategoriaAtributo' dado su id.
     *
     * @return CategoriaAtributo que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="CategoriaAtributoMap", value = {
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "idAtributo",   column = "id_atributo")
    })
    @Select("SELECT " + CAMPOS_CAT_ATRIBUTO + " FROM categoria_atributo WHERE     id_categoria = #{idCategoria} ,         id_atributo = #{idAtributo}     ")
    CategoriaAtributo getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'CategoriaAtributo'.
     *
     * @return Lista de objetos de tipo CategoriaAtributo
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CategoriaAtributoMap")
    @Select("SELECT " + CAMPOS_CAT_ATRIBUTO + " FROM categoria_atributo ")
    List<CategoriaAtributo> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'CategoriaAtributo' con base en la información dada por el objeto de tipo 'CategoriaAtributo'.
     *
     * @param categoriaAtributo a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO categoria_atributo(id_categoria, id_atributo) "
   + "VALUES(#{idCategoria}, #{idAtributo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(CategoriaAtributo categoriaAtributo) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'CategoriaAtributo' con base en la información dada por el objeto de tipo 'CategoriaAtributo'.
     *
     * @param categoriaAtributo a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE categoria_atributo"
    + " SET "
    + " WHERE id_categoria = #{idCategoria} , id_atributo = #{idAtributo} ")
    int update(CategoriaAtributo categoriaAtributo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de CategoriaAtributo.
     *
     * @param categoriaAtributo objeto a ser borrado
     * @return id del CategoriaAtributo borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM categoria_atributo WHERE id_categoria = #{idCategoria} and id_atributo = #{idAtributo} ")
    int delete(CategoriaAtributo categoriaAtributo) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'CategoriaAtributo' dado su id.
     *
     * @return CategoriaAtributo que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="CategoriaAtributoNombreMap", value = {
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "idAtributo",   column = "id_atributo"),
            @Result(property = "nombreAtributo",   column = "nombre")
    })
    @Select("SELECT ca.id_categoria,ca.id_atributo, a.nombre FROM categoria_atributo ca inner join atributo a on ca.id_atributo = a.id WHERE  ca.id_categoria = #{idCategoria} ")
    List<CategoriaAtributo> getNombreAtributosByIdCategoria(int id) throws SQLException;


    /**
     * Obtiene una lista de tipo 'Atributo' dado su id.
     *
     * @return Atributo que no tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param idCategoria a int.
     */
    @Results(id="CategoriaAtributoAtributoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre")
    })
    @Select("SELECT a.id, a.nombre FROM atributo a left join categoria_atributo ca on ca.id_atributo = a.id and ca.id_categoria = #{idCategoria} WHERE ca.id_categoria is null and a.activo = 1 ")
    List<Atributo> getAtributosFaltantesByIdCategoria(int idCategoria) throws SQLException;

}
