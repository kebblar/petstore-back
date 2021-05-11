/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   RolMapper.java
 * Tipo:        interface
 * AUTOR:       Marco Antonio Santiago Garcia
 * Fecha:       Martes 11 de Mayo de 2021 (09_00)
 *
 * Historia:    .
 *              20210503_1914 Creación de éste Mapper
 *
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Rol;

/**
 * Interface 'Mapper' MyBatis asociado a la entidad Rol
 *
 * @author  Marco Antonio Santiago Garcia
 * @see     io.kebblar.petstore.api.mapper.RolMapper
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface RolMapper {

    @Select("SELECT id, nombre, activo FROM rol")
    List<Rol> getAll() throws SQLException;

    @Select("SELECT id, nombre, activo FROM rol WHERE id = #{id} and activo=true")
    Rol getRol(int id) throws SQLException;

    @Select("select rol.* from usuario, rol, usuario_rol WHERE usuario.id=usuario_rol.id_usuario and usuario.id=#{idUser} and rol.id=usuario_rol.id_rol and rol.activo=true;")
    List<Rol> getUserRoles(int idUser) throws SQLException;

}
