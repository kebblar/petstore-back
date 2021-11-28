/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      UsuarioCompletoService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 09:23:31
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.UsuarioCompleto;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'usuario_completo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface UsuarioCompletoService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'usuario_completo'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase UsuarioCompleto
     * o nulo si no se encuentra ese elemento en la tabla.
     * @throws BusinessException if any.
     */
    UsuarioCompleto getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'usuario_completo'.
     *
     * @return Lista con todos los elementos de la tabla 'usuario_completo'.
     * @throws BusinessException if any.
     */
    List<UsuarioCompleto> getAll() throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'usuario_completo'.
     *
     * @param  usuarioCompleto objeto de tipo 'UsuarioCompleto'.
     * @return int numero de registros actualizados en la tabla'usuario_completo'.
     * @throws BusinessException es disparada por una regla de negocio
     */
    int update(UsuarioCompleto usuarioCompleto) throws BusinessException;

    /**
     * Método utilizado para obtener una lista PAGINADA con todos los elementos de la tabla 'usuario_completo'.
     *
     * @return Lista con todos los elementos de la tabla 'usuario_completo'.
     * @param startRow a int.
     * @param pageSize a int.
     * @throws BusinessException if any.
     */
    List<UsuarioCompleto> getAllPaginated(int startRow, int pageSize) throws BusinessException;

    /**
     * Regresa el Conteo de usuarios en el sistema.
     *
     * @return entero con el Conteo de usuarios en el sistema.
     * @throws BusinessException si ocurre un problema al contar a los usuarios.
     */
    int countUsuarios() throws BusinessException;
}
