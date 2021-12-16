
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
 * Fecha:       Wednesday 12 de December de 2021 (16_27)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20211215_1627 Implementación de interface 
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.CategAtt;
import io.kebblar.petstore.api.model.domain.Categoria;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Categoria 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see io.kebblar.petstore.api.model.domain.Categoria
 */
@Repository
public interface CategoriaMapper {
    static final String CAMPOS = " id, nombre, descripcion, activo ";

    /**
     * Obtiene un objeto de tipo 'Categoria' dado su id.
     *
     * @return Categoria que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="CategoriaMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "descripcion",   column = "descripcion"),
            @Result(property = "activo",   column = "activo")    
    })
    @Select("SELECT " + CAMPOS + " FROM categoria WHERE     id = #{id}     ") 
    Categoria getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria'.
     *
     * @return Lista de obetos de tipo Categoria
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("CategoriaMap")
    @Select("SELECT " + CAMPOS + " FROM categoria ") 
    List<Categoria> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'Categoria' con base en la información dada por el objeto de tipo 'Categoria'.
     *
     * @param categoria a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO categoria(id, nombre, descripcion, activo) "
   + "VALUES(#{id}, #{nombre}, #{descripcion}, #{activo} )")
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
    + " SET nombre = #{nombre}, descripcion = #{descripcion}, activo = #{activo}"
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

    
    
    
    
    static final String CAMPOS2 = " id, id_categoria, leyenda, activo ";

    /**
     * Obtiene un objeto de tipo 'CategAtt' dado su id.
     *
     * @return CategAtt que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="CategAttMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "leyenda",   column = "leyenda"),
            @Result(property = "activo",   column = "activo")    
    })
    @Select("SELECT " + CAMPOS2 + " FROM categ_att WHERE id_categoria = #{idCateg} ") 
    List<CategAtt> getCategAppById(int idCateg) throws SQLException;
}
