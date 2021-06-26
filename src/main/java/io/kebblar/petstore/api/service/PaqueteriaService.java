
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
 * Artefacto:   PaqueteriaService .java
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
