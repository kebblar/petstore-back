/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      MetodoPagoService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:48:07
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.MetodoPago;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'metodo_pago'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface MetodoPagoService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'metodo_pago'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase MetodoPago
     * o nulo si no se encuentra ese elemento en la tabla.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    MetodoPago getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'metodo_pago'.
     *
     * @return Lista con todos los elementos de la tabla 'metodo_pago'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    List<MetodoPago> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'metodo_pago'.
     *
     * @param metodoPago objeto de tipo 'MetodoPago'.
     * @return int numero de registros insertados en la tabla'metodo_pago'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException es disparada por una regla de negocio
     */
    int insert(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'metodo_pago'.
     *
     * @param  metodoPago objeto de tipo 'MetodoPago'.
     * @return int numero de registros actualizados en la tabla'metodo_pago'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException es disparada por una regla de negocio
     */
    int update(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'metodo_pago'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param metodoPago Información del elemento a guardar.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException En caso un error al momento de guardar los datos.
     * @return a int.
     */
    int save(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'metodo_pago'.
     *
     * @param metodoPago objeto de tipo 'MetodoPago'.
     * @return int numero de registros eliminados en la tabla'metodo_pago'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException es disparada por una regla de negocio
     */
    int delete(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para recuperar una lista elemento de la tabla 'metodo_pago'. por medio del usuario al que pertenecen.
     *
     * @param id Id del usuario
     * @return La información del elemento recuperado en un listado de objetos de la clase MetodoPago
     * o la lista vacia si no hay elementos.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    List<MetodoPago> getByIdUser(int id) throws BusinessException;
}
