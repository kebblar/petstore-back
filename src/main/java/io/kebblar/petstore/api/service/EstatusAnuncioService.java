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
 * Artefacto:   EstatusAnuncioService .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (00_13)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210606_0013 Implementación de interface
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.EstatusAnuncio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'estatus_anuncio'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public interface EstatusAnuncioService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'estatus_anuncio'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase EstatusAnuncio
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    EstatusAnuncio getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'estatus_anuncio'.
     *
     * @return Lista con todos los elementos de la tabla 'estatus_anuncio'.
     */
    List<EstatusAnuncio> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'estatus_anuncio'.
     *
     * @param estatusAnuncio objeto de tipo 'EstatusAnuncio'.
     * @return int numero de registros insertados en la tabla'estatus_anuncio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(EstatusAnuncio estatusAnuncio) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'estatus_anuncio'.
     *
     * @param  estatusAnuncio objeto de tipo 'EstatusAnuncio'.
     * @return int numero de registros actualizados en la tabla'estatus_anuncio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(EstatusAnuncio estatusAnuncio) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'estatus_anuncio'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param estatusAnuncio Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(EstatusAnuncio estatusAnuncio) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'estatus_anuncio'.
     *
     * @param estatusAnuncio objeto de tipo 'EstatusAnuncio'.
     * @return int numero de registros eliminados en la tabla'estatus_anuncio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(EstatusAnuncio estatusAnuncio) throws BusinessException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'EstatusAnuncio'. por medio de su nombre.
     *
     * @param nombre Nombre de EstatusAnuncio.
     * @return La información del elemento recuperado en una instacia de la clase EstatusAnuncio o nulo si no se encuentra ese elemento en la tabla.
     */
    List<EstatusAnuncio> getByNombre(String nombre) throws BusinessException;
}
