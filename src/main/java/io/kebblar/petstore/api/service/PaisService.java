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
 * Nombre:      PaisService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:49:00
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.model.exceptions.ServiceException;

/**
 * Interface para el servicio asociado a la entidad 'pais'.
 *
 * @author Luz
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface PaisService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'pais'. por medio de su llave primaria.
     *
     * @param id ID de Pais (la llave).
     * @return La información del elemento recuperado en una instacia de la clase Empleado o nulo si no se encuentra ese elemento en la tabla.
     */
    Pais getById(int id) throws ServiceException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'pais'.
     *
     * @return Lista con todos los elementos de la tabla 'pais'.
     */
    List<Pais> getAll() throws ServiceException;

    /**
     * Método utilizado para insertar un registro en la tabla 'pais'.
     *
     * @param pais objeto de tipo 'Pais'.
     * @return int numero de registros insertados en la tabla'pais'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Pais pais) throws ServiceException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'pais'.
     *
     * @param  pais objeto de tipo 'Pais'.
     * @return int numero de registros actualizados en la tabla'pais'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Pais pais) throws ServiceException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'pais'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param pais Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(Pais pais) throws ServiceException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'pais'.
     *
     * @param pais objeto de tipo 'Pais'.
     * @return int numero de registros eliminados en la tabla'pais'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Pais pais) throws ServiceException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'pais'. por medio de su nombre.
     *
     * @param nombre Nombre de Pais.
     * @return La información del elemento recuperado en una instacia de la clase País o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Pais> getByNombre(String nombre) throws ServiceException;
}
