/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      DireccionService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:44:03
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
import io.kebblar.petstore.api.model.request.NuevaDireccion;
import io.kebblar.petstore.api.model.response.DireccionConNombre;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad {@link Direccion}.
 *
 * @author Gustavo A. Arellano
 * @since 1.0-SNAPSHOT
 * @version 1.0-SNAPSHOT
 */
public interface DireccionService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'direccion'. por medio de su llave primaria.
     *
     * @param direccion Instancia de Direccion con los datos de la llave.
     * @return La información del elemento recuperado en una instacia de la clase Empleado o nulo si no se encuentra ese elemento en la tabla.
     */
    Direccion getById(Direccion direccion) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'direccion'.
     *
     * @return Lista con todos los elementos de la tabla 'direccion'.
     */
    List<Direccion> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'direccion'.
     *
     * @param direccion objeto de tipo {@link Direccion}.
     * @return int numero de registros insertados en la tabla'direccion'.
     * @throws BusinessException es disparada por una regla de negocio
     */
    int insert(Direccion direccion) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'direccion'.
     *
     * @param direccion objeto de tipo {@link Direccion}.
     * @return int numero de registros actualizados en la tabla'direccion'.
     * @throws BusinessException es disparada por una regla de negocio
     */
    int update(Direccion direccion) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'direccion'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param direccion Información del elemento a guardar.
     * @throws BusinessException En caso un error al momento de guardar los datos.
     */
    int save(Direccion direccion) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'direccion'.
     *
     * @param direccion objeto de tipo {@link Direccion}.
     * @return int numero de registros eliminados en la tabla'direccion'.
     * @throws BusinessException es disparada por una regla de negocio
     */
    int delete(Direccion direccion) throws BusinessException;

    /**
     * Método utilizado para recuperar una lista de elementos de la tabla 'direccion_con_nombre'. asociadas al usuario con el id
     * "id_user".
     *
     * @param idUser Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase DireccionConNombre
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    List<DireccionConNombre> getDireccionesNombre(int idUser) throws BusinessException;

    /**
     * Metodo que recibe los datos de una direccion agregada durante el proceso de compra y distribuye su
     * contenido para almacenarlo de forma correcta en el sistema.
     * @param nuevaDireccion objeto con los datos de la nueva dirección a insertar.
     * @return entero si sale bien.
     * @throws BusinessException En caso que ocurra un error en el sistema o en el proceso de inserción.
     */
    int agregaDireccion(NuevaDireccion nuevaDireccion) throws BusinessException;

}

