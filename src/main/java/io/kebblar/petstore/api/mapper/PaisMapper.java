/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   PaisMapper.java
 * Tipo:        interface
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Lunes 3 de Mayo de 2021 (19_14)
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Mapper
 *              20210516_0214 Creación del metodo getByNombre
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Pais;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Pais 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface PaisMapper {
    static final String CAMPOS = " id, nombre ";
    
    /**
     * Obtiene una lista de objetos de tipo 'pais'.
     *
     * @param  int id del pais.
     * @return Lista de obetos de tipo pais
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="PaisMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "nombre", column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM pais WHERE id = #{id} ") 
    Pais getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'pais'.
     *
     * @return Lista de obetos de tipo pais
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS + " FROM pais ") 
    List<Pais> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'Pais' con base en la información dada por el objeto de tipo 'pais'.
     *
     * @param  Pais a ser insertado.
     * @return El auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO pais(nombre) VALUES(#{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Pais pais) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Pais' con base en la infrmación dada por el objeto de tipo 'pais'.
     *
     * @param  Pais a ser actualizado.
     * @return El numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE pais SET nombre = #{nombre} WHERE id = #{id}")
    int update(Pais pais) throws SQLException;

    /**
     * Borra (de manera física) el registro de pais.
     *
     * @param  id id del pais a ser borrado
     * @return El numero de registros borrados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM pais WHERE id = #{id} ") 
    int delete(int id) throws SQLException;
    
    /**
     * Obtiene una lista de objetos de tipo 'pais' filtrado por el nombre ingresado.
     *
     * @param  String nombre del pais.
     * @return Lista de objetos de tipo pais filtrado por el nombre ingresado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS + " FROM pais WHERE nombre LIKE '%' #{nombre} '%'") 
    List<Pais> getByNombre(String nombre) throws SQLException;

}
