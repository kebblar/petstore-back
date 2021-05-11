/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 * Artefacto:   PaisMapper.java
 * Tipo:        Interface 
 * Autor:       Francisco Javier Moreno Romero (FJMR)
 * Fecha:       Viernes 7 de Mayo de 2021 08:34pm
 *
 * Historia:    .
 *              20210507_0834 Creación de éste Mapper.
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.domain.Pais;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Pais 
 *
 * @author javier
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface PaisMapper {
    static final String CAMPOS = " id, nombre ";

    @Results(id="PaisMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "nombre", column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM pais WHERE id = #{id} ") 
    Pais getById(int id) throws SQLException;
    
    /**
     * Obtiene una lista de objetos {@link Pais}.
     * 
     * @return el pais encontrado con el criterio de búsqueda.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS + " FROM pais ") 
    List<Pais> getAll() throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'Pais' con base en la información dada por el objeto de tipo 'pais'.
     * 
     * @param pais a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO pais(nombre) VALUES(#{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Pais pais) throws SQLException;
    
    /**
     * Actualiza un objeto de tipo 'Pais' con base en la infrmación dada por el objeto de tipo 'pais'.
     * 
     * @param pais a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE pais SET nombre = #{nombre} WHERE id = #{id}")
    int update(Pais pais) throws SQLException;
    
    /**
     * Borra (de manera lógica y no física).
     * 
     * @param id a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM pais WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
