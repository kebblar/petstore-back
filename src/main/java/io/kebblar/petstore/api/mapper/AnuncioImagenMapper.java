/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AnuncioImagenMapper.java
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
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.AnuncioMedia;
/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad AnuncioImagen 
 *
 * @author Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see AnuncioMapper
 */
@Repository
public interface AnuncioImagenMapper {

	 static final String CAMPOS_ANUNCIO_IMAGEN = " id_anuncio, uuid, imagen ";
	 
  
    /**
     * Consulta el objeto de tipo 'AnuncioImagen' con base al id del anuncio proporcionado
     * 
     * @param id Identificador del anunciocpor medio del cual se realizara la busqueda de sus imagenes asociadas
     * @return Listado de clases de tipo 'AnuncioImagen' con la informacion de las imagenes
     * @throws SQLException Excepcion lanzada en caso de error de base de datos
     */
    @Results(id="AnuncioImagenMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idAnuncio",   column = "id_anuncio"),
            @Result(property = "uuid",   column = "uuid"),
            @Result(property = "imagen",   column = "imagen")
    })
    @Select("SELECT id," + CAMPOS_ANUNCIO_IMAGEN + " FROM anuncio_imagen WHERE id_anuncio = #{id} ") 
	List<AnuncioMedia> getImagenes(int id);
    
    /**
     * Consulta el objeto de tipo 'AnuncioImagen' con base al id proporcionado
     * 
     * @param id Identificador de la imagen por medio del cual se realizara la busqueda de sus imagen
     * @return Clase de tipo 'AnuncioImagen' con la informacion de las imagen solicitada
     * @throws SQLException Excepcion lanzada en caso de error de base de datos
     */
    @ResultMap("AnuncioImagenMap")
    @Select("SELECT id," + CAMPOS_ANUNCIO_IMAGEN + " FROM anuncio_imagen WHERE uuid = #{uuid} ") 
	AnuncioMedia getImagen(String uuid);
	    
    /**
     * Inserta un objeto de tipo 'AnuncioImagen' con base en la información dada por el objeto de tipo 'AnuncioImagen'.
     *
     * @param AnuncioMedia a ser insertado.
     * @return identificador en base de datos del registro dado de alta.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO anuncio_imagen("+CAMPOS_ANUNCIO_IMAGEN+") VALUES(#{idAnuncio}, #{uuid}, #{imagen} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insertImagen(AnuncioMedia anuncioImagen) throws SQLException;
    
    /**
     * Elimina un objeto de tipo 'AnuncioImagen' con base al identificador proporcionado.
     *
     * @param idImagen identificador del anuncio a ser eliminado
     * @return identificador en base de datos del registro eliminado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM anuncio_imagen WHERE uuid = #{uuid} ") 
    int eliminarImagen(String uuid) throws SQLException;
    
}
