/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención 
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   Usuario.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (09_10)
 *
 * Historia:    .
 *              20210504_0910 Creación
 *
 */
package io.kebblar.petstore.api.service;

import io.kebblar.petstore.api.model.domain.TickerWrapper;

/**
 * <p>Definición de la interfaz de servicios para 'TickerWrapper'.
 * 
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.TickerWrapper
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT 
 */
public interface RemoteRestCallService {
    /**
     * <p>Retorna el valor de una criptomoneda en el instante actual.
     * 
     * @param Objeto de tipo {@link CredencialesRequest} con la información de su correo y su clave.
     * @return Clase de modelo que contiene la información de una cripto.
     * @throws BusinessException
     */
    TickerWrapper callTickerMicroservice();
}
