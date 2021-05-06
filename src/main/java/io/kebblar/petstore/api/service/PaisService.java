/*
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mencion de "AUTOR".
 *
 * Proyecto:    petstore
 * Paquete:     io.kebblar.petstore.api.service
 * Modulo:      Pais
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano
 * Fecha:       Wednesday 04 de April de 2021 (09_35)
 * Version:     1.0-SNAPSHOT
 * .
 * Interface para el servicio asociado a la entidad 'pais'. 
 *
 * Historia:    .
 *              20210421_0935 Generado por arq.gen, basado en los
 *              archivos fuente de Gustavo Arellano
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Pais;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'pais'. 
 *
 * @author Gustavo A. Arellano
 * @see     io.kebblar.petstore.api.model.domain.Pais
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface PaisService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'pais'. por medio de su llave primaria.
     * 
     * @param id ID de Pais (la llave).
     * @return La información del elemento recuperado en una instacia de la clase Empleado o nulo si no se encuentra ese elemento en la tabla.
     */
    Pais getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'pais'.
     * 
     * @return Lista con todos los elementos de la tabla 'pais'.
     */
    List<Pais> getAll() throws BusinessException;
    
    /**
     * Método utilizado para insertar un registro en la tabla 'pais'.
     * 
     * @param pais objeto de tipo 'Pais'.
     * @return int numero de registros insertados en la tabla'pais'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Pais pais) throws BusinessException;
    
    /**
     * Método utilizado para actualizar un registro en la tabla 'pais'.
     * 
     * @param pais objeto de tipo 'Pais'.
     * @return int numero de registros actualizados en la tabla'pais'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Pais pais) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'pais'.
     * si el elemento no existe se agrega a la base de datos.
     * 
     * @param pais Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos. 
     */
    int save(Pais pais) throws BusinessException;
    
    /**
     * Método utilizado para eliminar un registro en la tabla 'pais'.
     * 
     * @param pais objeto de tipo 'Pais'.
     * @return int numero de registros eliminados en la tabla'pais'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Pais pais) throws BusinessException;

}
