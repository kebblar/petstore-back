/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      TipoDireccion
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad TipoDireccion 
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
import io.kebblar.petstore.api.model.domain.TipoDireccion;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad TipoDireccion 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface TipoDireccionMapper {
    static final String CAMPOS = " id, nombre, activo ";

    @Results(id="TipoDireccionMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "nombre", column = "nombre"),
        @Result(property = "activo", column = "activo")    
    })
    @Select("SELECT " + CAMPOS + " FROM tipo_direccion WHERE id = #{id} ") 
    TipoDireccion getById(TipoDireccion tipoDireccion) throws SQLException;

    @ResultMap("TipoDireccionMap")
    @Select("SELECT " + CAMPOS + " FROM tipo_direccion ") 
    List<TipoDireccion> getAll() throws SQLException;
    
    @Insert("INSERT INTO tipo_direccion(nombre, activo) VALUES(#{nombre}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(TipoDireccion tipoDireccion) throws SQLException;

    @Update("UPDATE tipo_direccion SET nombre = #{nombre}, activo = #{activo} WHERE id = #{id} ")
    int update(TipoDireccion tipoDireccion) throws SQLException;

    @Delete("DELETE FROM tipo_direccion WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

}
