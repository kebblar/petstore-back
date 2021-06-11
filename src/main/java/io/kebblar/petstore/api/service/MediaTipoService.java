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
 * Artefacto:   MediaTipoService .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       sábado 06 de junio de 2021 (23_19)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210605_2319 Implementación de interface
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.MediaTipo;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'media_tipo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface MediaTipoService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'media_tipo'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase MediaTipo
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    MediaTipo getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'media_tipo'.
     *
     * @return Lista con todos los elementos de la tabla 'media_tipo'.
     */
    List<MediaTipo> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'media_tipo'.
     *
     * @param mediaTipo objeto de tipo 'MediaTipo'.
     * @return int numero de registros insertados en la tabla'media_tipo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(MediaTipo mediaTipo) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'media_tipo'.
     *
     * @param  mediaTipo objeto de tipo 'MediaTipo'.
     * @return int numero de registros actualizados en la tabla'media_tipo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(MediaTipo mediaTipo) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'media_tipo'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param mediaTipo Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(MediaTipo mediaTipo) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'media_tipo'.
     *
     * @param mediaTipo objeto de tipo 'MediaTipo'.
     * @return int numero de registros eliminados en la tabla'media_tipo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(MediaTipo mediaTipo) throws BusinessException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'MediaTipo'. por medio de su nombre.
     *
     * @param nombre Nombre de MediaTipo.
     * @return La información del elemento recuperado en una instacia de la clase MediaTipo o nulo si no se encuentra ese elemento en la tabla.
     */
    List<MediaTipo> getByNombre(String nombre) throws BusinessException;

}
