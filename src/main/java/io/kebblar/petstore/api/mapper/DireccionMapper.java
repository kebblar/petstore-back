/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.mapper
 * Modulo:      Direccion
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Direccion 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import io.kebblar.petstore.api.model.response.DireccionConNombre;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Direccion;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Direccion 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
@Repository
public interface DireccionMapper {
    static final String CAMPOS = " id, calle_numero, colonia, id_pais, id_estado, id_municipio, id_tipo_direccion, cp, referencias, activo ";

    @Results(id="DireccionMap", value = {
        @Result(property = "id",          column = "id"),
        @Result(property = "calleNumero", column = "calle_numero"),
        @Result(property = "colonia",     column = "colonia"),
        @Result(property = "idPais",      column = "id_pais"),
        @Result(property = "idEstado",    column = "id_estado"),
        @Result(property = "idMunicipio", column = "id_municipio"),
        @Result(property = "idTipoDireccion", column = "id_tipo_direccion"),
        @Result(property = "cp",          column = "cp"),
        @Result(property = "referencias", column = "referencias"),
        @Result(property = "activo",      column = "activo")    
    })
    @Select("SELECT " + CAMPOS + " FROM direccion WHERE id = #{id} ") 
    Direccion getById(Direccion direccion) throws SQLException;

    @ResultMap("DireccionMap")
    @Select("SELECT " + CAMPOS + " FROM direccion ") 
    List<Direccion> getAll() throws SQLException;
    
    @Insert("INSERT INTO direccion(id, calle_numero, colonia, id_pais, id_estado, id_municipio, id_tipo_direccion, cp, referencias, activo) VALUES(#{id}, #{calleNumero}, #{colonia}, #{idPais}, #{idEstado}, #{idMunicipio}, #{idTipoDireccion}, #{cp}, #{referencias}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Direccion direccion) throws SQLException;

    @Update("UPDATE direccion SET calle_numero = #{calleNumero}, colonia = #{colonia}, id_pais = #{idPais}, id_estado = #{idEstado}, id_municipio = #{idMunicipio}, id_tipo_direccion = #{idTipoDireccion}, cp = #{cp}, referencias = #{referencias}, activo = #{activo} WHERE id = #{id} ")
    int update(Direccion direccion) throws SQLException;

    @Delete("DELETE FROM direccion WHERE id = #{id} ") 
    int delete(int id) throws SQLException;

    @ResultMap("DireccionMap")
    @Select("select direccion.* from direccion, usuario_direccion where direccion.id=usuario_direccion.id_direccion and direccion.activo=true and id_usuario=#{idUser}")
    List<Direccion> getUserDirecciones(int idUser) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'DireccionConNombre' dado su id.
     *
     * @return DireccionConNombre que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="DireccionNombreMap", value = {
            @Result(property = "id",          column = "id_direccion"),
            @Result(property = "destinatario",          column = "destinatario"),
            @Result(property = "calleNumero", column = "calle_numero"),
            @Result(property = "colonia",     column = "colonia"),
            @Result(property = "cp",          column = "cp"),
            @Result(property = "municipioNombre", column = "municipio_nombre"),
            @Result(property = "estadoNombre",    column = "estado_nombre"),
            @Result(property = "paisNombre",      column = "pais_nombre")
    })
    @Select("SELECT id_direccion, destinatario, calle_numero, colonia, cp, municipio_nombre, estado_nombre, pais_nombre " +
            "from usuario_direccion, direccion_con_nombre where id_usuario=#{id}")
    List<DireccionConNombre> getDireccionesNombre(int id) throws SQLException;
}
