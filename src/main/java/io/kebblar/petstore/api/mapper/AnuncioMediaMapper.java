/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioMediaMapper.java
 * Tipo:        Interface
 * AUTOR:       Maria Isabel Contreras Garcia (MICG)
 * Fecha:       Jueves 25 de Mayo de 2021 (17_58)
 *
 * Historia:    .
 *              20210525_1758 Creación de ésta interfaz
 *
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.AnuncioMedia;

import static io.kebblar.petstore.api.mapper.constants.Campos.CAMPOS_ANUNCIO_MEDIA;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad AnuncioImagen.
 *
 * @author Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see AnuncioMapper
 */
@Repository
public interface AnuncioMediaMapper {

    /**
     * Consulta el objeto de tipo 'AnuncioMedia' con base al id del anuncio proporcionado.
     *
     * @param id Identificador del anuncio por medio del cual se realizara la búsqueda de sus imagenes asociadas
     * @return Listado de clases de tipo 'AnuncioMedia' con la información de las imágenes
     * @throws SQLException Excepción lanzada en caso de error de base de datos
     */
    @Results(id="AnuncioImagenMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idAnuncio",   column = "id_anuncio"),
            @Result(property = "uuid",   column = "uuid"),
            @Result(property = "idTipo",   column = "id_tipo"),
            @Result(property = "principal",   column = "principal")
    })
    @Select("SELECT id," + CAMPOS_ANUNCIO_MEDIA + " FROM anuncio_media WHERE id_anuncio = #{id} ORDER BY principal DESC")
    List<AnuncioMedia> getImagenes(int id);

    /**
     * Consulta el objeto de tipo 'AnuncioImagen' con base al id proporcionado.
     *
     * @param uuid Identificador de la imagen por medio del cual se realizara la búsqueda de sus imagen
     * @return Clase de tipo 'AnuncioImagen' con la información de las imágen solicitada
     * @throws SQLException Excepción lanzada en caso de error de base de datos
     */
    @ResultMap("AnuncioImagenMap")
    @Select("SELECT id," + CAMPOS_ANUNCIO_MEDIA + " FROM anuncio_media WHERE uuid = #{uuid} ")
    AnuncioMedia getImagen(String uuid);

    /**
     * Inserta un objeto de tipo 'AnuncioImagen' con base en la información dada por el objeto de tipo 'AnuncioImagen'.
     *
     * @param AnuncioMedia a ser insertado.
     * @return identificador en base de datos del registro dado de alta.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO anuncio_media("+CAMPOS_ANUNCIO_MEDIA+") VALUES(#{idAnuncio}, #{uuid}, #{idTipo}, #{principal} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insertImagen(AnuncioMedia anuncioImagen) throws SQLException;

    /**
     * Elimina un objeto de tipo 'AnuncioImagen' con base al identificador proporcionado.
     *
     * @param uuid identificador del anuncio a ser eliminado
     * @return identificador en base de datos del registro eliminado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM anuncio_media WHERE uuid = #{uuid} ")
    int eliminarImagen(String uuid) throws SQLException;

    /**
     * Metodo que permite actualizar si una imagen es principal o no, con base al uuid de la imagen.
     *
     * @param uuid Identificador del anuncio a actualizar
     * @param principal Indica si la imagen sera o no principal
     * @return numero de registros actualizados
     * @throws SQLException Excepción lanzada en caso de error
     */
    @Update("UPDATE anuncio_media SET principal = #{principal} WHERE uuid = #{uuid} ")
    int actualizaPrincipal(String uuid, Boolean principal) throws SQLException;

}
