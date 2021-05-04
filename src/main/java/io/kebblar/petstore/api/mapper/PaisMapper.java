/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      Pais
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Pais 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
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

    @Results(id="PaisMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "nombre", column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM pais WHERE id = #{id} ") 
    Pais getById(int id) throws SQLException;

    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS + " FROM pais ") 
    List<Pais> getAll() throws SQLException;
    
    @Insert("INSERT INTO pais(nombre) VALUES(#{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Pais pais) throws SQLException;

    @Update("UPDATE pais SET nombre = #{nombre} WHERE id = #{id}")
    int update(Pais pais) throws SQLException;

    @Delete("DELETE FROM pais WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
