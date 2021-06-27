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
 * Artefacto:   UsuarioCompletoService .java
 * Proyecto:    petstore
 * Tipo:        interface 
 * AUTOR:       Fhernanda Romo
 * Fecha:       Sunday 06 de June de 2021 (09_35)
 * 
 *              ------------------------------------------------
 *
 * Historia:    20210627_0935 Implementación de interface 
 *
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
     */
    UsuarioCompleto getById(int id) throws BusinessException;

    /**
     * Método utilizado para obtener una lista con todos los elementos de la tabla 'usuario_completo'.
     * 
     * @return Lista con todos los elementos de la tabla 'usuario_completo'.
     */
    List<UsuarioCompleto> getAll() throws BusinessException;

    /**
     * Método utilizado para actualizar un registro en la tabla 'usuario_completo'.
     * 
     * @param  usuarioCompleto objeto de tipo 'UsuarioCompleto'.
     * @return int numero de registros actualizados en la tabla'usuario_completo'.
     * @throws Exception es disparada por una regla de negocio
     */
    int update(UsuarioCompleto usuarioCompleto) throws BusinessException;

}
