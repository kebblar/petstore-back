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
 * Artefacto:   CategoriaAtributoMapper .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (19_06)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210606_1906 Implementación de interface 
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.CategoriaAtributo;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad CategoriaAtributo 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.CategoriaAtributo
 */
@Repository
public interface CategoriaAtributoMapper {
    static final String CAMPOS = " id_categoria, id_atributo ";

    /**
     * Obtiene un objeto de tipo 'CategoriaAtributo' dado su id.
     *
     * @return CategoriaAtributo que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="CategoriaAtributoMap", value = {
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "idAtributo",   column = "id_atributo")    
    })
    @Select("SELECT " + CAMPOS + " FROM categoria_atributo WHERE     id_categoria = #{idCategoria} ,         id_atributo = #{idAtributo}     ") 
    CategoriaAtributo getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'CategoriaAtributo'.
     *
     * @return Lista de obetos de tipo CategoriaAtributo
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("CategoriaAtributoMap")
    @Select("SELECT " + CAMPOS + " FROM categoria_atributo ") 
    List<CategoriaAtributo> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'CategoriaAtributo' con base en la información dada por el objeto de tipo 'CategoriaAtributo'.
     *
     * @param categoriaAtributo a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO categoria_atributo(id_categoria, id_atributo) "
   + "VALUES(#{idCategoria}, #{idAtributo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(CategoriaAtributo categoriaAtributo) throws SQLException;

/**
     * Actualiza un objeto de tipo 'CategoriaAtributo' con base en la infrmación dada por el objeto de tipo 'CategoriaAtributo'.
     *
     * @param categoriaAtributo a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE categoria_atributo" 
    + " SET "
    + " WHERE id_categoria = #{idCategoria} , id_atributo = #{idAtributo} ")
    int update(CategoriaAtributo categoriaAtributo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de CategoriaAtributo.
     *
     * @param id id del CategoriaAtributo a ser borrado
     * @return id del CategoriaAtributo borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM categoria_atributo WHERE id_categoria = #{idCategoria} and id_atributo = #{idAtributo} ") 
    int delete(CategoriaAtributo categoriaAtributo) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'CategoriaAtributo' dado su id.
     *
     * @return CategoriaAtributo que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
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
     * @return Atributo que no tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="CategoriaAtributoAtributoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre")  
    })
    @Select("SELECT a.id, a.nombre FROM atributo a left join categoria_atributo ca on ca.id_atributo = a.id and ca.id_categoria = #{idCategoria} WHERE ca.id_categoria is null and a.activo = 1 ") 
    List<Atributo> getAtributosFaltantesByIdCategoria(int idCategoria) throws SQLException;

}
