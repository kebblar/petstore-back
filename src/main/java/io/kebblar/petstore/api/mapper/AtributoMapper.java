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
 * Nombre:      AtributoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:04:04
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.AtributoDetalleTO;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Atributo.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see io.kebblar.petstore.api.model.domain.Atributo
 */
@Repository
public interface AtributoMapper {

    /** Constant <code>CAMPOS_ATRIBUTO=" id, nombre, activo "</code> */
    String CAMPOS_ATRIBUTO = " id, nombre, activo ";

    /**
     * Obtiene un objeto de tipo 'Atributo' dado su id.
     *
     * @return Atributo que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos
     * @param id a int.
     */
    @Results(id="AtributoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS_ATRIBUTO + " FROM atributo WHERE     id = #{id}     ")
    Atributo getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Atributo'.
     *
     * @return Lista de objetos de tipo Atributo
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("AtributoMap")
    @Select("SELECT " + CAMPOS_ATRIBUTO + " FROM atributo ")
    List<Atributo> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Atributo' con base en la información dada por el objeto de tipo 'Atributo'.
     *
     * @param atributo a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO atributo(id, nombre, activo) "
   + "VALUES(#{id}, #{nombre}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Atributo atributo) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Atributo' con base en la información dada por el objeto de tipo 'Atributo'.
     *
     * @param atributo a ser actualizado.
     * @return el número de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE atributo"
    + " SET nombre = #{nombre}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(Atributo atributo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Atributo.
     *
     * @param id id del Atributo a ser borrado
     * @return id del Atributo borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM atributo WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'atributo' filtrado por el nombre ingresado.
     *
     * @param  nombre nombre de atributo.
     * @return Lista de objetos de tipo Atributo filtrado por el nombre ingresado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("AtributoMap")
    @Select("SELECT " + CAMPOS_ATRIBUTO + " FROM atributo WHERE nombre LIKE '%' #{nombre} '%'")
    List<Atributo> getByNombre(String nombre) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Categoria'.
     *
     * @return Lista de objetos de tipo AtributoDetallesTO
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Select("select a.id as idAtributo, a.nombre as nombreAtributo, a.activo as estatusAtributo, va.id as idRango, va.id_atributo as rangoIdAtributo, va.rango as rango, va.activo as estatusRango  from  atributo a left join valor_atributo va on va.id_atributo = a.id order by a.id, va.id")
    List<AtributoDetalleTO> getAllAtributoDetalle() throws SQLException;
}
