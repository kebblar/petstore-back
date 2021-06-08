
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
 * Artefacto:   CarritoService .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 06 de June de 2021 (13_15)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210608_1315 Implementación de interface 
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Carrito;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'carrito'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public interface CarritoService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'carrito'. por medio de su llave primaria.
     * 
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase Carrito 
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    Carrito getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'carrito'.
     *
     * @param id Id del usuario del que ser recuprear'a su carrito.
     * @return Lista con todos los elementos de la tabla 'carrito'.
     */
    List<Carrito> getAll(int id) throws BusinessException;
    
    /**
     * Método utilizado para insertar un registro en la tabla 'carrito'.
     * 
     * @param carrito objeto de tipo 'Carrito'.
     * @return int numero de registros insertados en la tabla'carrito'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Carrito carrito) throws BusinessException;
    
    /**
     * Método utilizado para actualizar un registro en la tabla 'carrito'.
     * 
     * @param  carrito objeto de tipo 'Carrito'.
     * @return int numero de registros actualizados en la tabla'carrito'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Carrito carrito) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'carrito'.
     * si el elemento no existe se agrega a la base de datos.
     * 
     * @param carrito Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos. 
     */
    int save(Carrito carrito) throws BusinessException;
    
    /**
     * Método utilizado para eliminar un registro en la tabla 'carrito'.
     * 
     * @param carrito objeto de tipo 'Carrito'.
     * @return int numero de registros eliminados en la tabla'carrito'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Carrito carrito) throws BusinessException;

}
