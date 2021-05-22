
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
 * Artefacto:   UsuarioDetalleService .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       viernes 05 de mayo de 2021 (21_01)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210521_2101 Implementación de interface 
 *
 */

package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.UsuarioDetalle;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'usuario_detalle'. 
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

public interface UsuarioDetalleService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'usuario_detalle'. por medio de su llave primaria.
     * 
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase UsuarioDetalle 
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    UsuarioDetalle getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'usuario_detalle'.
     * 
     * @return Lista con todos los elementos de la tabla 'usuario_detalle'.
     */
    List<UsuarioDetalle> getAll() throws BusinessException;
    
    /**
     * Método utilizado para insertar un registro en la tabla 'usuario_detalle'.
     * 
     * @param usuarioDetalle objeto de tipo 'UsuarioDetalle'.
     * @return int numero de registros insertados en la tabla'usuario_detalle'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(UsuarioDetalle usuarioDetalle) throws BusinessException;
    
    /**
     * Método utilizado para actualizar un registro en la tabla 'usuario_detalle'.
     * 
     * @param  usuarioDetalle objeto de tipo 'UsuarioDetalle'.
     * @return int numero de registros actualizados en la tabla'usuario_detalle'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(UsuarioDetalle usuarioDetalle) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'usuario_detalle'.
     * si el elemento no existe se agrega a la base de datos.
     * 
     * @param usuarioDetalle Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos. 
     */
    int save(UsuarioDetalle usuarioDetalle) throws BusinessException;
    
    /**
     * Método utilizado para eliminar un registro en la tabla 'usuario_detalle'.
     * 
     * @param usuarioDetalle objeto de tipo 'UsuarioDetalle'.
     * @return int numero de registros eliminados en la tabla'usuario_detalle'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(UsuarioDetalle usuarioDetalle) throws BusinessException;

}
