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
 * Nombre:      HistorialComprasMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:09:26
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import io.kebblar.petstore.api.model.domain.HistorialCompras;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'AdministracionCompras'.
 *
 * @author  LMtz
 * @see     io.kebblar.petstore.api.model.domain.AdministracionCompras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface HistorialComprasMapper {

    /**
     * Obtiene todas las compras hechas por un usuario.
     *
     * @param idUsuario el id del usuario del que queremos saber sus compras.
     * @return Una lista de las compras hechas por un usuario.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="HistorialMap", value = {
            @Result(property = "cveOrden", column = "cve_orden_compra"),
            @Result(property = "fechaHoraCompra", column = "fecha_hora_comprar"),
            @Result(property = "estadoEnvio", column = "estado_envio"),
            @Result(property = "nombreAnuncio", column = "nombre_anuncio"),
            @Result(property = "metodoPago", column = "tipo"),
            @Result(property = "correo", column = "correo"),
            @Result(property = "urlPdf", column = "recibo"),
            @Result(property = "urlImagen", column = "imagen"),
        })
    @Select("SELECT cve_orden_compra,DATE_FORMAT(fecha_hora_comprar, '%d/%m/%y') as fecha_hora_comprar,estado_envio,nombre_anuncio,tipo,correo,recibo,imagen,id_usuario FROM historial_compras WHERE id_usuario = #{idUsuario}; ")
    List<HistorialCompras> getAll(@Param("idUsuario") int idUsuario) throws SQLException;
}
