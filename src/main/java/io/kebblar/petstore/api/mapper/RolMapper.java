/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    proyecto
 * Paquete:     mx.qbits.unam.proyecto.api.mapper
 * Modulo:      Anuncio
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano
 * Fecha:       domingo 10 de octubre de 2020 (12_53)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface 'Mapper' MyBatis asociado a la entidad Anuncio
 *
 * Historia:    .
 *              20201025_1253 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.Rol;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Rol
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
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
