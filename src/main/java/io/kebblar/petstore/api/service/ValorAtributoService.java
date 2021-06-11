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
 * Artefacto:   ValorAtributoService .java
 * Proyecto:    petstore
 * Tipo:        interface
 * AUTOR:       Fhernanda Romo
 * Fecha:       martes 06 de junio de 2021 (00_43)
 *
 *              ------------------------------------------------
 *
 * Historia:    20210608_0043 Implementación de interface
 *
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.ValorAtributo;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'valor_atributo'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface ValorAtributoService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'valor_atributo'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase ValorAtributo
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    ValorAtributo getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'valor_atributo'.
     *
     * @return Lista con todos los elementos de la tabla 'valor_atributo'.
     */
    List<ValorAtributo> getAll() throws BusinessException;

    /**
     * Método utilizado para insertar un registro en la tabla 'valor_atributo'.
     *
     * @param valorAtributo objeto de tipo 'ValorAtributo'.
     * @return int numero de registros insertados en la tabla'valor_atributo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int insert(ValorAtributo valorAtributo) throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'valor_atributo'.
     *
     * @param  valorAtributo objeto de tipo 'ValorAtributo'.
     * @return int numero de registros actualizados en la tabla'valor_atributo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(ValorAtributo valorAtributo) throws BusinessException;

    /**
     * Método utilizado para guardar la información de un elemento en la tabla 'valor_atributo'.
     * si el elemento no existe se agrega a la base de datos.
     *
     * @param valorAtributo Información del elemento a guardar.
     * @throws Exception En caso un error al momento de guardar los datos.
     */
    int save(ValorAtributo valorAtributo) throws BusinessException;

    /**
     * Método utilizado para eliminar un registro en la tabla 'valor_atributo'.
     *
     * @param valorAtributo objeto de tipo 'ValorAtributo'.
     * @return int numero de registros eliminados en la tabla'valor_atributo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int delete(ValorAtributo valorAtributo) throws BusinessException;

    /**
     * Método utilizado para obtener una lista de los elementos de la tabla 'valor_atributo' que correspondan a un atributo.
     *
     * @return Lista con todos los elementos de la tabla 'valor_atributo'.
     */
    List<ValorAtributo> getAllByIdAtributo(int id) throws BusinessException;
}
