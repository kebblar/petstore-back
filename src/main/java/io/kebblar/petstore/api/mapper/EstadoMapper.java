/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      Estado
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Estado 
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
import io.kebblar.petstore.api.model.domain.Estado;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Estado 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface EstadoMapper {
    static final String CAMPOS = " id, id_pais, nombre ";

    @Results(id="EstadoMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idPais", column = "id_pais"),
        @Result(property = "nombre", column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM estado WHERE id = #{id} ") 
    Estado getById(Estado estado) throws SQLException;

    @ResultMap("EstadoMap")
    @Select("SELECT " + CAMPOS + " FROM estado ") 
    List<Estado> getAll() throws SQLException;
    
    @Insert("INSERT INTO estado(id_pais, nombre) VALUES(#{idPais}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Estado estado) throws SQLException;

    @Update("UPDATE estado SET id_pais = #{idPais}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Estado estado) throws SQLException;

    @Delete("DELETE FROM estado WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
