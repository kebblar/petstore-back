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
 * Nombre:      AdministracionComprasMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:03:00
 */
package io.kebblar.petstore.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import io.kebblar.petstore.api.model.domain.AdministracionCompras;
/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'AdministracionCompras'.
 *
 * @author  LMtz
 * @see     io.kebblar.petstore.api.model.domain.AdministracionCompras
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface AdministracionComprasMapper {

    /**
     * Obtiene todas las compras hechas por los usuarios.
     *
     * @return Una lista de las compras hechas por los usuarios.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="AministracionComprasMap", value = {
            @Result(property = "estadoEnvio", column = "estado_envio"),
            @Result(property = "calleNumero", column = "calle_numero"),
            @Result(property = "colonia", column = "colonia"),
            @Result(property = "cp", column = "cp"),
            @Result(property = "cveOrden", column = "cve_orden_compra"),
            @Result(property = "nombreAnuncio", column = "nombre_anuncio"),
            @Result(property = "urlFactura", column = "recibo"),
            @Result(property = "fechaCompra", column = "fecha_hora_comprar"),
        })
    @Select("select estado_envio,calle_numero,colonia,cp,cve_orden_compra,nombre_anuncio,recibo,DATE_FORMAT(fecha_hora_comprar, '%d/%m/%y') as fecha_hora_comprar from administracion_compras;")
    List<AdministracionCompras> getAll() throws SQLException;

    /**
     * Actualiza el estado de una compra de en camino a enviado.
     *
     * @param estadoEnvio el estado al que se va a actualizar la compra.
     * @param cveCompra la compra que queremos actualizar.
     * @return un entero en caso de que la operacion fue exitosa.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE orden_compra SET estado_envio = ${estadoEnvio} WHERE cve_orden_compra = #{cveCompra};")
    int sent(int estadoEnvio, String cveCompra) throws SQLException;

}
