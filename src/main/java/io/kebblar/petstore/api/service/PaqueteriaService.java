/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      PaqueteriaService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:49:19
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Paqueteria;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'paqueteria'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public interface PaqueteriaService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'paqueteria'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase Paqueteria
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    Paqueteria getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'paqueteria'.
     *
     * @return Lista con todos los elementos de la tabla 'paqueteria'.
     */
    List<Paqueteria> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'paqueteria'.
     *
     * @param paqueteria objeto de tipo 'Paqueteria'.
     * @return int numero de registros insertados en la tabla'paqueteria'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Paqueteria paqueteria) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'paqueteria'.
     *
     * @param  paqueteria objeto de tipo 'Paqueteria'.
     * @return int numero de registros actualizados en la tabla'paqueteria'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Paqueteria paqueteria) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'paqueteria'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param paqueteria Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(Paqueteria paqueteria) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'paqueteria'.
     *
     * @param paqueteria objeto de tipo 'Paqueteria'.
     * @return int numero de registros eliminados en la tabla'paqueteria'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Paqueteria paqueteria) throws BusinessException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'paqueteria'. por medio de su nombre.
     *
     * @param nombre Nombre la paqueteria.
     * @return La información del elemento recuperado en una instacia de la clase paqueteria o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Paqueteria> getByNombre(String nombre) throws BusinessException;
}
