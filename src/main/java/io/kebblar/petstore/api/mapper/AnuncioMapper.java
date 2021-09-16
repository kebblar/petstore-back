/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      AnuncioMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:03:19
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.domain.MascotaValorAtributo;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.response.BusquedaAdministracionResponse;
import io.kebblar.petstore.api.model.response.DetalleAnuncioResponse;
import io.kebblar.petstore.api.model.response.MascotaValorAtributoResponse;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Anuncio.
 *
 * @author Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Anuncio
 */
@Repository
public interface AnuncioMapper {

    /** Constant <code>CAMPOS_ANUNCIO=" id_categoria, folio, titulo, descripci"{trunked}</code> */
    String CAMPOS_ANUNCIO = " id_categoria, folio, titulo, descripcion, precio, fecha_inicio_vigencia, " +
            "fecha_fin_vigencia, fecha_alta, fecha_modificacion, fecha_eliminacion, id_estatus, search_url ";
    /** Constant <code>CAMPOS_MASCOTA_VALOR_ATRIBUTOS=" id_anuncio, id_valor_atributo "</code> */
    String CAMPOS_MASCOTA_VALOR_ATRIBUTOS = " id_anuncio, id_valor_atributo ";

    /**
     * Inserta un objeto de tipo 'Anuncio' con base en la información dada por el objeto de tipo 'Anuncio'.
     *
     * @param anuncio a ser insertado.
     * @return identificador en base de datos del registro dado de alta.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO anuncio("+ CAMPOS_ANUNCIO+") VALUES(#{idCategoria}, #{folio},  #{titulo},  #{descripcion},  "
            + " #{precio},  #{fechaInicioVigencia},  #{fechaFinVigencia},  #{fechaAlta},  #{fechaModificacion}, "
            + " #{fechaEliminacion}, #{idEstatus}, #{searchUrl} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Anuncio anuncio) throws SQLException;

    /**
     * Inserta un objeto de tipo 'AnuncioAtributo' con base en la información dada por el objeto de tipo 'AnuncioAtributo'.
     *
     * @param anuncioAtributo a ser insertado.
     * @return identificador en base de datos del registro dado de alta.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO mascota_valor_atributo("+CAMPOS_MASCOTA_VALOR_ATRIBUTOS+") VALUES(#{idAnuncio}, #{idValorAtributo})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insertAtributo(MascotaValorAtributo anuncioAtributo) throws SQLException;

    /**
     * Consulta el objeto de tipo 'Anuncio' con base al id proporcionado.
     *
     * @param id Identificador por medio del cual se realizara la búsqueda del objeto 'anuncio'
     * @return Clase de tipo 'Anuncio' con la información asociada
     * @throws java.sql.SQLException Excepción lanzada en caso de error de base de datos
     */
    @Results(id="AnuncioMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "folio",   column = "folio"),
            @Result(property = "titulo",   column = "titulo"),
            @Result(property = "descripcion",   column = "descripcion"),
            @Result(property = "precio",   column = "precio"),
            @Result(property = "fechaInicioVigencia",   column = "fecha_inicio_vigencia"),
            @Result(property = "fechaFinVigencia",   column = "fecha_fin_vigencia"),
            @Result(property = "fechaAlta",   column = "fecha_alta"),
            @Result(property = "fechaModificacion",   column = "fecha_modificacion"),
            @Result(property = "fechaEliminacion",   column = "fecha_eliminacion"),
            @Result(property = "idEstatus",   column = "id_estatus"),
            @Result(property = "searchUrl",   column = "search_url")
    })
    @Select("SELECT id, " + CAMPOS_ANUNCIO + " FROM anuncio WHERE id = #{id} ")
    Anuncio getAnuncioById(int id) throws SQLException;

    /**
     * Método que retorna todos los anuncios registrados en el sistema.
     *
     * @return Lista de anuncios que existen en el sistema.
     * @throws java.sql.SQLException En caso de no poder realizar la consulta.
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT id, " + CAMPOS_ANUNCIO + " FROM anuncio")
    List<Anuncio> getAll() throws SQLException;

    /**
     * Regresa los anuncios activos o publicados por medio de su url única.
     *
     * @param searchUrl cadena que corresponde a la url de un anuncio.
     * @return lista de anuncios que corresponden al fragmento de la url ingresado.
     * @throws java.sql.SQLException Cuando la consulta no puede ser realizada.
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT id, " + CAMPOS_ANUNCIO + " FROM anuncio WHERE search_url like #{searchUrl} and (id_estatus=2 or id_estatus=3)")
    List<Anuncio> getBySearchUrl(String searchUrl) throws SQLException; // estos paréntesis --> ^ que se usan en el query--> ^ son MUY importantes !!!!

    /**
     * Método que permite actualizar el estatus de un anuncio, con base al identificador del anuncio.
     *
     * @param id Identificador del anuncio a actualizar
     * @param idEstatus Estatus al cual se actualizara el anuncio
     * @return numero de registros actualizados
     * @throws java.sql.SQLException Excepción lanzada en caso de error
     */
    @Update("UPDATE anuncio SET id_estatus = #{idEstatus} WHERE id = #{id} ")
    int actualizaEstatus(int id, short idEstatus) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'anuncio' con base en la información dada por el objeto de tipo 'anuncio'.
     *
     * @param anuncio a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE anuncio SET id_categoria = #{idCategoria}, titulo = #{titulo}, descripcion = #{descripcion}, "
            + " precio = #{precio}, fecha_inicio_vigencia = #{fechaInicioVigencia}, fecha_fin_vigencia = #{fechaFinVigencia}, "
            + " fecha_modificacion = #{fechaModificacion},  fecha_eliminacion = #{fechaEliminacion}, id_estatus = #{idEstatus}, "
            + " search_url = #{searchUrl} "
            + " WHERE id = #{id} ")
    int update(Anuncio anuncio) throws SQLException;

    /**
     * Elimina un objeto del tipo  'anuncio_atributo' asociados a un anuncio.
     *
     * @param id Identificador del anuncio del cual se eliminaran los atributos
     * @return el número de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM mascota_valor_atributo WHERE id_anuncio = #{id} ")
    int deleteAtributos(int id) throws SQLException;

    /**
     * Método que permite actualizar el estatus de un anuncio, con base al identificador del anuncio.
     *
     * @param id Identificador del anuncio a actualizar
     * @param estatus Estatus al cual se actualizara el anuncio
     * @return numero de registros actualizados
     * @throws java.sql.SQLException Excepción lanzada en caso de error
     * @param fechaEliminacion a {@link java.util.Date} object.
     */
    @Update("UPDATE anuncio SET id_estatus = #{estatus}, fecha_eliminacion = #{fechaEliminacion} WHERE id = #{id} ")
    int eliminaAnuncio(int id, short estatus, Date fechaEliminacion) throws SQLException;

    /**
     * Método que mediante una llave hash obtiene la cadena SQL que se realizara.
     *
     * @param map a {@link java.util.Map} object.
     * @return Lista de búsquedaAdministracionResponse
     * @throws java.sql.SQLException
     */
    @Results(id="BusquedaMap", value = {
             @Result(property = "id",   column = "id"),
             @Result(property = "folio",   column = "folio"),
             @Result(property = "titulo",   column = "titulo"),
             @Result(property = "fechaInicioVigencia",   column = "fecha_inicio_vigencia"),
             @Result(property = "fechaFinVigencia",   column = "fecha_fin_vigencia"),
             @Result(property = "idEstatus",   column = "id_estatus"),
             @Result(property = "idCategoria",   column = "id_categoria"),
             @Result(property = "descripcion",   column = "descripcion")
     })
    @Select("${sql}")
    List<BusquedaAdministracionResponse> busquedaAnuncio(Map<String,String> map) throws SQLException;

    /**
     * Obtiene la categoría mediante el id.
     *
     * @param idCategoria a int.
     * @return Modelo Categoria
     * @throws java.sql.SQLException
     */
    @Select("SELECT id, categoria FROM categoria WHERE id = #{idCategoria} ")
    Categoria obtieneCategoria(int idCategoria) throws SQLException;

    /**
     * Método que mediante una llave hash obtiene la cadena SQL que se realizara.
     *
     * @param map a {@link java.util.Map} object.
     * @return Lista de BusquedaAdministracionResponse
     * @throws java.sql.SQLException
     */
    @Select("${total}")
    List<BusquedaAdministracionResponse> obtieneCantidad(Map<String,String> map) throws SQLException;

    /**
     * Consulta el objeto de tipo 'AnuncioAtributo' con base al id del anuncio proporcionado.
     *
     * @param id Identificador del anuncio por medio del cual se realizara la búsqueda de sus imagenes asociadas
     * @return Listado de clases de tipo 'AnuncioAtributo' con la información de los atributos de un anuncio
     */
    @Results(id="AnuncioAtributoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idAtributo",   column = "id_atributo"),
            @Result(property = "valor",   column = "valor")
    })
    @Select("SELECT * FROM anuncio_atributo WHERE id_anuncio = #{id} ")
    List<MascotaValorAtributo> atributosPorAnuncio(int id);

    /**
     * Consulta por filtros para la búsqueda de usuario final.
     *
     * @param map a {@link java.util.Map} object.
     * @return {@link io.kebblar.petstore.api.model.response.DetalleAnuncioResponse} Lista de Detalle Anuncio
     * @throws java.sql.SQLException
     */
    @Results(id="FiltroMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "folio",   column = "folio"),
            @Result(property = "titulo",   column = "titulo"),
            @Result(property = "descripcion",   column = "descripcion"),
            @Result(property = "precio",   column = "precio"),
            @Result(property = "idEstatus",   column = "id_estatus")
    })
    @Select("${sql}")
    List<DetalleAnuncioResponse> busquedaFiltro(Map<String,String> map) throws SQLException;

    /**
     * Consulta por filtros para la búsqueda de usuario final para obtener total de registros.
     *
     * @param map a {@link java.util.Map} object.
     * @return {@link io.kebblar.petstore.api.model.response.DetalleAnuncioResponse} Lista de Detalle Anuncio
     * @throws java.sql.SQLException
     */
    @Select("${total}")
    List<DetalleAnuncioResponse> totalAnuncioFiltro(Map<String,String> map) throws SQLException;

    /**
     * Consulta el objeto de tipo 'MascotaValorAtributo' con base al id del anuncio proporcionado.
     *
     * @param idAnuncio Identificador del anuncio por medio del cual se realizara la búsqueda de sus imagenes asociadas
     * @return Listado de clases de tipo 'ValorAtributoResponse' con la información de los atributos de un anuncio
     */
    @Results(id="MascotaDetalleAtributoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idValorAtributo",   column = "id_valor_atributo"),
            @Result(property = "rango",   column = "rango"),
            @Result(property = "idAtributo",   column = "id_atributo"),
            @Result(property = "nombreAtributo",   column = "nombre_atributo")
    })
    @Select("SELECT mva.id, mva.id_valor_atributo, va.id_atributo AS id_atributo, a.nombre AS nombre_atributo, va.rango "
            + " FROM mascota_valor_atributo mva "
            + " JOIN valor_atributo va ON mva.id_valor_atributo=va.id "
            + " JOIN atributo a ON va.id_atributo=a.id "
            + " WHERE mva.id_anuncio = #{idAnuncio}")
    List<MascotaValorAtributoResponse> valorAtributosPorAnuncio(int idAnuncio);

    /**
     * Obtiene la descripción de la entidad 'estatus_anuncio' para un cierto id (PK) dado.
     *
     * @param id Identificador por medio del cual se realizara la búsqueda del objeto 'estatus_anuncio'
     * @return Cadena con la descripción del estatus
     * @throws java.sql.SQLException Excepción lanzada en caso de error de base de datos
     */
    @Select("SELECT descripcion FROM estatus_anuncio WHERE id = #{id}")
    String obtieneDescPorId(int id) throws SQLException;

    /**
     * Consulta el objeto de tipo 'DetalleAnuncioResponse' con base al id proporcionado.
     *
     * @param id Identificador por medio del cual se realizara la búsqueda del objeto 'anuncio'
     * @return Clase de tipo 'DetalleAnuncioResponse' con la información asociada
     * @throws java.sql.SQLException Excepción lanzada en caso de error de base de datos
     */
    @Results(id="AnuncioDetalleMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "descCategoria",   column = "categoria"),
            @Result(property = "folio",   column = "folio"),
            @Result(property = "titulo",   column = "titulo"),
            @Result(property = "descripcion",   column = "descripcion_anuncio"),
            @Result(property = "precio",   column = "precio"),
            @Result(property = "fechaInicioVigencia",   column = "fecha_inicio_vigencia"),
            @Result(property = "fechaFinVigencia",   column = "fecha_fin_vigencia"),
            @Result(property = "idEstatus",   column = "id_estatus"),
            @Result(property = "descEstatus",   column = "descripcion_estatus"),
            @Result(property = "searchUrl",   column = "search_url")
    })
    @Select("SELECT a.id, a.folio, a.titulo, a.descripcion AS descripcion_anuncio, a.precio, "
            + " a.fecha_inicio_vigencia, a.fecha_fin_vigencia, a.search_url, "
            + " a.id_estatus, a.id_categoria, ea.descripcion as descripcion_estatus, "
            + " cat.categoria FROM anuncio a "
            + " JOIN estatus_anuncio ea ON a.id_estatus=ea.id "
            + " JOIN categoria cat ON a.id_categoria=cat.id "
            + " WHERE a.id = #{id} ")
    DetalleAnuncioResponse getAnuncioDetalle(int id) throws SQLException;

    /**
     * <p>getAllAnuncioDetalle.</p>
     *
     * @return a {@link java.util.List} object.
     * @throws java.sql.SQLException if any.
     */
    @ResultMap("AnuncioDetalleMap")
    @Select("SELECT a.id, a.folio, a.titulo, a.descripcion AS descripcion_anuncio, a.precio, "
            + " a.fecha_inicio_vigencia, a.fecha_fin_vigencia,"
            + " a.id_estatus, a.id_categoria, ea.descripcion as descripcion_estatus, "
            + " cat.categoria FROM anuncio a "
            + " JOIN estatus_anuncio ea ON a.id_estatus=ea.id "
            + " JOIN categoria cat ON a.id_categoria=cat.id ")
    List<DetalleAnuncioResponse> getAllAnuncioDetalle() throws SQLException;

    /**
     * Método que permite consultar los anuncios con base a un esatus y unas fechas de inicio y fin.
     *
     * @param fechaInicio - Filtro de fecha de inicio con la que se comparara la fecha de inicio vigencia
     * @param fechaFin - Filtro de fecha de fin con la que se comparara la fecha de inicio vigencia
     * @param estatus - Estatus mediante el cual se filtraran los anuncios
     * @return Listado de clases de tipo 'Anuncio' con la información de los anuncios
     * @throws java.sql.SQLException Excepción lanzada en caso de error de base de datos
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT id, " + CAMPOS_ANUNCIO + " FROM anuncio  WHERE id_estatus = #{estatus} and fecha_inicio_vigencia BETWEEN #{fechaInicio} AND #{fechaFin}")
    List<Anuncio> anunciosPorPublicar(String fechaInicio, String fechaFin,  short estatus) throws SQLException;

    /**
     * Metodo que permite consultar los anuncios con base a un estatus y unas fechas de inicio y fin.
     *
     * @param fechaFin - Filtro de fecha de fin con la que se comparara la fecha de inicio vigencia
     * @param estatus - Estatus mediante el cual se filtraran los anuncios
     * @return Listado de clases de tipo 'Anuncio' con la información de los anuncios
     * @throws java.sql.SQLException Excepción lanzada en caso de error de base de datos
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT id, " + CAMPOS_ANUNCIO + " FROM anuncio  WHERE id_estatus = #{estatus} and fecha_fin_vigencia < #{fechaFin}")
    List<Anuncio> anunciosPorVencer(String fechaFin, short estatus) throws SQLException;
}
