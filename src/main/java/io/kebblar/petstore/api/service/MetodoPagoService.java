
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
 * Artefacto:   MetodoPagoService .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210511_1444 Implementación de interface
 *
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
     */
    MetodoPago getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'metodo_pago'.
     *
     * @return Lista con todos los elementos de la tabla 'metodo_pago'.
     */
    List<MetodoPago> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'metodo_pago'.
     *
     * @param metodoPago objeto de tipo 'MetodoPago'.
     * @return int numero de registros insertados en la tabla'metodo_pago'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'metodo_pago'.
     *
     * @param  metodoPago objeto de tipo 'MetodoPago'.
     * @return int numero de registros actualizados en la tabla'metodo_pago'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'metodo_pago'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param metodoPago Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'metodo_pago'.
     *
     * @param metodoPago objeto de tipo 'MetodoPago'.
     * @return int numero de registros eliminados en la tabla'metodo_pago'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(MetodoPago metodoPago) throws BusinessException;

    /**
     * Método utilizado para recuperar una lista elemento de la tabla 'metodo_pago'. por medio del usuario al que pertenecen.
     *
     * @param id Id del usuario
     * @return La información del elemento recuperado en un listado de objetos de la clase MetodoPago
     * o la lista vacia si no hay elementos.
     */
    List<MetodoPago> getByIdUser(int id) throws BusinessException;
}
