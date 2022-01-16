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
 * Nombre:      ConsultaMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:07:48
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.response.ConsultaResponse;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad ConsultaResponse.
 *
 * @author Gustavo Arellano
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see ConsultaResponse
 */
@Repository
public interface ConsultaMapper {
    /**
     * Obtiene un objeto de tipo 'ConsultaResponse' dado su id.
     *
     * @return ConsultaResponse que tiene asignado el id pasado como parámetro
     * @throws java.sql.PersistenceException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="ConsultaMap", value = {
            @Result(property = "id",  column = "id_combo"),
            @Result(property = "selected", column = "id_opcion")
    })
    @Select("SELECT id_combo, id_opcion FROM consulta WHERE id_usuario = #{idUsuario}     ")
    List<ConsultaResponse> getById(int idUsuario) throws PersistenceException;

    /**
     * Inserta un objeto de tipo 'ConsultaResponse' con base en la información dada por el objeto de tipo 'ConsultaResponse'.
     *
     * @param consulta a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO consulta(id_usuario, id_combo, id_opcion) VALUES(#{idUsuario}, #{idCombo}, #{idOpcion} )")
    int insert(int idUsuario, int idCombo, int idOpcion) throws PersistenceException;

    /**
     * Borra (de manera lógica y no física) el registro de ConsultaResponse.
     *
     * @param idUsuario id del ConsultaResponse a ser borrado
     * @return id de la ConsultaResponse borrada
     * @throws java.sql.PersistenceException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM consulta WHERE id_usuario = #{idUsuario} ")
    int delete(int idUsuario) throws PersistenceException;

}
