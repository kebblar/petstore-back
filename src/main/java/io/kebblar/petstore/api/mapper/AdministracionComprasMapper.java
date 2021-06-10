/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   AdministracionComprasMapper.java
 * Tipo:        Interface
 * AUTOR:       Luis Martinez (LMtz)
 * Fecha:       Jueves 19 de Mayo de 2021 (09_25)
 *
 * Historia:    .
 *              0210519_0925 Creación de éste Mapper
 *
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
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
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
     * @param estadoEnvio, el estado al que se va a actualizar la compra.
     * @param idCompra, la compra que queremos actualizar.
     * @return un entero en caso de que la operacion fue exitosa.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE orden_compra SET estado_envio = ${estadoEnvio} WHERE cve_orden_compra = #{cveCompra};")
    int sent(int estadoEnvio, String cveCompra) throws SQLException;

}
