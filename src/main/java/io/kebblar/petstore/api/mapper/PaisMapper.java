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
 * Tipo:        Clase
 * AUTOR:       Isabel Contreras
 * Fecha:       Martes 11 de Mayo de 2021 (08_58)
 *
 * Historia:    .
 *              20210511_0858 Se agrega la documentacion del mapper
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
 * @author  Isabel Contreras
 * @see     io.kebblar.petstore.api.mapper.Pais
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
@Repository
public interface PaisMapper {
    static final String CAMPOS = " id, nombre ";

    /**
     * Obtiene un objetos de tipo 'pais' con base al id.
     *
     * @return Obetos de tipo pais
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
     * Obtiene toda la lista de objetos de tipo 'pais'
     *
     * @return Lista de obetos de tipo pais
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS + " FROM pais ") 
    List<Pais> getAll() throws SQLException;
    
    /**
     * Permite guardar un objeto de tipo 'pais'.
     *
     * @return Id del objeto de tipo 'pais' que se ha guardado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Insert("INSERT INTO pais(nombre) VALUES(#{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Pais pais) throws SQLException;

    /**
     * Permite actualizar un objeto de tipo 'pais' con base al Id.
     *
     * @return Id del objeto de tipo 'pais' que se ha actualizado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Update("UPDATE pais SET nombre = #{nombre} WHERE id = #{id}")
    int update(Pais pais) throws SQLException;

    /**
     * Permite eliminar un objeto de tipo 'pais'con base al Id.
     *
     * @return Id del objeto de tipo 'pais' que se ha eliminado
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Delete("DELETE FROM pais WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
