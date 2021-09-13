/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso explí-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.service
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      AdministracionComprasService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:41:04
 */
package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.AdministracionCompras;
import io.kebblar.petstore.api.model.exceptions.BusinessException;
/**
 * <p>Descripción:</p>
 * Interface para el servicio asociado a la entidad 'AdministracionCompras'.
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
public interface AdministracionComprasService {

    /**
     * Método utilizado para obtener todas las compras hechas por los usuario.
     *
     * @return Lista de compras hechas por todos los usuarios.
     * @throws BusinessException es disparada por una regla de negocio.
     */
    List<AdministracionCompras> getAll() throws BusinessException;

    /**
     * Método utilizado para actualizar el estado de una compra.
     *
     * @param estadoEnvio, el nuevo estado que queremos colocar.
     * @param cveCompra, el cveCompra de la compra que queremos actualizar.
     * @return String que contiene un JSON que indica si salió bien o no.
     * @throws BusinessException es disparada por una regla de negocio
     */
    String sent(int estadoEnvio, String cveCompra) throws BusinessException;
}
