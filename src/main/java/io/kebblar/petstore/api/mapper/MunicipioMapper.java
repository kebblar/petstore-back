/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      Municipio
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Municipio 
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
import io.kebblar.petstore.api.model.domain.Municipio;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Municipio 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface MunicipioMapper {
    static final String CAMPOS = " id, id_estado, nombre ";

    @Results(id="MunicipioMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idEstado", column = "id_estado"),
        @Result(property = "nombre", column = "nombre")    
    })
    @Select("SELECT " + CAMPOS + " FROM municipio WHERE id = #{id} ") 
    Municipio getById(Municipio municipio) throws SQLException;

    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS + " FROM municipio ") 
    List<Municipio> getAll() throws SQLException;
    
    @Insert("INSERT INTO municipio(id_estado, nombre) VALUES(#{idEstado}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Municipio municipio) throws SQLException;

    @Update("UPDATE municipio SET id_estado = #{idEstado}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Municipio municipio) throws SQLException;

    @Delete("DELETE FROM municipio WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
