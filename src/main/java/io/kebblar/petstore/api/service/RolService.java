
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
 * Artefacto:   RolService .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       jueves 06 de junio de 2021 (17_26)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210624_1726 Implementación de interface
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Rol;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'rol'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public interface RolService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'rol'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase Rol
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    Rol getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'rol'.
     *
     * @return Lista con todos los elementos de la tabla 'rol'.
     */
    List<Rol> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'rol'.
     *
     * @param rol objeto de tipo 'Rol'.
     * @return int numero de registros insertados en la tabla'rol'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Rol rol) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'rol'.
     *
     * @param  rol objeto de tipo 'Rol'.
     * @return int numero de registros actualizados en la tabla'rol'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Rol rol) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'rol'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param rol Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(Rol rol) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'rol'.
     *
     * @param rol objeto de tipo 'Rol'.
     * @return int numero de registros eliminados en la tabla'rol'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Rol rol) throws BusinessException;

}
