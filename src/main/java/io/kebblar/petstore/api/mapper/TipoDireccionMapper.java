/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      TipoDireccionMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:11:02
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.TipoDireccion;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad TipoDireccion.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see TipoDireccion
 */

@Repository
public interface TipoDireccionMapper {

    /** Constant <code>CAMPOS_T_DIRECC=" id, nombre, activo "</code> */
    String CAMPOS_T_DIRECC = " id, nombre, activo ";

    /**
     * Obtiene un objeto de tipo 'TipoDireccion' dado su id.
     *
     * @return TipoDireccion que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="TipoDireccionMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS_T_DIRECC + " FROM tipo_direccion WHERE     id = #{id}     ")
    TipoDireccion getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'TipoDireccion'.
     *
     * @return Lista de obetos de tipo TipoDireccion
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("TipoDireccionMap")
    @Select("SELECT " + CAMPOS_T_DIRECC + " FROM tipo_direccion ")
    List<TipoDireccion> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'TipoDireccion' con base en la información dada por el objeto de tipo 'TipoDireccion'.
     *
     * @param tipoDireccion a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO tipo_direccion(id, nombre, activo) "
   + "VALUES(#{id}, #{nombre}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(TipoDireccion tipoDireccion) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'TipoDireccion' con base en la información dada por el objeto de tipo 'TipoDireccion'.
     *
     * @param tipoDireccion a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE tipo_direccion"
    + " SET nombre = #{nombre}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(TipoDireccion tipoDireccion) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de TipoDireccion.
     *
     * @param id id del TipoDireccion a ser borrado
     * @return id del TipoDireccion borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM tipo_direccion WHERE id = #{id} ")
    int delete(int id) throws SQLException;

}
