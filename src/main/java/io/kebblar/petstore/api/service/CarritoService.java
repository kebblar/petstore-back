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
 * Artefacto:   CarritoService .java
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
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.exceptions.VistaCarritoException;
import io.kebblar.petstore.api.model.response.CarritoDatosFactura;
import io.kebblar.petstore.api.model.response.CarritoVista;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'carrito'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface CarritoService {
    /**
     * Método utilizado para recuperar un elemento de la tabla 'carrito'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase Carrito
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    Carrito getById(int id) throws BusinessException;

    /**
     * Método que, dado la clave de la orden compra de un pedido, devuelve el carrito
     * asociado a este.
     * @param cve Clave de orden compra.
     * @return Listado de objetos dentro del carrito con información textual.
     * @throws BusinessException
     */
    List<CarritoDatosFactura> getByCveOrden(String cve) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'carrito'.
     *
     * @param id Id del usuario del que ser recuprear'a su carrito.
     * @return Lista con todos los elementos de la tabla 'carrito'.
     */
    List<Carrito> getAll(int id) throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'carrito'.
     *
     * @param carrito objeto de tipo 'Carrito'.
     * @return int numero de registros insertados en la tabla'carrito'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Carrito carrito) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'carrito'.
     *
     * @param  carrito objeto de tipo 'Carrito'.
     * @return int numero de registros actualizados en la tabla'carrito'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Carrito carrito) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'carrito'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param carrito Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(Carrito carrito) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'carrito'.
     *
     * @param id id del objeto de tipo 'Carrito'.
     * @return int numero de registros eliminados en la tabla'carrito'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(int id) throws BusinessException;

    /**
     * Regresa os elementos necesarios para pintar un carrito de compras en la
     * interfaz grafica. Es un filtro que solamente retorna lo que se le muestra
     * vistalmente al usuario.
     * @param id id del usuario del que se recupera el carrito.
     * @return lista de los elementos del carrito del usuario, solamente conteniendo
     * la informaci'on necesaria para pintarlos.
     */
    List<CarritoVista> getCarritoView(int id) throws VistaCarritoException;

    /**
     * Método que dado los datos de una compra que un usuario ya ha realizado, se encarga
     * de introducir dicha información en el sistema, asociando un carrito de compras con una
     * orden de compra ya pagada.
     * @param cveCompra clave de la orden compra.
     * @param idUser id del usuario.
     * @throws BusinessException Cuando no puee actualizarse el carrito de compras con la orden.
     */
    void updateCarritoCompra(String cveCompra, int idUser) throws BusinessException;

    /**
     * Método que dado los datos de una compra que un usuario ya ha realizado en BTC, se encarga
     * de introducir dicha información en el sistema, asociando un carrito de compras con una
     * orden de compra ya pagada.
     * @param cveOrdenCompra clave de la orden compra.
     * @param idUser id del usuario.
     * @throws BusinessException Cuando no puee actualizarse el carrito de compras con la orden.
     */
    void updateCarritoCompraBtc(String cveOrdenCompra, int idUser) throws BusinessException;
}
