/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      Municipio
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface para el servicio asociado a la entidad 'municipio'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'municipio'. 
 *
 * @author Gustavo A. Arellano
 * @version 1.0-SNAPSHOT
 */
public interface MunicipioService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'municipio'. por medio de su llave primaria.
     * 
     * @param municipio Instancia de Municipio con los datos de la llave.
     * @return La información del elemento recuperado en una instacia de la clase Empleado o nulo si no se encuentra ese elemento en la tabla.
     */
    Municipio getById(Municipio municipio) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'municipio'.
     * 
     * @return Lista con todos los elementos de la tabla 'municipio'.
     */
    List<Municipio> getAll() throws BusinessException;
    
    /**
     * Método utilizado para insertar un registro en la tabla 'municipio'.
     * 
     * @param municipio objeto de tipo 'Municipio'.
     * @return int numero de registros insertados en la tabla'municipio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Municipio municipio) throws BusinessException;
    
    /**
     * Método utilizado para actualizar un registro en la tabla 'municipio'.
     * 
     * @param municipio objeto de tipo 'Municipio'.
     * @return int numero de registros actualizados en la tabla'municipio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Municipio municipio) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'municipio'.
     * si el elemento no existe se agrega a la base de datos.
     * 
     * @param municipio Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos. 
     */
    int save(Municipio municipio) throws BusinessException;
    
    /**
     * Método utilizado para eliminar un registro en la tabla 'municipio'.
     * 
     * @param municipio objeto de tipo 'Municipio'.
     * @return int numero de registros eliminados en la tabla'municipio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Municipio municipio) throws BusinessException;

}
