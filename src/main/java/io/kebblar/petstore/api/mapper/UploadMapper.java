package io.kebblar.petstore.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Repository;

import io.kebblar.petstore.api.model.domain.UploadModel;

@Repository
public interface UploadMapper {
    String TABLA = " anuncio_media ";
    String CAMPOS = " id, id_anuncio, uuid, id_tipo, principal, md5, peso ";
    
    @Results(id="UploadMap", value = {
            @Result(property = "id",         column = "id"),
            @Result(property = "idAnuncio",  column = "id_anuncio"),
            // no existe nombreOriginal
            @Result(property = "nuevoNombre",column = "uuid"),
            @Result(property = "idTipo",     column = "id_tipo"),
            @Result(property = "principal",  column = "principal"),
            // no existe mimeType 
            // no existe fechaCarga
            @Result(property = "md5",         column = "md5"),
            @Result(property = "peso",        column = "peso")
            })
    @Select("select " + CAMPOS + " from " + TABLA + " WHERE id_anuncio= #{idAnuncio}")
    List<UploadModel> getMedia(int idAnuncio) throws PersistenceException;

    @Insert("INSERT INTO " + TABLA + "(id_anuncio, uuid, id_tipo, principal, md5, peso) VALUES(#{idAnuncio}, #{nuevoNombre}, #{idTipo}, #{principal}, #{md5}, #{peso} )")
    int insertMedia(UploadModel uploadModel) throws PersistenceException;

    @Delete("DELETE from " + TABLA + " where id=#{id}")
    int deleteMedia(int id) throws PersistenceException;
}
