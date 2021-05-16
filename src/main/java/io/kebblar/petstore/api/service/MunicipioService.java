/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   MunicipioService.java
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Tuesday 05 de May de 2021 (14_44)
 * 
 *              ------------------------------------------------
 *
 * Historia:    .
 *              20210504_1635 Creación de la interfaz
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad {@link Municipio}. 
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Municipio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface MunicipioService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'municipio'. por medio de su llave primaria.
     * 
     * @param id Identificador de la Instancia de Municipio con los datos de la llave.
     * @return Objeto de tipo  {@link Municipio} con la respuesta esperada por el fronted
     * @throws BusinessException La información del elemento recuperado en una instacia de la clase Empleado o nulo si no se encuentra ese elemento en la tabla.
     */
    Municipio getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'municipio'.
     * 
     * @return Lista con todos los elementos de la tabla 'municipio'.
     */
    List<Municipio> getAll() throws BusinessException;
    
    /**
     * Método utilizado para recuperar una lista de municipios por medio del identificador del estado
     * @param idEstado
     * @return Lista de municipios que pertenezcan al estado solicitado
     * @throws BusinessException
     */
    List<Municipio> getAllByEstado(int idEstado) throws BusinessException;
    
    /**
     * Método utilizado para insertar un registro en la tabla 'municipio'.
     * 
     * @param municipio objeto de tipo 'Municipio'.
     * @return int numero de registros insertados en la tabla 'municipio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Municipio municipio) throws BusinessException;
    
    /**
     * Método utilizado para actualizar un registro en la tabla 'municipio'.
     * 
     * @param  municipio objeto de tipo 'Municipio'.
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
     * @return int numero de registros eliminados en la tabla 'municipio'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Municipio municipio) throws BusinessException;

    /**
     * Retorna una lista paginada de objetos de tipo {@Code Municipio} asociados a un cierto estado
     * 
     * @param idEstado Estado del que retoraremos el conjunto de municipios paginados
     * @param pageNumber Número de página (empieza en la 1)
     * @param pageSize Tamaño de la página
     * 
     * @return  Lista paginada de objetos de tipo Municipio
     * @throws Exception es disparada por una regla de negocio
     */
    List<Municipio> getPaginatedMunicipios(int idEstado, int pageNumber, int pageSize) throws BusinessException;

}
