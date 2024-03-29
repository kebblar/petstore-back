/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      RolMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:10:49
 */
package io.kebblar.petstore.api.mapper;

import org.apache.ibatis.exceptions.PersistenceException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.UsuarioHabilidad;
import io.kebblar.petstore.api.model.response.HabResponse;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Rol.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see io.kebblar.petstore.api.model.domain.Rol
 */
@Repository
public interface HabilidadMapper {

    String CAMPOS = "  habilidad_id, nombre, costo ";

    @Results(id="HabilidadMap", value = {
            @Result(property = "id",column = "habilidad_id"),
            @Result(property = "label",     column = "nombre"),
            @Result(property = "val",      column = "costo")
            })
    @Select("SELECT " + CAMPOS + " FROM vw_habilidad WHERE usuario_id = #{id}")
    List<HabResponse> getHabilidadResponseList(int id) throws PersistenceException;

    @ResultMap("HabilidadMap")
    @Select("SELECT " + CAMPOS + " FROM vw_habilidad WHERE costo=0 and usuario_id = #{id}")
    List<HabResponse> getHabilidadResponseListGratis(int id) throws PersistenceException;

    @ResultMap("HabilidadMap")
    @Select("SELECT " + CAMPOS + " FROM vw_habilidad WHERE costo>0 and usuario_id = #{id}")
    List<HabResponse> getHabilidadResponseListConCosto(int id) throws PersistenceException;

//    @Select("SELECT id, nombre, activo FROM habilidad")
//    List<Habilidad> getHabilidades() throws PersistenceException;
    
    @Select("SELECT id, nombre as label, 0 as val FROM habilidad")
    List<HabResponse> getAllPlainHabilidades() throws PersistenceException;

    @Insert("INSERT INTO usuario_habilidad VALUES(#{idUsuario}, #{idHabilidad}, #{costo})")
    int insertUsuarioHabilidad(UsuarioHabilidad usuarioHabilidad) throws PersistenceException;

    @Delete("DELETE FROM usuario_habilidad where id_usuario=#{id}")
    int deleteUsuarioHabilidades(int id) throws PersistenceException;

}
