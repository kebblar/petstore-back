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
 * Nombre:      CategoriaService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:43:16
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Categoria;
import io.kebblar.petstore.api.model.domain.CategoriaTO;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'categoria'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface CategoriaService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'categoria'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase Categoria
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    Categoria getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'categoria'.
     *
     * @return Lista con todos los elementos de la tabla 'categoria'.
     */
    List<Categoria> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'categoria'.
     *
     * @param categoria objeto de tipo 'Categoria'.
     * @return int numero de registros insertados en la tabla'categoria'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(Categoria categoria) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'categoria'.
     *
     * @param  categoria objeto de tipo 'Categoria'.
     * @return int numero de registros actualizados en la tabla'categoria'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(Categoria categoria) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'categoria'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param categoria Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(Categoria categoria) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'categoria'.
     *
     * @param categoria objeto de tipo 'Categoria'.
     * @return int numero de registros eliminados en la tabla 'categoria'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(Categoria categoria) throws BusinessException;


    /**
     * Método utilizado para recuperar varios elementos de la tabla 'categoria'. por medio de su nombre.
     *
     * @param nombre categoria.
     * @return La información del elemento recuperado en una instacia de la clase categoria o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Categoria> getByNombre(String nombre) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'categoria'.
     *
     * @return Lista con todos los elementos de la tabla 'categoria'.
     */
    List<CategoriaTO> getAllCategoriaDetalles() throws BusinessException;

}
