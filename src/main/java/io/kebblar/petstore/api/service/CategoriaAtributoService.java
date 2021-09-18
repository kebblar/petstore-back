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
 * Nombre:      CategoriaAtributoService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:43:01
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.Atributo;
import io.kebblar.petstore.api.model.domain.CategoriaAtributo;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'categoria_atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface CategoriaAtributoService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'categoria_atributo'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase CategoriaAtributo
     * o nulo si no se encuentra ese elemento en la tabla.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    CategoriaAtributo getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'categoria_atributo'.
     *
     * @return Lista con todos los elementos de la tabla 'categoria_atributo'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    List<CategoriaAtributo> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'categoria_atributo'.
     *
     * @param categoriaAtributo objeto de tipo 'CategoriaAtributo'.
     * @return int numero de registros insertados en la tabla'categoria_atributo'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException es disparada por una regla de negocio
     */
    int insert(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'categoria_atributo'.
     *
     * @param  categoriaAtributo objeto de tipo 'CategoriaAtributo'.
     * @return int numero de registros actualizados en la tabla'categoria_atributo'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException es disparada por una regla de negocio
     */
    int update(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'categoria_atributo'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param categoriaAtributo Información del elemento a guardar.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException En caso un error al momento de guardar los datos.
     * @return a int.
     */
    int save(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'categoria_atributo'.
     *
     * @param categoriaAtributo objeto de tipo 'CategoriaAtributo'.
     * @return int numero de registros eliminados en la tabla'categoria_atributo'.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException es disparada por una regla de negocio
     */
    int delete(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'categoria_atributo'.
     *
     * @return Lista con todos los elementos de la tabla 'categoria_atributo'.
     * @param categoria a int.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    List<CategoriaAtributo> getAllAtributoByCategoria(int categoria) throws BusinessException;


    /**
     * Método utilizado para obtener una lista con todos los elementos faltantes de la tabla 'atributo'.
     *
     * @return Lista con todos los elementos de la tabla 'atributo' que no se agregaron a la categoria.
     * @param categoria a int.
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException if any.
     */
    List<Atributo> getAllAtributosFaltantesByCategoria(int categoria) throws BusinessException;


}
