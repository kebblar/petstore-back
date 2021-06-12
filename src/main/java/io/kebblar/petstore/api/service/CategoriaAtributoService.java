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
 * Artefacto:   CategoriaAtributoService .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       domingo 06 de junio de 2021 (19_06)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210606_1906 Implementación de interface
 *
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
     */
    CategoriaAtributo getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'categoria_atributo'.
     *
     * @return Lista con todos los elementos de la tabla 'categoria_atributo'.
     */
    List<CategoriaAtributo> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'categoria_atributo'.
     *
     * @param categoriaAtributo objeto de tipo 'CategoriaAtributo'.
     * @return int numero de registros insertados en la tabla'categoria_atributo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'categoria_atributo'.
     *
     * @param  categoriaAtributo objeto de tipo 'CategoriaAtributo'.
     * @return int numero de registros actualizados en la tabla'categoria_atributo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'categoria_atributo'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param categoriaAtributo Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'categoria_atributo'.
     *
     * @param categoriaAtributo objeto de tipo 'CategoriaAtributo'.
     * @return int numero de registros eliminados en la tabla'categoria_atributo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(CategoriaAtributo categoriaAtributo) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'categoria_atributo'.
     *
     * @return Lista con todos los elementos de la tabla 'categoria_atributo'.
     */
    List<CategoriaAtributo> getAllAtributoByCategoria(int categoria) throws BusinessException;


    /**
     * Método utilizado para obtener una lista con todos los elementos faltantes de la tabla 'atributo'.
     *
     * @return Lista con todos los elementos de la tabla 'atributo' que no se agregaron a la categoria.
     */
    List<Atributo> getAllAtributosFaltantesByCategoria(int categoria) throws BusinessException;


}
