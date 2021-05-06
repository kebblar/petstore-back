/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   DireccionService.java
 * Tipo:        Interface
 * AUTOR:       Fabiola Camilo Victoriano (FCV)
 * Fecha:       Jueves 6 de Mayo de 2021 (09_29)
 *
 * Historia:    .
 *              20210506_0929 Creación de éste Service
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Direccion;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

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
     * <p>Método utilizado para recuperar un elemento de la tabla 'direccion'. por medio de su llave primaria.
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
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Direccion direccion) throws BusinessException;
    
    /**
     * Método utilizado para actualizar un registro en la tabla 'direccion'.
     * 
     * @param direccion objeto de tipo {@link Direccion}.
     * @return int numero de registros actualizados en la tabla'direccion'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Direccion direccion) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'direccion'.
     * si el elemento no existe se agrega a la base de datos.
     * 
     * @param direccion Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos. 
     */
    int save(Direccion direccion) throws BusinessException;
    
    /**
     * Método utilizado para eliminar un registro en la tabla 'direccion'.
     * 
     * @param direccion objeto de tipo {@link Direccion}.
     * @return int numero de registros eliminados en la tabla'direccion'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Direccion direccion) throws BusinessException;

}
