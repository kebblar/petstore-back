/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AccessService.java
 * Tipo:        Interface
 * AUTOR:       Maria Isabel Contreras Garcia (MICG)
 * Fecha:       Jueves 20 de Mayo de 2021 (01_05)
 *
 * Historia:    .
 *              20210510_0105 Creación de ésta interfaz
 *
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Anuncio;
import io.kebblar.petstore.api.model.domain.AnuncioAtributo;
import io.kebblar.petstore.api.model.domain.AnuncioImagen;
/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Anuncio 
 *
 * @author Isabel Contreras Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Anuncio
 */
@Repository
public interface AnuncioMapper {

	 static final String CAMPOS_ANUNCIO = " id_categoria, sku, titulo, descripcion, precio, fecha_inicio_vigencia,"
	 		+ " fecha_fin_vigencia, fecha_alta, fecha_modificacion, fecha_eliminacion, estatus ";
	 static final String CAMPOS_ANUNCIO_ATRIBUTOS = " id_anuncio, id_atributo, valor ";
	 static final String CAMPOS_ANUNCIO_IMAGEN = " id_anuncio, uuid, imagen ";
	 
	 /**
     * Inserta un objeto de tipo 'Anuncio' con base en la información dada por el objeto de tipo 'Anuncio'.
     *
     * @param Anuncio a ser insertado.
     * @return identificador en base de datos del registro dado de alta.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO anuncio("+CAMPOS_ANUNCIO+") VALUES(#{idCategoria}, #{sku},  #{titulo},  #{descripcion},  #{precio},  #{fechaInicioVigencia},  #{fechaFinVigencia},  #{fechaAlta},  #{fechaModificacion},  #{fechaEliminacion}, #{estatus} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Anuncio anuncio) throws SQLException;
    
    /**
     * Inserta un objeto de tipo 'AnuncioAtributo' con base en la información dada por el objeto de tipo 'AnuncioAtributo'.
     *
     * @param AnuncioAtributo a ser insertado.
     * @return identificador en base de datos del registro dado de alta.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO anuncio_atributo("+CAMPOS_ANUNCIO_ATRIBUTOS+") VALUES(#{idAnuncio}, #{idAtributo}, #{valor} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insertAtributo(AnuncioAtributo anuncioAtributo) throws SQLException;
    
    /**
     * Consulta el objeto de tipo 'Anuncio' con base al id proporcionado
     * 
     * @param id Identificador por medio del cual se realizara la busqueda del objeto 'anuncio'
     * @return Clase de tipo 'Anuncio' con la informacion asociada
     * @throws SQLException Excepcion lanzada en caso de error de base de datos
     */
    @Results(id="AnuncioMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idCategoria",   column = "id_categoria"),
            @Result(property = "sku",   column = "sku"),
            @Result(property = "titulo",   column = "titulo"),
            @Result(property = "descripcion",   column = "descripcion"),
            @Result(property = "precio",   column = "precio"),
            @Result(property = "fechaInicioVigencia",   column = "fecha_inicio_vigencia"),
            @Result(property = "fechaFinVigencia",   column = "fecha_fin_vigencia"),
            @Result(property = "fechaAlta",   column = "fecha_alta"),
            @Result(property = "fechaModificacion",   column = "fecha_modificacion"),
            @Result(property = "fechaEliminacion",   column = "fecha_eliminacion"),
            @Result(property = "estatus",   column = "estatus") 
    })
    @Select("SELECT id, " + CAMPOS_ANUNCIO + " FROM anuncio WHERE id = #{id} ") 
    Anuncio getAnuncioById(int id) throws SQLException;

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
	List<AnuncioImagen> getImagenes(int id);
	    
    /**
     * Inserta un objeto de tipo 'AnuncioImagen' con base en la información dada por el objeto de tipo 'AnuncioImagen'.
     *
     * @param AnuncioImagen a ser insertado.
     * @return identificador en base de datos del registro dado de alta.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO anuncio_imagen("+CAMPOS_ANUNCIO_IMAGEN+") VALUES(#{idAnuncio}, #{uuid}, #{imagen} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insertImagen(AnuncioImagen anuncioImagen) throws SQLException;
	 
    /**
     * Metodo que permite actualizar el estatus de un anuncio,con base al identificador del anuncio
     * @param id Identificador del anuncio a actualizar
     * @param estatus Estatus al cual se actualizara el anuncio
     * @return numero de registyros actualizados
     * @throws SQLException Excepcion lanzada en caso de error
     */
    @Update("UPDATE anuncio SET estatus = #{estatus} WHERE id = #{id} ")
    int actualizaEstatus(int id, short estatus) throws SQLException;    
	    
}
