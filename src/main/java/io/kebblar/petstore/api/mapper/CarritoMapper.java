/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para copiarlo,  distribuirlo o modificarlo total
 *              o  parcialmente siempre y cuando  mantenga  este
 *              aviso y  reconozca la  autoría del  código al no
 *              modificar  los datos establecidos en  la mencion
 *              de "AUTOR".
 *
 *              ------------------------------------------------
 *
 * Artefacto:   CarritoMapper .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 06 de June de 2021 (13_15)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210608_1315 Implementación de interface
 *
 */
package io.kebblar.petstore.api.mapper;

import java.util.List;
import java.sql.SQLException;

import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import io.kebblar.petstore.api.model.response.CarritoVista;
import org.apache.ibatis.annotations.*;
import org.exolab.castor.mapping.xml.Sql;
import org.springframework.stereotype.Repository;
import io.kebblar.petstore.api.model.domain.Carrito;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Carrito
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 *
 * @see Carrito
 */
@Repository
public interface CarritoMapper {
    static final String CAMPOS = " id, id_usuario, id_anuncio, cve_orden_compra ";

    /**
     * Obtiene un objeto de tipo 'Carrito' dado su id.
     *
     * @return Carrito que tiene asignado el id pasado como parametro
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @Results(id="CarritoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idUsuario",   column = "id_usuario"),
            @Result(property = "idAnuncio",   column = "id_anuncio"),
            @Result(property = "cveOrdenCompra",   column = "cve_orden_compra")
    })
    @Select("SELECT " + CAMPOS + " FROM carrito WHERE     id = #{id}     ")
    Carrito getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Carrito'.
     *
     * @param id Id del usuario que posee determinado carrito.
     * @return Lista de obetos de tipo Carrito
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("CarritoMap")
    @Select("SELECT " + CAMPOS + " FROM carrito WHERE id_usuario = #{id} AND cve_orden_compra is NULL")
    List<Carrito> getAll(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Carrito' asignados a la orden btc de un usuario.
     *
     * @param idUser Id del usuario que posee determinado carrito.
     * @return Lista de obetos de tipo Carrito
     * @throws SQLException Se dispara en caso de que ocurra un error en esta
     * operación desde la base de datos.
     */
    @ResultMap("CarritoMap")
    @Select("SELECT " + CAMPOS + " FROM carrito WHERE id_usuario = #{idUser} AND cve_orden_compra='btcPen'")
    List<Carrito> getBtcCarrito(int idUser) throws SQLException;

    /**
     * Inserta un objeto de tipo 'Carrito' con base en la información dada por el objeto de tipo 'Carrito'.
     *
     * @param carrito a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO carrito(id_usuario, id_anuncio, cve_orden_compra) VALUES(#{idUsuario}, #{idAnuncio}, NULL )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Carrito carrito) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Carrito' con base en la infrmación dada por el objeto de tipo 'Carrito'.
     *
     * @param carrito a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE carrito SET id_usuario = #{idUsuario}, id_anuncio = #{idAnuncio}, cve_orden_compra = #{cveOrdenCompra} WHERE id = #{id} ")
    int update(Carrito carrito) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Carrito.
     *
     * @param id id del Carrito a ser borrado
     * @return id del Carrito borrado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM carrito WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Recupera los datos necesarios de los articulos de un carrito para generar el pdf de la compra.
     * @param cve cadena que representa el id de la compra.
     * @return Lista de datos sobre los elementos comprados.
     * @throws SQLException Si ocurre algun problema en la consulta.
     */
    @Results(id="CarritoDatos", value = {
            @Result(property = "titulo",   column = "titulo"),
            @Result(property = "descripcion",   column = "descripcion"),
            @Result(property = "precio",   column = "precio")
    })
    @Select("SELECT titulo,precio,descripcion FROM anuncio, carrito WHERE anuncio.id = carrito.id_anuncio AND cve_orden_compra = #{cve}")
    List<CarritoDatosFactura> getByCve(String cve) throws SQLException;
}
