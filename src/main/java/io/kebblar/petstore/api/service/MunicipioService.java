/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo  todo  criterio, el único  dueño de la  totalidad  de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      MunicipioService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:48:24
 */
package io.kebblar.petstore.api.service;

import java.util.List;
import io.kebblar.petstore.api.model.domain.Municipio;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * Interface para el servicio asociado a la entidad {@link Municipio}.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public interface MunicipioService {

    /**
     * Método utilizado para recuperar un elemento de la tabla 'municipio'. por medio de su llave primaria.
     *
     * @param id Id del objeto buscado
     * @return La información del elemento recuperado en una instacia de la clase Municipio
     * o nulo si no se encuentra ese elemento en la tabla.
     */
    Municipio getById(int id) throws BusinessException;

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

    /**
     * Retorna la lista de municipios de determinado estado. Dado el id del estado, los
     * municipios contenidos dentro de este serán devueltos.
     * @param id id del estado
     * @return Lista de municipios pertenecientes al estado ingresado
     * @throws BusinessException En caso de cualquier error lógico o físico.
     */
    List<Municipio> getByEstado(int id) throws BusinessException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'municipio', con el nombre del pais y del estado
     *
     * @return La información del elemento recuperado en una instacia de la clase Municipio o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Municipio> getMunicipiosDescripcion() throws BusinessException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'municipio', con el nombre del pais y del estado filtrado por nombre del municipio.
     *
     * @param nombre Nombre del que retoraremos el conjunto de municipios paginados
     * @return La información del elemento recuperado en una instacia de la clase Municipio o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Municipio> getMunicipiosDescripcionByNombre(String nombre) throws BusinessException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'municipio', con el nombre del pais y del estado
     *
     * @param id id del pais
     * @return La información del elemento recuperado en una instacia de la clase Municipio o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Municipio> getMunicipiosByPaisDescripcion(int pais, String nombre) throws BusinessException;

    /**
     * Método utilizado para recuperar varios elementos de la tabla 'municipio', con el nombre del pais y del estado
     *
     * @param id id del estado
     * @return La información del elemento recuperado en una instacia de la clase Municipio o nulo si no se encuentra ese elemento en la tabla.
     */
    List<Municipio> getMunicipiosByEstadoDescripcion(int estado, String nombre) throws BusinessException;

}
