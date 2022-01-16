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
 * Nombre:      EstadoService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:44:20
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Estado;
import io.kebblar.petstore.api.model.exceptions.ServiceException;

/**
 * Interface para el servicio asociado a la entidad 'estado'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface EstadoService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'estado'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado.
     * @return La información del elemento recuperado en una instacia de la clase Estado
     * o nulo si no se encuentra ese elemento en la tabla.
     * @throws ServiceException cuando hay un error en la recuperación de la dirección.
     */
    Estado getById(int id) throws ServiceException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'estado'.
     *
     * @return Lista con todos los elementos de la tabla 'estado'.
     * @throws ServiceException cuando ocurre un problema al recuperar los estados.
     */
    List<Estado> getAll() throws ServiceException;

    /**
     * Método utilizado para insertar un registro en la tabla 'estado'.
     *
     * @param estado objeto de tipo 'Estado'.
     * @return int numero de registros insertados en la tabla'estado'.
     * @throws ServiceException es disparada por una regla de negocio
     */
    int insert(Estado estado) throws ServiceException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'estado'.
     *
     * @param  estado objeto de tipo 'Estado'.
     * @return int numero de registros actualizados en la tabla'estado'.
     * @throws ServiceException es disparada por una regla de negocio
     */
    int update(Estado estado) throws ServiceException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'estado'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param estado Información del elemento a guardar.
     * @throws ServiceException En caso un error al momento de guardar los datos.
     */
    int save(Estado estado) throws ServiceException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'estado'.
     *
     * @param estado objeto de tipo 'Estado'.
     * @return int numero de registros eliminados en la tabla'estado'.
     * @throws ServiceException es disparada por una regla de negocio
     */
    int delete(Estado estado) throws ServiceException;

    /**
     * Método que regresa la lista de estados pertenecientes a determinado país.
     * @param id Id del pais que contiene a los estados retornados.
     * @return Lista de Estados del pais 'íd'.
     * @throws ServiceException En caso que ocurra un problema con la recuperación de la información.
     */
    List<Estado> getByPais(int id) throws ServiceException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'estado'. por medio de su nombre.
     *
     * @param nombre Nombre de Estado.
     * @return La información del elemento recuperado en una instacia de la clase Estado o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Estado> getByNombre(String nombre, int idPais) throws ServiceException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'estado'.
     *
     * @return Lista con todos los elementos de la tabla 'estado'.
     */
    List<Estado> getAllNombrePais() throws ServiceException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'estado'. por medio de su pais.
     *
     * @param id Id de Pais.
     * @return La información del elemento recuperado en una instacia de la clase Estado o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Estado> getEstadosByPais(int id) throws ServiceException;

}
