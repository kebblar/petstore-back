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
 * Nombre:      HistorialComprasService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:46:25
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.HistorialCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Servicio asociado a la entidad 'HistorialCompras'.
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
public interface HistorialComprasService {

    /**
     * Método utilizado para obtener todas las compras hechas por un usuario.
     *
     * @param int idUsuario contiene el id del usuario a buscar.
     * @return Lista de compras hechas por el usuario pasado como parametro.
     * @throws BusinessException es disparada por una regla de negocio
     */
    List<HistorialCompras> getAll(int idUsuario) throws BusinessException;

}