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
 * Nombre:      ContadorService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:43:33
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TablasContadorEnum;
import io.kebblar.petstore.api.model.exceptions.ServiceException;

/**
 * <p>ContadorService interface.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public interface ContadorService {
    /**
     * Regresa el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     *
     * @return Entero con el número de tuplas que actualmente tiene la tabla 'usuario_detalle'
     * @throws io.kebblar.petstore.api.model.exceptions.ServiceException cuando ocurre algun imprevisto.
     */
    int getUsuarioDetalleCounter() throws ServiceException;

    /**
     * <p>getUsuarioCounter.</p>
     *
     * @return a int.
     * @throws io.kebblar.petstore.api.model.exceptions.ServiceException if any.
     */
    int getUsuarioCounter() throws ServiceException;
    /**
     * <p>getPaisCounter.</p>
     *
     * @return a int.
     * @throws io.kebblar.petstore.api.model.exceptions.ServiceException if any.
     */
    int getPaisCounter() throws ServiceException;
    /**
     * <p>getEstadoCounter.</p>
     *
     * @return a int.
     * @throws io.kebblar.petstore.api.model.exceptions.ServiceException if any.
     */
    int getEstadoCounter() throws ServiceException;
    /**
     * <p>getMunicipioCounter.</p>
     *
     * @return a int.
     * @throws io.kebblar.petstore.api.model.exceptions.ServiceException if any.
     */
    int getMunicipioCounter() throws ServiceException;

    /**
     * <p>getTableCounter.</p>
     *
     * @param tabla a {@link java.lang.String} object.
     * @return a {@link java.lang.Integer} object.
     * @throws io.kebblar.petstore.api.model.exceptions.ServiceException if any.
     */
    Integer getTableCounter(String tabla) throws ServiceException;
    /**
     * <p>getTableCounter2.</p>
     *
     * @param contador a {@link io.kebblar.petstore.api.model.domain.TablasContadorEnum} object.
     * @return a {@link java.lang.String} object.
     * @throws io.kebblar.petstore.api.model.exceptions.ServiceException if any.
     */
    String getTableCounter2(TablasContadorEnum contador) throws ServiceException;
}
